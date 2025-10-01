import java.util.ArrayList;

public class GestaoEventos {
    private ArrayList<Eventos> eventos;
    private Bilheteria bilheteria;

    public GestaoEventos(){
        eventos = new ArrayList<>();
    }

    public boolean cadastrarEvento(String nome, String data, double valor, int lotacao, String responsavel){
        Eventos e = new Eventos();

        System.out.println("Nome do Evento: ");
        e.setNome(nome);

        System.out.println("Data do Evento: ");
        e.setData(data);

        System.out.println("Valor do Ingresso: ");
        e.setValorIngresso(valor);

        System.out.println("Lotaçao maxima do Evento:");
        e.setLotacao(lotacao);

        System.out.println("Responsável do Evento: ");
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
            return true;
        }
    }

    public void buscarEventoPorNome(String termoBusca) {

        System.out.println("Eventos encontrados:");
        for (Eventos evento : eventos) {
            if (evento.getNome().toLowerCase().contains(termoBusca.toLowerCase())) {
                System.out.println(evento);
            }
        }
    }

    public Eventos buscarEventoPorCodigo(int cod){
        for (Eventos evento : eventos) {
            if(evento.getCodigo() == cod){
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

    public void editarNomeEvento(Eventos evento, String novoNome) {
        evento.setNome(novoNome);
        System.out.print("Novo nome do evento (" + evento.getNome() + ")");
    }




   // if (!evento.getParticipantes().isEmpty()) {
   //     System.out.println("ERRO: Evento com participantes não pode ser editado.");
    }



//    private void gerirEvento(int codigo) {
//
//    Eventos eventoSelecionado = null;
//        for (Eventos evento : eventos) {
//        if (evento.getCodigo() == codigo) {
//            eventoSelecionado = evento;
//            break;
//        }
//    }
//
//        if (eventoSelecionado == null) {
//        System.out.println("Evento não encontrado.");
//        return;
//    }
//
//        if (eventoSelecionado == null) { return;}
//
//        System.out.println("\nA editar o evento: " + eventoSelecionado.getNome());
//        System.out.println("1. Editar evento");
//        System.out.println("2. Listar participantes");
//        System.out.println("0. Voltar");
//        System.out.print("Escolha: ");
//    int opcao = Integer.parseInt(scanner.nextLine());
//
//        switch (opcao) {
//        case 1: editarEvento(eventoSelecionado); break;
//        case 2: listarParticipantesDoEvento(eventoSelecionado); break;
//    }




//private void listarParticipantesDoEvento(Eventos evento) {
//    System.out.println("\n--- PARTICIPANTES DE: " + evento.getNome() + " ---");
//    if (evento.getParticipantes().isEmpty()) {
//        System.out.println("Nenhum participante neste evento.");
//    } else {
//        for (Participantes p : evento.getParticipantes()) {
//            System.out.println(p);
//        }
//    }
//}
//
//
//}


