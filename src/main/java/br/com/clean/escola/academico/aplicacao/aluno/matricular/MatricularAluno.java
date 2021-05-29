package br.com.clean.escola.academico.aplicacao.aluno.matricular;

import br.com.clean.escola.academico.dominio.PublicadorDeEventos;
import br.com.clean.escola.academico.dominio.aluno.Aluno;
import br.com.clean.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.clean.escola.academico.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {

    private final RepositorioDeAlunos repositorioDeAlunos;
    private final PublicadorDeEventos publicadorDeEventos;

    public MatricularAluno(RepositorioDeAlunos repositorioDeAlunos, PublicadorDeEventos publicadorDeEventos) {
        this.repositorioDeAlunos = repositorioDeAlunos;
        this.publicadorDeEventos = publicadorDeEventos;
    }

    //COMMAND - Pattern
    public void executar(MatricularAlunoDTO matricularAlunoDTO){
        Aluno novoAluno = matricularAlunoDTO.criarAluno();
        repositorioDeAlunos.matricular(novoAluno);

        AlunoMatriculado alunoMatriculadoEvento = new AlunoMatriculado(novoAluno.getCpf());
        publicadorDeEventos.publicar(alunoMatriculadoEvento);
    }
}
