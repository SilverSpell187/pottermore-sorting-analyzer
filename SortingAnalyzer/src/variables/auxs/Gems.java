package variables.auxs;
/**
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-11
 */
public abstract class Gems implements Comparable<Gems> {
    /**
     * Contains the Score associated to a particular House.
     */
    private double puntos;
    
    /**
     * Constructor.
     *
     * @param double Score associated by this object to a particular House.
     */
    public Gems(double sc) {
        this.puntos = sc;
    }
    
    /**
     * Returns the Score given by this object to a particular House.
     *
     * @return double Score given by this object to its particular House.
     */
    public double getValue() {
        return this.puntos;
    }
    /**
     * Sets the Score given by this object to its particular House.
     *
     * @param double Score given by this object to its particular House.
     */
    public void setValue(double sc) {
        this.puntos = sc;
    }
    /**
     * Sets the Score within this object back to 0.
     */
    public void resetCount() {
        this.puntos = 0;
    }
    
    /**
     * Adds the specified numerical Weight to this object's counter.
     *
     * @param double Numerical weight (score) added.
     */
    public void addPoints(double sc) {
        this.puntos += sc;
    }
    /**
     * Takes the specified numerical Weight from this object's counter.
     *
     * @param double Numerical weight (score) taken.
     */
    public void takePoints(double sc) {
        this.puntos -= sc;
    }
    /**
     * Multiplies the specified numerical Weight of this object's counter.
     *
     * @param double Numerical weight to which this object's counter is to be
     * multiplied.
     */
    public void multiplyPoints(double sc) {
        this.puntos = this.puntos*sc;
    }

    /**
     * Compares an "associated Score (Gems)" object with another one to know if
     * its value is equal, higher or lower. Returns 0 if both are equal. Returns
     * a negative integer if it is lower, or possitive if it is higher.
     *
     * @param Gems Object associated Score.
     * @return Comparison.
     */
    @Override
    public int compareTo(Gems h) {
        Double h1 = h.getValue();
        Double este = this.getValue();
        return este.compareTo(h1);
    }
}