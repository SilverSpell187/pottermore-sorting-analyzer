package operations;

import java.util.Arrays;
import variables.*;
import variables.auxs.*;

/**
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
        if(scores[0].equals(scores[1])) {
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
            if(scores[0] instanceof Rubys) {
                house = ((Rubys)scores[0]).getHouse();
            }
            if(scores[0] instanceof Diamonds) {
                house = ((Diamonds)scores[0]).getHouse();
            }
            if(scores[0] instanceof Emeralds) {
                house = ((Emeralds)scores[0]).getHouse();
            }
            if(scores[0] instanceof Shappires) {
                house = ((Shappires)scores[0]).getHouse();
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
        return "G/" + this.gryffindor.getValue() + "\t" +
                "R/" + this.ravenclaw.getValue() + "\t" +
                "H/" + this.hufflepuff.getValue() + "\t" +
                "S/" + this.slytherin.getValue() + "\t";
    }
        
}
