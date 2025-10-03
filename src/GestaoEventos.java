package src;

import java.util.ArrayList;

public class GestaoEventos {
    private ArrayList<Eventos> eventos;

    public GestaoEventos(){
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

    public boolean removerEvento(int cod){
        Eventos evento = buscarEventoPorCodigo(cod);
        if (evento == null)
            return false;

        else{
            eventos.remove(evento);
            System.out.println("Evento removido: " + evento);
            return true;
        }
    }

    public void buscarEventoPorNome(String termoBusca) {
        boolean encontrado = false;
        System.out.println("Eventos encontrados:");

        for (Eventos evento : eventos) {
            if (evento.getNome().toLowerCase().contains(termoBusca.toLowerCase())) {
                System.out.println(evento);
            }
            if(!encontrado) {
            System.out.println("Nenhum evento encontrado para: " + termoBusca);
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

            System.out.println("Nenhum evento encontrado com o código: " + cod);
        return null;

    }

    public ArrayList<Eventos> listarEventos() {
        System.out.println("\n--- LISTA DE EVENTOS ---");
        ArrayList<Eventos> CopiaEventos = new ArrayList<>();
        CopiaEventos.addAll(eventos);
        return CopiaEventos;
    }

    public void editarNomeEvento(Eventos evento, String novoNome) {
        evento.setNome(novoNome);
        System.out.print("Novo nome do evento (" + evento.getNome() + ")");
    }
}