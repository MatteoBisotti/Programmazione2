/**
 * Rational
 */
public class Rational {

    // CAMPI
    // Campo intero che rappresenta il numeratore
    private int numeratore;
    // Campo intero che rappresenta il denominatore
    private int denominatore;

    /**
     * AF - Funzione di Astrazione: AF(num, den) = num / den 
     * RI - Invariante di Rappresentazione: den != 0
     */

    // Costruttori
    /**
     * Precondizioni:
     * Effetti collaterali:
     * Postcondizioni: inizializza il numero razionale this ridotto ai minimi termini
     */
    public Rational(int n, int d) {
        if (d == 0) throw new IllegalDenException("Il denominatore deve essere diverso da zero.");
        if (d < 0) {
            n = -n;
            d = -d;
        }
        int cd = mcd(n, d);
        n /= cd;
        d /= cd;

        this.numeratore = n;
        this.denominatore = d;

        assert repOk();
    }

    public Rational(int n) {
        this.numeratore = n;
        this.denominatore = 1;
    }

    // METODI
    // somma
    /**
     * Precondizioni:
     * Effetti collaterali:
     * Postcondizioni: restituisce il razionale this + x
     *                 solleva un'eccezione di tipo NullPointerException se x è null.
     */
    public Rational somma(Rational x) {
        if (x == null) throw new NullPointerException();
        int d = this.denominatore * x.denominatore;
        int n = (this.numeratore * x.denominatore) + (x.numeratore * this.denominatore);

        assert repOk();

        return new Rational(n, d);
    }
    
    // differenza
    /**
     * Precondizioni:
     * Effetti collaterali:
     * Postcondizioni: restituisce il razionale this - x
     *                 solleva un'eccezione di tipo NullPointerException se x è null.
     */
    public Rational differenza(Rational x) {
        if (x == null) throw new NullPointerException();
        int n = (this.numeratore * x.denominatore) - (this.denominatore * x.numeratore);
        int d = this.denominatore * x.denominatore;

        assert repOk();

        return new Rational(n, d);
    }

    // moltiplicazione
    /**
     * Precondizioni:
     * Effetti collaterali:
     * Postcondizioni: restituisce il razionale this * x
     *                 solleva un'eccezione di tipo NullPointerException se x è null.
     */
    public Rational moltiplicazione(Rational x) {
        if (x == null) throw new NullPointerException();
        int n = this.numeratore * x.numeratore;
        int d = this.denominatore * x.denominatore;

        assert repOk();

        return new Rational(n, d);
    }

    // divisione
    /**
     * Precondizioni:
     * Effetti collaterali:
     * Postcondizioni: restituisce il razionale this / x
     *                 solleva un'eccezione di tipo NullPointerException se x è null.
     */
    public Rational divisione(Rational x) {
        if (x == null) throw new NullPointerException();
        assert repOk();
        return moltiplicazione(x.reciproco());
    }

    // mcd
    /**
     * Precondizioni:
     * Effetti collaterali:
     * Postcondizioni: restituisce il massimo comun divisore tra due interi a e b
     *                 solleva un'eccezione di tipo IllegalArgumentException se uno dei due termini è negativo
     */
    private static int mcd(int a, int b) {
        if (a < 0 || b < 0) throw new IllegalArgumentException("I due interi devono essere positivi.");

        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }

    // reciproco
    /**
     * Precondizioni:
     * Effetti collaterali:
     * Postcondizioni: restituisce il reciproco di this
     */
    public Rational reciproco() {
        assert repOk();
        return new Rational(this.denominatore, this.numeratore);
    }

    // repOk
    /**
     * Postcondizioni: restituisce true se l'invariante di rappresentazione è valida
     */
    private boolean repOk() {
        return this.denominatore != 0;
    }

    // tostring
    /**
     * Precondizioni:
     * Effetti collaterali:
     * Postcondizioni: restituisce una rappresentazione testuale di this 
     */
    @Override
    public String toString() {
        assert repOk();
        String s = "" + this.numeratore;

        if (this.denominatore != 1) {
            s += " / " + this.denominatore;
        }

        return s;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rational)) return false;
        Rational other = (Rational) o;
        return this.numeratore == other.numeratore && this.denominatore == other.denominatore;
    }

    // hashcode
    
}
