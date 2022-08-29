/**
 * Vettore
 */

import java.util.*;

public class Vettore implements InterfaceVettore {

    // Campi
    private final int[] elementi;

    /**
     * Funzione di Astrazione AF(elementi) = (elem[0], elem[1], ..., elem[elem.lenght - 1])
     * Invariante di Rappresentazione IR = vettore non deve essere null
     *                                     elementi non deve essere null
     *                                     dimensione del vettore deve essere positiva
     */

    // Costruttori
    private Vettore(final int dim) {
        if (dim <= 0) throw new IllegalArgumentException("La dimensione dell'array deve essere positiva.");
        this.elementi = new int[dim];

        assert repOk();
    }

    public Vettore(int[] vettore) {
        Objects.requireNonNull(vettore, "Il vettore non può essere null.");
        if (vettore.length == 0) throw new IllegalArgumentException("Il vettore non può avere dimensione uguale a zero.");
        this.elementi = vettore.clone();

        assert repOk();
    }

    // Metodi
    /** 
     * Restituisce la dimensione del vettore
     * 
     * @return un intero che rappresenta la dimensione di this
     */
    @Override 
    public int dim() {
        return this.elementi.length;
    }

    /**
     * Restituisce il valore dell’i-esima componente del vettore
     * 
     * @return il valore dell’i-esima componente di this
     * @throws IllegalArgumentException nel caso in cui l'indice i sia minore di 0
     */
    @Override
    public int val(final int i) {
        if (i < 0) throw new IllegalArgumentException("La posizione nel vettore deve essere positiva.");
        return this.elementi[i];
    }

    /**
     * Restituisce il prodotto del vettore corrente per lo scalare alpha
     * 
     * @return il prodotto di this per lo scalare alpha
     */
    @Override
    public InterfaceVettore per(final int alpha) {
        assert repOk();

        Vettore result = new Vettore(this.elementi.length);
        for (int i=0; i<this.elementi.length; i++) {
            result.elementi[i] = this.elementi[i] * alpha;
        }

        return result;
    }

    /**
     * Restituisce true se il vettore corrente e il vettore v sono conformi
     * 
     * @param v vettore da confrontare con this
     * @return true se this e v sono conformi, ovvero se la loro dimensione è uguale, false altrimenti
     * @throws NullPointerException nel caso in cui v sia null
     */
    public boolean conformi(final InterfaceVettore v) {
        Objects.requireNonNull(v, "Il vettore non deve essere null.");
        if (this.dim() != v.dim()) return false;
        return true;
    }

    /**
     * Restituisce la somma vettoriale tra il vettore corrente e quello dato 
     * 
     * @param v vettore da sommare 
     * @return la somma vettoriale tra this e v, se conformi
     * @throws NullPointerException nel caso in cui v sia null
     * @throws IllegalArgumentException nel caso in cui this e v non siano conformi
     */
    @Override 
    public InterfaceVettore più(final InterfaceVettore v) {
        assert repOk();

        Objects.requireNonNull(v, "Il vettore non deve essere null.");
        if (!this.conformi(v)) throw new IllegalArgumentException("I due vettori non sono conformi.");
        Vettore result = new Vettore(this.dim());
        for (int i=0; i<this.dim(); i++) {
            result.elementi[i] = this.elementi[i] + v.val(i);
        }
        return result;
    }

    public boolean repOk() {
        if (this == null) return false;
        if (this.elementi == null) return false;
        if (this.dim() <= 0) return false;
        return true;
    }

    @Override 
    public String toString() {
        assert repOk();

        StringBuilder s = new StringBuilder();
        s.append("(" + this.val(0));
        for (int i=1; i<this.dim(); i++) {
            s.append(", " + this.val(i));
        }
        s.append(")");
        return s.toString();
    }

}