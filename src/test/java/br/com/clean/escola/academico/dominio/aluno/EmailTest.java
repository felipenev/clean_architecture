package br.com.clean.escola.academico.dominio.aluno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {

    @Test
    void naoDeveriaCriarEmailsComEnderecosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));

        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));

        assertThrows(IllegalArgumentException.class,
                () -> new Email("emailinvalido"));
    }

    @Test
    void deveriaPermitirCriarEmailComEnderecoValido() {
        String endereco = "fulano@alura.com.br";
        Email email = new Email(endereco);
        assertEquals(endereco, email.getEndereco());
    }

}