import java.util.ArrayList;

public class Bilheteria {
    private Eventos eventos;
    private ArrayList<Ingressos> ingressos;
    private Participantes participantes;

    public Bilheteria(){
        ingressos = new ArrayList<>();
    }

    public boolean realizarVenda(){
        System.out.println("insira o nome do evento");
    }
}
