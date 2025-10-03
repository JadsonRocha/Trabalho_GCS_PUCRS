package src;

import java.util.ArrayList;

public class GestaoEventos {
    private ArrayList<Eventos> eventos;

    public GestaoEventos() {
        eventos = new ArrayList<>();
    }

    public boolean cadastrarEvento(String nome, String data, double valor, int lotacao, String responsavel){
        Eventos e = new Eventos();

        e.setNome(nome);

        e.setData(data);

        e.setValorIngresso(valor);

        e.setLotacao(lotacao);

        e.setResponsavel(responsavel);

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

    public Eventos buscarEventoPorCodigo(int cod){
       for (Eventos evento : eventos) {
            if(evento.getCodigo() == cod){
                System.out.println("\nEvento encontrado:");
                return evento;
            }
        }
        return null; 
    }

    public ArrayList<Eventos> listarEventos() {
        System.out.println("\n--- LISTA DE EVENTOS ---");
        ArrayList<Eventos> CopiaEventos = new ArrayList<>();
        CopiaEventos.addAll(eventos);
        return CopiaEventos;
}
    
    public ArrayList<Eventos> getEventos() {
        return new ArrayList<>(eventos);
    }
}