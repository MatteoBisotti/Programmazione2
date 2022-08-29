/**
 * Liste_Distribuzione
 */

import java.util.*;

public class Liste_Distribuzione implements Iterable<Indirizzo> {
    
    private final String nome;
    private List<Indirizzo> lista_indirizzi = new ArrayList<>();

    /**
     * Funzione di Astrazione AF(nome, lista_indirizzi) = List = nome
     *                                                    lista_indirizzi[0]
     *                                                    lista_indirizzi[1]
     *                                                    ...
     *                                                    lista_indirizzi[lista_indirizzi.size() - 1]
     * Invariante di Rappresentazione IR = nome non deve essere null
     *                                     lista_indirizzi non deve essere null
     *                                     lista_indirizzi non deve contenere elementi null
     */

    /**
     * Costruisce un oggetto di tipo Liste_Distribuzione
     * 
     * @param nome String 
     * @param alias Alias
     * @throws NullPointerException nel caso in cui nome sia null
     * @throws NullPointerException nel caso in cui alias sia null
     */
    public Liste_Distribuzione(final String nome, final Alias alias) {
        Objects.requireNonNull(nome);
        this.nome = nome;

        Objects.requireNonNull(alias);
        for (Locale l : alias) {
            Indirizzo indirizzo = new Indirizzo(l, alias.dominioAlias());
            this.lista_indirizzi.add(indirizzo);
        }

        assert repOk();
    }

    /**
     * Costruisce un oggetto di tipo Liste_Distribuzione
     * 
     * @param nome String 
     * @param lista List
     * @throws NullPointerException nel caso in cui nome sia null
     * @throws NullPointerException nel caso in cui lista sia null
     */
    public Liste_Distribuzione(final String nome, final List<Indirizzo> lista) {
        Objects.requireNonNull(nome);
        this.nome = nome;

        Objects.requireNonNull(lista);
        for (Indirizzo i : lista) {
            this.lista_indirizzi.add(i);
        }

        assert repOk();
    }

    /**
     * Restituisce una lista di distribuzione data dalla somma tra due liste di distribuzione
     * 
     * @param other Liste_Distribuzione
     * @return una lista di distribuzione data dalla somma tra this e other
     * @throws NullPointerException nel caso in cui other sia null
     * @throws NullPointerException nel caso in cui nome sia null
     */
    public Liste_Distribuzione somma(final String nome, final Liste_Distribuzione other) {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(other);

        List<Indirizzo> lista = new ArrayList<>();

        for (Indirizzo i : this) {
            lista.add(i);
        }

        for (Indirizzo i : other) {
            if (!other.contieneIndirizzo(i)) {
                lista.add(i);
            }
        }

        assert repOk();

        return new Liste_Distribuzione(nome, lista);
    }

    /**
     * Restituisce una lista di distribuzione data dalla differenza tra due liste di distribuzione
     * 
     * @param other Liste_Distribuzione
     * @return una lista di distribuzione data dalla differenza tra this e other
     * @throws NullPointerException nel caso in cui other sia null
     */
    public Liste_Distribuzione differenza(final String nome, final Liste_Distribuzione other) {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(other);

        List<Indirizzo> lista = new ArrayList<>();

        for (Indirizzo i : this) {
            if (!other.contieneIndirizzo(i)) {
                lista.add(i);
            }
        }

        assert repOk();

        return new Liste_Distribuzione(nome, lista);
    }

    /**
     * Restituisce true se un indirizzo è presente nella lista di distribuzione
     * 
     * @return true se indirizzo appartiene a this, false altrimenti
     * @throws NullPointerException nel caso indirizzo sia null
     */
    public boolean contieneIndirizzo(final Indirizzo indirizzo) {
        Objects.requireNonNull(indirizzo);
        if (this.lista_indirizzi.contains(indirizzo)) return true;
        return false;
    }

    @Override
    public Iterator<Indirizzo> iterator() {
        return new Iterator<Indirizzo>() {

            private Iterator<Indirizzo> it = lista_indirizzi.iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override 
            public Indirizzo next() {
                return it.next();
            }

        };
    }

    /**
     * Restituisce true se due liste di distribuzione sono uguali
     * 
     * @param o object
     * @return true se this e o sono uguali, false altrimenti
     */
    @Override 
    public boolean equals(Object o) {
        if (!(o instanceof Liste_Distribuzione)) return false;
        Liste_Distribuzione other = (Liste_Distribuzione) o;
        if (!(this.nome.equals(other.nome))) return false;
        return true;
    }

    /**
     * Restituisce true se vale l'invariante di rappresentazione
     * 
     * @return true se vale l'invariante di rappresentazione di this, false altrimenti
     */
    public boolean repOk() {
        if (this.nome == null) return false;
        if (this.lista_indirizzi == null) return false;
        for (Indirizzo i : this) {
            if (i == null) return false;
        }
        return true;
    }

    /**
     * Restituisce una rappresentazione testuale della Lista di distribuzione
     * 
     * @return una rappresentazione testuale di this
     */
    @Override
    public String toString() {
        assert repOk();

        String s = "";
        s += "List = " + this.nome + "\n";
        for (Indirizzo i : this) {
            s += i.toString() + "\n";
        }
        return s;
    }
    
}