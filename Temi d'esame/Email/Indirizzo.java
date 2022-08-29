/**
 * Indirizzo
 */

import java.util.*;

public class Indirizzo {

    private final Locale locale;
    private final Dominio dominio;

    /**
     * Funzione di Astrazione AF(locale, dominio) = locale@dominio
     * Invariante di Rappresentazione IR = locale non deve essere null
     *                                     dominio non deve essere null
     */

    /**
     * Costruisce un oggetto di classe Indirizzo 
     * 
     * @param locale stringa
     * @param dominio stringa
     * @throws NullPointerException nel caso in cui locale sia null
     * @throws NullPointerException nel caso in cui dominio sia null
     */
    public Indirizzo(final String locale, final String dominio) {
        Objects.requireNonNull(locale);
        Objects.requireNonNull(dominio);
        Locale l = new Locale(locale);
        Dominio d = new Dominio(locale);
        this.locale = l;
        this.dominio = d;
    }

    /**
     * Costruisce un oggetto di classe Indirizzo 
     * 
     * @param locale Locale
     * @param dominio Dominio
     * @throws NullPointerException nel caso in cui locale sia null
     * @throws NullPointerException nel caso in cui dominio sia null
     */
    public Indirizzo(final Locale locale, final Dominio dominio) {
        Objects.requireNonNull(locale);
        Objects.requireNonNull(dominio);
        this.locale = locale;
        this.dominio = dominio;
    }

    /**
     * Restituisce true se vale l'invariante di rappresentazione
     * 
     * @return true se vale l'invariante di rappresentazione, false altrimenti
     */
    public boolean repOk() {
        if (this.locale == null) return false;
        if (this.dominio == null) return false;
        return true;
    }

    /**
     * Restituisce la parte locale dell'indirizzo
     * 
     * @return la parte locale di this
     */
    public Locale getLocale() {
        return this.locale;
    }   

    /**
     * Restituisce la parte dominio dell'indirizzo
     * 
     * @return la parte dominio di this
     */
    public Dominio getDominio() {
        return this.dominio;
    }

    /**
     * Restituisce true se due indirizzi sono uguali
     * 
     * @param o object
     * @return true se this e o sono uguali
     */
    @Override 
    public boolean equals(Object o) {
        if (!(o instanceof Indirizzo)) return false;
        Indirizzo other = (Indirizzo) o;
        if (!(this.getLocale().locale().equals(other.getLocale().locale()))) return false;
        if (!(this.getDominio().dominio().equals(other.getDominio().dominio()))) return false;
        return true;
    }

    /**
     * Restituisce una rappresentazione testuale di this
     */
    @Override
    public String toString() {
        return this.locale.toString() + "@" + this.dominio.toString();
    }

}