import java.util.Scanner;

import excecoes.ParametrosInvalidosException;

public class Contador {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o parametro 1");
        int p1 = sc.nextInt();
        System.out.println("Digite o parametro 2");
        int p2 = sc.nextInt();

        try {
            contar(p1, p2);
        }
        catch (ParametrosInvalidosException e){
            System.out.println("\nO segundo parametro deve ser maior que o primeiro");
        }

        sc.close();
    }

    static void contar(int p1, int p2) throws ParametrosInvalidosException {

        if (p1 > p2) {
            throw new ParametrosInvalidosException();
        }

        int cont = p2 - p1;

        for (int i = 1; i < cont; i++) {
            System.out.println("Imprimindo o numero " + i);
        }

    }

}
