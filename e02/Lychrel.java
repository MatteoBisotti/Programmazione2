import java.util.Scanner;

public class Lychrel {

    // controllo Stringa palindroma
    /**
     * Precondizioni: 
     * Effetti Collaterali: 
     * Postcondizioni: restituisce true se la stringa s è palindroma
     *                 restituisce false altrimenti
     *                 solleva un'eccezione di tipo NullPointerException nel caso in cui la stringa fosse un riferimento a null
     */
    public static boolean isPalindrome(String s) {
        if (s==null) throw new NullPointerException();
        
        if (s.length()<=1) return true; 

        return s.charAt(0)==s.charAt(s.length()-1) && isPalindrome(s.substring(1, s.length()-1));
    }

    // inverti Stringa
    /**
     * Precondizioni: 
     * Effetti Collaterali:
     * Postcondizioni: restituisce la s in reverse
     *                 solleva un'eccezione di tipo NullPointerException nel caso in cui la stringa fosse un riferimento a null
     */
    public static String invertiStringa(String s) {
        if (s==null) throw new NullPointerException();

        if (s.length()<=1) return s;

        return s.charAt(s.length()-1) + invertiStringa(s.substring(1, s.length()-1)) + s.charAt(0);
    }

    // converti String -> long
    /**
     * Precondizioni:
     * Effetti Collaterali:
     * Postcondizioni: restituisce la rappresentazione long della stringa s
     *                 solleva un'eccezione di tipo NullPointerException nel caso in cui la stringa fosse un riferimento a null 
     */
    public static long stringToLong(String s) {
        if (s==null) throw new NullPointerException();
        long n = 0;
        for (int i=0; i<s.length(); i++) {
            n *= 10;
            n += s.charAt(i) - '0';
        }
        return n;
    }

    // converti long -> String
    /**
     * Precondizioni: 
     * Effetti Collaterali:
     * Postcondizioni: restituisce la rappresentazione in stringa di n
     */
    public static String longToString(long n) {
        return "" + n;
    }

    // passo kaprekar
    /**
     * Precondizioni: 
     * Effetti Collaterali:
     * Postcondizioni: restituisce il passo successivo della sequenza di Kaprekar
     *                 solleva un'eccezione di tipo IllegalArgumentException nel caso in cui n sia negativo
     */
    public static long stepKaprekar(long n) {
        if (n < 0) throw new IllegalArgumentException();
        return n + stringToLong(invertiStringa(longToString(n)));
    }
    
    // stampa Kaprekar
    /**
     * Precondizioni: n non è un numero di Lychrel
     * Effetti Collaterali:
     * Postcondizioni: stampa la sequenza di Lychrel a partire da n
     */
    public static void printKaprekar(long n) {
        while (!isPalindrome(longToString(n))) {
            System.out.println(n);
            n = stepKaprekar(n);
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();

        printKaprekar(n);
    }

}