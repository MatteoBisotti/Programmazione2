import java.util.Objects;

/**
 * Matrice
 */
public class Matrice extends AbsMatrice {

    private final int[][] elementi;

    private Matrice(final int dim) {
        if (dim <= 0) throw new IllegalArgumentException("La dimensione deve essere positiva.");
        this.elementi = new int[dim][dim];
    }

    public Matrice(int[][] elementi) {
        Objects.requireNonNull(elementi);
        if (elementi.length == 0) throw new IllegalArgumentException("La matrice non deve essere vuota.");
        int dim = elementi.length;
        this.elementi = new int[dim][dim];
        for (int i=0; i<dim; i++) {
            if (elementi[i].length != dim) throw new IllegalArgumentException("La matrice deve essere quadrata.");
            for (int j=0; j<dim; j++) {
                this.elementi[i][j] = elementi[i][j];
            }
        }
    } 

    public Matrice(final InterfaceMatrice m) {
        Objects.requireNonNull(m);
        if (m.dim() == 0) throw new IllegalArgumentException("La matrice non deve essere vuota.");
        this.elementi = new int[m.dim()][m.dim()];
        for (int i=0; i<m.dim(); i++) {
            for (int j=0; j<m.dim(); j++) {
                this.elementi[i][j] = m.val(i, j);
            }
        }
    }

    @Override
    public int dim() {
        return this.elementi.length;
    }

    @Override 
    public int val(final int i, final int j) {
        if (0 <= i && i < dim() && 0 <= j && j < dim()) {
            return this.elementi[i][j];
        }

        throw new IndexOutOfBoundsException("Gli indici devono essere compresi nella dimensione della matrice.");
    }

    @Override 
    public InterfaceMatrice per(final int alpha) {
        Matrice result = new Matrice(this.dim());
        for (int i=0; i<dim(); i++) {
            for (int j=0; j<dim(); j++) {
                result.elementi[i][j] = alpha * this.elementi[i][j];
            }
        }
        return result;
    }

    @Override
    public InterfaceMatrice somma(final InterfaceMatrice m) {
        Objects.requireNonNull(m);
        if (!this.conforme(m)) throw new IllegalArgumentException("Le due matrici devono essere conformi.");
        Matrice result = new Matrice(this.dim());
        for (int i=0; i<dim(); i++) {
            for (int j=0; j<dim(); j++) {
                result.elementi[i][j] = this.elementi[i][j] + m.val(i, j);
            }
        }
        return result;
    }

    @Override 
    public InterfaceMatrice prodotto(final InterfaceMatrice m) {
        Objects.requireNonNull(m);
        if (!this.conforme(m)) throw new IllegalArgumentException("Le due matrici devono essere conformi.");
        Matrice result = new Matrice(dim());
        for (int i=0; i<dim(); i++) {
            for (int j=0; j<dim(); j++) {
                for (int k=0; k<dim(); k++) {
                    result.elementi[i][j] += this.elementi[i][k] * m.val(i, j);
                }
            }
        }
        return result;
    }

}