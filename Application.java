import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    private GestaoEventos gestao;
    private Scanner scanner;

    public Application() {
        this.gestao = new GestaoEventos();
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

                case 2: gestao.listarEventos();
                break;

                case 3:
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

        System.out.println("Data do Evento no formato (dd/mm/aaaa)");
        String data = scanner.nextLine();

        System.out.println("Valor do Ingresso: ");
        Double valor = scanner.nextDouble();

        System.out.println("Lotaçao maxima do Evento:");
        int lotacao = scanner.nextInt();

        System.out.println("Responsável do Evento: ");
        String responsavel = scanner.nextLine();

        gestao.cadastrarEvento(nome, data, valor, lotacao, responsavel);
    }

        private void popularDadosIniciais() {
            gestao.cadastrarEvento("Show de Rock", "30/11/2025", 150.00, 200, "Daniel Callegari");
            gestao.cadastrarEvento("Palestra de Tecnologia", "15/10/2025", 50.00, 100, "Equipe GCS");

            gestao.

        }
    }