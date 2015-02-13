package variables;

import variables.auxs.QuizItem;
import variables.auxs.TipoR;

/**
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-11
 */
public class Answer extends QuizItem {
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
     * Contains a unique answer identifier which includes its text.
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
    public Answer(int id, TipoR answer, Diamonds h, Emeralds s, Shappires r, Rubys g) {
        super(id, answer.getOpcion());
        this.answer = answer;
        this.puff = h;
        this.sly = s;
        this.claw = r;
        this.gryf = g;
    }
    /**
     * Constructor.
     * @param id Unique number identifier of this particular Quiz item.
     * @param TipoR Unique answer identifier, containing its shortened text.
     */
    public Answer(int id, TipoR answer) {
        super(id, answer.getOpcion());
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
        return this.getAnswerText() + "\t" +
                "G/" + this.getGryffindorWeight() + "\t" +
                "R/" + this.getRavenclawWeight() + "\t" +
                "H/" + this.getHufflepuffWeight() + "\t" +
                "S/" + this.getSlytherinWeight() + "\n";
    }
}
