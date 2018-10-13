package ChessGame.Logic;

/**
 * Enum represent a row in the Chess GameManager
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

    Row(int score) {
        this.value = score;
    }

    /**
     * Returns the  int value of the row
     *
     * @return int number represent the value of the row
     */
    public int getValue() {
        return value;
    }

    /**
     * Return the next row in order
     * @return Row object represent the row that is north of this one. if there is no another row, return null.
     */
    public Row getNext() {
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
    /**
     * Return the previous row in order
     * @return Row object represent the row that is south of this one. if there is no another row, return null.
     */
    public Row getPrevious() {
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

    /**
     * returns a Row according to the given value.
     * @param value int number represent the index of the wanted Row.
     * @return  Row Object that matches the given value. if there is no matching value, returns null.
     */
    public static Row getRowByValue(int value){
        switch (value) {
            case 7:
                return ONE;
            case 6:
                return TWO;
            case 5:
                return THREE;
            case 4:
                return FOUR;
            case 3:
                return FIVE;
            case 2:
                return SIX;
            case 1:
                return SEVEN;
            case 0:
                return EIGHT;
            default:
                return null;
        }
    }

    /**
     * Returns a String representation of the Row
     * @return String of the number this row Represent
     */
    @Override
    public String toString() {
        switch (this) {
            case ONE:
                return "1";
            case TWO:
                return "2";
            case THREE:
                return "3";
            case FOUR:
                return "4";
            case FIVE:
                return "5";
            case SIX:
                return "6";
            case SEVEN:
                return "7";
            case EIGHT:
                return "8";
            default:
                return "";
        }
    }
}
