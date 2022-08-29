import java.util.Arrays;
import java.util.Scanner;

public class Kap {

    /**
     * Precondizioni: 
     * Effetti Collaterali:
     * Postcondizioni: restituisce il numero di cifre che compongono il numero n
     */
    public static int numeroCifre(int n) {
        int count = 0;
        while (n!=0) {
            n /= 10;
            count++;
        }
        return count;
    }

    /**
     * Precondizioni: n deve essere compreso tra 1000 e 9999
     * Effetti Collaterali:
     * Postcondizioni: restituisce un array contenente le cifre di n
     */
    public static byte[] intToDigits(int n) {
        byte[] a = new byte[numeroCifre(n)];
        for (int i=0; i<a.length; i++) {
            a[i] = (byte) (n%10);
            n /= 10;
        }
        return a;
    }

    /**
     * Precondizioni: a non deve essere null
     * Effetti Collaterali:
     * Postcondizioni: restituisce il numero che formano i singoli elementi dell'array a
     */
    public static int digitsToNum(byte[] a) {
        int n = 0;;
        for (int i=0; i<a.length; i++) {
            n = n * 10 + a[i];
        }
        return n;
    }

    /**
     * Precondizioni: a non deve esssere null
     * Effetti Collaterali: a potrebbe essere modificato
     * Postcondizioni: al termine della procedura, a conterrà il suo reverse
     */
    public static void reverse(byte[] a) {
        for (int i=0; i<a.length/2; i++) {
            byte temp = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = temp;
        }
    }

    /**
     * Precondizioni: n deve essere compreso tra 1000 e 9999
     * Effetti Collaterali:
     * Postcondizioni: restituisce il successivo di n nella sequenza di Kaprekar 
     */
    public static int nextKaprekar(int n) {
        byte[] a = intToDigits(n);

        Arrays.sort(a);

        int num = - digitsToNum(a);
        reverse(a);
        return num + digitsToNum(a);
    }

    public static void printKaprekar(int n) {
        while (n != 6174) {
            System.out.println(n);
            n = nextKaprekar(n);
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();

        /*
        byte[] a = intToDigits(n);
        for (int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println();

        Arrays.sort(a);

        for (int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println();

        int num = - digitsToNum(a);
        System.out.println(num);

        reverse(a);

        for (int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println();

        int num1 = digitsToNum(a);
        System.out.println(num+num1);
        */

        printKaprekar(n);
    }

}