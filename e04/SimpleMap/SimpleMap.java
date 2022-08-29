import java.util.List;
import java.util.LinkedList;

public class SimpleMap {

	// CAMPI
	// Lista di Stringhe che contiene le chiavi della mappa
	private List<String> keys;
	// Lista di Integer che contiene i valori della mappa
	private List<Integer> values;

	/**
	 * AF - Funzione di Astrazione: AF(keys, values) = { k_i -> v_i | per ogni i = 1, ..., n, k_i = keys[i], v_i = values[i] }
	 * 
	 * RI - Invariante di Rappresentazione: keys non null
	 * 										values non null
	 * 										keys non contiene riferimenti a null
	 * 										values non contiene riferimenti a null
	 * 										keys.size() == values.size()
	 * 										keys non contiene elementi ripetuti
	 */ 

	// COSTRUTTORI
	/**
	 * Precondizioni:
	 * Effetti collaterali:
	 * Postcondizioni: inizializza this affinchè rappresenti una SimpleMap vuota
	 */
	public SimpleMap() {
		keys = new LinkedList<>();
		values = new LinkedList<>();

		assert repOk();
	}

	// METODI
	// put
	/**
	 * Precondizioni:
	 * Effetti collaterali: potrebbe modificare this
	 * Postcondizioni: aggiunge a this una chiave k di valore v, se la chiave è già presente nella mappa sovrascrive il risultato
	 * 				   solleva un'eccezione di tipo NullKeyException nel caso in cui la chiave sia nulla
	 */
	public void put(String k, int v) {
		if (k == null || k.equals("")) throw new NullKeyException("Non si può inserire una chiave nulla nella mappa.");
		for (int i=0; i<this.keys.size(); i++) {
			if (k.equals(this.keys.get(i))) {
				this.values.set(i, v);
				return;
			}
		}
		this.keys.add(k);
		this.values.add(v); 
		
		assert repOk();
	}

	// remove
	/**
	 * Precondizioni:
	 * Effetti collaterali: potrebbe modificare this
	 * Postcondizioni: rimuove da this l'elemento di chiave k se presente e il suo relativo valore
	 */
	public void remove(String k) {
		for (int i=0; i<this.keys.size(); i++) {
			if (k.equals(this.keys.get(i))) {
				this.keys.remove(i);
				sthis.values.remove(i);
				return;
			}
		}
		assert repOk();
	}

	// get
	/**
	 * Precondizioni:
	 * Effetti collaterali:
	 * Postcondizioni: restituisce il valore corrispondente alla chiave k
	 * 				   solleva un'eccezione di tipo NotPresentKeyException nel caso in cui la chiave non sia presente in this
	 */
	public Integer get(String k) {
		for (int i=0; i<this.keys.size(); i++) {
			if (k.equals(this.keys.get(i))) {
				return this.values.get(i);
			}
		}

		throw new NotPresentKeyException("La chiave passata non è presente nella mappa.");
	}

	// size
	/**
	 * Precondizioni:
	 * Effetti collaterali:
	 * Postcondizioni: restituisce la dimensione di this
	 */
	public int size() {
		return this.keys.size();
	}

	// contains 
	/**
	 * Precondizioni:
	 * Effetti collaterali:
	 * Postcondizioni: restituisce true se la chiave k è presente in this, false altrimenti
	 */
	public boolean contains(String k) {
		if (this.keys.contains(k)) return true;
		return false;
	}


	// repOk
	/**
	 * Precondizioni: 
	 * Effetti collaterali: 
	 * Postcondizioni: restituisce true se vale l'invariante di rappresentazione
	 */
	public boolean repOk() {
		if (this.keys == null || this.values == null) return false;
		
		if (this.keys.size() != this.values.size()) return false;

		for (int i=0; i<this.keys.size(); i++) {
			if (this.keys.get(i) == null) return false;
			if (this.values.get(i) == null) return false;
		}
		return true;
	}

	// toString
	/**
	 * Precondizioni:
	 * Effetti collaterali:
	 * Postcondizioni: restituisce una rappresentazione testuale di this
	 */
	@Override
	public String toString() {
		assert repOk();

		String s = "SimpleMap = { ";
		if (this.keys.size() > 0) {
			s += this.keys.get(0) + " -> " + this.values.get(0);
		}
		for (int i=1; i<this.keys.size(); i++) {
			s += ", " + this.keys.get(i) + " -> " + this.values.get(i);
		}
		return s + " }";
	}

	// equals
	/**
	 * Precondizioni:
	 * Effetti collaterali:
	 * Postcondizioni: 
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof SimpleMap)) return false;
		SimpleMap m = (SimpleMap) o;
		if (this.size() != m.size()) return false;
		for (String k: this.keys) {
			if (!m.contains(k)) return false;
			if (this.get(k) != m.get(k)) return false;
		}
		return true;
	}

	// hashcode

}
