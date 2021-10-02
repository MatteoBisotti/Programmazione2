import java.util.Arrays;

public class Vettori {
    public static void main(String[] args) {
        //Dichiarazione di un array di interi
        int[] y = {1, 2, 3, 4, 5};
        
        // Per stampare il riferimento, e non i valori
        System.out.println(y);
        System.out.println(y.toString());

        // Per stampare i valori dell'array
        System.out.println(Arrays.toString(y));

        String[] w = {"Ciao", "Mamma"};
        System.out.println(Arrays.toString(w));
        w[0] = "addio";
        System.out.println(Arrays.toString(w));

        int[][] m = {{1, 2}, {3, 4, 5}};
        int[] v = m[0];
        // ora v referenzia il primo elemento di m

        System.out.println("m prima delle modifiche");
        System.out.println(Arrays.toString(m[0]));
        System.out.println(Arrays.toString(m[1]));
        System.out.println("v prima delle modifiche");
        System.out.println(Arrays.toString(v));

        v[1] = 100;
        System.out.println("m dopo delle modifiche");
        System.out.println(Arrays.toString(m[0]));
        System.out.println(Arrays.toString(m[1]));
        System.out.println("v dopo delle modifiche");
        System.out.println(Arrays.toString(v));
    }
}
