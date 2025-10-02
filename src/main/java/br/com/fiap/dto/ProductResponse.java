package br.com.fiap.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.fiap.model.Product;


public class ProductResponse {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer quantidade;
    private String description;
    private String imageUrl;
    private List<CategoryResponse> categoriasIds;

    public ProductResponse toDto(Product product){
        this.setId(product.getId());
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.setQuantidade(product.getQuantidade());
        this.setDescription(product.getDescription());
        this.setImageUrl(product.getImageUrl());

    if (product.getCategorias() != null) {
        this.setCategoriasIds(
            product.getCategorias().stream()
            .map(p -> new CategoryResponse().toDto(p))
            .toList()
        );
    } else {
        this.setCategoriasIds(List.of());
    }

        return this;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<CategoryResponse> getCategoriasIds() {
        return categoriasIds;
    }

    public void setCategoriasIds(List<CategoryResponse> categoriasIds) {
        this.categoriasIds = categoriasIds;
    }
    
    
}
