
public class Ingressos {

    private boolean  especial;
    private String codigo;
    private Participantes participante;
    private boolean foiUtilizado;

    public Ingressos(Participantes comprador, String codigo, boolean especial){
        this.especial = especial;
        this.codigo = codigo;
        this.participante = comprador;
        this.foiUtilizado = false;
    }

    public boolean isEspecial () {
        return especial;
    }

    public String getCodigo () {
        return codigo;
    }

    public Participantes getParticipante () {
        return participante;
    }

    public boolean isFoiUtilizado () {
        return foiUtilizado;
    }

    public void setFoiUtilizado(boolean usado) {
        this.foiUtilizado = usado;
    }

   @Override
    public String toString() {
        if (participante != null) {
            if (especial == true) {
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

 

