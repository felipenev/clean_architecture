package br.com.clean.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private CPF cpf;//identificador unico. Representacao mais proxima possivel no mundo real, do modelo negocial.
    private String nome;

    private Email email;
    private List<Telefone> telefones = new ArrayList<>();

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero){
        if(this.telefones.size() == 2) {
            throw new IllegalArgumentException("Numero maximo de telefones atingido!");
        }
        this.telefones.add(new Telefone(ddd, numero));
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

//    public Email getEmail() {
//        return email;
//    }
    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
