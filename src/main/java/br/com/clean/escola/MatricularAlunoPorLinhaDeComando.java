package br.com.clean.escola;

import br.com.clean.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.clean.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.clean.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoPorLinhaDeComando {

    public static void main(String[] args) {

        //Independente de onde vier a chamada, a parte de criar usuario e chamar servico de inclusao (ou qualquer outra relacionada)
        //basta passar a responsabilidade para o MatricularAluno, independente de onde vier a solicitacao.
        //Seja chamada Rest, linha de comando ou qualquer lugar.
        //Basta passar o repositorio

        String nome = "Fulano da Silva";
        String cpf = "123.456.789-00";
        String email = "fulano@email.com";

        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
        matricular.executar(new MatricularAlunoDTO(cpf, nome, email));
    }
}
