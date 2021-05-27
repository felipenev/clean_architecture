package br.com.clean.escola.aplicacao.indicacao;

import br.com.clean.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarPara(Aluno indicado);
}
