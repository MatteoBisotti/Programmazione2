import java.util.*;

/**
 * Alias
 */
public class Alias implements Iterable<Locale> {

    private final String nome;
    private final Dominio dominio;
    private List<Locale> lista_locali = new ArrayList<>();

    /**
     * Funzione di Astrazione AF(nome, dominio, lista_locali) = Alias = nome
     *                                                          lista_locali[0]@dominio
     *                                                          lista_locali[1]@dominio
     *                                                          ...
     *                                                          lista_locali[lista_locali.size()-1]@dominio
     * Invariante di Rappresentazione IR = nome non deve essere null
     *                                     dominio non deve esseere null
     *                                     lista_locali non deve essere null
     *                                     lista_locali non deve contenere elementi null
     */

    /**
     * Costruisce un oggetto di tipo Alias
     * 
     * @param nome stringa
     * @param dominio Dominio
     * @throws NullPointerException nel caso in cui nome sia null
     * @throws NullPointerException nel caso in cui dominio sia null
     */
    public Alias(final String nome, final Dominio dominio) {
        Objects.requireNonNull(nome);
        this.nome = nome;

        Objects.requireNonNull(dominio);
        this.dominio = dominio;

        assert repOk();
    }

    /**
     * Costruisce un oggetto di tipo Alias
     * 
     * @param nome stringa
     * @param dominio Dominio
     * @throws NullPointerException nel caso in cui nome sia null
     * @throws NullPointerException nel caso in cui dominio sia null
     * @throws NullPointerException nel caso in cui lista sia null
     */
    public Alias(final String nome, final Dominio dominio, List<Locale> lista) {
        Objects.requireNonNull(nome);
        this.nome = nome;

        Objects.requireNonNull(dominio);
        this.dominio = dominio;

        Objects.requireNonNull(lista);
        for (Locale l : lista) {
            this.aggiungiIndirizzo(new Indirizzo(l, dominio));
        }

        assert repOk();
    }

    /**
     * Restituisce true se il dominio passato è conforme con il dominio dell'alias, ovvero se è uguale
     * 
     * @param dominio Dominio
     * @return true se dominio è uguale al dominio di this, false altrimenti
     * @throws NullPointerException nel caso in cui dominio sia null
     */
    public boolean conforme(final Dominio dominio) {
        Objects.requireNonNull(dominio);
        if (this.dominio.dominio().equals(dominio.dominio())) return true;
        return false;
    }

    /**
     * Restituisce true se locale è presente nell'alias
     * 
     * @param locale Locale
     * @return true se locale è presente in this, false altrimenti
     * @throws NullPointerException nel caso in cui locale sia null
     */
    public boolean presente(final Locale locale) {
        Objects.requireNonNull(locale);
        if (this.lista_locali.contains(locale)) return true;
        return false;
    }

    /**
     * Aggiunge indirizzo all'alias, nel caso non sia conforme stampa un messaggio di avviso e nel caso sia già presente nell'alias stampa un messaggio di errore
     * 
     * @param indirizzo Indirizzo
     * @throws NullPointerException nel caso in cui indirizzo sia null
     */
    public void aggiungiIndirizzo(final Indirizzo indirizzo) {
        Objects.requireNonNull(indirizzo);

        if (conforme(indirizzo.getDominio()) == false) {
            System.out.println("L'indirizzo in questione non ha un dominio conforme con l'alias.");
            return;
        }

        if (presente(indirizzo.getLocale()) == true) {
            System.out.println("L'indirizzo in questione è già presente nell'alias.");
            return;
        }

        this.lista_locali.add(indirizzo.getLocale());

        assert repOk();
    }

    /**
     * Rimuove indirizzo dall'alias, nel caso non sia conforme stampa un messaggio di avviso e nel caso non sia presente nell'alias stampa un messaggio di avviso
     * 
     * @param indirizzo Indirizzo
     * @throws NullPointerException nel caso in cui indirizzo sia null
     */
    public void rimuoviIndirizzo(final Indirizzo indirizzo) {
        assert repOk();

        Objects.requireNonNull(indirizzo);

        if (conforme(indirizzo.getDominio()) == false) {
            System.out.println("L'indirizzo in questione non ha un dominio conforme con l'alias.");
            return;
        }

        if (presente(indirizzo.getLocale()) == false) {
            System.out.println("L'indirizzo in questione non è presente nell'alias.");
            return;
        }

        this.lista_locali.remove(indirizzo.getLocale());
    }

    /**
     * Restituisce true se un alias è contenuto in un altro alias
     * 
     * @param alias Alias
     * @return true se alias è contenuto in this, false altrimenti
     * @throws NullPointerException nel caso in cui alias sia null
     */
    public boolean contieneAlias(final Alias alias) {
        Objects.requireNonNull(alias);
        if (!(this.nome.equals(alias.nome))) return false;
        for (Locale l : alias) {
            if (!presente(l)) return false;
        }
        return true;
    }

    /**
     * Restituisce il dominio dell'alias
     * 
     * @return il dominio di this
     */
    public Dominio dominioAlias() {
        return this.dominio;
    }

    /**
     * Restituisce true se vale l'invariante di rappresentazione
     * 
     * @return true se vale l'invariante di rappresentazione di this, false altrimenti
     */
    public boolean repOk() {
        if (this.nome == null) return false;
        if (this.dominio == null) return false;
        if (this.lista_locali == null) return false;
        for (Locale l : this) {
            if (l == null) return false;
        }
        return true;
    }

    @Override
    public Iterator<Locale> iterator() {
        return new Iterator<Locale>() {

            private Iterator<Locale> it = lista_locali.iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Locale next() {
                if (!it.hasNext()) throw new NoSuchElementException();
                return it.next();
            }

        };
    }

    /**
     * Restituisce true se due alias sono uguali
     * 
     * @param o object
     * @return true se this e o sono uguali, false altrimenti
     */
    @Override 
    public boolean equals(Object o) {
        if (!(o instanceof Alias)) return false;
        Alias other = (Alias) o;
        if (!(this.nome.equals(other.nome))) return false;
        return true;
    }

    /**
     * Restituisce una rappresentazione testuale dell'Alias
     * 
     * @return una rappresentazione testuale di this
     */
    @Override 
    public String toString() {
        assert repOk();
        
        String s = "";
        s += "Alias = " + this.nome + "\n";
        for (Locale l : this) {
            Indirizzo indirizzo = new Indirizzo(l, this.dominio);
            s += indirizzo.toString() + "\n";
        }
        return s;
    }

}
