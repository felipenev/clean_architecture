package br.com.clean.escola.aplicacao.aluno.matricular;

import br.com.clean.escola.dominio.aluno.Aluno;
import br.com.clean.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {

    private final RepositorioDeAlunos repositorioDeAlunos;

    public MatricularAluno(RepositorioDeAlunos repositorioDeAlunos) {
        this.repositorioDeAlunos = repositorioDeAlunos;
    }

    //COMMAND - Pattern
    public void executar(MatricularAlunoDTO matricularAlunoDTO){
        Aluno novoAluno = matricularAlunoDTO.criarAluno();
        repositorioDeAlunos.matricular(novoAluno);
    }
}
