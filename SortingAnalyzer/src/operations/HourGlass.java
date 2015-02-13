package operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                this.gryffindor.addPoints(a.getGryffindorWeight());
                this.hufflepuff.addPoints(a.getHufflepuffWeight());
                this.ravenclaw.addPoints(a.getRavenclawWeight());
                this.slytherin.addPoints(a.getSlytherinWeight());
                break;
            case 2:
                this.gryffindor.addPoints(a.getGryffindorWeight());
                this.hufflepuff.addPoints(a.getHufflepuffWeight());
                this.ravenclaw.addPoints(a.getRavenclawWeight());
                this.slytherin.addPoints(a.getSlytherinWeight());
                break;
            case 3:
                this.gryffindor.addPoints(a.getGryffindorWeight());
                this.hufflepuff.addPoints(a.getHufflepuffWeight());
                this.ravenclaw.addPoints(a.getRavenclawWeight());
                this.slytherin.addPoints(a.getSlytherinWeight());
                break;
            case 4:
                this.gryffindor.addPoints(a.getGryffindorWeight());
                this.hufflepuff.addPoints(a.getHufflepuffWeight());
                this.ravenclaw.addPoints(a.getRavenclawWeight());
                this.slytherin.addPoints(a.getSlytherinWeight());
                break;
            case 5:
                this.gryffindor.addPoints(a.getGryffindorWeight());
                this.hufflepuff.addPoints(a.getHufflepuffWeight());
                this.ravenclaw.addPoints(a.getRavenclawWeight());
                this.slytherin.addPoints(a.getSlytherinWeight());
                break;
            case 6:
                this.gryffindor.addPoints(a.getGryffindorWeight());
                this.hufflepuff.addPoints(a.getHufflepuffWeight());
                this.ravenclaw.addPoints(a.getRavenclawWeight());
                this.slytherin.addPoints(a.getSlytherinWeight());
                break;
            case 7:
                this.gryffindor.multiplyPoints(a.getGryffindorWeight());
                this.hufflepuff.multiplyPoints(a.getHufflepuffWeight());
                this.ravenclaw.multiplyPoints(a.getRavenclawWeight());
                this.slytherin.multiplyPoints(a.getSlytherinWeight());
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
     * 
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
     * @see Gems addPoints()
     */
    private void addScore(Gems sc) {
        if(sc instanceof Rubys) {
            this.gryffindor.addPoints(sc.getValue());
        }
        if(sc instanceof Diamonds) {
            this.hufflepuff.addPoints(sc.getValue());
        }
        if(sc instanceof Emeralds) {
            this.slytherin.addPoints(sc.getValue());
        }
        if(sc instanceof Shappires) {
            this.ravenclaw.addPoints(sc.getValue());
        }
    }
}
