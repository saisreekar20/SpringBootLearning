package com.ecommerce.SpringEcommerce.service;

import com.ecommerce.SpringEcommerce.model.Product;
import com.ecommerce.SpringEcommerce.repostitory.Repo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {


    private Product products;

    @Autowired
    private Repo repo;


    public List<Product> getAllProducts() {
        return repo.findAll();
    }
    public Product getProductById(int id) {
        Product product = repo.findById(id).get();
        return product;
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageType(imageFile.getContentType());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImagebyte(imageFile.getBytes());
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        Product product1=repo.findById(id).get();
        product1.setImageType(imageFile.getContentType());
        product1.setImageName(imageFile.getOriginalFilename());
        product1.setImagebyte(imageFile.getBytes());

        return repo.save(product1);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProduct(String keyword) {
        return repo.searchProduct(keyword);
    }
}