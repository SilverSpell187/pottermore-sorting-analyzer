package variables.auxs;

import java.util.Comparator;

/**
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-11
 */
public abstract class Comparador implements Comparator<Gems> {
    /**
     * Compares two associated Scores (Gems) and determines which relation there
     * is between them, that is, if the first one is bigger, equal or smaller than
     * the second.
     * @param h1 Gems object.
     * @param h2 Gems object.
     * @return Returns 0 if both Scores are equal or if there has occurred an
     * error; returns 1 if the first Score is the biggest and -1 if it is smaller
     * than the second one.
     */
    @Override
    public int compare(Gems h1, Gems h2) {
        int resultado = 0;
        try {
            if(h1.getValue()<h2.getValue()) {
                resultado = -1;
            } else if(h1.getValue()>h2.getValue()) {
                resultado = 1;
            }
        } catch (ClassCastException e) {
        }
        return resultado;
    }
}