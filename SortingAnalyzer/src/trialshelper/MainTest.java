package trialshelper;

import operations.SortingQuiz;

/**
 * This is the main class used to run all the procedures, methods and analysis
 * contained in the remaining java files.
 * @author SilverSpell187
 * @contact runeprophecy@hotmail.com
 * @version 1.0
 * @since 2015-02-13
 */
public class MainTest {

    public static void main(String[] args) {
        //1st Step: Create a full Quiz object with full Answer set with complete info
        SortingQuiz quiz = new SortingQuiz();
        quiz.printScoringMethodSummary(); //Print a summary of the Quiz created
        
        //2nd Step: Recover an image of the full set of Sorting Samples
        ExploreExcel experiment = new ExploreExcel();
        experiment.retrieveAllSamples();
        
        //3rd Step: Run any of the avaliable analysis over the full Data recovered
        experiment.evaluateMissortingsWith(quiz);
        experiment.testAccuracy();
    }
}
