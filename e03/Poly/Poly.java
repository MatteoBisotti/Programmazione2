/**
 * OVERVIEW: le istanze di questa classe rappresentano polinomi
 *           gli oggetti di questo tipo NON mutabili 
 *           es: 4x^0 + 3 x^1 + 5 x^2
 */

public class Poly {
    
    // Attributi
    /** Array contenente i coefficienti del polinomio */
    private int[] terms; // final -> indica che una volta inizializzata quella variabile non cambierà
    /** Grado del polinomio */
    private int degree;

    // Costruttori
    /**
     * Precondizionni:
     * Effetti collaterali:
     * Postcondizioni: inizializza this affinchè rappresenti il polinomio zero
     */
    public Poly() {
        terms = new int[1];
        degree = 0;
    }

    private Poly(int degree) {
        terms = new int[degree + 1];
        this.degree = degree;
    }

    /**
     * Precondizionni:
     * Effetti collaterali:
     * Postcondizioni: inizializza this affinchè rappresenti il polinomio \(c x^n\)
     *                 solleva un'eccezione di tipo NegativeExponentException se n è negativo
     */
    public Poly(int c, int n) {
        if (n < 0) throw new NegativeExponentException();
        if (n==0) {
            degree = 0;
        } else {
            degree = n;
        }
        terms = new int[degree + 1];
        terms[degree] = c;
    }

    // Metodi
    /**
     * Precondizioni: 
     * Effetti Collaterali: 
     * Postcondizioni: restituisce il grado maggiore tra i gradi del polinomio p e q
     */
    private int maxDegree(Poly p, Poly q) { 
        if (p.degree >= q.degree) return p.degree;
        return q.degree;
    }


    /**
     * Precondizionni: 
     * Effetti collaterali:
     * Postcondizioni: restituisce il polinomio somma = this + q
     *                 solleva un'eccezione di tipo NullPointerException se q è null
     */
    public Poly add(Poly q) {
        if (q == null) throw new NullPointerException();

        int maxDegree = maxDegree(this, q);
        Poly result = new Poly(maxDegree);

        for (int i=0; i<=result.degree; i++) {
            if (i <= this.degree) {
                if (i <= q.degree) {
                    result.terms[i] = this.terms[i] + q.terms[i];
                } else {
                    result.terms[i] = this.terms[i];
                }
            } else {
                if (i <= q.degree) result.terms[i] = q.terms[i];
            }
        }

        return result;
    }

    /**
     * Precondizionni:
     * Effetti collaterali:
     * Postcondizioni: restituisce il polinomio differenza = this - q
     *                 solleva un'eccezione di tipo NullPointerException se q è null
     */
    public Poly sub(Poly q) {
        if (q == null) throw new NullPointerException();
        return this.add(q.minus());
    }

    /**
     * Precondizionni:
     * Effetti collaterali:
     * Postcondizioni: restituisce il polinomio moltiplicazione = this * q
     *                 solleva un'eccezione di tipo NullPointerException se q è null
     */
    public Poly mul(Poly q) {
        if (q == null) throw new NullPointerException();

        int degreeMul = this.degree + q.degree;

        Poly result = new Poly(degreeMul);
        for (int i=0; i<=this.degree; i++) {
            for (int j=0; j<=q.degree; j++) {
                result.terms[i + j] = this.terms[i] * q.terms[j];
            }
        }
        return result;
    }

    /**
     * Precondizionni:
     * Effetti collaterali:
     * Postcondizioni: restituisce il polinomio opposo a this = - this
     */
    public Poly minus() {
        Poly result = new Poly(this.degree);
        for (int i = 0; i<=this.degree; i++) {
            result.terms[i] = - this.terms[i];
        }
        return result;
    }

    /**
     * Precondizionni:
     * Effetti collaterali:
     * Postcondizioni: restituisce il grado del polinomio
     */
    public int degree() {
        return this.degree;
    }

    /**
     * Precondizionni:
     * Effetti collaterali:
     * Postcondizioni: restituisce il termine corrispondente alla variabile con grado d 
     */
    public int coeff(int d) {
        return this.terms[d];
    }

    /**
     * Precondizioni:
     * Effetti collaterali:
     * Postcondizioni: restituisce una rappresentazione testuale di this
     */
    @Override
    public String toString() {
        String s = "";
        boolean written = false;

        if (this.terms[0] != 0) {
            s += this.terms[0];
            written = true;
        }

        for (int i=1; i<=this.degree; i++) {
            if (this.terms[i] != 0) {
                if (written == true) {
                    s += " ";
                    if (this.terms[i] > 0) s += "+ ";
                } else {
                    written = true;
                }
                s += this.terms[i] + "x^" + i;
            }
        }
        
        if (s=="") return "0";
        
        return s; 
    }

}

