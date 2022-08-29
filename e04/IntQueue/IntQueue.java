import java.util.*;

/**
 * IntQueue 
 * OVERVIEW: Le istanze di questa rappresentano code di interi (Limitate)
 *           Gli oggetti di questo tipo sono mutabili
 *           Una coda tipica è [x1, x2, ..., xk], k <= alla capienza della coda
 *           Dato che è una struttura dati FIFO,
 *           a seguito di una enqueue dell'elemento y, si otterrà [x_1, x_2, ..., x_k, x_k+1]
 *           a seguito di una dequeue, si otterrà [x_1, x_2, ..., x_k-1]
 */
public class IntQueue {

    // CAMPI
    /** la struttura dati contenente gli elementi dell'intqueue this */
    private final int[] elements;

    /** Intero head che indica l'indice del primo elemento della coda (se la coda è vuota vale -1) */
    private int head;
    /** Intero tail che indica l'indice della prima posizione disponibile in this (se head==tail la coda è piena) */
    private int tail;

    /**
     * Funzione di Astrazione: AF(elements, head, tail) = 
     *                         = [ elements[i] | head <= i < tail ] = 
     *                         = [] se head == -1 e tail = 0
     *                           [elements[head], elements[head+1], ..., elements[elements.size-1], elements[0], ..., elements[tail-1]] se tail < head
     *                           [elements[head], elements[head+1], ..., elements[tail-1]] se head <= tail
     * Invariante di Rappresentazione: la coda non contiene più elementi della sua capienza massima
     *                                 elements non deve essere null
     *                                 -1 <= head < elements.size - 1
     *                                 0 <= tail < elements.size - 1
     *                                 head == -1 => tail == 0
     */

    // COSTRUTTORI
    /**
     * Precondizioni:
     * Effetti Collaterali:
     * Postcondizioni: inizializza this affinchè rappresenti una coda vuota con capacità massima n
     *                 solleva un'eccezione di tipo NegativeArraySizeException nel caso in cui n sia negativo
     */
    public IntQueue(int n) {
        if (n < 0) throw new NegativeArraySizeException("Il valore n passato non può essere negativo. Trovato " + n);
        elements = new int[n];
        head = -1;
        tail = 0;

        assert repOk();
    }

    // METODI
    /**
     * Precondizioni:
     * Effetti collaterali: this è modificato se la coda non è piena
     * Postcondizioni: aggiunge x alla coda this
     *                 solleva un'eccezione di tipo FullQueueException nel caso in cui la coda sia piena
     *                 this = [x_1, x_2, ..., x_k] this_post = [x_1, x_2, ..., x_k, x]
     */
    public void enqueue(int x) {
        if (isFull()) throw new FullQueueException("Impossibile aggiungere un elemento. Coda Piena.");
        this.elements[tail] = x;
        this.tail = (this.tail + 1) % this.elements.length;

        assert repOk();
    }

    /**
     * Precondizioni:
     * Effetti collaterali: this è modificato se la coda non è vuota
     * Postcondizioni: toglie il primo elemento della coda this
     *                 solleva un'eccezione di tipo EmptyQueueException nel caso in cui la coda sia vuota
     *                 this = [x_1, x_2, ..., x_k] this_post = [x_2, ..., x_k]
     */
    public int dequeue() {

        if (isEmpty()) throw new EmptyQueueException("Impossibile togliere un elemento. Coda Vuota.");
        int r = this.elements[head];
        this.head = (this.head + 1) % this.elements.length;
        // incrementando head potrebbe diventare uguale a tail, ma non vuol dire che la coda è piena ma che la coda è vuota dunque devo risettare i due valori head e tail
        if (this.head == this.tail) {
            this.head = -1;
            this.tail = 0;
        }

        assert repOk();
        return r;
    }

    /**
     * Precondizioni:
     * Effetti Collaterali:
     * Postcondizioni: restituisce true se la code è piena
     */
    public boolean isFull() {
        return this.head == this.tail;
    }

    /**
     * Precondizioni:
     * Effetti Collaterali:
     * Postcondizioni: restituisce true se la coda è vuota
     */
    public boolean isEmpty() {
        return this.head == -1 && this.tail == 0;
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
                s += this.elements[(this.head + i) % this.elements.length] + ", ";
            }
            s += this.elements[(this.head + i) % this.elements.length];
        }
        return s + "]";
    }

    /**
     * Postcondizioni: restituisce il numero di elementi presenti nella coda
     */
    public int size() {
        assert repOk();

        if (isFull()) return this.elements.length;
        if (isEmpty()) return 0;
        return (this.tail - this.head + this.elements.length) % this.elements.length;
    }

    /**
     * Precondizioni:
     * Effetti collaterali:
     * Postcondizioni: restituisce true se l'invariante di rappresentazione è valida 
     */
    private boolean repOk() {
        return size() < this.elements.length 
            && this.elements != null
            && -1 <= this.head
            && this.head < this.elements.length
            && this.tail >= 0
            && this.tail < this.elements.length
            && (this.head != -1 || this.tail==0);
    }
    
}
