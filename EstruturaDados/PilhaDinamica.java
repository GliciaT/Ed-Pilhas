package EstruturaDados;

public class PilhaDinamica implements TADPilha {

    private NoSimples topo;
    private int quantidade;

    public void push(Object o) {
        NoSimples novo = new NoSimples();
        novo.setElemento(o);
        if (topo == null) {
            topo = novo;
        } else {
            novo.setProximo(topo);
            topo = novo;
        }
        quantidade++;
    }

    public Object pop() {
        Object r = null;
        if (topo != null) {
            r = topo.getElemento();
            topo = topo.getProximo();
            quantidade--;
        }
        return r;
    }

    public Object top() {
        Object r = null;
        if (topo != null) {
            r = topo.getElemento();
        }
        return r;
    }

    public int size() {
        return quantidade;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public boolean isFull() {
        return false;
    }

    //Parte 1 - Resolver uma expressão pós-fixa (Que contém apenas números
    //A expressão passada deve ter seus números/operadores separados por espaços
    public Float resolverExpressao(String expressao) {
        PilhaDinamica pilha = new PilhaDinamica();
        Float a, b, resultado;
        if (!expressao.isEmpty()) {
            String[] format = expressao.split("\\s");
            for (String format1 : format) {
                switch (format1) {
                    case "+":
                        a = (Float) pilha.pop();
                        b = (Float) pilha.pop();
                        resultado = a + b;
                        pilha.push(resultado);
                        break;
                    case "-":
                        a = (Float) pilha.pop();
                        b = (Float) pilha.pop();
                        resultado = b - a;
                        pilha.push(resultado);
                        break;
                    case "*":
                        a = (Float) pilha.pop();
                        b = (Float) pilha.pop();
                        resultado = a * b;
                        pilha.push(resultado);
                        break;
                    case "/":
                        a = (Float) pilha.pop();
                        b = (Float) pilha.pop();
                        resultado = b / a;
                        pilha.push(resultado);
                        break;
                    default:
                        pilha.push(Float.parseFloat(format1));
                        break;
                }
            }
        }
        return (Float) pilha.pop();
    }

    //Parte 2 - Converter uma função pósfixa em uma infixa (aceitando expressões com variáveis)
    //A expressão passada deve ter seus números/operadores separados por espaços
    public String convertePosFixa(String expressao) {
        String aux, num1, num2;
        TADPilha pilha = new PilhaDinamica();
        if (!expressao.isEmpty()) {
            String[] format = expressao.split("\\s");

            for (String format1 : format) {
                if (format1.equals("+") || format1.equals("-") || format1.equals("*") || format1.equals("/")) {
                    num2 = (String) pilha.pop();
                    num1 = (String) pilha.pop();
                    aux = "(" + num1 + "" + format1 + num2 + ")";
                    pilha.push(aux);
                } else {
                    pilha.push(format1);

                }
            }
        }
        return (String) pilha.pop();
    }
}
