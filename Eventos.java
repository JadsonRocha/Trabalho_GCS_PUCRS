
import java.util.Random;

public class Eventos {

    private int codigo;
    private String nome;
    private String data;
    private double valorIngresso;
    private int lotacao;
    private String responsavel;

    public Eventos () {
        this.codigo = 0;
        this.nome = "";
        this.data = "";
        this.valorIngresso = 0.0;
        this.lotacao = 0;
        this.responsavel = "";
    }

    public Eventos(String nome, String data, double valorIngresso, int lotacao, String responsavel) {
        this.nome = nome;
        this.data = data;
        this.valorIngresso = valorIngresso;
        this.lotacao = lotacao;
        this.responsavel = responsavel;
        this.codigo = geraCodigo();
    }

    private static int geraCodigo() {
        Random random = new Random();
        return random.nextInt(900) + 100;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Evento [Codigo=" + this.codigo + ", Nome=" + this.nome + ", Data=" + this.data + ", Valor=R$" + valorIngresso + "]";
    }
}