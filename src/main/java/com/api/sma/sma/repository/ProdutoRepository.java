package com.api.sma.sma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.sma.sma.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
