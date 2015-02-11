package variables.auxs;
/**
 * @author SilverSpell187
 * @version 1.0
 * @since 2015-02-11
 */
public abstract class QuizItem {
    /**
     * Contains the unique number id of this item.
     */
    private int idNum;
    /**
     * Contains the text associated with this particular Quiz item.
     */
    private String enunciado;
    
    /**
     * Constructor.
     *
     * @param int Unique number identifier of this particular item.
     * @param String Description of the answer or question represented by this object.
     */
    public QuizItem(int id, String txt) {
        this.idNum = id;
        this.enunciado = txt;
    }
    
    /**
     * Returns the unique id associated with this item.
     *
     * @return Unique number identifier associated with this particular Quiz item.
     */
    public int getId() {
        return this.idNum;
    }
    /**
     * Returns the text associated with this particular Quiz item.
     *
     * @return Description of the answer or question represented by this object.
     */
    public String getText() {
        return this.enunciado;
    }
}