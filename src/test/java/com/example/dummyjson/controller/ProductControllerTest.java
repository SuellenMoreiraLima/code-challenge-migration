package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductService productService;

    @Test
    public void testGetAllProducts() {
        List<Product> products = this.restTemplate.getForObject("http://localhost:" + port + "/api/products", List.class);
        assertNotNull(products);
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Essence Mascara Lash Princess");
        product.setDescription("Description 1");
        product.setPrice(10.0);

        // Simula a inserção de um produto no serviço
        productService.getAllProducts().add(product);

        Product response = this.restTemplate.getForObject("http://localhost:" + port + "/api/products/1", Product.class);
        assertNotNull(response);
        assertEquals("Essence Mascara Lash Princess", response.getTitle());
    }
}