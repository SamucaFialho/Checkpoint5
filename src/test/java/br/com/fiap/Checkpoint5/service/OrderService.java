package br.com.fiap.service;

import br.com.fiap.dto.ProductRequestCreate;
import br.com.fiap.model.Product;
import br.com.fiap.repository.CategoryRepository;
import br.com.fiap.repository.ProductRepository;
import br.com.fiap.service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenProductRequestWhenCreateThenProductIsSaved() {
        ProductRequestCreate dto = mock(ProductRequestCreate.class);
        Product productMock = new Product();
        productMock.setId(1L);

        when(dto.toModel()).thenReturn(productMock);
        when(productRepository.save(any(Product.class))).thenReturn(productMock);


        Product result = productService.createProduct(dto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void whenGetByIdThenReturnProductOptional() {
        Product product = new Product();
        product.setId(1L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<Product> result = productService.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void whenFindAllThenReturnProductList() {
        List<Product> products = List.of(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(products);


        List<Product> result = productService.findAll();

        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void whenSaveProductThenReturnSavedProduct() {
        Product product = new Product();
        product.setId(1L);
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(1L, result.getId());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void givenExistingIdWhenDeleteThenReturnTrue() {
        when(productRepository.existsById(1L)).thenReturn(true);

        boolean result = productService.delete(1L);

        assertTrue(result);
        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    void givenNonExistingIdWhenDeleteThenReturnFalse() {

        when(productRepository.existsById(99L)).thenReturn(false);

        boolean result = productService.delete(99L);

     
        assertFalse(result);
        verify(productRepository, never()).deleteById(anyLong());
    }
}