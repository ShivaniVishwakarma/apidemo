//package com.example.apidemo.controllers;
//
//import com.example.apidemo.models.ProductDto;
//import com.example.apidemo.services.ProductService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductControllerTest {
//
//    @Mock
//    private ProductService productService;
//
//    @InjectMocks
//    private ProductController productController;
//
//    @Test
//    void getAllProducts() {
//        ProductDto product1 =  ProductDto.builder().id(1L).name("product1").price(100.0).build();
//        ProductDto product2 =  ProductDto.builder().id(2L).name("product2").price(200.0).build();
//
//        when(productService.getProductsList()).thenReturn(Arrays.asList(product1, product2));
//
//        ResponseEntity<List<ProductDto>> response = productController.getAllProducts();
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(2, response.getBody().size());
//        verify(productService, times(1)).getProductsList();
//    }
//
//    @Test
//    void getProductById() {
//        ProductDto productDto = ProductDto.builder().id(1L).name("product1").price(100.0).build();
//        when(productService.getProductById(1L)).thenReturn(Optional.of(productDto));
//
//        ResponseEntity<Object> response = productController.getProductById(1L);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Product1", ((ProductDto) response.getBody()).getName());
//        verify(productService, times(1)).getProductById(1L);
//    }
//
////    @Test
////    void addProduct() {
////        ProductDto ProductDto = new ProductDto(1L, "Product1", 100.0);
////
////        when(productService.createProduct(ProductDto)).thenReturn(Optional.of(ProductDto));
////
////        ResponseEntity<Object> response = productController.addProduct(ProductDto);
////
////        assertEquals(HttpStatus.CREATED, response.getStatusCode());
////        assertEquals("Product1", ((ProductDto) response.getBody()).getName());
////        verify(productService, times(1)).createProduct(ProductDto);
////    }
//
////    @Test
////    void updateProduct() {
////        ProductDto updatedProductDto = new ProductDto(1L, "UpdatedProduct", 150.0);
////
////        when(productService.updateProduct(updatedProductDto, 1L)).thenReturn(Optional.of(updatedProductDto));
////
////        ResponseEntity<Object> response = productController.updateProduct(updatedProductDto, 1L);
////
////        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertEquals("UpdatedProduct", ((ProductDto) response.getBody()).getName());
////        verify(productService, times(1)).updateProduct(updatedProductDto, 1L);
////    }
//
//    @Test
//    void deleteProduct() {
//        ProductDto productDto = ProductDto.builder().id(1L).name("product1").price(100.0).build();
//
//        when(productService.deleteProductById(1L)).thenReturn(Optional.of(productDto));
//
//        ResponseEntity<Object> response = productController.deleteProduct(1L);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Records deleted", response.getBody());
//        verify(productService, times(1)).deleteProductById(1L);
//    }
//}
