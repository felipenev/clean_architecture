package br.com.clean.escola.dominio.aluno;


import java.util.List;

/** Conceitos do dominio da aplicacao */


public interface RepositorioDeAlunos {

    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf);

    List<Aluno> listarTodosAlunosMatriculados();

    //...
}
