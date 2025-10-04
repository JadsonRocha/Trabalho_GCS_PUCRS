package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GestaoEventos {
    private ArrayList<Eventos> eventos;

    public GestaoEventos() {
        eventos = new ArrayList<>();
    }

    public boolean cadastrarEvento(String nome, String data, double valor, int lotacao, String responsavel) {
        Eventos e = new Eventos(nome, data, valor, lotacao, responsavel);
        eventos.add(e);
        return true;
    }

    public boolean removerEvento(int cod) {
        Eventos evento = buscarEventoPorCodigo(cod);
        if (evento == null) {
            System.out.println("Evento com código " + cod + " não encontrado para remoção.");
            return false;
        } else {
            eventos.remove(evento);
            System.out.println("Evento removido com sucesso: " + evento.getNome());
            return true;
        }
    }

    public void buscarEventoPorNome(String termoBusca) {
        ArrayList<Eventos> encontrados = new ArrayList<>();
        for (Eventos evento : eventos) {
            if (evento.getNome().toLowerCase().contains(termoBusca.toLowerCase())) {
                encontrados.add(evento);
            }
        }

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum evento encontrado com o termo: '" + termoBusca + "'");
        } else {
            System.out.println("\n--- Eventos encontrados ---");
            for (Eventos evento : encontrados) {
                System.out.println(evento);
            }
        }
    }

    public Eventos buscarEventoPorCodigo(int cod) {
        for (Eventos evento : eventos) {
            if (evento.getCodigo() == cod) {
                return evento;
            }
        }
        return null;
    }

    public ArrayList<Eventos> getEventos() {
        return new ArrayList<>(eventos);
    }
    
    public String gerarRelatorioMensal(int mes, int ano) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder relatorio = new StringBuilder();
        relatorio.append(String.format("\n--- RELATÓRIO DE EVENTOS PARA %02d/%d ---\n", mes, ano));

        ArrayList<Eventos> eventosDoMes = new ArrayList<>();
        double receitaTotal = 0;
        int ingressosVendidosTotal = 0;

        for (Eventos evento : eventos) {
            LocalDate dataEvento = LocalDate.parse(evento.getData(), formatter);
            if (dataEvento.getMonthValue() == mes && dataEvento.getYear() == ano) {
                eventosDoMes.add(evento);
                int vendidos = evento.getBilheteria().getTotalVendidos();
                ingressosVendidosTotal += vendidos;
                receitaTotal += vendidos * evento.getValorIngresso();
            }
        }

        if (eventosDoMes.isEmpty()) {
            return relatorio.append("Nenhum evento encontrado para este mês e ano.").toString();
        }

        for (Eventos evento : eventosDoMes) {
            relatorio.append("----------------------------------------\n");
            relatorio.append("Evento: ").append(evento.getNome()).append(" (Cód: ").append(evento.getCodigo()).append(")\n");
            relatorio.append("Data: ").append(evento.getData()).append("\n");
            relatorio.append("Ingressos Vendidos: ").append(evento.getBilheteria().getTotalVendidos()).append("\n");
        }
        relatorio.append("----------------------------------------\n");
        relatorio.append("Total de Eventos no Mês: ").append(eventosDoMes.size()).append("\n");
        relatorio.append("Total de Ingressos Vendidos: ").append(ingressosVendidosTotal).append("\n");
        relatorio.append(String.format("Receita Total Estimada: R$ %.2f\n", receitaTotal));

        return relatorio.toString();
    }
    
    public String gerarRelatorioAnual(int ano) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder relatorio = new StringBuilder();
        relatorio.append(String.format("\n--- RELATÓRIO DE EVENTOS PARA O ANO DE %d ---\n", ano));

        ArrayList<Eventos> eventosDoAno = new ArrayList<>();
        double receitaTotal = 0;
        int ingressosVendidosTotal = 0;

        for (Eventos evento : eventos) {
            LocalDate dataEvento = LocalDate.parse(evento.getData(), formatter);
            if (dataEvento.getYear() == ano) {
                eventosDoAno.add(evento);
                int vendidos = evento.getBilheteria().getTotalVendidos();
                ingressosVendidosTotal += vendidos;
                receitaTotal += vendidos * evento.getValorIngresso();
            }
        }

        if (eventosDoAno.isEmpty()) {
            return relatorio.append("Nenhum evento encontrado para este ano.").toString();
        }
        
        relatorio.append("Total de Eventos no Ano: ").append(eventosDoAno.size()).append("\n");
        relatorio.append("Total de Ingressos Vendidos: ").append(ingressosVendidosTotal).append("\n");
        relatorio.append(String.format("Receita Total Estimada: R$ %.2f\n", receitaTotal));
        relatorio.append("----------------------------------------\n");

        return relatorio.toString();
    }
}