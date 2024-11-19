package com.himanshu.esd.esd_yummy.repo;

import com.himanshu.esd.esd_yummy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN 15 AND 300 ORDER BY p.price")
    List<Product> findTop2ByPriceBetweenOrderByPriceAsc();
}
