import java.util.ArrayList;

public class Bilheteria {
    private Eventos eventos;
    private ArrayList<Ingressos> ingressos;

    public Bilheteria(Eventos evento){
        eventos = evento;
        ingressos = new ArrayList<>(evento.getLotacao());
    }

    public void adicionarParticipante(String nome, String cpf){
        Participantes p = new Participantes(nome, cpf);
        participantes.add(p);
    }

    public boolean realizarVenda(Participantes participante, boolean especial){ /** fazer verificação de Especiais **/
        int lotacaoMax = this.eventos.getLotacao();
        int qtdIngressos = ingressos.size();
        String codIngresso;
        if(qtdIngressos >= lotacaoMax){
            return false;
        }
        else{
            if(!especial){ //verifica se o ingresso é especial e add o "E" no cod do ingresso se necessário

                codIngresso = String.valueOf(eventos.getCodigo() + "-" + (ingressos.size() + 1)); /** ajustar cod para 3 digitos no fim**/
            }
            else{
                codIngresso = String.valueOf(eventos.getCodigo() + "-" + (ingressos.size() + 1)+ "E");
                }
            Ingressos ingresso = new Ingressos(participante, codIngresso, false);
            ingressos.add(ingresso);
            return true;
        }
    }

    public boolean registrarEntrada(String codigoIngresso) {
        for (Ingressos ingresso : ingressos) {
            if (ingresso.getCodigo().equals(codigoIngresso)) {
                if (ingresso.getfoiUtilizado()) {
                    //System.out.println("Ingresso já utilizado.");
                    return false;
                }
                ingresso.setfoiUtilizado(true);
                //System.out.println("Entrada registrada para: " + ingresso.getParticipante().getNome());
                return true;
            }
        }
        //System.out.println("Ingresso não encontrado.");
        return false;
    }
}
