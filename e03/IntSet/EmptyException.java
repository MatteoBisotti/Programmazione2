/**
 * OVERVIEW: Eccezione sollevata nel caso di insieme vuoto
 */
public class EmptyException extends RuntimeException {

    public EmptyException() {
        super();        // ereditiamo tutto da RunTimeException
    }

    public EmptyException(String m) {
        super(m);
    }
    
}