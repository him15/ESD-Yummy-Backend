package com.himanshu.esd.esd_yummy.service;


import com.himanshu.esd.esd_yummy.dto.ProductRequest;
import com.himanshu.esd.esd_yummy.entity.Product;
import com.himanshu.esd.esd_yummy.mapper.ProductMapper;
import com.himanshu.esd.esd_yummy.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public String addProduct(ProductRequest product) {
        Product product1 = productMapper.toProduct(product);
        productRepo.save(product1);
        return "Product added";
    }

    public Product getProduct(String name) {
        Product product = productRepo.findByName(name).orElse(null);
        return product;
    }

    public String updateProduct(ProductRequest product) {
        Product uproduct = getProduct(product.name());
        uproduct.setPrice(product.price());
        productRepo.save(uproduct);
        return "Product updated";
    }

    public String deleteProduct(String name) {
        Product product = productRepo.findByName(name).orElse(null);
        productRepo.delete(product);
        return "Product deleted";
    }
}
