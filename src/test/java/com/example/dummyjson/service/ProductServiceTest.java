package com.example.dummyjson.service;

import com.example.dummyjson.client.DummyJsonClient;
import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private DummyJsonClient dummyJsonClient;

    @Autowired
    private ProductService productService;

    @Test
    public void getAllProductsReturnsEmptyListWhenNoProductsAvailable() {
        ProductResponse emptyResponse = new ProductResponse();
        emptyResponse.setProducts(Collections.emptyList()); // Certifique-se de que o setter está configurando a lista corretamente
        Mockito.when(dummyJsonClient.getAllProducts()).thenReturn(emptyResponse);

        List<Product> products = productService.getAllProducts();
        assertEquals(0, products.size());
    }

    @Test
    public void getProductByIdReturnsNullWhenProductNotFound() {
        Mockito.when(dummyJsonClient.getProductById(anyLong())).thenReturn(null);

        Product product = productService.getProductById(999L);

        assertNull(product);
    }
}