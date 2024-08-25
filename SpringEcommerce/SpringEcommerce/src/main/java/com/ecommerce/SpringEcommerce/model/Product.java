package com.ecommerce.SpringEcommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private Date releaseDate;
    private String category;
    private String brand;
    private boolean productAvailable;

    private String imageType;

    @Lob
    @Column(name = "imagebyte",columnDefinition = "LONGBLOB")
    private byte[] imagebyte;
    private String imageName;



}