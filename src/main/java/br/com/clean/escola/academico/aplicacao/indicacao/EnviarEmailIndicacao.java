package br.com.clean.escola.academico.aplicacao.indicacao;

import br.com.clean.escola.academico.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarPara(Aluno indicado);
}
