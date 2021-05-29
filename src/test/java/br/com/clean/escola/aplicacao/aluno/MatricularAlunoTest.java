package br.com.clean.escola.aplicacao.aluno;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.clean.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.clean.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.clean.escola.dominio.PublicadorDeEventos;
import br.com.clean.escola.dominio.aluno.LogDeAlunoMatriculado;
import org.junit.jupiter.api.Test;

import br.com.clean.escola.dominio.aluno.Aluno;
import br.com.clean.escola.dominio.aluno.CPF;
import br.com.clean.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {
        // MOCK -> Mockito
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
        publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
        MatricularAluno useCase = new MatricularAluno(repositorio, publicadorDeEventos);

        MatricularAlunoDTO dados = new MatricularAlunoDTO(
                "123.456.789-00",
                "Fulano",
                "fulano@email.com");
        useCase.executar(dados);

        Aluno encontrado = repositorio.buscarPorCPF(
                new CPF("123.456.789-00"));

        assertEquals("Fulano", encontrado.getNome());
        assertEquals("123.456.789-00", encontrado.getCpf());
        assertEquals("fulano@email.com", encontrado.getEmail());
    }

}
