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
