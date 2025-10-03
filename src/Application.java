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
        opcao = entrada.nextInt();
        entrada.nextLine();

        //em seguida vou criar o Switch case
        switch(opcao){
          case 1:
            cadastraEvento();
            break;

          case 2:
            listarEventos();
            break;

          case 3:
            buscarEvento();
            break;

          case 4:
            // Gerar relatorio mensal
            break;

          case 0:
            System.out.println("Sistema finalizado...");
            break;

          default:
            System.out.println("Seleçao invalida");
            break;
        }

    } while (opcao != 0);
  }

    private void exibirMenuPrincipal() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Listar eventos");
        System.out.println("2. Procurar evento por nome");
        System.out.println("3. Editar um evento");
        System.out.println("0. Sair");
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

        System.out.println("Responsável do Evento: ");
        entrada.next(); //limpando buffer
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

    public void listarEventos(){
      ArrayList<Eventos> eventos = gestao.listarEventos();
      if (eventos.isEmpty()){
          System.out.println("não existem eventos cadastrados");
      }
      else{
          System.out.println(eventos);
      }
    }

    private void buscarEvento() {
        System.out.println("\n--- BUSCANDO EVENTO ---");
        if (gestao.listarEventos().isEmpty())

            System.out.println("ainda não existem eventos cadastrados");
        else {

            System.out.println("[1] Por código");
            System.out.println("[2] Por nome (contém)");
            System.out.print("Escolha: ");
            int op = entrada.nextInt();
            entrada.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Informe o código do evento: ");
                    int cod = entrada.nextInt();
                    entrada.nextLine();
                    gestao.buscarEventoPorCodigo(cod);
                    break;

                case 2:
                    System.out.print("Informe o nome do evento: ");
                    String termo = entrada.nextLine().trim().toLowerCase();
                    gestao.buscarEventoPorNome(termo);
                    break;

                default:
                    System.out.println("opção inválida");
            }
        }
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

