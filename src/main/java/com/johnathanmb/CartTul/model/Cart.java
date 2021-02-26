package com.johnathanmb.CartTul.model;

import lombok.*;

/**
 * Modelo de Cart de base de datos
 *
 * @author ja.monsalve.bello@gmail.com
 * @since JDK 1.8
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Cart {
    private String id;
    private String status;
}
