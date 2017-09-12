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

    //Parte 1 - Resolver uma expressão pós-fixa
    //A expressão passada deve ter seus números/operadores separados por espaços
    public Float resolverExpressao(String expressao) {
        PilhaDinamica pilha = new PilhaDinamica();
        Float a, b, resultado, c;
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
                    c = Float.parseFloat(format1);
                    pilha.push(c);
                    break;
            }
        }
        return (Float) pilha.pop();
    }

    //Parte 2 - Converter uma função pósfixa em uma infixa
    //A expressão passada deve ter seus números/operadores separados por espaços
    public String convertePosFixa(String expressao) {
        String aux = "";
        TADPilha pilha = new PilhaDinamica();
        Object num1, num2, c;
        String[] format = expressao.split("\\s");
        //for (int i = 0; i < expressao.length(); i++) {
        for (int i = 0; i < format.length; i++) {
            if (format[i].equals("+") || format[i].equals("-")
                    || format[i].equals("*") || format[i].equals("/")) {
                num2 = pilha.pop();
                num1 = pilha.pop();
                aux = "(" + num1 + "" + format[i] + num2 + ")";
                pilha.push(aux);
            } else {
                c = Float.parseFloat(format[i]);
                pilha.push(c);
                //pilha.push(expressao.charAt(i));
            }
        }
        return aux;
    }
}
