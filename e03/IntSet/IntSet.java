import java.util.List;
import java.util.ArrayList;

/**
 * Le istanze di questa classe rappresentano insiemi (non limitati) di interi. Gli oggetti di questo tipo sono mutabili.
 */
public class IntSet {

    // CAMPI
    private final List<Integer> elements;


    // COSTRUTTORI
    /** 
     * Precondizioni:
     * Effetti collaterali: 
     * Post condizioni: inizializza un nuovo insieme di interi vuoto
     */
    public IntSet() {
        elements = new ArrayList<>();
    }


    // METODI
    /**
     * Precondizioni:
     * Effetti collaterali: potrebbe modificare this: this_post = this + {x}
     * Postcondizioni: aggiunge x all'insieme this
     */
    public void insert(int x) {
        if (!this.contains(x)) {
            elements.add(x);
        }
    }

    /**
     * Precondizioni:
     * Effetti collaterali: potrebbe modificaer this: this_post = this - {x}
     * Postcondizioni: rimuove x dall'insieme this
     */
    public void remove(int x) {
        //elements.remove(Integer.valueOf(x));

        // Mi salvo la posizione dell'elemento da togliere
        int index = elements.indexOf(x);
        // Se l'elemento è presente nel set
        if (index != -1) {
            // Metto in una variabile l'indice dell'ultima posizione
            int lastIndex = elements.size() - 1;
            // Rimpiazzo l'elemento che devo togliere con l'elemento in ultima posizione
            elements.set(index, elements.get(lastIndex));
            // Elimino l'elemento in ultima posizione
            elements.remove(lastIndex);
        }
    }

    /**
     * Precondizioni:
     * Effetti collaterali:
     * Postcondizioni: restituisce un intero scelto arbitrariamente tra gli elemtni di this
     *                 e solleva un'eccezione di tipo EmptyException se l'insieme è vuoto
     */
    public int choose() {
        // questa eccezione non esiste nella gerarchia, dobbiamo implementarla 
        if (size() == 0) throw new EmptyException("Impossibile estrarre elemento. Insieme vuoto.");
        return elements.get(elements.size() - 1);
    }

    /**
     * Preocondizioni:
     * Effetti collaterali:
     * Postcondizioni: restituisce la cardinalità di this
     * 
     */
    public int size() {
        return elements.size();
    }

    /**
     * Precondizioni: 
     * Effetti collaterali:
     * Postcondizioni: restituisce true se x è in this, false altrimenti
     */
    public boolean contains(int x) {
        return elements.contains(x);
    }

    /**
     * Precondizioni:
     * Effetti collaterali:
     * Postcondizioni: restituisce una rappresentazione testuale di this
     *                 ad esempio -> {1, 2, 3}
     */
    @Override
    public String toString() {
        String r = "IntSet: {";
        if (elements.size() > 0) {
            for (int i=0; i<elements.size()-1; i++) {
                r += elements.get(i) + ", ";
            }
            r += elements.get(elements.size()-1);
        }
        return r + "}";
    }

    @Override 
    public boolean equals(Object o) {
        if (!(o instanceof IntSet)) return false;
        IntSet s = (IntSet) o;
        if (this.size() != s.size()) return false;
        for (int x: this.elements) {
            if (!(s.contains(x))) return false;
        }
        return true;
    }

}
