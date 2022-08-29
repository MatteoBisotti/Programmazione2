import java.util.Scanner;

public class Prova {

    /**
     * Precondizioni: n > 0
     * Effetti Collaterali:
     * Postcondizioni: restituisce la somma (di lunghezza 1) delle cifre che compongono il numero n 
     */
    public static int sommaCifre(int n) {
        int somma = 0;
        while (n!=0) {
            somma += n%10;
            n /= 10;
        }
        if (somma >= 10) return sommaCifre(somma);
        return somma;
    }

    /**
     * Precondizioni: i numeri a e b devono essere > 0
     * Effetti Collaterali:
     * Postcondizioni: restituisce la cifra ottenuta dal prodotto delle cifre ottenute dai moltiplicandi
     */
    public static int prodottoCifre(int a, int b) {
        return sommaCifre(sommaCifre(a) * sommaCifre(b));
    }

    /**
     * Precondizioni: a b c > 0
     * Effetti Collaterali:
     * Postcondizioni: restituisce true se la prova del nove funziona
     *                 altrimenti false
     */
    public static boolean provaNove(int a, int b, int c) {
        return prodottoCifre(a, b) == sommaCifre(c);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int a=1; a < n; a++) {
            for (int b=1; b < n; b++) {
                for (int c=1; c<n; c++) {
                    if ((a*b!=c) && (provaNove(a, b, c))) {
                        System.out.println(a + " " + b + " " + c);
                    }
                }
            }
        }
    }

}