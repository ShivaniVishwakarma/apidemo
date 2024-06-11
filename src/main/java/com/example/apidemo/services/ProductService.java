package com.example.apidemo.services;

import com.example.apidemo.entities.Product;
import com.example.apidemo.mappers.ProductMapper;
import com.example.apidemo.models.ProductDto;
import com.example.apidemo.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public List<ProductDto> getProductsList(){
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());

    }

    public Optional<ProductDto> getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toDto);

    }

    @Transactional
    public Optional<ProductDto> createProduct(ProductDto productDto){
        Optional<Product> existingProduct = productRepository.findByName(productDto.getName());
        if(existingProduct.isPresent()) {
            return Optional.empty();
        }
        Product product = productMapper.toEntity(productDto);
        product = productRepository.save(product);
        return Optional.of(productMapper.toDto(product));
    }

    @Transactional
    public Optional<ProductDto> updateProduct(ProductDto productDto, Long id){
        return productRepository.findById(id).map(existingProduct -> {
            existingProduct.setName(productDto.getName());
            existingProduct.setPrice(productDto.getPrice());
            return productMapper.toDto(productRepository.save(existingProduct));
        });
    }


    @Transactional
    public Optional<ProductDto> deleteProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(productRepository::delete);
        return product.map(productMapper::toDto);
    }
}
