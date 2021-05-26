package escola;

public class Email {

    private String endereco;

    public Email(String endereco){

        if(endereco == null || !endereco.matches("")){
            throw new IllegalArgumentException("Endereço inválido!");
        }
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
