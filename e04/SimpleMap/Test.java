import java.util.Scanner;

public class Test {
    
    public static void print(SimpleMap m) {
        System.out.println(m.toString());
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            SimpleMap m = new SimpleMap();
            print(m);
            m.put(s.next(), s.nextInt());
            m.put(s.next(), s.nextInt());
            m.put(s.next(), s.nextInt());
            m.put(s.next(), s.nextInt());
            print(m);
            System.out.println(m.get("ciao"));
            m.remove("ciao");
            print(m);
            m.remove("ciao");
            print(m);
            m.put("biso", 14);
            print(m);
            System.out.println(m.get("bella"));
        }
    }

}
