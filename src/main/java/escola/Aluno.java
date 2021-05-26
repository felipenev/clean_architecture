package escola;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private String cpf;//identificador unico. Representacao mais proxima possivel no mundo real, do modelo negocial.
    private String nome;

    private Email email;
    private List<Telefone> telefones = new ArrayList<>();

    public Aluno(String cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero){
        this.telefones.add(new Telefone(ddd, numero));
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
