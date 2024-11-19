package com.himanshu.esd.esd_yummy.mapper;

import com.himanshu.esd.esd_yummy.dto.ProductRequest;
import com.himanshu.esd.esd_yummy.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct (ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .price(request.price())
                .build();
    }
}
