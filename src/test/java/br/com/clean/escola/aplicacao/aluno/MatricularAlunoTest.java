package br.com.clean.escola.aplicacao.aluno;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.clean.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.clean.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import org.junit.jupiter.api.Test;

import br.com.clean.escola.dominio.aluno.Aluno;
import br.com.clean.escola.dominio.aluno.CPF;
import br.com.clean.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {
        // MOCK -> Mockito
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);

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
