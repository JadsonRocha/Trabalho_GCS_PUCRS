public class Ingressos {

    private boolean especial;
    private String codigo;
    private Participantes Comprador;

    public Ingressos(){
        especial = false;
        codigo = "";
        Comprador = null;
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

    public Participantes getComprador () {
        return Comprador;
    }

    public void setComprador (Participantes comprador) {
        Comprador = comprador;
    }

}
