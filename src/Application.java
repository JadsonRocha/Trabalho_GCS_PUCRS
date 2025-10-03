package src;

import java.util.Scanner;

public class Application {
    private GestaoEventos gestao;
    private Scanner entrada;

    public Application() {
        this.gestao = new GestaoEventos();
        this.entrada = new Scanner(System.in);
        popularDadosIniciais(); 
    }

    public void executar() {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = entrada.nextInt();
            entrada.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastraEvento();
                    break;
                case 2:
                    gestao.listarEventos();
                    break;
                case 3:
                    System.out.println("Digite [1] para buscar por nome \n Digite [2] para buscar por codigo");
                    int select = entrada.nextInt();
                    if(select == 1){
                        buscarEvento();
                    }
                    else if(select == 2){
                        buscarEventoPorCodigo();
                    }
                    break;

                case 4:
                    gestao.listarEventos();
                    break;
                case 0:
                    System.out.println("Sistema finalizado...");
                    break;
                default:
                    System.out.println("Seleção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n--- Gestão de Eventos ---");
        System.out.println("[1] Cadastrar novo evento");
        System.out.println("[2] Listar todos os eventos");
        System.out.println("[3] Buscar Evento");
        System.out.println("[4] Gerar relatório mensal");
        System.out.println("[0] Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private void cadastraEvento() {
        System.out.println("\n--- CADASTRO DE NOVO EVENTO ---");
        System.out.print("Nome do Evento: ");
        String nome = entrada.nextLine();

        System.out.print("Data do Evento (dd/mm/aaaa): ");
        String data = entrada.nextLine();

        System.out.print("Valor do Ingresso: ");
        double valor = entrada.nextDouble();

        System.out.print("Lotação máxima do Evento: ");
        int lotacao = entrada.nextInt();
        entrada.nextLine(); 

        System.out.print("Responsável pelo Evento: ");
        String responsavel = entrada.nextLine();

        if (gestao.cadastrarEvento(nome, data, valor, lotacao, responsavel)) {
            System.out.println("Evento '" + nome + "' cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar o evento.");
        }
    }
    
    private void buscarEvento() {
        System.out.print("\nDigite o nome ou parte do nome do evento que deseja buscar: ");
        String nomeBusca = entrada.nextLine();
        gestao.buscarEventoPorNome(nomeBusca);
    }

    private void popularDadosIniciais() {
        gestao.cadastrarEvento("Show de Rock", "30/11/2025", 150.00, 200, "Daniel Callegari");
        gestao.cadastrarEvento("Palestra de Tecnologia", "15/10/2025", 50.00, 100, "Equipe GCS");
    }

    
    public void buscarEventoPorCodigo(){
      System.out.println("Digite o codigo do evento: ");
      int codigo = entrada.nextInt();
      entrada.nextLine();

      Eventos evento = gestao.buscarEventoPorCodigo(codigo);

      if(evento != null){
        System.out.println("Evento encontrado: " + evento);

      } else {
        System.out.println("Nenhum evento foi encontrado");
      }
      
    }

    
}

