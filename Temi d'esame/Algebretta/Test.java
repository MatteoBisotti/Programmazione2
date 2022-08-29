/**
 * Test
 */

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int dim = s.nextInt();
        int[] array = new int[dim];
        for (int i=0; i<dim; i++) {
            array[i] = s.nextInt();
        }
        InterfaceVettore v = new Vettore(array);
        InterfaceVettore prod = new Vettore(array);
        prod = v.per(2);
        /*
        int[][] mat = new int[dim][dim];
        for (int i=0; i<dim; i++) {
            for (int j=0; j<dim; j++) {
                mat[i][j] = s.nextInt();
            }
        }
        */
        InterfaceMatrice m = new MatriceIdentità(dim);

        s.close();

        System.out.println(v);
        System.out.println(prod);

        System.out.println(m);
    }

}