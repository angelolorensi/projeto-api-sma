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
import org.springframework.web.bind.annotation.RestController;

import com.api.sma.sma.entity.Usuario;
import com.api.sma.sma.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioService.buscarTodosUsuarios();
    }
    
    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> registrarUsuario(@Valid @RequestBody Usuario usuario) throws Exception {      
        return new ResponseEntity<>(usuarioService.salvarUsuario(usuario), HttpStatus.CREATED); 
    }

    @PutMapping("/")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.ok().build();
    }
}
