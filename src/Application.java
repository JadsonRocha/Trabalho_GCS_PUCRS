package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
  private GestaoEventos gestao;
  private Scanner entrada;
  private int contadorCodigo;

  public Application() {
    this.gestao = new GestaoEventos();
    this.entrada = new Scanner(System.in);
    this.contadorCodigo = 0;

  }
  public void executar() {
    int opcao;

    do {
        System.out.println("\n--- Gestão de Eventos---");
        System.out.println("[1] Cadastrar novo evento");
        System.out.println("[2] Listar todos os eventos");
        System.out.println("[3] Buscar Evento");
        System.out.println("[4] Gerar relatorio mensal");
        System.out.println("[0] Sair");
        opcao = entrada.nextInt();
        entrada.nextLine();

        //em seguida vou criar o Switch case
        switch(opcao){
          case 1:
            cadastraEvento();
            break;

          case 2:
            gestao.listarEventos();
            break;

          case 3:
            // Buscar Evento
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
        System.out.print("Escolha: ");
    }

    public void cadastraEvento() {
        System.out.println("---REALIZANDO CADASTRO DE EVENTO---");
        System.out.println("Nome do Evento: ");
        String nome = entrada.nextLine();

        System.out.println("Data do Evento no formato (dd/mm/aaaa)");
        String data = entrada.nextLine();

        System.out.println("Valor do Ingresso: ");
        Double valor = entrada.nextDouble();

        System.out.println("Lotaçao maxima do Evento:");
        int lotacao = entrada.nextInt();

        System.out.println("Responsável do Evento: ");
        String responsavel = entrada.nextLine();

        gestao.cadastrarEvento(nome, data, valor, lotacao, responsavel);
    }

    private void popularDadosIniciais() {
        gestao.cadastrarEvento("Show de Rock", "30/11/2025", 150.00, 200, "Daniel Callegari");
        gestao.cadastrarEvento("Palestra de Tecnologia", "15/10/2025", 50.00, 100, "Equipe GCS");
    }
}
