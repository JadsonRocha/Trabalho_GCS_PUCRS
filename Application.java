import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private GestaoEventos gestao;

    private Scanner scanner;

    public Application() {
        this.gestaoEventos = new GestaoEventos();
        this.scanner = new Scanner(System.in);
        popularDadosIniciais(); 
    }


    public void run() {
        System.out.println("Bem-vindo ao Sistema de Gestão de Eventos!");
        int opcao = -1;
        while (opcao != 0) {
            exibirMenuPrincipal();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastraEvento();
                    break;

                case 2: GestaoEventos.listarEventos();
                break;

                case 3:
                    buscarEventoPorNome();
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

    public void cadastraEvento() {
        System.out.println("---REALIZANDO CADASTRO DE EVENTO---");
        System.out.println("Nome do Evento: ");
        String nome = scanner.nextLine();

        System.out.println("Data do Evento: ");

        System.out.println("dia: ");
        S

        System.out.println("Valor do Ingresso: ");
        e.setValorIngresso(valor);

        System.out.println("Lotaçao maxima do Evento:");
        e.setLotacao(lotacao);

        System.out.println("Responsável do Evento: ");
        e.setResponsavel(responsavel);

        eventos.add(e);
        return true;
    }

        private void popularDadosIniciais() {
            Eventos e1 = new Eventos("Show de Rock", "30/11/2025", 150.00, 200, "Daniel Callegari");
            Eventos e2 = new Eventos("Palestra de Tecnologia", "15/10/2025", 50.00, 100, "Equipe GCS");

            Participantes p1 = new Participantes("Ana Silva", "111.222.333-44");
            e2.getParticipantes().add(p1);

            eventos.add(e1);
            eventos.add(e2);

        }
    }