package com.johnathanmb.CartTul.service;

import com.johnathanmb.CartTul.repository.CartRepository;
import com.johnathanmb.CartTul.service.impl.CartServiceImpl;
import com.johnathanmb.CartTul.vo.ResponseProductsByCart;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class CartServiceTest {

    private final CartService cartService = new CartServiceImpl();

    @MockBean
    private CartRepository cartRepository;

    @Test
    public void returnCartNotNullWhitID(){
        //Give
        String cartId = "2021-02-01";

        //When
        ResponseProductsByCart productsByCartResponse = cartService.consult(cartId);

        //Then
        assertNotNull(productsByCartResponse);
        assertEquals(productsByCartResponse.getCart().getId(), cartId);
        assertEquals(productsByCartResponse.getCart().getStatus(), "pending");
        assertEquals(productsByCartResponse.getProducts().size(), 3);
        ArgumentCaptor idCaptor = ArgumentCaptor.forClass(String.class);
        verify(cartRepository).findById((String) idCaptor.capture());
        assertEquals((String) idCaptor.getValue(), cartId);
    }



}