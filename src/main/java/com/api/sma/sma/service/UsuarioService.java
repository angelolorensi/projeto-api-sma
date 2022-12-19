package com.api.sma.sma.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sma.sma.entity.Usuario;
import com.api.sma.sma.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }
    
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuario inserirUsuario(Usuario usuario) {
        usuario.setDataCriacao(new Date());
        return usuarioRepository.saveAndFlush(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        usuario.setDataAtualizacao(new Date());
        return usuarioRepository.saveAndFlush(usuario);
    }

    public void excluirUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }
}
