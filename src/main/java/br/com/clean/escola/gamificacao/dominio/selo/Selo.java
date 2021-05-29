package br.com.clean.escola.gamificacao.dominio.selo;

import br.com.clean.escola.academico.dominio.aluno.CPF;

public class Selo {

    private CPF cpfDoAluno;
    private String nomeAluno;

    public Selo(CPF cpfDoAluno, String nomeAluno) {
        this.cpfDoAluno = cpfDoAluno;
        this.nomeAluno = nomeAluno;
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }
}
