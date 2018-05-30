package com.bootcamp.api.ServiceTest;

import com.bootcamp.api.models.Product;
import com.bootcamp.api.repositories.ProductRepository;
import com.bootcamp.api.services.ProductService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    private ProductService productService;
    private ProductRepository productRepository;
    private Product mockedProd;

    @Before
    public void setUp(){
        this.mockedProd = mock(Product.class);
        when(mockedProd.getName()).thenReturn("yamaha");
        when(mockedProd.getCategory()).thenReturn("bikes");
        this.productRepository = mock(ProductRepository.class);
        when(this.productRepository.findByName("yamaha")).thenReturn(mockedProd);
        when(this.productRepository.findAll()).thenReturn(new ArrayList<>());
        when(this.productRepository.findByCategory("bikes")).thenReturn(new ArrayList<>());
        this.productService = new ProductService(productRepository);
    }

    @Test
    public void getFullProductListReturnsList(){
        assertNotNull(this.productService.getAll());
    }

    @Test
    public void givenProductsNameReturnsProduct(){
        assertEquals(this.mockedProd,this.productService.getByName("yamaha"));
    }

    @Test
    public void givenCategoryReturnsList(){
        assertNotNull(this.productService.getByCategory(mockedProd.getCategory()));
    }

}
