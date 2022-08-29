/**
 * InterfaceVettore
 */

import java.util.*;

public interface InterfaceVettore {

    int dim();

    int val(final int i);

    InterfaceVettore per(final int alpha);

    InterfaceVettore più(final InterfaceVettore v);

}