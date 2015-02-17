package operations;

import java.util.HashMap;
import variables.*;
import variables.auxs.*;

/**
 * This Class is designed to represent an individual, already answered, Quiz.
 * Note that it only records the enum Type corresponding to each individual
 * answer, not any fully informative Answer object, as well as the House that is
 * assigned to that particular Sorting. It also provides a way to keep track of
 * possible duplicates differentieting them from Hatstalls.
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-13
 */
public class SortingSample {
    /**
     * Contains all Answers' enum Types given by the subject to the Quiz.
     */
    private HashMap<Integer, TipoR> answers = new HashMap<>();
    /**
     * Contains the enum summary of the House in which the person was sorted.
     */
    private House house;
    /**
     * Contains the enum summary of the House in which this sorting is
     * predicted to belong to, after calculating its HourGlass.
     * @see HourGlass
     */
    private House predicted;
    /**
     * Contains an true/false label indicating if this particular Sorting refers
     * to a Hatstall and, thus, it is bound to have another identical copy, save
     * for the House assigned to it.
     */
    private boolean isHatstall;
    /**
     * Contains the estimated weights of this person in every House.
     */
    protected HourGlass scores = new HourGlass();
    
    /**
     * Constructor.
     * @see Answer
     * @param TipoR Answers' enum Types to Questions 1-7 in a regular Sorting Quiz.
     * @param House House enum summary of the one in which this person was
     * originally sorted to.
     * @param boolean Indicator of this object representing (true) or not (false)
     * a Hatstall sorting.
     */
    public SortingSample(TipoR a1, TipoR a2, TipoR a3, TipoR a4, TipoR a5, TipoR a6, TipoR a7, House h, boolean hatstall) {
        this.answers.put(1, a1);
        this.answers.put(2, a2);
        this.answers.put(3, a3);
        this.answers.put(4, a4);
        this.answers.put(5, a5);
        this.answers.put(6, a6);
        this.answers.put(7, a7);
        this.house = h;
        this.isHatstall = hatstall;
    }
    
    /**
     * Returns the House in which this person was originally sorted into.
     * @return The House in which the person was sorted into.
     */
    public House getHouse() {
        return this.house;
    }
    /**
     * Returns the enum type of the House predicted for this Sample.
     * @return The House predicted.
     */
    public House getPredicted() {
        return this.predicted;
    }
    
    public void predictHouse() {
        this.predicted = this.scores.getSorted();
    }
    /**
     * This methods returns true if this object represents a Hatstall sorting and
     * therefore should have an identical twin, save for the assigned House.
     * @return boolean True if the Sorting is a Hatstall, false if not.
     */
    public boolean isHatstall() {
        return this.isHatstall;
    }
    /**
     * Returns the Answer enum type given by the subject in Q#.
     * @param int Numerical place of the Question/Answer within the Quiz.
     */
    public TipoR getAnswerNum(int p) {
        return this.answers.get(p);
    }
    /**
     * Returns the Scores contained within this object.
     * @return HourGlass containing the Scores given by this object to every House.
     */
    public HourGlass getScoring() {
        return this.scores;
    }
    /**
     * Compares the House assigned to this particular Sorting with the one that
     * would be expected given the correspondent algorithm.
     * @return Returns -1 if this SortingSample belongs to a Hatstall and thus
     * farther investigation ought to be done in order to determine whether its
     * predicted Houses match the appropiate Hatstall. Otherwise, this returns
     * 0 if both the predicted House and the actual one match, or 1 if said
     * prediction failed and thus is a missorting.
     */
    public int isMissorted() {
        int isMissorted = 0;
        if (this.isHatstall) {
            isMissorted = -1;
        } else {
            if (this.house != this.predicted) {
                isMissorted = 1;
            }
        }
        return isMissorted;
    }
    
    /**
     * Given a SortingQuiz (Scoring Method) and a Sorting Sample, it runs the
     * weightAnswer method to calculate the final scores predicted by said
     * Scoring Method in every House.
     * @param SortingQuiz Scoring method according to which the Sample must be
     * scored.
     * @param SortingSample A simple, individual sorting sample to be scored. 
     */
    public void scoreSorting(SortingQuiz scoringMethod, SortingSample s) {
        for(int i=1; i<=s.answers.size(); i++) {
            System.out.println(s.toString());
            System.out.println(s.answers.size());
            System.out.println(s.getAnswerNum(i+1));
            System.out.println(scoringMethod.answers.get(s.getAnswerNum(i)).toString());
//            System.out.println(scoringMethod.answers.get(s.getAnswerNum(i)).getClass()); //ERROR EN CÓDIGO (NULL POINTER)!!!!
            HourGlass scores = new HourGlass();
            scores.weightAnswer(scoringMethod.answers.get(s.getAnswerNum(i)));
            System.out.println(scores);
//            this.scores.weightAnswer(scoringMethod.answers.get(s.getAnswerNum(i)));
        }
    }
    
    @Override
    public String toString() {
        String summary = "";
        summary += this.answers.get(1).getOpcion() + " // ";
        summary += this.answers.get(2).getOpcion() + " // ";
        summary += this.answers.get(3).getOpcion() + " // ";
        summary += this.answers.get(4).getOpcion() + " // ";
        summary += this.answers.get(5).getOpcion() + " // ";
        summary += this.answers.get(6).getOpcion() + " // ";
        summary += this.answers.get(7).getOpcion();
        return summary;
    }
}
