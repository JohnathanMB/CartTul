package com.johnathanmb.CartTul.util;

public class CartConstants {
    // Response Code
    public static final String SUCCESS_CODE = "200";
    public static final String ERROR_CODE = "400";
    public static final String ERROR_CODE_NOT_FOUND = "404";

    // Response Message
    public static final String SUCCESS_MESSAGE = "OK";
    public static final String ERROR_MESSAGE = "ERROR";
    public static final String ERROR_MESSAGE_NOT_FOUND = "No se encontró carrito con el id ingresado";
    public static final String ERROR_MESSAGE_PROD_NOT_FOUND = "No se encontró el producto ingresado";

    //CartService
    public static final String CART_SERVICE = "/cart";
    public static final String LIST_PRODUCTS_IN_CART = "/list-products-cart/{cartID}";
    public static final String ADD_PRODCUT_IN_CART = "/add-product-in-cart";

    //CartObject
    public static final String CART_STATUS_PENDING = "pending";
    public static final String CART_STATUS_COMPLETED = "completed";

    public static final String CHECKOUT_CART = "/checkout-cart/{cartID}";
}
