public class Ingressos {

    private boolean especial;
    private String codigo;

    public Ingressos(int codigo, boolean especial){
        this.especial = especial;
    }

    public boolean isEspecial () {
        return especial;
    }

    public void setEspecial (boolean especial) {
        this.especial = especial;
    }
}
