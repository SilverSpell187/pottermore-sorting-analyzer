package variables;

import variables.auxs.Gems;
import variables.auxs.House;

/**
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-11
 */
public class Emeralds extends Gems {
    /**
     * Contains an identification of the Slytherin House.
     * {@value #house}
     */
    private static final House house = House.S;
    
    /**
     * Constructor.
     *
     * @param double Score associated by this object to Slytherin.
     */
    public Emeralds(double sc) {
        super(sc);
    }
    
    /**
     * Return the identification of the House this object represents.
     *
     * @param Casa Slytherin's id.
     */
    public House getHouse() {
        return Emeralds.house;
    }
}