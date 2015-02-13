package operations;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import variables.*;
import variables.auxs.*;

/**
 * This Class is designed to ease the way in which the answer weighting might be
 * changed and so provide a simple way in which several possibilities can be tried.
 * This Class uses the jxl.jar Library under its GNU copyleft license.
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-11
 */
public class SortingQuiz {
    /**
     * Contains all possible Answers for this Quiz.
     */
    HashMap<Integer, Answer> answers = new HashMap<>();
    /**
     * Constructor. It reads the TipoR enum and creates a new Answer object for
     * each one; note that this Constructor assigns NO weights to answers.
     * @see TipoR
     */
    SortingQuiz() {
        TipoR[] answerTypes = TipoR.values();
        for(int i=0; i<answerTypes.length; i++) {
            Answer r = new Answer(i+1, answerTypes[i]);
            this.answers.put(i+1, r);
        }
    }
    /**
     * Constructor. It reads the TipoR enum and creates a new Answer object for
     * each one assigning the weights from the Scoring Method given in the form
     * of a HashMap with key = answer tags (shortened versions) relating to
     * Arrays of doubles corresponding to each Weight.
     * 
     * @param HashMap<String, double[]> Scoring Method where the Keys correspond
     * to the shortened version of any answer and the Array contains the weights
     * given by that answer to, respectively, Gryffindor, Hufflepuff, Ravenclaw
     * and Slytherin.
     * @see TipoR
     */
    SortingQuiz(HashMap<String, double[]> scoringMethod) {
        TipoR[] answerTypes = TipoR.values();
        for(int i=0; i<answerTypes.length; i++) {
            double[] weight = scoringMethod.get(answerTypes[i].getOpcion());
            Answer r = new Answer(i+1, answerTypes[i],
                    new Diamonds(weight[1]),
                    new Emeralds(weight[3]),
                    new Shappires(weight[2]),
                    new Rubys(weight[0])
                    );
            this.answers.put(i+1, r);
        }
    }
    /**
     * Read a XLS document within the code, containing the weights assigned to
     * every House by every single Answer.
     * 
     * @param String Name of the xls (Excel) file containing the answer weights.
     */
    private static HashMap<String, double[]> getWeightingsFrom(String fileName) {
        HashMap<String, double[]> weightings = new HashMap<>();
        try {
            Workbook w = Workbook.getWorkbook(new File(fileName));
            Sheet s = w.getSheet(0);
            //Check row
            for (int y=0; y<s.getRows(); y++) {
                String itemCode = "";
                double[] weights = new double[4];
                //Check column
                for (int x=0; x<s.getColumns(); x++) {
                    Cell celda = s.getCell(x, y);
                    String content = celda.getContents();
                    switch (x) {
                        case 0:     //Answer tag identifier
                            itemCode += content;
                            break;
                        case 1:     //Meaning the Gryffindor weight
                            weights[0] = Double.parseDouble(content);
                            break;
                        case 2:     //Meaning the Hufflepuff weight
                            weights[1] = Double.parseDouble(content);
                            break;
                        case 3:     //Meaning the Ravenclaw weight
                            weights[2] = Double.parseDouble(content);
                            break;
                        case 4:     //Meaning the Slytherin weight
                            weights[3] = Double.parseDouble(content);
                            break;
                    }
                }
                weightings.put(itemCode, weights);
            }
            w.close();
        } catch (IOException | BiffException | IndexOutOfBoundsException e) {
            System.out.println("Error " + e.getMessage());
        }
        return weightings;
    }
}
