package br.com.clean.escola.academico.aplicacao.aluno.matricular;

import br.com.clean.escola.academico.dominio.aluno.Aluno;
import br.com.clean.escola.shared.dominio.CPF;
import br.com.clean.escola.academico.dominio.aluno.Email;

public class MatricularAlunoDTO {

    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;

    public MatricularAlunoDTO(String cpfAluno, String nomeAluno, String emailAluno) {
        this.cpfAluno = cpfAluno;
        this.nomeAluno = nomeAluno;
        this.emailAluno = emailAluno;
    }

    public Aluno criarAluno(){
        return new Aluno(new CPF(this.cpfAluno), this.nomeAluno, new Email(this.emailAluno));
    }
}
