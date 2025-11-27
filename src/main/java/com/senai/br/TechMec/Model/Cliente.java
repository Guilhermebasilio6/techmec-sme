package com.senai.br.TechMec.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "obrigatorio")
    private String nome;

    @NotBlank(message = "obrigatorio")
    private String email;

    @NotBlank(message = "obrigatorio")
    @Size(min = 6, message = "min 6 characteres")
    private String senha;

    @NotBlank(message = "obrigatorio")
    private int nivelAcesso;

    public Cliente() {}

    public Cliente(Long id, String nome, String email, String senha, int nivelAcesso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public boolean  autenticar (String email, String senha){
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public void redefinirSenha(String novaSenha){
        this.senha = novaSenha;
    }

}


