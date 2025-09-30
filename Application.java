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
        Eventos e1 = new Eventos("Show de Rock", "30/11/2025", 150.00, 200, "Daniel Callegari", 1);
        Eventos e2 = new Eventos("Palestra de Tecnologia", "15/10/2025", 50.00, 100, "Equipe GCS", 2);

        Participantes p1 = new Participantes("Ana Silva", "111.222.333-44");
        e2.getParticipantes().add(p1);

        eventos.add(e1);
        eventos.add(e2);
    }

    public void run() {
        System.out.println("Bem-vindo ao Sistema de Gestão de Eventos!");
        int opcao = -1;
        while (opcao != 0) {
            exibirMenuPrincipal();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:

                case 2: listarEventos();
                break;

                case 3: buscarEventoPorNome();
                break;

                case 4: gerirEvento();
                break;

                case 0: System.out.println("A encerrar o sistema...");
                break;

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
        System.out.println("3. Editar um evento");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
    }

    public void cadastraEvento(){
        Eventos e = new Eventos();

        System.out.println("Nome do Evento: ");
        e.setNome(scanner.nextLine());

        System.out.println("Data do Evento: ");
        e.setData(scanner.nextLine());

        System.out.println("Valor do Ingresso: ");
        e.setValorIngresso(scanner.nextDouble());

        System.out.println("Lotaçao maxima do Evento:");
        e.setLotacao(scanner.nextInt());

        System.out.println("Responsável do Evento: ");
        e.setResponsavel(scanner.next());

        System.out.println("Codigo do Evento: ");


        eventos.add(e);
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

    private void gerirEvento() {
        System.out.print("Insere o código do evento para editar: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        Eventos eventoSelecionado = null;
        for (Eventos evento : eventos) {
            if (evento.getCodigo() == codigo) {
                eventoSelecionado = evento;
                break;
            }
        }

        if (eventoSelecionado == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        if (eventoSelecionado == null) { return; }

        System.out.println("\nA editar o evento: " + eventoSelecionado.getNome());
        System.out.println("1. Editar evento");
        System.out.println("2. Listar participantes");
        System.out.println("0. Voltar");
        System.out.print("Escolha: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        switch (opcao) {
            case 1: editarEvento(eventoSelecionado); break;
            case 2: listarParticipantesDoEvento(eventoSelecionado); break;
        }

        
    }

    private void listarParticipantesDoEvento(Eventos evento) {
        System.out.println("\n--- PARTICIPANTES DE: " + evento.getNome() + " ---");
        if (evento.getParticipantes().isEmpty()) {
            System.out.println("Nenhum participante neste evento.");
        } else {
            for (Participantes p : evento.getParticipantes()) {
                System.out.println(p);
            }
        }
    }

    private void editarEvento(Eventos evento) {
        if (!evento.getParticipantes().isEmpty()) {
            System.out.println("ERRO: Evento com participantes não pode ser editado.");
            return;
        }

        System.out.print("Novo nome do evento (" + evento.getNome() + "): ");
        String novoNome = scanner.nextLine();
        evento.setNome(novoNome);

        System.out.println("Evento editado com sucesso!");
    }
}