package com.api.sma.sma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.sma.sma.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Usuario findByNome(String nome);
    
    Usuario findByCpf(String cpf);
}

