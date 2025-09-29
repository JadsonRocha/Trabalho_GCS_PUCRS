import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private List<Eventos> eventos;
    private List<Participantes> participantes;
    private Scanner scanner;

    public Application() {
        this.eventos = new ArrayList<>();
        this.participantes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        popularDadosIniciais(); 
    }

    private void popularDadosIniciais() {
        eventos.add(new Eventos("Show de Rock", "30/11/2025", 150.00, 200, "Daniel Callegari", 1));
        eventos.add(new Eventos("Palestra de Tecnologia", "15/10/2025", 50.00, 100, "Equipe GCS", 2));
        System.out.println("Dados iniciais foram carregados.");
    }

    public void run() {
        System.out.println("Bem-vindo ao Sistema de Gestão de Eventos!");
        int opcao = -1;
        while (opcao != 0) {
            exibirMenuPrincipal();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1: listarEventos(); break;
                case 2: buscarEventoPorNome(); break; 
                case 0: System.out.println("A encerrar o sistema..."); break;
                default: System.out.println("Opção inválida.");
            }
            if (opcao != 0) {
               System.out.println("\nPressiona Enter para continuar...");
               scanner.nextLine();
            }
        }
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Listar eventos");
        System.out.println("2. Procurar evento por nome");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
    }

    private void listarEventos() {
        System.out.println("\n--- LISTA DE EVENTOS ---");
        for (Eventos evento : eventos) {
            System.out.println(evento);
        }
    }

    private void buscarEventoPorNome() {
        System.out.println("\n--- BUSCA DE EVENTO ---");
        System.out.print("Digita parte do nome do evento: ");
        String termoBusca = scanner.nextLine();

        System.out.println("Eventos encontrados:");
        for (Eventos evento : eventos) {
            if (evento.getNome().toLowerCase().contains(termoBusca.toLowerCase())) {
                System.out.println(evento);
            }
        }
    }

}