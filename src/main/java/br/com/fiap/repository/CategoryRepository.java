package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
