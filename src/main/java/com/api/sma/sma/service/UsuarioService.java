package com.api.sma.sma.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sma.sma.dto.UsuarioDto;
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

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    
    public Usuario buscarUsuarioPorNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }
    
    public Usuario buscarUsuarioPorCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }

    public Usuario salvarUsuario(Usuario usuario) throws Exception {
        usuario.setDataCriacao(new Date());
        String email = usuario.getEmail();
        String nome = usuario.getNome();
        String cpf = usuario.getCpf();
        if (email != null && !"".equals(email) && nome != null && !"".equals(nome) && cpf != null
                && !"".equals(cpf)) {
            Usuario usuarioPorEmail = buscarUsuarioPorEmail(email);
            Usuario usuarioPorNome = buscarUsuarioPorNome(nome);
            Usuario usuarioPorCpf = buscarUsuarioPorCpf(cpf);
            if (usuarioPorEmail != null) {
                throw new Exception(" : Usuario com email ja registrado");
            } else if (usuarioPorNome != null) {
                throw new Exception(" : Usuario com nome ja registrado");
            } else if (usuarioPorCpf != null) {
                throw new Exception(" : Usuario com cpf ja registrado");
            }
        }
        return usuarioRepository.saveAndFlush(usuario);
    }
    
    public UsuarioDto converterUsuarioParaDto(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        BeanUtils.copyProperties(usuario, usuarioDto);
        return usuarioDto;
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
