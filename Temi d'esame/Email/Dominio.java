/**
 * Dominio
 */

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Dominio {

    private final String dominio;
    final static Predicate<String> VALIDODOMINIO = Pattern.compile("^[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$").asPredicate();

    /**
     * Funzione di Astrazione AF(dominio) = dominio
     * Invariante di Rappresentazione IR = dominio non deve essere null
     *                                     dominio deve essere valida
     */

    /**
     * Costruisce un oggetto di classe Dominio
     * 
     * @param dominio stringa
     * @throws NullPointerException nel caso in cui dominio sia null
     * @throws IllegalArgumentException nel caso in cui dominio non sia una stringa valida
     */
    public Dominio(final String dominio) {
        Objects.requireNonNull(dominio);

        if (!(VALIDODOMINIO.test(dominio))) throw new IllegalArgumentException("La parte dominio non è valida.");

        this.dominio = dominio;
    }

    /**
     * Restituisce true se vale l'invariante di rappresentazione
     * 
     * @return true se vale l'invariante di rappresentazione, false altrimenti
     */
    public boolean repOk() {
        if (this.dominio == null) return false;
        if (!(VALIDODOMINIO.test(this.dominio))) return false;
        return true;
    }

    /**
     * Restituisce la stringa che rappresenta la parte dominio 
     * 
     * @return la stringa che rappresenta this
     */
    public String dominio() {
        return this.dominio;
    }

    /**
     * Restituisce una rappresentazione testuale di this
     */
    @Override 
    public String toString() {
        return this.dominio;
    }

}