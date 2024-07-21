package com.ecommerce.service.impl;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = mapToProduct(productDTO);
        product = productRepository.save(product);
        return mapToProductDTO(product);
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String deleteProduct(long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Product deleted successfully!";
        } else {
            return "Product not found!";
        }
    }

    private Product mapToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setProductColor(productDTO.getProductColor());
        product.setProductPrice(productDTO.getProductPrice());
        return product;
    }

    private ProductDTO mapToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductPrice(product.getProductPrice());
        productDTO.setProductColor(product.getProductColor());
        return productDTO;
    }
}
