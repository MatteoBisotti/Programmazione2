import java.util.List;

/**
 * IntQueue_Unbounded
 */
public class IntQueue_Unbounded {

    // Campi
    /** La struttura dati che contiene gil elementi della Unbounded Intqueue this */
    private List<Integer> elements;

    // Costruttori
    public IntQueue() {
        // più comodo usare una linked list
        elements = new LinkedList<>();

        assert repOk();
    }

    // Metodi
    /**
     * Precondizioni:
     * Effetti collaterali: potrebbe modificare this
     * Postcondizioni: aggiunge x alla coda this
     */
    public void enqueue(int x) {
        this.elements.add(x);

        assert repOk();
    }

    /**
     * Precondizioni:
     * Effetti Collaterali:
     * Postcondizioni: restituisce true se la coda è vuota, false altrimenti
     */
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    /**
     * Precondizioni:
     * Effetti collaterali: potrebbe modificare this
     * Postcondizioni: toglie il primo elemento della coda this
     *                 solleva un'eccezione di tipo EmptyQueueException nel caso in cui la coda sia vuota
     *                 this = [x_1, x_2, ..., x_k] this_post = [x_2, ..., x_k]
     */
    public int dequeue() {
        assert repOk();
        if (isEmpty()) throw new EmptyQueueException("Impossibile togliere un elemento. Coda Vuota.");
        
        return this.elements.remove(0);
    }

    /**
     * Precondizioni:
     * Effetti collaterali: 
     * Postcondizioni: implementa la funzione di astrazione
     */
    @Override
    public String toString() {
        assert repOk();

        String s = "IntQueue = [";
        if (!isEmpty()) {
            int i = 0;
            for (i=0; i<this.size() - 1; i++) {
                s += this.elements.get(i) + ", ";
            }
            s += this.elements.get(i);
        }
        return s + "]";
    }

    /**
     * Postcondizioni: restituisce il numero di elementi presenti nella coda
     */
    public int size() {
        assert repOk();
        return this.elements.size();
    }

}
