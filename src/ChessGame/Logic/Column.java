package ChessGame.Logic;

/**
 * Enum represent a column in the Chess Board
 */
public enum Column {

    A(1),

    B(2),

    C(3),

    D(4),

    E(5),

    F(6),

    G(7),

    H(8);

    /**
     * Int number represent the int value of the column
     */
    private final int value;

    Column(int score){
        this.value = score;
    }
    /**
     * Returns the  int value of the column
     * @return int number represent the value of the column
     */
    public int getValue(){
        return value;
    }
}

