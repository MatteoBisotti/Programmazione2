import java.util.Scanner;

public class Scacchi {

    /**
     * Precondizioni: 
     * Effetti Collaterali:
     * Postcondizioni: stampa il singolo pattern '-'
     */
    public static void stampaTrattino() {
        System.out.print("-");
    }

    /**
     * Precondizioni: 
     * Effetti Collaterali:
     * Postcondizioni: stampa il singolo pattern '#'
     */
    public static void stampaCancelletto() {
        System.out.print("#");
    }

    /**
     * Precondizioni: n > 0
     * Effetti Collaterali:
     * Postcondizioni: stampa il singolo pattern con '-' (---)
     */
    public static void stampaSingoloPatternBianco(int n) {  
        for (int i=0; i<n; i++) {
            stampaTrattino();
        }
    }

    /**
     * Precondizioni: n > 0
     * Effetti Collaterali:
     * Postcondizioni: stampa il singolo pattern con '#' (###)
     */
    public static void stampaSingoloPatternNero(int n) {  
        for (int i=0; i<n; i++) {
            stampaCancelletto();
        }
    }

    /**
     * Precondizioni: n > 0
     * Effetti Collaterali:
     * Postcondizioni: stampa il pattern di una singola riga che inizia con '-' (---###---###---###---###)
     */
    public static void stampaRigaBianco(int n) {
        for (int i=0; i<4; i++) {
            stampaSingoloPatternBianco(n);
            stampaSingoloPatternNero(n);
        }
    }

    /**
     * Precondizioni: n > 0
     * Effetti Collaterali:
     * Postcondizioni: stampa il pattern di una singola riga che inizia con '#' (###---###---###---###---)
     */
    public static void stampaRigaNero(int n) {
        for (int i=0; i<4; i++) {
            stampaSingoloPatternNero(n);
            stampaSingoloPatternBianco(n);
        }
    }

    /**
     * Precondizioni: n > 0
     * Effetti Collaterali:
     * Postcondizioni: stampa il pattern di una singola riga che inizia con '-' n volte      
     */
    public static void stampaRigaScacchieraPari(int n) {
        for (int i=0; i<n; i++) {
            stampaRigaBianco(n);
            System.out.println();
        }
    }

    /**
     * Precondizioni: n > 0
     * Effetti Collaterali:
     * Postcondizioni: stampa il pattern di una singola riga che inizia con '#' n volte      
     */
    public static void stampaRigaScacchieraDispari(int n) {
        for (int i=0; i<n; i++) {
            stampaRigaNero(n);
            System.out.println();
        }
    }

    /**
     * Precondizioni: n > 0
     * Effetti Collaterali:
     * Postcondizioni: stampa il pattern della scacchiera      
     */
    public static void stampaScachiera(int n) {
        for (int i=0; i<4; i++) {
            stampaRigaScacchieraPari(n);
            stampaRigaScacchieraDispari(n);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        stampaScachiera(n);
        s.close();
    }

}