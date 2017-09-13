package EstruturaDados;

/**
 *
 * @author Glícia Tigre e Diego Arruda
 */
public class TesteAtividadePilhas {

    public static void main(String[] args) {
        PilhaDinamica pilha = new PilhaDinamica();

        //teste para calcular uma expressão pós fixa
        System.out.println(pilha.resolverExpressao("45 5 + 7 + 6 7 * +"));

        //teste de conversão de uma expressão pósfixa em infixa
        //somente números
        System.out.println(pilha.convertePosFixa("45 5 + 7 + 6 7 * +"));
        //com variáveis
        System.out.println(pilha.convertePosFixa("n 1 + n 3 * 7 + +"));
    }
}
