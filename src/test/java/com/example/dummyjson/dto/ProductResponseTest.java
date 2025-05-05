package com.example.dummyjson.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductResponseTest {

    @Test
    public void testSetAndGetProducts() {
        ProductResponse productResponse = new ProductResponse();

        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Product 1");
        product1.setDescription("Description 1");
        product1.setPrice(10.0);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("Product 2");
        product2.setDescription("Description 2");
        product2.setPrice(20.0);

        List<Product> products = Arrays.asList(product1, product2);
        productResponse.setProducts(products);

        assertNotNull(productResponse.getProducts());
        assertEquals(2, productResponse.getProducts().size());
        assertEquals("Product 1", productResponse.getProducts().get(0).getTitle());
        assertEquals("Product 2", productResponse.getProducts().get(1).getTitle());
    }
}