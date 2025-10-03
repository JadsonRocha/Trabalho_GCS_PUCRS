package src;

import java.util.ArrayList;

// Classe de gerenciamento dos eventos
// Permite adicionar, listar e buscar eventos

public class GestaoEventos {
    private ArrayList<Eventos> eventos;

    public GestaoEventos(){
        eventos = new ArrayList<>();

    }
// Validar se uma string não está vazia
private boolean validarStringNaoVazia(String texto, String campo) {
    if (texto == null || texto.trim().isEmpty()) {
        System.out.println("Erro: " + campo + " é obrigatório!");
        return false;
    }
    return true;
    }

    // Validar se um número é positivo
    private boolean validarNumeroPositivo(double numero, String campo) {
    if (numero <= 0) {
        System.out.println("Erro: " + campo + " deve ser maior que zero!");
        return false;
        }
    return true;
    }


    public boolean cadastrarEvento(String nome, String data, double valor, int lotacao, String responsavel){
        Eventos e = new Eventos();

         // Usa os métodos para validação
    if (!validarStringNaoVazia(nome, "Nome do evento")) return false;
    if (!validarStringNaoVazia(data, "Data do evento")) return false;
    if (!validarStringNaoVazia(responsavel, "Responsável pelo evento")) return false;
    if (!validarNumeroPositivo(valor, "Valor do ingresso")) return false;
    if (!validarNumeroPositivo(lotacao, "Lotação do evento")) return false;

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