package com.api.sma.sma.dto;

import java.util.Date;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioDto {
    
    private Long id;
    @NotNull(message = "Nome de usuario não deve ser nulo.")
    private String nome;
    @NotNull(message = "Senha não deve ser nula.")
    private String senha;
    @NotNull(message = "Endereço não deve ser nulo.")
    private String endereco;
    @NotNull(message = "CEP não deve ser nulo")
    private String cep;
    @NotNull(message = "Telefone não deve ser nulo")
    private String telefone;
    @NotNull(message = "CPF não deve ser nulo")
    private String cpf;
    @NotNull(message = "Email não deve ser nulo")
    @Email
    private String email;
    @NotNull(message = "Data de nascimento não deve ser nulo")
    private Date dataNascimento;

}
