package com.api.sma.sma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.sma.sma.entity.Produto;
import com.api.sma.sma.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> buscarTodosProdutos() {
        return produtoService.buscarTodosProdutos();
    }
    
    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto inserirProduto(@RequestBody Produto produto) {
        return produtoService.inserirProduto(produto);
    }

    @PutMapping("/")
    public Produto atualizarProduto(@RequestBody Produto produto) {
        return produtoService.atualizarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.ok().build();
    }
}
