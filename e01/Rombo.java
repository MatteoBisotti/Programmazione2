import java.util.Scanner;

public class Rombo {

    /**
     * Precondizioni: n>0
     * Postcondizioni: stampa n spazi
     * Effetti collaterali:
     */
    static void stampaSpazi(int n) {
        for (int i=0; i<n; i++) {
            System.out.print(" ");
        }
    }

    /**
     * Precondizioni: n>0
     * Postcondizioni: stampa n asterischi
     * Effetti collaterali:
     */
    static void stampaAsterischi(int n) {
        for (int i=0; i<n; i++) {
            System.out.print("*");
        }
    }

    /**
     * Precondizioni: n>0
     * Postcondizioni: stampa le prime n righe del rombo, ovvero le righe sopra la diagonale orizzontale
     * Effetti collaterali:
     */
    static void stampaRigheSuperiori(int n) {
        for (int r=0; r<n; r++) {
            stampaSpazi(n-r);
            stampaAsterischi(2*r+1);
            System.out.println();
        }
    }

    /**
     * Precondizioni: n>0
     * Postcondizioni: stampa la diagonale orizzontale del rombo
     * Effetti collaterali:
     */
    static void stampaDiagonale(int n) {
        stampaAsterischi(2*n+1);
        System.out.println();
    }

    /**
     * Precondizioni: n>0
     * Postcondizioni: stampa le ultime n righe del rombo, ovvero le righe sotto la diagonale orizzontale
     * Effetti collaterali:
     */
    static void stampaRigheInferiori(int n) {
        for (int r=0; r<n; r++) {
            stampaSpazi(r+1);
            stampaAsterischi(2*n - 2*r - 1);
            System.out.println();
        }
    }

    /**
     * Precondizioni: n>0
     * Postcondizioni: stampa il pattern completo del rombo
     * Effetti collaterali:
     */
    static void stampaRombo(int n) {
        stampaRigheSuperiori(n);
        stampaDiagonale(n);
        stampaRigheInferiori(n);
    }
    
    public static void main(String[] args) {
       
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        stampaRombo(n);
    }
}
