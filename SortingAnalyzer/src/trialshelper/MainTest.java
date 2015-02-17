package trialshelper;

import operations.SortingQuiz;

/**
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-13
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create an instance of the Quiz: each and every Answer with weights
        SortingQuiz quiz = new SortingQuiz();
        quiz.printScoringMethodSummary();
        //Recover the full sample of Sortings
        ExploreExcel experiment = new ExploreExcel();
        experiment.retrieveAllSamples();
        experiment.evaluateEverythingWith(quiz);
    }
}
