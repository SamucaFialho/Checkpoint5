package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dto.ProductRequestCreate;
import br.com.fiap.model.Product;
import br.com.fiap.repository.CategoryRepository;
import br.com.fiap.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
     private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryrepository;

    public Product createProduct(ProductRequestCreate dto) {
        return repository.save(dto.toModel());
    }

    public Optional<Product> getById(Long id) {
        return repository.findById(id);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
    
