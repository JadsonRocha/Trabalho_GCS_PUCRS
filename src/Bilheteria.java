package src;

import java.util.ArrayList;

public class Bilheteria {
    private Eventos evento;
    private ArrayList<Ingressos> ingressosVendidos;

    public Bilheteria(Eventos evento) {
        this.evento = evento;
        this.ingressosVendidos = new ArrayList<>();
    }

    public boolean realizarVenda(Participantes participante, boolean especial) {
        if (ingressosVendidos.size() >= evento.getLotacao()) {
            System.out.println("Lotação máxima atingida. Não é possível vender mais ingressos.");
            return false;
        }

        String codIngresso;
        int proximoNumero = ingressosVendidos.size() + 1;

        if (especial) {
            codIngresso = evento.getCodigo() + "-E" + String.format("%03d", proximoNumero);
        } else {
            codIngresso = evento.getCodigo() + "-N" + String.format("%03d", proximoNumero);
        }

        Ingressos novoIngresso = new Ingressos(participante, codIngresso, especial);
        ingressosVendidos.add(novoIngresso);
        System.out.println("Venda realizada com sucesso! Ingresso: " + codIngresso);
        return true;
    }
    
    public boolean registrarEntrada(String codigoIngresso) {
        for (Ingressos ingresso : ingressosVendidos) {
            if (ingresso.getCodigo().equalsIgnoreCase(codigoIngresso)) {
                if (ingresso.isFoiUtilizado()) {
                    System.out.println("ATENÇÃO: Este ingresso já foi utilizado.");
                    return false;
                }
                ingresso.setFoiUtilizado(true);
                System.out.println("Entrada registrada com sucesso para: " + ingresso.getParticipante().getNome());
                return true;
            }
        }
        System.out.println("ERRO: Ingresso não encontrado.");
        return false;
    }
    
    public int getQuantidadeIngressosVendidos() {
        return ingressosVendidos.size();
    }
}