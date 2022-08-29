/**
 * Locale
 */

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Locale {

    private final String locale;
    final static Predicate<String> VALIDOLOCALE = Pattern.compile("^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$").asPredicate();

    /**
     * Funzione di Astrazione AF(locale) = locale
     * Invariante di Rappresentazione IR = locale non deve essere null
     *                                     locale deve essere una stringa valida
     */

    /**
     * Costruisce un oggetto di classe Locale
     * 
     * @param locale stringa
     * @throws NullPointerException nel caso in cui locale sia null
     * @throws IllegalArgumentException nel caso in cui locale non sia una stringa valida
     */
    public Locale(final String locale) {
        Objects.requireNonNull(locale);

        if (!(VALIDOLOCALE.test(locale))) throw new IllegalArgumentException("La parte locale non è valida.");

        this.locale = locale;
    }

    /**
     * Restituisce true se vale l'invariante di rappresentazione
     * 
     * @return true se vale l'invariante di rappresentazione, false altrimenti
     */
    public boolean repOk() {
        if (this.locale == null) return false;
        if (!(VALIDOLOCALE.test(this.locale))) return false;
        return true;
    }

    /**
     * Restituisce la stringa che rappresenta la parte locale 
     * 
     * @return la stringa che rappresenta this
     */
    public String locale() {
        return this.locale;
    }

    /**
     * Restituisce una rappresentazione testuale di this
     */
    @Override 
    public String toString() {
        return this.locale;
    }
    
}