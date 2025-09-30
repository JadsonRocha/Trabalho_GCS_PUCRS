import java.util.ArrayList;
import java.util.List;

public class Eventos {
    private String nome;
    private String data;
    private double valorIngresso;
    private int lotacao;
    private String responsavel;
    private int codigo;
    private Bilheteria bilheteria;

    public Eventos (String nome, String data, double valorIngresso, int lotacao, String responsavel, int codigo) {
        this.nome = nome;
        this.data = data;
        this.valorIngresso = valorIngresso;
        this.lotacao = lotacao;
        this.responsavel = responsavel;
        this.codigo = codigo;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getData () {
        return data;
    }

    public void setData (String data) {
        this.data = data;
    }

    public double getValorIngresso () {
        return valorIngresso;
    }

    public void setValorIngresso (double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public int getLotacao () {
        return lotacao;
    }

    public void setLotacao (int lotacao) {
        this.lotacao = lotacao;
    }

    public String getResponsavel () {
        return responsavel;
    }

    public void setResponsavel (String responsavel) {
        this.responsavel = responsavel;
    }

    public int getCodigo () {
        return codigo;
    }

    @Override
    public String toString() {
        return "Evento [Codigo=" + codigo + ", Nome=" + nome + ", Data=" + data + ", Valor=R$" + valorIngresso + "]";
    }
}
