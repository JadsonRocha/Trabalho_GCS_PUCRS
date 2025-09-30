import java.util.ArrayList;
import java.util.Scanner;

public class Application {
  private ArrayList<Eventos> eventos;
  private Scanner entrada;
  private int contadorCodigo;

  public Application() {
    this.eventos = new ArrayList<>();
    this.entrada = new Scanner(System.in);
    this.contadorCodigo = 1;

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
            //Cadastrar novo evento
            break;
          
          case 2:
            // Listar todos Eventos
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

  
}
