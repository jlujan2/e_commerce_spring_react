package com.juank;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderPlaceEvent {
    private String orderNumber;
}
