package com.example.apidemo.models;

import lombok.*;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private Double price;

    public ProductDto(){

    }
    public ProductDto(long id, String name, Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
