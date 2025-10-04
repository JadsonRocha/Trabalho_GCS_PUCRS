package src;

import java.util.ArrayList;

public class Bilheteria {
    private Eventos eventos;
    private ArrayList<Ingressos> ingressos;
    private ArrayList<Participantes> participantes;

    private final int lotacaoMax;
    private final int maxEspeciais;
    private final int maxNormais;
    private int vendidosEspeciais = 0;
    private int vendidosNormais = 0;
    private int seqTotal = 0;

    public Bilheteria (Eventos evento) {
        this.eventos = evento;
        this.lotacaoMax = evento.getLotacao();
        this.maxEspeciais = (int) Math.ceil(this.lotacaoMax * 0.15);
        this.maxNormais = this.lotacaoMax - this.maxEspeciais;

        this.ingressos = new ArrayList<>(evento.getLotacao());
        this.participantes = new ArrayList<>();
    }

    public void adicionarParticipante (String nome, String cpf) {
        Participantes p = new Participantes(nome, cpf);
        participantes.add(p);
    }

    public boolean realizarVenda(Participantes participante, boolean especial){
        if ((vendidosNormais + vendidosEspeciais) >= lotacaoMax) return false;

        if (especial) {
            if (vendidosEspeciais >= maxEspeciais) return false;
        } else {
            if (vendidosNormais >= maxNormais) return false;
        }

        seqTotal += 1;
        String codIngresso = String.format("%d-%03d%s",
                eventos.getCodigo(),
                seqTotal,
                (especial ? "E" : ""));

        Ingressos ingresso = new Ingressos(participante, codIngresso, especial);
        ingressos.add(ingresso);

        if (especial) vendidosEspeciais++; else vendidosNormais++;
        return true;
    }

    public boolean cancelarIngresso(String nomeParticipante) {
        for (Ingressos ingresso : ingressos) {
            if (ingresso.getParticipante().getNome().equals(nomeParticipante)) {

                if (ingresso.getfoiUtilizado()) {
                    System.out.println("Não é possível cancelar.");
                    return false;
                }

                ingressos.remove(ingresso);

                if (ingresso.isEspecial()) {
                    vendidosEspeciais--;
                } else {
                    vendidosNormais--;
                }
                return true;
            }
        }
        System.out.println("Ingresso não encontrado.");
        return false;
    }

    public boolean registrarEntrada(String codigoIngresso) {
        for (Ingressos ingresso : ingressos) {
            if (ingresso.getCodigo().equalsIgnoreCase(codigoIngresso)) {
                if (ingresso.getfoiUtilizado()) {
                    return false;
                }
                ingresso.setfoiUtilizado(true);
                return true;
            }
        }
        return false;
    }

    public Participantes buscarParticipantePorNome(String nomeBuscado) {
        String nome = nomeBuscado.toLowerCase().trim();
        for (Participantes participante : this.participantes) {
            String nomeCompletoLower = participante.getNome().toLowerCase();
            if (nomeCompletoLower.contains(nome)) {
                return participante;
            }
        }
        return null;
    }

    public int getVendidosNormais () {
        return vendidosNormais;
    }

    public int getVendidosEspeciais () {
        return vendidosEspeciais;
    }

    public int getTotalVendidos() {
        return vendidosNormais + vendidosEspeciais;
    }

    public int getMaxNormais () {
        return maxNormais;
    }

    public int getMaxEspeciais () {
        return maxEspeciais;
    }

    public int getLotacaoMax () {
        return lotacaoMax;
    }
}