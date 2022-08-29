import java.util.Objects;

/**
 * MatriceNulla
 */
public class MatriceNulla extends AbsMatrice {

    // Campi
    private final int dim;

    // Costruttori
    public MatriceNulla(final int dim) {
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
            return 0;
        }

        throw new IndexOutOfBoundsException("Gli indici devono essere compresi nella dimensione della matrice.");
    }

    @Override 
    public InterfaceMatrice per(final int alpha) {
        return this;
    }

    @Override 
    public InterfaceMatrice somma(final InterfaceMatrice m) {
        Objects.requireNonNull(m, "La matrice da sommare non deve essere nulla");
        if (!this.conforme(m)) throw new IllegalArgumentException("Le due matrici devono essere conformi.");
        return m;
    }

    @Override 
    public InterfaceMatrice prodotto(final InterfaceMatrice m) {
        Objects.requireNonNull(m, "La matrice da moltiplicare non deve essere nulla");
        if (!this.conforme(m)) throw new IllegalArgumentException("Le due matrici devono essere conformi.");
        return this;
    }

}