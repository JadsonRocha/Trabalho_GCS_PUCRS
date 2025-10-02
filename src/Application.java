import java.util.ArrayList;
import java.util.Scanner;

public class Application {
  private ArrayList<Eventos> eventos;
  private Scanner entrada;
  private int contadorCodigo;

  public Application() {
    this.eventos = new ArrayList<>();
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
            listaEventos();
            break;
          
          case 3:
            // Buscar Evento
            buscarEvento();
            break;

          case 4:
            // Gerar relatorio mensal
            gerarRelatorioMensal();
            break;
          
          case 0:
            System.out.println("Sistema finalizado...");
            break;
          
          default:
            System.out.println("Seleçao invalida");
            entrada.close();
            break;
        }

    } while (opcao != 0);
  }

    public void cadastraEvento(){
      Eventos e = new Eventos();

      System.out.println("Nome do Evento: ");
      e.setNome(entrada.nextLine());

      System.out.println("Data do Evento: ");
      e.setData(entrada.nextLine());
      
      System.out.println("Valor do Ingresso: ");
      e.setValorIngresso(entrada.nextDouble());

      System.out.println("Lotaçao maxima do Evento:");
      e.setLotacao(entrada.nextInt());

      System.out.println("Responsável do Evento: ");
      e.setResponsavel(entrada.next());

      System.out.println("Codigo do Evento: ");
      e.setCodigo(entrada.nextInt());
      contadorCodigo++;
      
      eventos.add(e);
    }

    public void listaEventos(){
      int contadorEventos = 0;
      for(Eventos e : eventos){
        if(e instanceof Eventos){
          System.out.println(e);
          contadorEventos++;
          System.out.println("\n-------------------------------- \n");
          
        }
        
      }
    }

    private void buscarEvento() {
      System.out.println("\n-- Buscar Evento --");
      System.out.println("[1] Por código");
      System.out.println("[2] Por nome (contém)");
      System.out.print("Escolha: ");
      int op = entrada.nextInt();
      entrada.nextLine();
  
      if (op == 1) {
        System.out.print("Informe o código do evento: ");
        int cod = entrada.nextInt();
        entrada.nextLine();
  
        Eventos achado = null;
        for (Eventos e : eventos) {
          if (e.getCodigo() == cod) {
            achado = e;
            break;
          }
        }
  
        if (achado != null) {
          System.out.println("\nEvento encontrado:");
          System.out.println(achado);
        } else {
          System.out.println("Nenhum evento com o código " + cod + " foi encontrado.");
        }
  
      } else if (op == 2) {
        System.out.print("Informe parte do nome: ");
        String termo = entrada.nextLine().trim().toLowerCase();
  
        int cont = 0;
        for (Eventos e : eventos) {
          if (e.getNome() != null && e.getNome().toLowerCase().contains(termo)) {
            if (cont == 0)
              System.out.println("\nEventos encontrados:");
            System.out.println(e);
            System.out.println("--------------------------------");
            cont++;
          }
        }
        if (cont == 0) {
          System.out.println("Nenhum evento com nome contendo \"" + termo + "\" foi encontrado.");
        }
  
      } else {
        System.out.println("Opção inválida.");
      }
    }

    private void gerarRelatorioMensal() {
      System.out.println("\n-- Relatório Mensal --");
      System.out.print("Informe o mês (1-12): ");
      int mes = entrada.nextInt();
      System.out.print("Informe o ano (ex.: 2024): ");
      int ano = entrada.nextInt();
      entrada.nextLine();
  
      if (mes < 1 || mes > 12 || ano < 1000) {
        System.out.println("Mês/ano inválidos.");
        return;
      }
  
      int qtd = 0;
      double soma = 0.0;
      Double menor = null;
      Double maior = null;
  
      System.out.println("\nEventos do mês " + String.format("%02d", mes) + "/" + ano + ":");
      for (Eventos e : eventos) {
        if (e.getData() == null)
          continue;
        String data = e.getData().trim().replace('-', '/');
        String[] partes = data.split("/");
  
        if (partes.length != 3)
          continue;
  
        try {
          int m = Integer.parseInt(partes[1]);
          int a = Integer.parseInt(partes[2]);
  
          if (m == mes && a == ano) {
            System.out.println(e);
            System.out.println("--------------------------------");
  
            qtd++;
            double v = e.getValorIngresso();
            soma += v;
            if (menor == null || v < menor)
              menor = v;
            if (maior == null || v > maior)
              maior = v;
          }
        } catch (NumberFormatException ex) {
          // ignora erros de data
        }
      }
  
      if (qtd == 0) {
        System.out.println("Nenhum evento encontrado para " + String.format("%02d", mes) + "/" + ano + ".");
      } else {
        System.out.println("Resumo do mês:");
        System.out.println("Quantidade de eventos: " + qtd);
        System.out.printf("Soma dos valores de ingresso: %.2f%n", soma);
        System.out.printf("Menor valor de ingresso: %.2f%n", menor);
        System.out.printf("Maior valor de ingresso: %.2f%n", maior);
      }
    }
  }
  




