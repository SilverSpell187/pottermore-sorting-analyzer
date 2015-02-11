package variables;

import variables.auxs.Gems;
import variables.auxs.House;

/**
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-11
 */
public class Diamonds extends Gems {
    /**
     * Contains an identification of the Hufflepuff House.
     * {@value #house}
     */
    private static final House house = House.H;
    
    /**
     * Constructor.
     *
     * @param double Score associated by this object to Hufflepuff.
     */
    public Diamonds(double sc) {
        super(sc);
    }
    
    /**
     * Return the identification of the House this object represents.
     *
     * @param Casa Hufflepuff's id.
     */
    public House getHouse() {
        return Diamonds.house;
    }
}