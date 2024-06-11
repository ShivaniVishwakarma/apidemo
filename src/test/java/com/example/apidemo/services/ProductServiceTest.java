//package com.example.apidemo.services;
//
//import com.example.apidemo.entities.Product;
//import com.example.apidemo.mappers.ProductMapper;
//import com.example.apidemo.models.ProductDto;
//import com.example.apidemo.repositories.ProductRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Arrays;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTest {
//
//    @Mock
//    private ProductRepository productRepository;
//
//    @InjectMocks
//    private ProductService productService;
//
//    private final ProductMapper productMapper = ProductMapper.INSTANCE;
//
//    @Test
//    void getProductsList() {
//        Product product1 = new Product(1L, "Product1", 100.0);
//        Product product2 = new Product(2L, "Product2", 200.0);
//
//        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));
//
//        List<ProductDto> productList = productService.getProductsList();
//
//        assertEquals(2, productList.size());
//        verify(productRepository, times(1)).findAll();
//    }
//
//    @Test
//    void getProductById() {
//        Product product = new Product(1L, "Product1", 100.0);
//        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
//
//        Optional<ProductDto> ProductDto = productService.getProductById(1L);
//
//        assertTrue(ProductDto.isPresent());
//        assertEquals("Product1", ProductDto.get().getName());
//        verify(productRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    void createProduct() {
//        Product product = new Product(1L, "Product1", 100.0);
//        ProductDto ProductDto = productMapper.toDto(product);
//
//        when(productRepository.findByName("Product1")).thenReturn(Optional.empty());
//        when(productRepository.save(any(Product.class))).thenReturn(product);
//
//        Optional<ProductDto> createdProductDto = productService.createProduct(ProductDto);
//
//        assertTrue(createdProductDto.isPresent());
//        assertEquals("Product1", createdProductDto.get().getName());
//        verify(productRepository, times(1)).findByName("Product1");
//        verify(productRepository, times(1)).save(any(Product.class));
//    }
//
//    @Test
//    void updateProduct() {
//        Product existingProduct = new Product(1L, "Product1", 100.0);
//        Product updatedProduct = new Product(1L, "UpdatedProduct", 150.0);
//        ProductDto updatedProductDto = productMapper.toDto(updatedProduct);
//
//        when(productRepository.findById(1L)).thenReturn(Optional.of(existingProduct));
//        when(productRepository.save(any(Product.class))).thenReturn(updatedProduct);
//
//        Optional<ProductDto> result = productService.updateProduct(updatedProductDto, 1L);
//
//        assertTrue(result.isPresent());
//        assertEquals("UpdatedProduct", result.get().getName());
//        verify(productRepository, times(1)).findById(1L);
//        verify(productRepository, times(1)).save(any(Product.class));
//    }
//
//    @Test
//    void deleteProductById() {
//        Product product = new Product(1L, "Product1", 100.0);
//
//        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
//
//        Optional<ProductDto> deletedProductDto = productService.deleteProductById(1L);
//
//        assertTrue(deletedProductDto.isPresent());
//        verify(productRepository, times(1)).findById(1L);
//        verify(productRepository, times(1)).delete(product);
//    }
//}
