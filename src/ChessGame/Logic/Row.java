package ChessGame.Logic;

/**
 * Enum represent a row in the Chess GameManager
 *
 */
public enum Row {
    ONE(7),

    TWO(6),

    THREE(5),

    FOUR(4),

    FIVE(3),

    SIX(2),

    SEVEN(1),

    EIGHT(0);

    /**
     * Int number represent the int value of the row
     */
    private final int value;

    Row(int score){
        this.value = score;
    }

    /**
     * Returns the  int value of the row
     * @return int number represent the value of the row
     */
    public int getValue(){
        return value;
    }

    public Row getNext(){
        switch (this) {
            case ONE:
                return TWO;
            case TWO:
                return THREE;
            case THREE:
                return FOUR;
            case FOUR:
                return FIVE;
            case FIVE:
                return SIX;
            case SIX:
                return SEVEN;
            case SEVEN:
                return EIGHT;
            case EIGHT:
                return null;
            default:
                return null;
        }
    }
    public Row getPrevious(){
        switch (this) {
            case ONE:
                return null;
            case TWO:
                return ONE;
            case THREE:
                return TWO;
            case FOUR:
                return THREE;
            case FIVE:
                return FOUR;
            case SIX:
                return FIVE;
            case SEVEN:
                return SIX;
            case EIGHT:
                return SEVEN;
            default:
                return null;
        }
    }
}
