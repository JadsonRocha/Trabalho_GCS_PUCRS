import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Eventos> eventos;
    private List<Participantes> participantes;

    public Application() {
        this.eventos = new ArrayList<>();
        this.participantes = new ArrayList<>();
    }

    public void run() {
        System.out.println("Sistema de Gestão de Eventos iniciado!");
    }
}