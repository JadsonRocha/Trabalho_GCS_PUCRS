import java.util.ArrayList;

public class GestaoEventos {
    private ArrayList<Eventos> eventos;

    public GestaoEventos(){
        eventos = new ArrayList<>();
    }

    public boolean CadastrarEvento(String nome, String data, double valor, int lotacao, String responsavel){
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

    public void buscarEventoPorNome(String termoBusca) {

        System.out.println("Eventos encontrados:");
        for (Eventos evento : eventos) {
            if (evento.getNome().toLowerCase().contains(termoBusca.toLowerCase())) {
                System.out.println(evento);
            }
        }
    }

    public Eventos BuscarEventoPorCodigo(int cod){
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


}
