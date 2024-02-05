//package com.juank.orderService.orderservice.config;
//
//import com.juank.orderService.orderservice.event.OrderPlaceEvent;
//import lombok.RequiredArgsConstructor;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@RequiredArgsConstructor
//public class KafkaProducerConfig {
//    @Bean
//    public ProducerFactory<String, OrderPlaceEvent> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        configProps.put(JsonSerializer.TYPE_MAPPINGS, "OrderPlaceEvent:com.juank.orderService.orderservice.event.OrderPlaceEvent");
////        configProps.put(JsonSerializer.TYPE_MAPPINGS,
////                "orderPlaceEvent:com.juank.orderService.orderservice.event.OrderPlaceEvent");
//        DefaultKafkaProducerFactory<String, OrderPlaceEvent> pf = new DefaultKafkaProducerFactory<>(configProps,
//                new JsonSerializer<String>()
//                        .forKeys()
//                        .noTypeInfo(),
//                new JsonSerializer<OrderPlaceEvent>()
//                        .noTypeInfo());
//        return pf;
//    }
//    @Bean
//    public KafkaTemplate<String, OrderPlaceEvent> kafkaTemplate() {
//
//
//
//        return new KafkaTemplate<>(producerFactory());
//    }
//}
