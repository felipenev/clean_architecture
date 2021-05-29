package br.com.clean.escola.gamificacao.aplicacao;

import br.com.clean.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.clean.escola.gamificacao.dominio.selo.Selo;
import br.com.clean.escola.shared.dominio.CPF;
import br.com.clean.escola.shared.dominio.evento.Evento;
import br.com.clean.escola.shared.dominio.evento.Ouvinte;
import br.com.clean.escola.shared.dominio.evento.TipoDeEvento;

public class GeraSeloAlunoNovato extends Ouvinte {

    private final RepositorioDeSelos repositorioDeSelos;

    public GeraSeloAlunoNovato(RepositorioDeSelos repositorioDeSelos) {
        this.repositorioDeSelos = repositorioDeSelos;
    }

    @Override
    protected void reageAo(Evento evento) {

        CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
        Selo novato = new Selo(cpfDoAluno, "Novato"); //Novato poderia ser um Enum ou algo do tipo
        repositorioDeSelos.adicionarSelo(novato);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return TipoDeEvento.ALUNO_MATRICULADO.equals(evento.tipo());
    }
}
