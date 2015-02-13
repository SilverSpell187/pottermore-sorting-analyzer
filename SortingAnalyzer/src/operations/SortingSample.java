package operations;

import java.util.HashMap;
import variables.*;
import variables.auxs.*;

/**
 * This Class is designed to represent an individual, already answered, Quiz.
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-13
 */
public class SortingSample {
    /**
     * Contains all Answers given by the subject to the Quiz.
     */
    private HashMap<Integer, Answer> answers = new HashMap<>();
    /**
     * Contains the enum identifier of the House in which the person was sorted.
     */
    private House house;
    /**
     * Contains the estimated weights of this person in every House.
     */
    private HourGlass scores;
    
    /**
     * Constructor.
     * @see Answer
     * @param Answer Answers to Questions 1-7 in a regular Sorting Quiz.
     * @param House House enum identifier of the one in which this person was
     * originally sorted to.
     */
    public SortingSample(Answer a1, Answer a2, Answer a3, Answer a4, Answer a5, Answer a6, Answer a7, House h) {
        this.answers.put(1, a1);
        this.answers.put(2, a2);
        this.answers.put(3, a3);
        this.answers.put(4, a4);
        this.answers.put(5, a5);
        this.answers.put(6, a6);
        this.answers.put(7, a7);
        this.house = h;
    }
    
    /**
     * Returns the House in which this person was originally sorted into.
     * @return The House in which the person was sorted into.
     */
    public House getHouse() {
        return this.house;
    }
    /**
     * Returns the Answer given by the subject in Q#.
     * @param int Numerical place of the Question/Answer within the Quiz.
     */
    public Answer getAnswerNum(int p) {
        return this.answers.get(p);
    }
}
