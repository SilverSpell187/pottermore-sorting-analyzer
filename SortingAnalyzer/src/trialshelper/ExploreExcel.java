package trialshelper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import operations.*;
import variables.auxs.*;

/**
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-13
 */
public class ExploreExcel {
    //Variables
    static String excelFile = "Registro.xls";
    static TipoR[] r1s = TipoR.values();
    static House[] houses = House.values();
    /**
     * Contains a mapped representation of every Sorting sample found within an
     * Excel file.
     * @see SortingSample
     */
    public HashMap<Integer, SortingSample> samples;
    
    /**
     * Constructor.
     */
    public ExploreExcel() {
        this.samples = new HashMap<>();
    }
    
    /**
     * This method provides a way to read an Excel file containing every Sorting
     * sample avaliable and use the info to build up a HashMap representing each
     * and every single one.
     */
    public void retrieveAllSamples() {
        try {
            Workbook w = Workbook.getWorkbook(new File(excelFile));
            Sheet s = w.getSheet(0);
            for (int y=0; y<s.getRows(); y++) {
                TipoR q1 = null, q2 = null, q5 = null, q6 = null, q7 = null, q3 = null, q4 = null;
                House sortedIn = null;
                boolean hatStall = false;
                for (int x=0; x<s.getColumns(); x++) {
                    Cell celda = s.getCell(x, y);
                    String contenido = celda.getContents();
                    switch (x) {
                        case 0:
                            for(int i=0; i<r1s.length; i++) {
                                if(r1s[i].getOpcion().equals(contenido)) {
                                    q1 = r1s[i];
                                }
                            }
                            break;
                        case 1:
                            for(int i=0; i<r1s.length; i++) {
                                if(r1s[i].getOpcion().equals(contenido)) {
                                    q2 = r1s[i];
                                }
                            }
                            break;
                        case 2:
                            for(int i=0; i<r1s.length; i++) {
                                if(r1s[i].getOpcion().equals(contenido)) {
                                    q3 = r1s[i];
                                }
                            }
                            break;
                        case 3:
                            for(int i=0; i<r1s.length; i++) {
                                if(r1s[i].getOpcion().equals(contenido)) {
                                    q4 = r1s[i];
                                }
                            }
                            break;
                        case 4:
                            for(int i=0; i<r1s.length; i++) {
                                if(r1s[i].getOpcion().equals(contenido)) {
                                    q5 = r1s[i];
                                }
                            }
                            break;
                        case 5:
                            for(int i=0; i<r1s.length; i++) {
                                if(r1s[i].getOpcion().equals(contenido)) {
                                    q6 = r1s[i];
                                }
                            }
                            break;
                        case 6:
                            for(int i=0; i<r1s.length; i++) {
                                if(r1s[i].getOpcion().equals(contenido)) {
                                    q7 = r1s[i];
                                }
                            }
                            break;
                        case 7:
                            for(int i=0; i<houses.length; i++) {
                                if(houses[i].toString().equals(contenido)) {
                                    sortedIn = houses[i];
                                }
                            }
                            break;
                        case 8:
                            if(!contenido.equals("")) {
                                hatStall = true;
                            }
                            break;
                    }
                }
                this.samples.put(y+1, new SortingSample(q1, q2, q3, q4, q5, q6, q7, sortedIn, hatStall));
            }
            w.close();
        } catch (IOException | BiffException | NullPointerException | IndexOutOfBoundsException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    /**
     * Loops through the whole sample applying the Scoring Method provided in
     * order to score each and every Sorting Sample.
     * @param scoringMethod A SortingQuiz object containing a full set of Answer
     * objects with all the related info.
     */
    public void evaluateEverythingWith(SortingQuiz scoringMethod) {
        try {
            if(!this.samples.isEmpty()) {
                for(int i=0; i<this.samples.size(); i++) {
                    SortingSample s = this.samples.get(i+1);
                    s.scoreThisWith(scoringMethod);
                    s.predictHouse();
                    //Print output
                    System.out.println("\nSort #" + (i+1) + "\t -> Predicted: " + s.getPredicted().toString().toUpperCase() +
                            " ///-----------------/// Actual: " + s.getHouse().toString().toUpperCase());
                    System.out.println(s.toString());
                    if(s.isHatstall()) {
                        System.out.println("-> is HATSTALL");
                    }
                    System.out.println(s.getScoring().toString());
                        //End of output
                }
            }
        } catch (NullPointerException e) {
            System.out.println("An error has occurred: " + e.toString());
        }
    }
    
    public void evaluateMissortingsWith(SortingQuiz scoringMethod) {
        try {
            if(!this.samples.isEmpty()) {
                for(int i=0; i<this.samples.size(); i++) {
                    SortingSample s = this.samples.get(i+1);
                    s.scoreThisWith(scoringMethod);
                    s.predictHouse();
                    //Print output
                    if(s.isMissorted() != 0) {
                        System.out.println("\nSort #" + (i + 1) + "\t -> Predicted: " + s.getPredicted().toString().toUpperCase()
                                + " ///-----------------/// Actual: " + s.getHouse().toString().toUpperCase());
                        System.out.println(s.toString());
                        if (s.isHatstall()) {
                            System.out.println("-> should be Hatstall");
                        }
                        System.out.println(s.getScoring().toString());
                    }//End of output
                }
            }
        } catch (NullPointerException e) {
            System.out.println("An error has occurred: " + e.toString());
        }
    }
    
    public void searchForDuplicates() {
//        System.out.println("\n//////-----Duplicate Sortings Found:-----//////");
//        boolean hallados = false;
//        for (SortingSample z : this.samples.values()) {
//            for (SortingSample s : sortings) {
//                if (z.compararCon(s) && z.getID() != s.getID() && !z.isHatstall) {
//                    System.out.println(z.getID() + "\t" + z.getRespuestas() + "\t" + z.getHouse());
//                    System.out.println(s.getID() + "\t" + s.getRespuestas() + "\t" + s.getHouse());
//                    hallados = true;
//                }
//            }
//        }
//        if(!hallados) {
//            System.out.println("\tNone found.");
//        }
    }
    
    public void printSummaryOfAccuracyTestFor(SortingQuiz scoringMethod) {
        System.out.println("//////-----ACCURACY TEST FOR SCORING METHOD:-----//////");
        scoringMethod.printScoringMethodSummary();
    }
    /**
     * This method provides a quick way to analyze the accuracy of an Scoring Method
     * (SortingQuiz), that is, the accuracy of the weights assigned to each answer.
     * It proceeds by calculating the total SortingSamples avaliable from Data and
     * them calculates the total number of Hatstall within them.
     */
    public void testAccuracy() {
        int hatstalls = 0;
        for(int j=0; j<this.samples.size(); j++) {
            if(this.samples.get(j+1).isHatstall()) {
                hatstalls++;
            }
        }
        int contador = 0;
        int contador2 = 0; //Contador para el isMissorted method
        for (int i=0; i<this.samples.size(); i++) {
            if (this.samples.get(i+1).getPredicted().equals(this.samples.get(i+1).getHouse())) {
                contador++;
            }
            if(this.samples.get(i+1).isMissorted()>0) {
                contador2++;
            }
        }
        double resultado = (contador * 100) / (this.samples.size() - (hatstalls/2));
        System.out.print("\n****************\n\tACCURACY OUTPUT:");
        System.out.println("\nFull Sample Size: " + this.samples.size()
                + "\nTotal Hatstalls Found: " + hatstalls/2
                + "\nTotal Sorting Samples: " + (this.samples.size() - (hatstalls/2))
                + "\nCorrectly Predicted Sortings (including Hatstalls): " + contador
                + "\nTotal Failed (excluding Hatstalls): " + contador2);
        System.out.println("Total Failed Sortings: "
                + (this.samples.size() - contador));
        System.out.println("Scoring Method Fiability: "
                + resultado + "%");
    }
    

    /**
     * Reads an Excel file containing all weights for every answers in its 2nd
     * sheet and creates a HashMap using the Answer's shortened text as Key and
     * an Array of doubles with the weights given by that Answer to every House.
     * @return HashMap<String, double[]> Mapped Answer weights.
     * @see Answer
     * @see TipoR
     */
    public static HashMap<String, double[]> retrieveWeights() {
        HashMap<String, double[]> weights = new HashMap<>();
        try {
            Workbook w = Workbook.getWorkbook(new File(excelFile));
            Sheet s = w.getSheet(1);
            for (int y=0; y<s.getRows(); y++) {
                String answerText = "";
                double[] scores = new double[4];
                for (int x=0; x<s.getColumns(); x++) {
                    Cell celda = s.getCell(x, y);
                    String contenido = celda.getContents();
                    String fixedContent = contenido.replaceAll(",",".");
                    switch (x) {
                        case 0:
                            answerText = contenido;
                            break;
                        case 1:
                            scores[0] = Double.parseDouble(fixedContent);
                            break;
                        case 2:
                            scores[1] = Double.parseDouble(fixedContent);
                            break;
                        case 3:
                            scores[2] = Double.parseDouble(fixedContent);
                            break;
                        case 4:
                            scores[3] = Double.parseDouble(fixedContent);
                            break;
                    }
                }
                weights.put(answerText, scores);
            }
            w.close();
        } catch (IOException | BiffException | IndexOutOfBoundsException e) {
            System.out.println("Error " + e.getMessage());
        }
        return weights;
    }
}
