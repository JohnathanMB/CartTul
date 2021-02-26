package com.johnathanmb.CartTul.util;

import com.johnathanmb.CartTul.model.Cart;
import com.johnathanmb.CartTul.model.Product;
import com.johnathanmb.CartTul.model.ProductByCart;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BuildedObjects {

    private Cart cart1 = Cart.builder()
            .id("2021-02-01")
            .status("pending")
            .build();
    private Cart cart2 = Cart.builder()
            .id("2021-02-02")
            .status("pending")
            .build();
    private Cart cart3 = Cart.builder()
            .id("2021-02-03")
            .status("pending")
            .build();
    private ProductByCart productByCart1 = ProductByCart.builder()
            .carId("2021-02-01")
            .productId("TAL-PER-101")
            .quantity(3)
            .build();
    private ProductByCart productByCart2 = ProductByCart.builder()
            .carId("2021-02-01")
            .productId("BAL-CER-101")
            .quantity(2)
            .build();
    private ProductByCart productByCart3 = ProductByCart.builder()
            .carId("2021-02-01")
            .productId("KIT-DEST-10-101")
            .quantity(5)
            .build();
    private Product product1 = Product.builder()
            .id("TAL-PER-101")
            .name("Taladro Percutor Marca")
            .sku("TAL-PER-MARCA")
            .description("Taladro Percutor Marca")
            .build();
    private Product product2 = Product.builder()
            .id("BAL-CER-101")
            .name("Baldosa de cerámica blanca")
            .sku("BAL-CER-M2")
            .description("Baldosa de cerámica blanca Por metro cuadrado")
            .build();
    private Product product3 = Product.builder()
            .id("KIT-DEST-10-101")
            .name("Kit de Destornilladores")
            .sku("KIT-DEST-10")
            .description("Kit de 10 Destornilladores con punta magnética")
            .build();
    private ArrayList<ProductByCart> productByCartList = new ArrayList<>();
    private ArrayList<Product> productList = new ArrayList<>();
    private ArrayList<Cart> cartList = new ArrayList<>();

    public BuildedObjects() {
        cartList.add(cart1);
        cartList.add(cart2);
        cartList.add(cart3);

        productByCartList.add(productByCart1);
        productByCartList.add(productByCart2);
        productByCartList.add(productByCart3);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
    }

    public ArrayList<Cart> getCartList(){
        return cartList;
    }

    public ArrayList<ProductByCart> getProductByCartList() {
        return productByCartList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
