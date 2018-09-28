package ChessGame.Logic;

/**
 * Enum represent a row in the Chess Board
 */
public enum Row {
    ONE(1),

    TWO(2),

    THREE(3),

    FOUR(4),

    FIVE(5),

    SIX(6),

    SEVEN(7),

    EIGHT(8);

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
}
