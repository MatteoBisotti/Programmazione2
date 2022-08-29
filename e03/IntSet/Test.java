/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        IntSet s = new IntSet();

        System.out.println(s.toString());

        for (int i=0; i<10; i++) {
            s.insert(i);
        }

        System.out.println(s.toString());

        for (int i=11; i>7; i--) {
            s.remove(i);
        }

        System.out.println(s.toString());

    }
    
}