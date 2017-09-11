package EstruturaDados;

/**
 *
 * @author Glícia Tigre e Diego Arruda
 */
public class TesteAtividadePilhas {
    public static void main (String[] args){
        PilhaDinamica pilha = new PilhaDinamica();
        System.out.println(pilha.resolverExpressao("45+7+67*+"));
        System.out.println(pilha.convertePosFixa("45+7+67*+"));
    }
}
