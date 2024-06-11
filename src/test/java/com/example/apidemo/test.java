package com.example.apidemo;

import com.example.apidemo.entities.Product;
import com.example.apidemo.models.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test {

    @Test
    public void test(){
       // new Product(1L, "Product1", 100.0);
        ProductDto pd = new ProductDto(1L, "Product1", 100.0);
        Assertions.assertEquals(pd.getPrice(),1.0);
    }
}
