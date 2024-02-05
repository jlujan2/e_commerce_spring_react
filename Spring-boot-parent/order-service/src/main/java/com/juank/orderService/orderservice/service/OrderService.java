package com.juank.orderService.orderservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.juank.orderService.orderservice.dto.InventoryResponse;
import com.juank.orderService.orderservice.event.OrderPlaceEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juank.orderService.orderservice.dto.OrderLineItemsDto;
import com.juank.orderService.orderservice.dto.OrderRequest;
import com.juank.orderService.orderservice.model.Order;
import com.juank.orderService.orderservice.model.OrderLineItems;
import com.juank.orderService.orderservice.repository.OrderRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService {
	
	private final OrderRepository orderRepository;

	private final WebClient.Builder webClientBuilder;

	//private final KafkaTemplate<String, OrderPlaceEvent> kafkaTemplate;
	public String placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
			.stream()
			.map(this::mapToDto)
			.toList();
		
		order.setOrderLineItemList(orderLineItems);

		List<String> skuCodes = order.getOrderLineItemList().stream().map(OrderLineItems::getSkuCode)
				.toList();

		InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
				.uri("http://inventory-service/api/inventory",
						uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
				.retrieve()
				.bodyToMono(InventoryResponse[].class)
				.block();

		boolean allProductsInStock = Arrays.stream(inventoryResponseArray)
				.allMatch(InventoryResponse::isInStock);

		if(allProductsInStock) {
			orderRepository.save(order);
			//kafkaTemplate.send("notificationTopic", new OrderPlaceEvent(order.getOrderNumber()));
			return "Order Place succesfully";
		} else {
			throw new IllegalArgumentException("Product is not in stock, Please try again");
		}
	}
	
	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		return orderLineItems;
	}
}
