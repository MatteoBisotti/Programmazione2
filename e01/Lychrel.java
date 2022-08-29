import java.util.Scanner;

public class Lych {

    /**
     * Postcondizioni: restituisce una stringa che rappresenta n
     */
    public static String convertToString(long n) {
        return "" + n;
    }

    /**
     * Precondizioni: s non è riferimento null
     *                s è una stringa che rappresenta un numero
     * Postcondizioni: restituisce una rappresentazione di s tramite un long
     */
    public static long convertToLong(String s) {
        long n = 0;
        for (int i=0; i<s.length(); i++) {
            n *= 10;
            n += s.charAt(i) - '0';
        }
        return n;
    }

    /**
     * Precondizioni: s non è un riferimento a null
     * Effetti Collaterali:
     * Postcondizioni: restituisce la stringa reverse di s
     */
    public static String reverse(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        return s.charAt(len-1) + reverse(s.substring(1, len-1)) + s.charAt(0);
    }

    /**
     * Precondizioni: s non è riferimento a null
     * Effetti Collaterali:
     * Postcondizioni: restituisce true se s è palindroma
     *                 altrimenti false
     */
    public static boolean isPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return true;
        return s.charAt(0) == s.charAt(len-1) && isPalindrome(s.substring(1, len-1));
    }
        
    /**
     * Precondizioni: n > 0
     * Effetti Collaterali:
     * Postcondizioni: restituisce il numero successivo ad n nella sequenza di Lychrel
     */
    public static long nextLychrel(long n) {
        return n + convertToLong(reverse(convertToString(n)));
    }

    /**
     * Precondizioni: n > 0
     * Effetti Collaterali:
     * Postcondizioni: stampa la sequenza di Lychrel a partire da n
     */
    public static void lychrelSequence(long n) {    
        while (!isPalindrome(convertToString(n))) {
            System.out.println(n);
            n = nextLychrel(n);
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        lychrelSequence(s.nextLong());
        s.close();
    }

}
