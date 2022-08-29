/**
 * InterfaceMatrice
 */
public interface InterfaceMatrice {

    /**
     * Restituisce la dimensione della matrice
     * 
     * @return la dimensione di this
     */
    int dim();

    /**
     * Restituisce l'elemento della matrice in posizione i j
     * 
     * @param i indice della riga
     * @param j indice della colonna
     * @return l'elemento della matrice in posizione i j
     * @throws IndexOutOfBoundsException nel caso in cui o i o j sia oltre la dimensione della matrice
     */
    int val(final int i, final int j);

    /**
     * Restituisce la matrice prodotto tra la matrice corrente e lo scalare alpha
     * 
     * @param alpha scalare
     * @return la matrice prodotto tra this e lo scalare alpha
     */
    InterfaceMatrice per(final int alpha);

    /**
     * Restituisce la matrice somma tra la matrice corrente e la matrice m 
     * 
     * @param m matrice da sommare
     * @return la matrice somma tra this e la matrice m
     * @throws NullPointerException nel caso in cui m sia null
     * @throws IllegalArgumentException nel caso in cui this e m non siano conformi
     */
    InterfaceMatrice somma(final InterfaceMatrice m);

    /**
     * Restituisce la matrice prodotto tra la matrice corrente e la matrice m 
     * 
     * @param m matrice da moltiplicare
     * @return la matrice prodotto tra this e la matrice m
     * @throws NullPointerException nel caso in cui m sia null
     */
    InterfaceMatrice prodotto(final InterfaceMatrice m);

    /**
     * Restituisce true se la matrice corrente e la matrice m sono conformi
     * 
     * @param m matrice da confrontare
     * @return true se this e m sono conformi, false altrimenti
     * @throws NullPointerException nel caso in cui m sia null
     */
    default boolean conforme(final InterfaceMatrice m) {
        if (this.dim() != m.dim()) return false;
        return true;
    }

}