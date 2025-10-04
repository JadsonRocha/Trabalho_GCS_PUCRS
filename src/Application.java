package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
            MenuPrincipal();
            try {
                opcao = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1; 
            }

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

    private void MenuEventos() {
        System.out.println("\n--- Gestão de Eventos ---");
        System.out.println("[1] Cadastrar novo evento");
        System.out.println("[2] Listar todos os eventos");
        System.out.println("[3] Buscar Evento");
        System.out.println("[4] Gerar relatórios");
        System.out.println("[0] Voltar ao menu anterior");
        System.out.print("Escolha uma opção: ");
    }

    private void menuGestaoEventos() {
        int opcao;
        do {
            MenuEventos();
            try {
                opcao = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }
            switch (opcao) {
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
                    menuRelatorios();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Seleção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
    
    private void menuRelatorios() {
        System.out.println("\n--- Menu de Relatórios ---");
        System.out.println("[1] Relatório Mensal");
        System.out.println("[2] Relatório Anual");
        System.out.println("[0] Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao;
        try {
            opcao = Integer.parseInt(entrada.nextLine());
        } catch (NumberFormatException e) {
            opcao = -1;
        }

        switch (opcao) {
            case 1:
                exibirRelatorioMensal();
                break;
            case 2:
                exibirRelatorioAnual();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void exibirRelatorioMensal() {
        try {
            System.out.print("Digite o mês (1-12): ");
            int mes = Integer.parseInt(entrada.nextLine());
            System.out.print("Digite o ano (ex: 2025): ");
            int ano = Integer.parseInt(entrada.nextLine());

            if (mes < 1 || mes > 12) {
                System.out.println("Mês inválido. Deve ser entre 1 e 12.");
                return;
            }

            String relatorio = gestao.gerarRelatorioMensal(mes, ano);
            System.out.println(relatorio);

        } catch (NumberFormatException e) {
            System.out.println("Erro: Mês e ano devem ser números.");
        }
    }

    private void exibirRelatorioAnual() {
        try {
            System.out.print("Digite o ano (ex: 2025): ");
            int ano = Integer.parseInt(entrada.nextLine());
            String relatorio = gestao.gerarRelatorioAnual(ano);
            System.out.println(relatorio);
        } catch (NumberFormatException e) {
            System.out.println("Erro: O ano deve ser um número.");
        }
    }

    private boolean isDataValida(String dataStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate data = LocalDate.parse(dataStr, formatter);
            if (data.isBefore(LocalDate.now())) {
                System.out.println("ERRO: A data do evento deve ser no futuro.");
                return false;
            }
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("ERRO: Formato de data inválido. Use dd/mm/aaaa.");
            return false;
        }
    }
    
    private void cadastraEvento() {
        System.out.println("\n--- CADASTRO DE NOVO EVENTO ---");
        System.out.print("Nome do Evento: ");
        String nome = entrada.nextLine();

        String data;
        do {
            System.out.print("Data do Evento no formato (dd/mm/aaaa): ");
            data = entrada.nextLine();
        } while (!isDataValida(data));

        try {
            System.out.print("Valor do Ingresso: ");
            double valor = Double.parseDouble(entrada.nextLine());

            System.out.print("Lotação máxima do Evento: ");
            int lotacao = Integer.parseInt(entrada.nextLine());

            System.out.print("Responsável pelo Evento: ");
            String responsavel = entrada.nextLine();

            if (gestao.cadastrarEvento(nome, data, valor, lotacao, responsavel)) {
                System.out.println("Evento '" + nome + "' cadastrado com sucesso!");
            } else {
                System.out.println("Falha ao cadastrar o evento.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro de entrada: Valor e lotação devem ser números.");
        }
    }

    public void listarEventos() {
        System.out.println("\n--- LISTA DE TODOS OS EVENTOS ---");
        ArrayList<Eventos> eventos = gestao.getEventos();
        if (eventos.isEmpty()) {
            System.out.println("Não existem eventos cadastrados.");
        } else {
            for (Eventos evento : eventos) {
                System.out.println(evento);
            }
        }
    }

    private void MenuIngressos(Eventos evento) {
        System.out.println("\n--- Gerenciando Ingressos para: '" + evento.getNome() + "' ---");
        System.out.println("[1] Cadastrar participante");
        System.out.println("[2] Vender ingresso");
        System.out.println("[3] Registrar entrada de participante");
        System.out.println("[4] Ver estatísticas");
        System.out.println("[5] Cancelar venda de ingresso");
        System.out.println("[0] Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    private void menuGestaoIngressos(){
        System.out.println("\n--- GESTÃO DE INGRESSOS ---");
        System.out.print("Digite o código do evento que deseja gerenciar: ");
        try {
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
                        break;
                    case 0: System.out.println("Retornando ao menu principal..."); break;
                    default: System.out.println("Opção inválida."); break;
                }
            } while (opcao != 0);
        } catch (NumberFormatException e) {
            System.out.println("Código inválido. Deve ser um número.");
        }
    }

    private void buscarEvento() {
        System.out.println("\n--- BUSCANDO EVENTO ---");
        if (gestao.getEventos().isEmpty()){
            System.out.println("Ainda não existem eventos cadastrados");
            return;
        }
        
        System.out.println("[1] Por código");
        System.out.println("[2] Por nome (contém)");
        System.out.print("Escolha: ");
        int op;
        try {
            op = Integer.parseInt(entrada.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida.");
            return;
        }
        
        switch (op) {
            case 1:
                System.out.print("Informe o código do evento: ");
                int cod = Integer.parseInt(entrada.nextLine());
                Eventos evento = gestao.buscarEventoPorCodigo(cod);
                if (evento == null) {
                    System.out.println("Evento com o código [" + cod + "] não encontrado.");
                } else {
                    System.out.println(evento);
                }
                break;
            case 2:
                System.out.print("Informe o nome do evento: ");
                String termo = entrada.nextLine().trim().toLowerCase();
                gestao.buscarEventoPorNome(termo);
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    public void cadastrarParticipante(Eventos evento){
        System.out.print("Insira o nome do participante: ");
        String nome = entrada.nextLine();
        System.out.print("Insira o CPF do participante: ");
        String cpf = entrada.nextLine();
        evento.getBilheteria().adicionarParticipante(nome,cpf);
        System.out.println("Participante adicionado com sucesso!");
    }

    public void realizarVenda(Eventos evento){
        System.out.print("Insira o nome do comprador: ");
        String nomeComprador = entrada.nextLine();
        Participantes comprador = evento.getBilheteria().buscarParticipantePorNome(nomeComprador);
        if(comprador == null){
            System.out.println("Participante não cadastrado. Cadastre-o primeiro.");
            return;
        }

        System.out.println("O ingresso é especial?\n(1) Sim\n(2) Não");
        System.out.print("Escolha: ");
        int opc = Integer.parseInt(entrada.nextLine());
        boolean ehEspecial = (opc == 1);

        if(evento.getBilheteria().realizarVenda(comprador,ehEspecial)){
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a venda (Lotação esgotada para este tipo de ingresso).");
        }
    }

    private void RegistroEntrada(Eventos evento) {
        System.out.println("\n--- Registrar Entrada no Evento: " + evento.getNome() + " ---");
        System.out.print("Digite o código do ingresso do participante: ");
        String codigoIngresso = entrada.nextLine();
        Bilheteria bilheteria = evento.getBilheteria();
        if (bilheteria.registrarEntrada(codigoIngresso)) {
            System.out.println("Entrada registrada com sucesso!");
        } else {
            System.out.println("Falha ao registrar entrada (Código inválido ou ingresso já utilizado).");
        }
    }

    private void exibirEstatisticas(Eventos evento) {
        System.out.println("\n--- Estatísticas para o Evento: " + evento.getNome() + " ---");
        Bilheteria bilheteria = evento.getBilheteria();
        int totalVendidos = bilheteria.getTotalVendidos();
        int lotacao = bilheteria.getLotacaoMax();
        
        if (lotacao == 0) {
            System.out.println("A lotação deste evento é 0. Impossível calcular percentual.");
            return;
        }

        double ocupacao = ((double) totalVendidos / lotacao) * 100;
        System.out.println("Ocupação: " + totalVendidos + " de " + lotacao + " ingressos vendidos.");
        System.out.printf("Percentual de Ocupação: %.2f%%\n", ocupacao);
    }

    public void cancelarIngresso(Eventos evento){
        System.out.print("Insira o nome do dono do ingresso a ser cancelado: ");
        String nome = entrada.nextLine();
        if(evento.getBilheteria().cancelarIngresso(nome)){
            System.out.println("Ingresso cancelado com sucesso.");
        }
    }

    private void popularDadosIniciais() {
        gestao.cadastrarEvento("Show de Rock", "30/11/2025", 150.00, 200, "Daniel Callegari");
        gestao.cadastrarEvento("Palestra de Tecnologia", "15/10/2025", 50.00, 100, "Equipe GCS");
        gestao.cadastrarEvento("Apresentação T1 GCS", "21/10/2026", 250.00, 2, "Thomas");
        gestao.cadastrarEvento("Festa de Fim de Ano", "20/12/2025", 100.00, 50, "Empresa X");
    }
}