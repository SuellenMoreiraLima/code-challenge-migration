package com.example.dummyjson.service;

import com.example.dummyjson.client.DummyJsonClient;
import com.example.dummyjson.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private DummyJsonClient dummyJsonClient;

    public List<Product> getAllProducts() {
        return dummyJsonClient.getAllProducts().getProducts();
    }

    public Product getProductById(Long id) {
        return dummyJsonClient.getProductById(id);
    }

}
