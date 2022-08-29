import java.util.Scanner;
import java.util.Arrays;

public class Kaprekar {

    /**
     * Precondizioni: 
     * Effetti Collaterali: potrebbe modificare l'ordine degli elementi di a
     * Postcondizioni: inverte l'ordine degli elementi di a
     *                 solleva un'eccezione di tipo NullPointerException se a è null
     */
    public static void reverse(byte[] a) {
        if (a == null) throw new NullPointerException();
        for (int i=0; i<a.length/2; i++) {
            byte tmp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = tmp;
        }
    }

    /**
     * Precondizioni: n è un numero di al più digits cifre
     * Effetti Collaterali:
     * Postcondizioni: restituisce un array di byte in cui sono memorizzate le cifre di n
     */
    public static byte[] numToDigits(int n, int digits) {
        byte[] a = new byte[digits];
        for (int i=digits-1; i>=0; i--) {
            a[i] = (byte)(n%10);
            n /= 10;
        }
        if (n > 0) throw new IllegalArgumentException("Il numero in ingresso è composto da più di " + digits + "cifre");
        return a;
    }

    /**
     * Precondizioni: 
     * Effetti Collaterali:
     * Postcondizioni: converte il numero memorizzato (in cifre) in a in un intero
     *                 solleva un'eccezione di tipo NullPointerException se a è null
     *                 solleva un'eccezione di tipo IllegalArgumentException se qualche elemento di a non è una cifra decimale
     */
    public static int digitsToNum(byte[] a) {
        // eccezione unchecked
        if (a == null) throw new NullPointerException();
        int n = 0;
        for (byte b : a) {
            if (b < 0 || b > 9) throw new IllegalArgumentException("Valori attesi per argomento compresi tra 0 e 9. Trovato: " + b);
            n = n * 10 + b;
        }
        return n;
    }

    /**
     * Precondizioni: 
     * Effetti Collaterali:
     * Postcondizioni: stampa la "sequenza di Kaprekar"
     */
    public static void printKaprekar(int n) {
        if (n < 1 || n > 10000) throw new IllegalArgumentException("Il numero deve essere compreso tra 1 e 9999");
        while (n != 6174) {
            System.out.println(n);
            n = stepKaprekar(n);
            if (n==0) throw new IllegalArgumentException("Il numero deve avere almeno due cifre diverse");
        }
        System.out.println(n);
    }
    
    /**
     * Precondizioni: 
     * Effetti Collaterali:
     * Postcondizioni: esegue un passo della "sequenza di kaprekar"
     */
    public static int stepKaprekar(int n) {
        if (n < 1 || n > 10000) throw new IllegalArgumentException("Il numero deve essere compreso tra 1 e 9999");
        byte[] a = numToDigits(n, 4);
        Arrays.sort(a);
        int num = - digitsToNum(a);
        reverse(a);
        return num + digitsToNum(a);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();

        printKaprekar(n);
    }

}
