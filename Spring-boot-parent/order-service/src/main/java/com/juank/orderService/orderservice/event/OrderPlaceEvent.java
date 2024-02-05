package com.juank.orderService.orderservice.event;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderPlaceEvent {
    private String orderNumber;
}
