package variables.auxs;

/**
 * Collection for every possible answer for the PM Sorting Test.
 * @author SilverSpell187
 * @since 2015-02-11
 * @version 1.0
 */
public enum TipoR {
    //Q1
    GOOD ("The Good", TipoQ.Z),
    GREAT ("The Great", TipoQ.Z),
    WISE ("The Wise", TipoQ.Z),
    BOLD ("The Bold", TipoQ.Z),
    SELFISH ("Selfish", TipoQ.A),
    ORDINARY ("Ordinary", TipoQ.A),
    IGNORANT ("Ignorant", TipoQ.A),
    COWARD ("Cowardly", TipoQ.A),
    LOVE ("Love", TipoQ.C),
    POWER ("Power", TipoQ.C),
    WISDOM ("Wisdom", TipoQ.C),
    GLORY ("Glory", TipoQ.C),
    MISS ("Miss me and smile", TipoQ.D),
    ALIVE ("Opinion matters when alive", TipoQ.D),
    ACHIEVS ("Think of achievements", TipoQ.D),
    ADVENTURES ("Ask for more stories", TipoQ.D),
    //Q2
    HOME ("Home", TipoQ.B),
    SEA ("Sea", TipoQ.B),
    PARCHMENT ("Fresh Parchment", TipoQ.B),
    LOGFIRE ("Log Fire", TipoQ.B),
    SHELL_BOX ("Tortoiseshell squeaky box", TipoQ.R),
    MERLIN ("Merlin's rune box", TipoQ.R),
    TEMPTATION ("Ornate temptation box", TipoQ.R),
    PEWTER_BOX ("Pewter box for worthy", TipoQ.R),
    TRUMPET ("Trumpet", TipoQ.E),
    VIOLIN ("Violin", TipoQ.E),
    PIANO ("Piano", TipoQ.E),
    DRUMS ("Drums", TipoQ.E),
    CHOCOLATE ("Plums and chocolate", TipoQ.Q),
    VISIONS ("Black visions goblet", TipoQ.Q),
    SILVERY ("Silvery glittery potion", TipoQ.Q),
    GOLDEN ("Golden sunspots potion", TipoQ.Q),
    TOADSTOOLS ("Talking toadstools", TipoQ.P),
    POOL ("Luminous pool", TipoQ.P),
    TREE ("Silver tree, golden apples", TipoQ.P),
    STATUE ("Statue", TipoQ.P),
    //Q3
    CURE_BOOK ("Cure>Book>Records", TipoQ.X),
    CURE_RECORDS ("Cure>Records>Book", TipoQ.X),
    BOOK_CURE ("Book>Cure>Records", TipoQ.X),
    BOOK_RECORDS ("Book>Records>Cure", TipoQ.X),
    RECORDS_CURE ("Records>Cure>Book", TipoQ.X),
    RECORDS_BOOK ("Records>Book>Cure", TipoQ.X),
    TRUSTED ("Trusted", TipoQ.U),
    LIKED ("Liked", TipoQ.U),
    PRAISED ("Praised", TipoQ.U),
    IMITATED ("Imitated", TipoQ.U),
    ENVIED ("Envied", TipoQ.U),
    FEARED ("Feared", TipoQ.U),
    HUNGER ("Hunger", TipoQ.F),
    COLD ("Cold", TipoQ.F),
    LONELINESS ("Loneliness", TipoQ.F),
    BEING_IGNORED ("Being Ignored", TipoQ.F),
    BOREDOM ("Boredom", TipoQ.F),
    //Q4
    ALL_MAGIC ("Every area of magic", TipoQ.T),
    APARITION ("Apparition/Disapparition", TipoQ.T),
    HEXES ("Hexes and jinxes", TipoQ.T),
    CREATURES ("Magical Creatures", TipoQ.T),
    CASTLE_SECRETS ("Castle secrets", TipoQ.T),
    FLYING ("Broom Flying", TipoQ.T),
    TRANSFIGURATION ("Transfiguration", TipoQ.T),
    CHANGE_PAST ("Change the past", TipoQ.V),
    APPEARANCE ("Change appearance", TipoQ.V),
    READ_MINDS ("Read Minds", TipoQ.V),
    INVISIBILITY ("Invisibility", TipoQ.V),
    ANIMAL_TALK ("Talk to animals", TipoQ.V),
    STRENGTH ("Superstrength", TipoQ.V),
    GHOSTS ("Ghosts", TipoQ.G),
    CENTAURS ("Centaurs", TipoQ.G),
    WEREWOLVES ("Werewolves", TipoQ.G),
    MERPEOPLE ("Merpeople", TipoQ.G),
    VAMPIRES ("Vampires", TipoQ.G),
    GOBLINS ("Goblins", TipoQ.G),
    TROLLS ("Trolls", TipoQ.G),
    //Q5
    LIE ("Lie and say you don't know", TipoQ.W),
    TELL ("Tell Flitwick before the test", TipoQ.W),
    GET_POINTS ("Tell Flitwick, you'll get points", TipoQ.W),
    CONFRONT ("Tell person to tell truth or you will", TipoQ.W),
    WIDE_SUNNY ("Wide sunny grassy lane", TipoQ.Y),
    LANTERN_LIT ("Lantern-lit alley", TipoQ.Y),
    ANCIENT ("Cobbled street with ancient buildings", TipoQ.Y),
    WOODSY_PATH ("Twisting leafy woodsy path", TipoQ.Y),
    WORRIED ("Worried about mental health, call Dr.", TipoQ.S),
    JINX ("Offer them a sample of a jinx", TipoQ.S),
    WHY ("Ask what makes them think so", TipoQ.S),
    BLUFF ("Agree and walk away (bluffing)", TipoQ.S),
    CAUTION ("Proceed with caution, concealed wand", TipoQ.H),
    STAND_GROUND ("Draw wand and stand ground", TipoQ.H),
    WITHDRAW ("Withdraw and review spells", TipoQ.H),
    FIND_SOURCE ("Draw wand, find source", TipoQ.H),
    LOTS ("Draw lots", TipoQ.I),
    CHEAT ("Suggest all 3 fight (without informing troll)", TipoQ.I),
    CONFUSE ("Confuse Troll", TipoQ.I),
    VOLUNTEER ("Volunteer to fight", TipoQ.I),
    ISOLATION ("No one knows you", TipoQ.LL),
    RIDICULE ("Silly voice", TipoQ.LL),
    HEIGHTS ("Up high, no handholds", TipoQ.LL),
    EYED_KEYHOLE ("Eye at keyhole of dark", TipoQ.LL),
    //Q6
    STARS ("Stars", TipoQ.J),
    MOON ("Moon", TipoQ.J),
    RIVER ("River", TipoQ.O),
    FOREST ("Forest", TipoQ.O),
    DAWN ("Dawn", TipoQ.L),
    DUSK ("Dusk", TipoQ.L),
    //Q7
    BLACK ("Black", TipoQ.K),
    WHITE ("White", TipoQ.K),
    LEFT ("Left", TipoQ.M),
    RIGHT ("Right", TipoQ.M),
    HEADS ("Heads", TipoQ.N),
    TAILS ("Tails", TipoQ.N);
    
    private final String opcion;
    private final TipoQ question;
    
    TipoR(String o, TipoQ q) {
        this.opcion = o;
        this.question = q;
    }
    
    /**
     * Returns a short version of the answer text.
     * @return String Shortened answer text.
     */
    public String getOpcion() {
        return this.opcion;
    }
    
    /**
     * Returns the enum identifier of the Question to which this Answer belongs.
     * @return TipoQ Question to which this answer belongs.
     */
    public TipoQ getQuestionType() {
        return this.question;
    }
}
