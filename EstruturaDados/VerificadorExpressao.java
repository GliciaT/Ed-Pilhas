package EstruturaDados;

public class VerificadorExpressao {

    public static boolean verificarParenteses(String s) {
        boolean r = true;
        TADPilha p = new PilhaDinamica();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                p.push("(");
            } else if (s.charAt(i) == ')') {
                if (!p.isEmpty()) {
                    p.pop();
                } else {
                    r = false;
                    break;
                }
            }
        }

        if (!p.isEmpty()) {
            r = false;
        }

        return r;
    }

    public static void main(String[] args) {
        String s = "(7 - (( X * (( X + Y) / ( J - 3)) + Y) / (4 - 2.5)))";
        System.out.println("Verificando " + s);
        System.out.println(verificarParenteses(s));

        s = "(7 - (( X * ( X + Y) / ( J - 3)) + Y) / (4 - 2.5)))";
        System.out.println("Verificando " + s);
        System.out.println(verificarParenteses(s));

        s = "(7 - (( X * (( X + Y) / ( J - 3)) + Y / (4 - 2.5)))";
        System.out.println("Verificando " + s);
        System.out.println(verificarParenteses(s));

        s = ") 7 + 5";
        System.out.println("Verificando " + s);
        System.out.println(verificarParenteses(s));

    }

}
