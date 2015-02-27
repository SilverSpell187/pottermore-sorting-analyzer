package operations;

import java.util.HashMap;
import trialshelper.ExploreExcel;
import variables.*;
import variables.auxs.*;

/**
 * Contains a repressentation of every single Answer within the Quiz, already
 * weightened and with full info, each one accessible through its enum Type.
 * This Class is designed to ease the way in which the answer weighting might be
 * changed and so provide a simple way in which several possibilities can be
 * tried. This Class uses the jxl.jar Library under its GNU copyleft license.
 *
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-11
 */
public class SortingQuiz {

    /**
     * Contains all possible Answers for this Quiz.
     */
    HashMap<TipoR, Answer> answers = new HashMap<>();

    /**
     * Constructor. It reads the TipoR enum and creates a new Answer object for
     * each one assigning the related weights found in the 2nd sheet of the
     * Excel file to, respectively, Gryffindor, Hufflepuff, Ravenclaw and
     * Slytherin.
     *
     * @see TipoR
     * @see Answer
     * @see ExploreExcel retrieveWeights
     */
    public SortingQuiz() {
        HashMap<String, double[]> scoringMethod = ExploreExcel.retrieveWeights();
        TipoR[] answerTypes = TipoR.values();
        for (int i=0; i<answerTypes.length; i++) {
            double[] weight = scoringMethod.get(answerTypes[i].getOpcion());
            Answer r = new Answer(answerTypes[i],
                    new Diamonds(weight[1]),
                    new Emeralds(weight[3]),
                    new Shappires(weight[2]),
                    new Rubys(weight[0]));
            this.answers.put(answerTypes[i], r);
        }
    }
    
    /**
     * Assigns a new numerical value to the Weight given by an Answer object to
     * the specified House.
     * @param Answer Answer to be reviewd and updated.
     * @param House House whose weighting is to be updated.
     * @param double New value that should be given to the updated weight.
     * @return True if an update has succesfully been performed, false otherwise.
     */
    public boolean setNewWeighting(TipoR a, House h, double sc) {
        boolean changeCorrect = false;
        if (h.equals(House.G)) {
            this.answers.get(a).setGryffindorWeight(sc);
            changeCorrect = true;
        }
        if (h.equals(House.R)) {
            this.answers.get(a).setRavenclawWeight(sc);
            changeCorrect = true;
        }
        if (h.equals(House.H)) {
            this.answers.get(a).setHufflepuffWeight(sc);
            changeCorrect = true;
        }
        if (h.equals(House.S)) {
            this.answers.get(a).setSlytherinWeight(sc);
            changeCorrect = true;
        }
        return changeCorrect;
    }
    
    public void adjustScoringMethod(ExploreExcel data) {
        for(SortingSample s : data.samples.values()) {
            if(!s.isHatstall()) {
                //Variables to pay attention to
                House actual, predicted;
                actual = s.getHouse();
                predicted = s.getPredicted();
                //If Missorted
                if(actual != predicted) {
                    //Calc the difference of the scores and the items it should count for more
                    double dif = (s.getScoring().getScoreFrom(predicted)) - (s.getScoring().getScoreFrom(actual));
                    int items = 0;
                    for(int i=1; i<7; i++) {
                        if(this.answers.get(s.getAnswerNum(i)).hasWeightFor(actual)) {
                            items++;
                        }
                    }
                    //Calc and update the Answer weights
                    double correction = dif/items;
                        this.answers.get(s.getAnswerNum(3)).updateWeightFor(actual, correction);
                        this.answers.get(s.getAnswerNum(4)).updateWeightFor(actual, correction);
                }
            }
        }
    }
    
    /**
     * Prints a summary of all weights given by every Answer contained within
     * this Quiz object (Scoring Method).
     */
    public void printScoringMethodSummary() {
        System.out.println("*************************************************");
        System.out.println("Answer Weights of Tested Method:");
        for(TipoR r : TipoR.values()) {
            System.out.println(this.answers.get(r).toString());
        }
        System.out.println("*************************************************");
    }
}
