package operations;

import java.util.Arrays;
import variables.*;
import variables.auxs.*;

/**
 * This Class is designed to represent the Scores or Weight values corresponding
 * to each individual answer as well as those belonging to particular subjects
 * (as SortingSamples), so it contains the variables related to each House and
 * methods for doing all related maths (using, in most cases, those contained
 * within the Gems superclass).
 * @see Gems
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-11
 */
public class HourGlass {
    /**
     * Contains the Score given by this object to Gryffindor.
     */
    private Rubys gryffindor;
    /**
     * Contains the Score given by this object to Ravenclaw.
     */
    private Shappires ravenclaw;
    /**
     * Contains the Score given by this object to Hufflepuff.
     */
    private Diamonds hufflepuff;
    /**
     * Contains the Score given by this object to Slytherin.
     */
    private Emeralds slytherin;
    
    /**
     * Constructor.
     */
    public HourGlass() {
        this.gryffindor = new Rubys(0);
        this.ravenclaw = new Shappires(0);
        this.hufflepuff = new Diamonds(0);
        this.slytherin = new Emeralds(0);
    }
    
    /**
     * Deletes all numerical values within this object, setting all House
     * counters back to 0.
     */
    protected void resetAllCounters() {
        this.gryffindor.resetCount();
        this.hufflepuff.resetCount();
        this.ravenclaw.resetCount();
        this.slytherin.resetCount();
    }
    /**
     * Adds all weights given by an Answer to each House counter within this
     * object. Currently Q7 multiplys its value.
     * 
     * @param Answer Answer to be weighted.
     */
    public void weightAnswer(Answer a) {
        switch (a.getPlaceWithinQuiz()) {
            case 1:
                this.gryffindor.add(a.getGryffindorWeight());
                this.hufflepuff.add(a.getHufflepuffWeight());
                this.ravenclaw.add(a.getRavenclawWeight());
                this.slytherin.add(a.getSlytherinWeight());
                break;
            case 2:
                this.gryffindor.add(a.getGryffindorWeight());
                this.hufflepuff.add(a.getHufflepuffWeight());
                this.ravenclaw.add(a.getRavenclawWeight());
                this.slytherin.add(a.getSlytherinWeight());
                break;
            case 3:
                this.gryffindor.add(a.getGryffindorWeight());
                this.hufflepuff.add(a.getHufflepuffWeight());
                this.ravenclaw.add(a.getRavenclawWeight());
                this.slytherin.add(a.getSlytherinWeight());
                break;
            case 4:
                this.gryffindor.add(a.getGryffindorWeight());
                this.hufflepuff.add(a.getHufflepuffWeight());
                this.ravenclaw.add(a.getRavenclawWeight());
                this.slytherin.add(a.getSlytherinWeight());
                break;
            case 5:
                this.gryffindor.add(a.getGryffindorWeight());
                this.hufflepuff.add(a.getHufflepuffWeight());
                this.ravenclaw.add(a.getRavenclawWeight());
                this.slytherin.add(a.getSlytherinWeight());
                break;
            case 6:
                this.gryffindor.add(a.getGryffindorWeight());
                this.hufflepuff.add(a.getHufflepuffWeight());
                this.ravenclaw.add(a.getRavenclawWeight());
                this.slytherin.add(a.getSlytherinWeight());
                break;
            case 7:
                this.gryffindor.multiplyBy(a.getGryffindorWeight());
                this.hufflepuff.multiplyBy(a.getHufflepuffWeight());
                this.ravenclaw.multiplyBy(a.getRavenclawWeight());
                this.slytherin.multiplyBy(a.getSlytherinWeight());
                break;
        }
    }
    
    /**
     * Returns the Score associated to the provided House stored within this object.
     * @param House The House whose score is asked.
     * @return double The score linked to that House.
     */
    public double getScoreFrom(House h) {
        double score = -1;
        if(this.gryffindor.getHouse().equals(h)) {
            score = this.gryffindor.getValue();
        }
        if(this.hufflepuff.getHouse().equals(h)) {
            score = this.hufflepuff.getValue();
        }
        if(this.ravenclaw.getHouse().equals(h)) {
            score = this.ravenclaw.getValue();
        }
        if(this.slytherin.getHouse().equals(h)) {
            score = this.slytherin.getValue();
        }
        return score;
    }
    
    /**
     * Does the "Sorting", ordering all House scores.
     * @return Gems[] Array containing the associated scores ordered.
     */
    private Gems[] getSortingDone() {
        Gems[] scores = new Gems[4];
        scores[0] = this.gryffindor;
        scores[1] = this.ravenclaw;
        scores[2] = this.hufflepuff;
        scores[3] = this.slytherin;
        Arrays.sort(scores);
        return scores;
    }
    /**
     * Helps identify Hatstalls by comparing the first (highest) associated
     * score with the second one.
     * @param Gems[] Array containing the ordered associated scores of this object.
     * @return Returns true if the first highest and second highest scores are
     * of equal value and therefore there's a Hatstall.
     */
    private static boolean isHatstall(Gems[] scores) {
        boolean isHatstall = false;
        if(scores[3].getValue() == scores[2].getValue()) {
            isHatstall = true;
        }
        return isHatstall;
    }
    /**
     * Runs the getSortingDone method and selects the House with the highest
     * score to return; in case a Hatstall occurred, it returns the correspondent
     * enum type value.
     * @return House with the highest score, once ordered or Hatstall if appropiate.
     */
    public House getSorted() {
        House house = null;
        Gems[] scores = this.getSortingDone();
        if(isHatstall(scores)) {
            house = House.HATSTALL;
        } else {
            if(scores[3] instanceof Rubys) {
                house = ((Rubys)scores[3]).getHouse();
            }
            if(scores[3] instanceof Diamonds) {
                house = ((Diamonds)scores[3]).getHouse();
            }
            if(scores[3] instanceof Emeralds) {
                house = ((Emeralds)scores[3]).getHouse();
            }
            if(scores[3] instanceof Shappires) {
                house = ((Shappires)scores[3]).getHouse();
            }
        }
        return house;
    }
    
    /**
     * Adds the Score given by a Gems object to a particular House, whatever
     * that might be (this method uses the instanceof operator).
     * @param Gems Score object associated to a particular House.
     * @deprecated Possibly not useful.
     * @see Gems add()
     */
    private void addScore(Gems sc) {
        if(sc instanceof Rubys) {
            this.gryffindor.add(sc.getValue());
        }
        if(sc instanceof Diamonds) {
            this.hufflepuff.add(sc.getValue());
        }
        if(sc instanceof Emeralds) {
            this.slytherin.add(sc.getValue());
        }
        if(sc instanceof Shappires) {
            this.ravenclaw.add(sc.getValue());
        }
    }
    
    @Override
    public String toString() {
        return "\tG/" + this.gryffindor.getValue() + "\t" +
                "R/" + this.ravenclaw.getValue() + "\t" +
                "H/" + this.hufflepuff.getValue() + "\t" +
                "S/" + this.slytherin.getValue() + "\t";
    }
        
}
