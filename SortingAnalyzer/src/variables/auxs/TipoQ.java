package variables.auxs;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection for every possible question for the PM Sorting Test.
 * @author SilverSpell187
 * @since 2015-02-11
 * @version 1.0
 */
public enum TipoQ {
    /**
     * Which of the following would you most hate people to call you?.
     */
    A (1, "Insult"),
    /**
     * Once every century, the Flutterby bush produces flowers that adapt their scent to attract the unwary. If it lured you, it would smell of:.
     */
    B (2, "Smell"),
    /**
     * Given the choice, would you rather invent a potion that would guarantee you:.
     */
    C (1, "Potion"),
    /**
     * After you have died, what would you most like people to do when they hear your name? .
     */
    D (1, "Memoriam"),
    /**
     * What kind of instrument most pleases your ear?.
     */
    E (2, "Instrument"),
    /**
     * Which of the following do you find most difficult to deal with?.
     */
    F (3, "Torment"),
    /**
     * Which of the following would you most like to study?.
     */
    G (4, "Creature"),
    /**
     * Late at night, walking alone down the street, you hear a peculiar cry that you believe to have a magical source. Do you:
     */
    H (5, "Noise"),
    /**
     * You and two friends need to cross a bridge guarded by a river troll who 
     * insists on fighting one of you before he will let all of you pass. Do you:
     */
    I (5, "Bridge"),
    /**
     * Moon or stars?.
     */
    J (6, "Heaven"),
    /**
     * Black or White?.
     */
    K (7, "Colour"),
    /**
     * Dawn or dusk?.
     */
    L (6, "Moment"),
    /**
     * Left or right?.
     */
    M (7, "Direction"),
    /**
     * Heads or tails?.
     */
    N (7, "Coin"),
    /**
     * Forest or river?.
     */
    O (6, "Place"),
    /**
     * You enter an enchanted garden. What would you be most curious to examine first?
     */
    P (2, "Garden"),
    /**
     * Four goblets are placed before you. Which would you choose to drink?
     */
    Q (2, "Drinks"),
    /**
     * Four boxes are placed before you. Which would you try and open?
     */
    R (2, "Boxes"),
    /**
     * A Muggle confronts you and says that they are sure you are a witch or wizard. Do you:
     */
    S (5, "Muggle"),
    /**
     * What are you most looking forward to learning at Hogwarts?.
     */
    T (4, "School subject"),
    /**
     * Which would you rather be?.
     */
    U (3, "Want to be"),
    /**
     * If you could have any power, which would you choose?.
     */
    V (4, "Power"),
    /**
     * One of your house mates has cheated in a Hogwarts exam by using a 
     * Self-Spelling Quill. Now he has come top of the class in Charms, beating 
     * you into second place. Professor Flitwick is suspicious of what happened. 
     * He draws you to one side after his lesson and asks you whether or not 
     * your classmate used a forbidden quill. What do you do?
     */
    W (5, "Classmate"),
    /**
     * A troll has gone berserk in the Headmaster's study at Hogwarts. It is 
     * about to smash, crush and tear several irreplaceable items and treasures, 
     * including a cure for dragon pox, which the Headmaster has nearly perfected; 
     * student records going back 1000 years and a mysterious handwritten book 
     * full of strange runes, believed to have belonged to Merlin. In which order 
     * would you rescue these objects from the troll's club, if you could? 
     */
    X (3, "Save things"),
    /**
     * Which road tempts you most?.
     */
    Y (5, "Road"),
    /**
     * Which nightmare would frighten you most?.
     */
    LL (5, "Nightmare"),
    /**
     * How would you like to be known in history?.
     */
    Z (1, "Title");
    
    private final String opcion;
    private final int order;
    
    TipoQ(int id, String o) {
        this.order = id;
        this.opcion = o;
    }
    
    /**
     * Returns a short version of the question text.
     * @return String Shortened question text.
     */
    public String getQuestionID() {
        return this.opcion;
    }
    /**
     * Returns an integer among 1-7 indicating the possition of this question
     * within the original Quiz.
     * @return int Position within the Quiz.
     */
    public int getOrder() {
        return this.order;
    }
    
    /**
     * Returns the total number of possible Answers belonging to this Question.
     * @return int Total of possible answers to this Question.
     */
    public int getAnswerNum() {
        int answerNum = 0;
        for(TipoR r : TipoR.values()) {
            if(r.getQuestionType().equals(this)) {
                answerNum += 1;
            }
        }
        return answerNum;
    }
    /**
     * Returns the complete set of possible answers to this Question object.
     * @return List<TipoR> Set of possible answers to this Question.
     * @see TipoR
     */
    public List<TipoR> getAnswers() {
        List<TipoR> answers = new ArrayList<>();
        for(TipoR r : TipoR.values()) {
            if(r.getQuestionType().equals(this)) {
                answers.add(r);
            }
        }
        return answers;
    }
}
