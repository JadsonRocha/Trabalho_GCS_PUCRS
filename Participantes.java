public class Participantes {
    private String nome;
    private String cpf;

    public Participantes (String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome () {
        return nome;
    }

    public String getCpf () {
        return cpf;
    }
}
