import java.util.Scanner;

public class Test {

  private static void print(Poly p) {
    /*final int degree = p.degree();
    for (int i = 0; i <= degree; i++) System.out.printf("%d %d\n", p.coeff(i), i);*/
    System.out.println(p.toString());
  }

  public static void main(String[] args) {
    try (Scanner s = new Scanner(System.in)) {
      int degreeP = s.nextInt();
      int degreeQ = s.nextInt();
      Poly p = new Poly();
      Poly q = new Poly();
      //System.out.println(degreeP);
      for (int i=0; i <= degreeP; i++) {
        p = p.add(new Poly(s.nextInt(), s.nextInt()));
      }
      print(p);
      for (int i=0; i <= degreeQ; i++) {
        q = q.add(new Poly(s.nextInt(), s.nextInt()));
      }
      print(q);
      print(p.minus());
      print(p.add(q));
      print(p.sub(q));
      print(p.mul(q));
    }
    
  }

}