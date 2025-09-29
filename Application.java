import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Eventos> eventos;
    private List<Participantes> participantes;

    public Application() {
        this.eventos = new ArrayList<>();
        this.participantes = new ArrayList<>();
        popularDadosIniciais(); 
    }

    private void popularDadosIniciais() {
        eventos.add(new Eventos("Show de Rock", "30/11/2025", 150.00, 200, "Daniel Callegari", 1));
        eventos.add(new Eventos("Palestra de Tecnologia", "15/10/2025", 50.00, 100, "Equipe GCS", 2));
        System.out.println("Dados iniciais carregados.");
    }

    public void run() {
        System.out.println("Bem-vindo ao Sistema de Gestão de Eventos!");
    }
}