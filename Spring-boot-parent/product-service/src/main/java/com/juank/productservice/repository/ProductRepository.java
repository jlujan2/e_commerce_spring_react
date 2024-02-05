package com.juank.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.juank.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
