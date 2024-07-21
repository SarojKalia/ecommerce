package com.ecommerce.service;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO productDTO);
    Product getProduct(long id);
    List<Product> getAllProducts();
    String deleteProduct(long id);
}
