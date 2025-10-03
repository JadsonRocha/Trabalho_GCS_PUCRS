package src;

import java.util.ArrayList;
import java.util.Random;

public class Eventos {

    private static int contador = 100; 
    private int codigo;
    private String nome;
    private String data;
    private double valorIngresso;
    private int lotacao;
    private String responsavel;
    private ArrayList<Participantes> participantes;
    private Bilheteria bilheteria;

    public Eventos() {
        this.participantes = new ArrayList<>();
        this.bilheteria = new Bilheteria(this);
    }

    public Eventos(String nome, String data, double valorIngresso, int lotacao, String responsavel) {
        this.nome = nome;
        this.data = data;
        this.valorIngresso = valorIngresso;
        this.lotacao = lotacao;
        this.responsavel = responsavel;
        this.codigo = geraCodigo(); 
        this.participantes = new ArrayList<>();
        this.bilheteria = new Bilheteria(this);
    }

    private static int geraCodigo() {
        return contador++;
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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Bilheteria getBilheteria() {
        return this.bilheteria;
    }

    @Override
    public String toString() {
        return "Evento Cód: " + getCodigo() + "\n" +
               "  Nome: " + getNome() + "\n" +
               "  Data: " + getData() + "\n" +
               "  Valor do Ingresso: R$" + getValorIngresso() + "\n" +
               "  Lotação Máxima: " + getLotacao() + "\n" +
               "  Responsável: " + getResponsavel() + "\n";
    }
}