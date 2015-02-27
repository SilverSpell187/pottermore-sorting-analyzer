package variables;

import variables.auxs.TipoR;
import variables.auxs.House;

/**
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-11
 */
public class Answer {
    /**
     * Contains the Score (Weight) given by this object to Hufflepuff House.
     */
    private Diamonds puff;
    /**
     * Contains the Score (Weight) given by this object to Slytherin House.
     */
    private Emeralds sly;
    /**
     * Contains the Score (Weight) given by this object to Ravenclaw House.
     */
    private Shappires claw;
    /**
     * Contains the Score (Weight) given by this object to Gryffindor House.
     */
    private Rubys gryf;
    /**
     * Contains a unique enum type (answer) identifier which includes its text.
     */
    private TipoR answer;
    
    /**
     * Constructor.
     * @param id Unique number identifier of this particular Quiz item.
     * @param TipoR Unique answer identifier, containing its shortened text.
     * @param Diamonds Weight given by this object to Hufflepuff House.
     * @param Emeralds Weight given by this object to Slytherin House.
     * @param Shappires Weight given by this object to Raveclaw House.
     * @param Rubys Weight given by this object to Gryffindor House.
     */
    public Answer(TipoR answer, Diamonds h, Emeralds s, Shappires r, Rubys g) {
        this.answer = answer;
        this.puff = h;
        this.sly = s;
        this.claw = r;
        this.gryf = g;
    }
    /**
     * Constructor. Sets up an Answer object with no weigths.
     * @param id Unique number identifier of this particular Quiz item.
     * @param TipoR Unique answer identifier, containing its shortened text.
     */
    public Answer(TipoR answer) {
        this.answer = answer;
    }
    
    /**
     * Returns the relative Weight given by this Object-Answer to Gryffindor.
     * @return double This answer's weight for Gryffindor.
     */
    public double getGryffindorWeight() {
        return this.gryf.getValue();
    }
    /**
     * Returns the relative Weight given by this Object-Answer to Hufflepuff.
     * @return double This answer's weight for Hufflepuff.
     */
    public double getHufflepuffWeight() {
        return this.puff.getValue();
    }
    /**
     * Returns the relative Weight given by this Object-Answer to Ravenclaw.
     * @return double This answer's weight for Ravenclaw.
     */
    public double getRavenclawWeight() {
        return this.claw.getValue();
    }
    /**
     * Returns the relative Weight given by this Object-Answer to Slytherin.
     * @return double This answer's weight for Slytherin.
     */
    public double getSlytherinWeight() {
        return this.sly.getValue();
    }
    /**
     * Returns the shortened version of this answer.
     * @return String Shortened description of this answer.
     */
    public String getAnswerText() {
        return this.answer.getOpcion();
    }
    /**
     * Returns the enum type corresponding to this Answer object.
     * @return TipoR enum constant associated with this object.
     */
    public TipoR getAnswerType() {
        return this.answer;
    }
    /**
     * Returns an integer representing the order (place) in which the Question to
     * which this Answer belongs appears within the original Quiz.
     * @return int Numerical place within the Quiz.
     * @see TipoQ
     * @see getOrder()
     */
    public int getPlaceWithinQuiz() {
        return this.answer.getQuestionType().getOrder();
    }
    
    /**
     * Returns the numerical weight value associated with the House provided.
     * @param House House id whose numerical weight we wish to know.
     * @return Numerical value, in double format, assigned to the provided House
     * by this Answer object.
     */
    public double getWeightFor(House h) {
        double score = 0;
        if(this.gryf.getHouse().equals(h)) {
            score = this.getGryffindorWeight();
        }
        if(this.claw.getHouse().equals(h)) {
            score = this.getRavenclawWeight();
        }
        if(this.puff.getHouse().equals(h)) {
            score = this.getHufflepuffWeight();
        }
        if(this.sly.getHouse().equals(h)) {
            score = this.getSlytherinWeight();
        }
        return score;
    }
    /**
     * Returns true if this Answer object has weight towards the specified House
     * and false otherwise (i.e. if it gives 0 points to it).
     * @param House House id whose relation with this Answer we wish to know.
     * @return Returns true if this Answer object gives a numerical value (weight)
     * higher or below 0, thus giving points to the specified House, and false
     * otherwise. Note that false is also the default option.
     */
    public boolean hasWeightFor(House h) {
        boolean hasWeight = false;
        if(this.getWeightFor(h) != 0) {
            hasWeight = true;
        }
        return hasWeight;
    }
    /**
     * Sets a new Score associated with a specified House, being the new value
     * the adding of a score to the previous one.
     * @param House House id whose weight is to be updated.
     * @param double New numerical weight to be added for the specified House.
     */
    public void updateWeightFor(House h, double sc) {
        if(this.gryf.getHouse().equals(h)) {
            this.gryf.setValue(this.getGryffindorWeight()+sc);
        }
        if(this.claw.getHouse().equals(h)) {
            this.claw.setValue(this.getRavenclawWeight()+sc);
        }
        if(this.puff.getHouse().equals(h)) {
            this.puff.setValue(this.getHufflepuffWeight()+sc);
        }
        if(this.sly.getHouse().equals(h)) {
            this.sly.setValue(this.getSlytherinWeight()+sc);
        }
    }
    
    /**
     * Sets the relative Weight given by this Object-Answer to Gryffindor.
     * @param double Weight given by this Answer to Gryffindor House.
     */
    public void setGryffindorWeight(double sc) {
        this.gryf.setValue(sc);
    }
    /**
     * Sets the relative Weight given by this Object-Answer to Hufflepuff.
     * @param double Weight given by this Answer to Hufflepuff House.
     */
    public void setHufflepuffWeight(double sc) {
        this.puff.setValue(sc);
    }
    /**
     * Sets the relative Weight given by this Object-Answer to Ravenclaw.
     * @param double Weight given by this Answer to Ravenclaw House.
     */
    public void setRavenclawWeight(double sc) {
        this.claw.setValue(sc);
    }
    /**
     * Sets the relative Weight given by this Object-Answer to Slytherin.
     * @param double Weight given by this Answer to Slytherin House.
     */
    public void setSlytherinWeight(double sc) {
        this.sly.setValue(sc);
    }
    
    /**
     * Returns a description of this Answer object, containing the shortened
     * version of Answer text and the Weights given by it to each House.
     * @return Answer description, weights included.
     */
    @Override
    public String toString() {
        return "G/" + this.getGryffindorWeight() + "\t" +
                "R/" + this.getRavenclawWeight() + "\t" +
                "H/" + this.getHufflepuffWeight() + "\t" +
                "S/" + this.getSlytherinWeight() + "\t" +
                " -> " + this.getAnswerText();
    }
}
