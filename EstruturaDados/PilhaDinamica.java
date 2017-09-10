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

    public Object resolverExpressao(String s) {
        TADPilha pilha = new PilhaDinamica();
        Object num1, num2, resultado = 0;
        for (int i = 0; i < s.length(); i++) {
            //verificar para qualquer espaço em branco
            if (s.charAt(i) != ' ') {
                switch (s.charAt(i)) {
                    case '+':
                        num1 = pilha.pop();
                        num2 = pilha.pop();
                        resultado = Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
                        pilha.push(resultado);
                        break;
                    case '-':
                        num1 = pilha.pop();
                        num2 = pilha.pop();
                        resultado = Integer.parseInt(num1.toString()) - Integer.parseInt(num2.toString());
                        pilha.push(resultado);
                        break;
                    case '*':
                        num1 = pilha.pop();
                        num2 = pilha.pop();
                        resultado = Integer.parseInt(num1.toString()) * Integer.parseInt(num2.toString());
                        pilha.push(resultado);
                        break;
                    case '/':
                        num1 = pilha.pop();
                        num2 = pilha.pop();
                        resultado = Integer.parseInt(num1.toString()) / Integer.parseInt(num2.toString());
                        pilha.push(resultado);
                        break;
                    default:
                        pilha.push(s.charAt(i));
                }
            }

        }
        return pilha.pop();
    }
}
