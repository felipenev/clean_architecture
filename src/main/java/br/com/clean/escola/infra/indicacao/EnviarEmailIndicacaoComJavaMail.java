package br.com.clean.escola.infra.indicacao;

import br.com.clean.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.clean.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

    @Override
    public void enviarPara(Aluno indicado) {
    //logica de envio de email com biblioteca Java Mail
    }
}
