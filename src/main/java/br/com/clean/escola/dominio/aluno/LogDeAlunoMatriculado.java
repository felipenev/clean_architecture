package br.com.clean.escola.dominio.aluno;

import br.com.clean.escola.dominio.Evento;
import br.com.clean.escola.dominio.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {

    @Override
    public void reageAo(Evento evento){
        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        System.out.println(String.format("Aluno com CPF %s matriculado em: %s",
                                        ((AlunoMatriculado)evento).getCpfDoAluno(), momentoFormatado));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
