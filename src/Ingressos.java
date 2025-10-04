package src;

public class Ingressos {

    private boolean especial;
    private String codigo;
    private Participantes participante;
    private boolean foiUtilizado;

    public Ingressos(Participantes participante, String codigo, boolean especial) {
        this.especial = especial;
        this.codigo = codigo;
        this.participante = participante;
        this.foiUtilizado = false;
    }

    public boolean isEspecial() {
        return especial;
    }

    public String getCodigo() {
        return codigo;
    }

    public Participantes getParticipante() {
        return participante;
    }

    public boolean getfoiUtilizado () {
        return foiUtilizado;
    }

    public void setfoiUtilizado (boolean foiUtilizado) {
        this.foiUtilizado = foiUtilizado;
    }

    public void setParticipante (Participantes participante) {
        this.participante = participante;
    }

    @Override
    public String toString() {
        if (participante != null) {
            if (especial) {
                return codigo + " - Especial - " + participante.getNome();
            } else {
                return codigo + " - Normal - " + participante.getNome();
            }
        } else {
            if (especial) {
                return codigo + " - Especial (ingresso disponível)";
            } else {
                return codigo + " - Normal (ingresso disponível)";
            }
        }
    }
}