package br.com.clean.escola;

import br.com.clean.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.clean.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.clean.escola.gamificacao.aplicacao.GeraSeloAlunoNovato;
import br.com.clean.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.clean.escola.gamificacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.clean.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.clean.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.clean.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoPorLinhaDeComando {

    public static void main(String[] args) {

        //Independente de onde vier a chamada, a parte de criar usuario e chamar servico de inclusao (ou qualquer outra relacionada)
        //basta passar a responsabilidade para o MatricularAluno, independente de onde vier a solicitacao.
        //Seja chamada Rest, linha de comando ou qualquer lugar.
        //Basta passar o repositorio

        String nome = "Fulano da Silva";
        String cpf = "123.456.789-00";
        String email = "fulano@email.com";

        RepositorioDeSelos repositorioDeSelos = new RepositorioDeSelosEmMemoria();

        PublicadorDeEventos publicadorDeEventos =  new PublicadorDeEventos();

        publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());// publica para varios ou nenhum ouvinte.
        publicadorDeEventos.adicionar(new GeraSeloAlunoNovato(repositorioDeSelos));
        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicadorDeEventos);
        matricular.executar(new MatricularAlunoDTO(cpf, nome, email));
    }
}
