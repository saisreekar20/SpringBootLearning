package com.ecommerce.SpringEcommerce.repostitory;

import com.ecommerce.SpringEcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<Product,Integer> {

    @Query("select p from Product p where "+
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword,'%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword,'%')) or " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword,'%')) or " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword,'%'))")
    public List<Product> searchProduct(String keyword);
}