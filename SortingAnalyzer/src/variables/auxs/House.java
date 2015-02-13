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
    HATSTALL ("Hatstall");
    
    House(String n) {
        this.nombre = n;
    }
    /**
     * Contains the identification of the House refered by this Enum Type.
     */
    private final String nombre;
    /**
     * For Hatstalls may be used to state its class, that is, the initials of
     * every House involved.
     */
    private String tipo;
    
    /**
     * Gives back the House name.
     * @return House name or Hatstall.
     */
    @Override
    public String toString() {
        return this.nombre;
    }
    
    /**
     * Assigns the Hastall class, that is, the identification of the Houses
     * involved in said Hatstall.
     * @param int Hatstall type (two-way, three-way, etc)
     * @param House[] Array containing the Houses ordered by score. 
     */
    public void setHatstallType(int n, House[] home) {
        if(this.equals(HATSTALL)) {
            for(int i=0; i<n; i++) {
                this.tipo += home[i].toString() + "/";
            }
        }
    }
}
