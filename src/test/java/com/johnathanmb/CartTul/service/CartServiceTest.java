package com.johnathanmb.CartTul.service;

import com.johnathanmb.CartTul.repository.impl.CartRepositoryImpl;
import com.johnathanmb.CartTul.repository.impl.ProductByCartRepositoryImpl;
import com.johnathanmb.CartTul.repository.impl.ProductRepositoryImpl;
import com.johnathanmb.CartTul.service.impl.CartServiceImpl;
import com.johnathanmb.CartTul.util.BuildedObjectsTest;
import com.johnathanmb.CartTul.vo.GenericResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class CartServiceTest {

    @Autowired
    private CartServiceImpl cartService;

    @MockBean
    private CartRepositoryImpl cartRepository;
    @MockBean
    private ProductRepositoryImpl productRepository;
    @MockBean
    private ProductByCartRepositoryImpl productByCartRepository;

    BuildedObjectsTest buildedObjectsTest = new BuildedObjectsTest();

    @Test
    public void returnCartNotNullWhitID(){
        //Give
        String cartId = "2021-02-01";
        doReturn(buildedObjectsTest.getCartList()).when(cartRepository).findById(cartId);
        doReturn(buildedObjectsTest.getProductByCartList()).when(productByCartRepository).findByCartId(cartId);
        doReturn(buildedObjectsTest.getProductList().get(0)).when(productRepository).findById(cartId);

        //When
        GenericResponse productsByCartResponse = cartService.consult(cartId);

        //Then
        assertNotNull(productsByCartResponse);
        //assertEquals(productsByCartResponse.getCart().getId(), cartId);
        //assertEquals(productsByCartResponse.getCart().getStatus(), "pending");
        //assertEquals(productsByCartResponse.getProducts().size(), 3);


    }



}