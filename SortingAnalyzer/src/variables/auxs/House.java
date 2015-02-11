package variables.auxs;

/**
 * Collection for every possible value of Hogwarts Houses plus the Hatstall option.
 * @author SilverSpell187
 * @since 2015-02-11
 * @version 1.0
 */
public enum House {
    /**
     * Gryffindor House.
     */
    G ("Gryffindor"),
    /**
     * Ravenclaw House.
     */
    R ("Ravenclaw"),
    /**
     * Hufflepuff House.
     */
    H ("Hufflepuff"),
    /**
     * Slytherin House.
     */
    S ("Slytherin"),
    /**
     * Hatstall (occurs when equal score in, at least, two Houses).
     */
    HATSTALL ("");
    
    House(String n) {
        this.nombre = n;
    }
    
    private final String nombre;
    
    /**
     * Gives back the House name.
     * @return String House name; if Hatstall, the String will be empty.
     */
    @Override
    public String toString() {
        return this.nombre;
    }
}
