package variables;

import variables.auxs.Gems;
import variables.auxs.House;

/**
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-11
 */
public class Rubys extends Gems {
    /**
     * Contains an identification of the Gryffindor House.
     * {@value #house}
     */
    private static final House house = House.G;
    
    /**
     * Constructor.
     *
     * @param double Score associated by this object to Gryffindor.
     */
    public Rubys(double sc) {
        super(sc);
    }
    
    /**
     * Return the identification of the House this object represents.
     *
     * @param Casa Gryffindor's id.
     */
    public House getHouse() {
        return this.house;
    }
}