package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private GestaoEventos gestao;
    private Scanner entrada;

    public Application () {
        this.gestao = new GestaoEventos();
        this.entrada = new Scanner(System.in);
        popularDadosIniciais(); // para facilitar os testes
    }

    public void executar () {
        int opcao;
        do {
            MenuPrincipal();
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    menuGestaoEventos();
                    break;
                case 2:
                    menuGestaoIngressos();
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

    private void MenuPrincipal() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("[1] Gerenciar eventos");
        System.out.println("[2] Gerenciar ingressos");
        System.out.println("[0] Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void MenuEventos () {
        System.out.println("\n--- Gestão de Eventos ---");
        System.out.println("[1] Cadastrar novo evento");
        System.out.println("[2] Listar todos os eventos");
        System.out.println("[3] Buscar Evento");
        System.out.println("[4] Gerar relatório mensal");
        System.out.println("[0] Sair");
    }

    private void menuGestaoEventos() {
        int opcao;
        do {
            MenuEventos();
            opcao = Integer.parseInt(entrada.nextLine());
            switch (opcao) {
                case 1: cadastraEvento();
                break;
                case 2: listarEventos();
                break;
                case 3: buscarEvento();
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

    private void MenuIngressos(Eventos evento) {
        System.out.println("\n--- Gerenciando Ingressos para: '" + evento.getNome() + "' ---");
        System.out.println("[1] Cadastrar participante");
        System.out.println("[2] Vender ingresso");
        System.out.println("[3] Registrar entrada de participante");
        System.out.println("[4] Ver estatísticas");
        System.out.println("[5] cancelar venda de ingresso");
        System.out.println("[0] Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    private void menuGestaoIngressos(){
        System.out.println("\n--- GESTÃO DE INGRESSOS ---");
        System.out.print("digite o código do evento que deseja gerenciar: ");
        int codigo = Integer.parseInt(entrada.nextLine());

        Eventos evento = gestao.buscarEventoPorCodigo(codigo);
        if (evento == null) {
            System.out.println("Evento com o código [" + codigo + "] não encontrado.");
            return;
        }
        int opcao;
        do {
            MenuIngressos(evento);
            opcao = Integer.parseInt(entrada.nextLine());
            switch (opcao) {
                case 1:
                    cadastrarParticipante(evento);
                    break;
                case 2:
                    realizarVenda(evento);
                    break;
                case 3:
                    RegistroEntrada(evento);
                    break;
                case 4:
                    exibirEstatisticas(evento);
                    break;
                case 5:
                    cancelarIngresso(evento);
                case 0: System.out.println("Retornando ao menu principal..."); break;
                default: System.out.println("Opção inválida."); break;
            }
        } while (opcao != 0);
    }

    private void cadastraEvento () {
        System.out.println("\n--- CADASTRO DE NOVO EVENTO ---");
        System.out.print("Nome do Evento: ");
        String nome = entrada.nextLine();

        System.out.println("Data do Evento no formato (dd/mm/aaaa)");
        String data = entrada.nextLine();

        System.out.println("Valor do Ingresso: ");
        double valor = entrada.nextDouble();

        System.out.println("Lotaçao maxima do Evento:");
        int lotacao = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Responsável do Evento: ");
        String responsavel = entrada.nextLine();

        if (gestao.cadastrarEvento(nome, data, valor, lotacao, responsavel)) {
            System.out.println("Evento '" + nome + "' cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar o evento.");
        }
    }

    public void listarEventos () {
        ArrayList<Eventos> eventos = gestao.listarEventos();
        if (eventos.isEmpty()) {
            System.out.println("não existem eventos cadastrados");
        } else {
            System.out.println(eventos);
        }
    }

    private void buscarEvento () {
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
                    Eventos evento = gestao.buscarEventoPorCodigo(cod);
                    if(evento == null){
                        System.out.println("Evento com o código [" + cod + "] não encontrado.");
                    }
                    else
                        System.out.println(evento);
                    break;

                case 2:
                    System.out.print("Informe o nome do evento: ");
                    String termo = entrada.nextLine().trim().toLowerCase();
                    System.out.println("evento encontrado: ");
                    gestao.buscarEventoPorNome(termo);
                    break;

                default:
                    System.out.println("opção inválida");
            }
        }
    }

    public void cadastrarParticipante(Eventos evento){
        System.out.println("insira o nome do participante: ");
        String nome = entrada.nextLine();
        System.out.println("insira o CPF do participante:");
        String cpf = entrada.nextLine();
        System.out.println("participante adicionado com sucesso!");
        evento.getBilheteria().adicionarParticipante(nome,cpf);
    }

    public void realizarVenda(Eventos evento){
        System.out.println("insira o nome do comprador: ");
        String nomeComprador = entrada.nextLine();
        Participantes comprador = evento.getBilheteria().buscarParticipantePorNome(nomeComprador);
        System.out.println("o ingresso é especial?" +
                           "\n(1) sim" + "\n(2) não");
        int opc = Integer.parseInt(entrada.nextLine());
        boolean ehEspecial;
        if (opc == 1)
            ehEspecial = true;
        else
            ehEspecial = false;

        evento.getBilheteria().realizarVenda(comprador,ehEspecial);
        System.out.println("venda realizada com sucesso!");
        }

    private void RegistroEntrada(Eventos evento) {
        System.out.println("\n--- Marcar Presença no Evento: " + evento.getNome() + " ---");
        System.out.print("Digite o código do ingresso do participante: ");
        String codigoIngresso = entrada.nextLine();
        Bilheteria bilheteria = evento.getBilheteria();
        boolean sucesso = bilheteria.registrarEntrada(codigoIngresso);
        if (sucesso) {
            System.out.println("Presença marcada com sucesso!");
        } else {
            System.out.println("Falha ao registrar entrada.");
        }
    }

    private void exibirEstatisticas(Eventos evento) {
        System.out.println("\n--- Vendas para o Evento: " + evento.getNome() + " ---");

        Bilheteria bilheteria = evento.getBilheteria();

        int totalVendidos = bilheteria.getTotalVendidos();
        int lotacao = bilheteria.getLotacaoMax();

        if (lotacao == 0) {
            System.out.println("A lotação deste evento é 0.");
            return;
        }

        double ocupacao = ((double) totalVendidos / lotacao) * 100;

        System.out.println("Ocupação Total: " + totalVendidos + " de " + lotacao + " ingressos vendidos.");
        System.out.println(String.format("%.2f", ocupacao) + "% da lotação.");

        System.out.println("\nDados por tipo:");

        int vendidosNormais = bilheteria.getVendidosNormais();
        int maxNormais = bilheteria.getMaxNormais();
        double percNormais = ((double) vendidosNormais / maxNormais) * 100;
        System.out.println("- Normais:   " + vendidosNormais + " / " + maxNormais +
                " (" + String.format("%.2f", percNormais) + "%)");

        int vendidosEspeciais = bilheteria.getVendidosEspeciais();
        int maxEspeciais = bilheteria.getMaxEspeciais();
        double percEspeciais = ((double) vendidosEspeciais / maxEspeciais) * 100;
        System.out.println("- Especiais: " + vendidosEspeciais + " / " + maxEspeciais +
                " (" + String.format("%.2f", percEspeciais) + "%)");
    }

    public void cancelarIngresso(Eventos evento){
        System.out.println("Insira o nome do dono do ingresso");
        String nome = entrada.nextLine();
        evento.getBilheteria().cancelarIngresso(nome);
    }

    private void popularDadosIniciais () {
        gestao.cadastrarEvento("Show de Rock", "30/11/2025", 150.00, 200, "Daniel Callegari");
        gestao.cadastrarEvento("Palestra de Tecnologia", "15/10/2025", 50.00, 100, "Equipe GCS");
        gestao.cadastrarEvento("Apresentação T1 GCS", "21/11/2026", 250.00, 2, "Thomas");
    }
}
