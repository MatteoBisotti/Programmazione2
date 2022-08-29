import java.util.*;

public class DisegnaV {

    /**
     * Precondizioni: r >= 0
     * Postcondizioni: stampa r spazi esterni al pattern
     */
    static void stampaSpaziEsterni(int r) {
        for (int i=0; i<r; i++) {
            System.out.print(" ");
        }
    }

    /**
     * Precodizioni: r>=0 e n>0
     * Postcondizioni: stampa gli spazi interni del pattern
     * Effetti collaterali:
     */
    static void stampaSpaziInterni(int r, int n) {
        for (int i=0; i<2*(n-r)-3; i++) {
            System.out.print(" ");
        }
    }

    /**
     * Precondizioni: r>=0 e n>0
     * Postcondizioni: stampa una singola riga del pattern
     * Effetti collaterali:
     */
    static void stampaRiga(int r, int n) {
        stampaSpaziEsterni(r);
        System.out.print("*");
        stampaSpaziInterni(r, n);
        System.out.print("*");
        stampaSpaziEsterni(r);
        System.out.println();
    }

    /**
     * Precondizioni: n>0
     * Postcondizioni: stampa le prime n-1 righe del pattern
     * Effetti collaterali:
     */
    static void stampaRighe(int n) {
        for (int r=0; r<n-1; r++) {
            stampaRiga(r, n);
        }
    }

    /**
     * Precondizioni: n>0
     * Postcondizioni: stampa l'ultima riga del pattern
     * Effetti collaterali:
     */
    static void stampaUltimaRiga(int n) {
        stampaSpaziEsterni(n-1);
        System.out.println("*");
    }
    
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        stampaRighe(n);
        stampaUltimaRiga(n);
    }
}
