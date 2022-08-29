import java.util.Objects;

/**
 * MatriceDiagonale
 */
public class MatriceDiagonale extends AbsMatrice {

    // Campi
    private final int[] elementi;

    // Costruttore
    public MatriceDiagonale(final int[] elementi) {
        Objects.requireNonNull(elementi, "L'array non deve essere null.");
        if (elementi.length == 0) throw new IllegalArgumentException("La dimensione dell'array non può essere zero.");
        int dim = elementi.length;
        this.elementi = new int[dim];
        for (int i=0; i<dim; i++) {
            this.elementi[i] = elementi[i];
        }
    }

    @Override 
    public int dim() {
        return this.elementi.length;
    }

    @Override 
    public int val(final int i, final int j) {
        if (0 <= i && i < this.dim() && 0 <= j && j < this.dim()) {
            if (i == j) {
                return this.elementi[i];
            } else {
                return 0;
            }
        }

        throw new IndexOutOfBoundsException("Gli indici devono essere compresi nella dimensione della matrice.");
    }

    @Override 
    public InterfaceMatrice per(final int alpha) {
        int[] elem = new int[dim()];
        for (int i=0; i<dim(); i++) {
            elem[i] = this.elementi[i] * alpha;
        }
        return new MatriceDiagonale(elem);
    }

    @Override 
    public InterfaceMatrice somma(final InterfaceMatrice m) {
        Objects.requireNonNull(m, "La matrice da moltiplicare non deve essere nulla");
        if (!this.conforme(m)) throw new IllegalArgumentException("Le due matrici devono essere conformi.");
        return new Matrice(this).somma(m);
    }

    @Override 
    public InterfaceMatrice prodotto(final InterfaceMatrice m) {
        Objects.requireNonNull(m, "La matrice da moltiplicare non deve essere nulla");
        if (!this.conforme(m)) throw new IllegalArgumentException("Le due matrici devono essere conformi.");
        return new Matrice(this).prodotto(m);
    }

}