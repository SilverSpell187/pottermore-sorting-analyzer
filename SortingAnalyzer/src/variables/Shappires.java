package variables;

import variables.auxs.Gems;
import variables.auxs.House;

/**
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-11
 */
public class Shappires extends Gems {
    /**
     * Contains an identification of the Ravenclaw House.
     * {@value #house}
     */
    private static final House house = House.R;
    
    /**
     * Constructor.
     *
     * @param double Score associated by this object to Ravenclaw.
     */
    public Shappires(double sc) {
        super(sc);
    }
    
    /**
     * Return the identification of the House this object represents.
     *
     * @param Casa Ravenclaw's id.
     */
    public House getHouse() {
        return Shappires.house;
    }
}