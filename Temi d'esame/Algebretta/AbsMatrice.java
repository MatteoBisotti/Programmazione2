/**
 * AbsMatrice
 */

import java.util.*;

public abstract class AbsMatrice implements InterfaceMatrice {

    @Override 
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i=0; i<dim(); i++) {
            for (int j=0; j<dim(); j++) {
                s.append(val(i, j));
                if (j < dim() - 1) {
                    s.append(", ");
                }
            }
            if (i < dim() - 1) {
                s.append("; ");
            }
        }
        s.append("]");
        return s.toString();
    }
    
}
