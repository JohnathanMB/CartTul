package com.johnathanmb.CartTul.model;

import lombok.*;

/**
 * Modelo de relación entre producto y cart de base de datos
 *
 * @author ja.monsalve.bello@gmail.com
 * @since JDK 1.8
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductsByCar {
    private String productId;
    private String carId;
    private String quantity;
}
