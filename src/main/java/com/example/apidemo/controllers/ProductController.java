package com.example.apidemo.controllers;

import com.example.apidemo.models.ProductDto;
import com.example.apidemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return new ResponseEntity<>(productService.getProductsList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        Optional<ProductDto> product = productService.getProductById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "Product with requested id is not found");
            return new ResponseEntity<>(pd, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto) {
        Optional<ProductDto> p = productService.createProduct(productDto);
        if (p.isPresent()) {
            return new ResponseEntity(p.get(), HttpStatus.CREATED);
        } else {
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Product already exist with given name");
            return new ResponseEntity(pd, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id) {
        Optional<ProductDto> updatedProduct = productService.updateProduct(productDto, id);
        if (updatedProduct.isPresent()) {
            return new ResponseEntity<>(updatedProduct.get(), HttpStatus.OK);
        } else {
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "Product with requested id is not found");
            return new ResponseEntity<>(pd, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        Optional<ProductDto> deletedProduct = productService.deleteProductById(id);
        if (deletedProduct.isPresent()) {
            return new ResponseEntity<>("Records deleted", HttpStatus.OK);
        } else {
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "Product with requested id is not found");
            return new ResponseEntity<>(pd, HttpStatus.NOT_FOUND);
        }

    }
}
