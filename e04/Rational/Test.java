import java.util.Scanner;

public class Test {

	public static void print(Rational r) {
		System.out.println(r.toString());
	}

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			Rational r = new Rational(s.nextInt(), s.nextInt());
			Rational q = new Rational(s.nextInt(), s.nextInt());
			print(r);
			print(q);
			print(r.somma(q));
			print(r.differenza(q));
			print(r.moltiplicazione(q));
			print(r.divisione(q));
		}
	}

}