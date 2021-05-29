package br.com.clean.escola.gamificacao.infra.selo;

import br.com.clean.escola.shared.dominio.CPF;
import br.com.clean.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.clean.escola.gamificacao.dominio.selo.Selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

    private List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionarSelo(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> selosDoAlunoDeCPF(CPF cpf) {
        return this.selos.stream()
                .filter(s -> s.getCpfDoAluno().getNumero().equals(cpf.getNumero()))
                .collect(Collectors.toList());
    }
}