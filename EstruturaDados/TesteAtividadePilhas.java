/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturaDados;

/**
 *
 * @author Glícia Tigre
 */
public class TesteAtividadePilhas {
    public static void main (String[] args){
        PilhaDinamica pilha = new PilhaDinamica();
        System.out.println(pilha.resolverExpressao("45+7+67*+"));
        System.out.println(pilha.convertePosFixa("45+7+67*+"));
    }
}
