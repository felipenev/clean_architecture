package br.com.clean.escola.academico.dominio.aluno;


import br.com.clean.escola.shared.dominio.CPF;

import java.util.List;

/** Conceitos do dominio da aplicacao */


public interface RepositorioDeAlunos {

    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf);

    List<Aluno> listarTodosAlunosMatriculados();

    //...
}
