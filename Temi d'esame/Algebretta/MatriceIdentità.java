import java.util.Objects;

/**
 * MatriceIdentità
 */
public class MatriceIdentità extends AbsMatrice {

    private final int dim;

    public MatriceIdentità(final int dim) {
        if (dim <= 0) throw new IllegalArgumentException("La dimensione deve essere positiva.");
        this.dim = dim; 
    }

    @Override
    public int dim() {
        return this.dim;
    }

    @Override
    public int val(final int i, final int j) {
        if (0 <= i && i < this.dim() && 0 <= j && j < this.dim()) {
            if (i == j) {
                return 1;
            } else {
                return 0;
            }
        }

        throw new IndexOutOfBoundsException("Gli indici devono essere compresi nella dimensione della matrice.");
    }

    @Override 
    public InterfaceMatrice per(final int alpha) {
        int[] result = new int[this.dim()];
        for (int i=0; i<this.dim(); i++) {
            result[i] = alpha;
        }
        return new MatriceDiagonale(result);
    }

    @Override 
    public InterfaceMatrice somma(final InterfaceMatrice m) {
        Objects.requireNonNull(m, "La matrice da somma non deve essere nulla.");
        if (!this.conforme(m)) throw new IllegalArgumentException("Le due matrici da sommare non sono conformi.");
        return new Matrice(this).somma(m);
    }

    @Override
    public InterfaceMatrice prodotto(final InterfaceMatrice m) {
        Objects.requireNonNull(m, "La matrice da somma non deve essere nulla.");
        if (!this.conforme(m)) throw new IllegalArgumentException("Le due matrici da sommare non sono conformi.");
        return m;
    }

}