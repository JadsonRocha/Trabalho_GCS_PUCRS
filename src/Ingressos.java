package src;

public class Ingressos {

    private boolean especial;
    private String codigo;
    private Participantes Participante;
    private boolean foiUtilizado;

    public Ingressos(Participantes comprador, String codigo, Boolean especial){
        especial = especial;
        codigo = codigo;
        Participante = comprador;
    }

    public boolean isEspecial () {
        return especial;
    }

    public void setEspecial (boolean especial) {
        this.especial = especial;
    }

    public String getCodigo () {
        return codigo;
    }

    public void setCodigo (String codigo) {
        this.codigo = codigo;
    }

    public Participantes getParticipante () {
        return Participante;
    }

    public void setParticipante (Participantes participante) {
        Participante = participante;
    }

    public boolean getfoiUtilizado () {
        return foiUtilizado;
    }

    public void setfoiUtilizado (boolean foiUtilizado) {
        foiUtilizado = foiUtilizado;
    }
}