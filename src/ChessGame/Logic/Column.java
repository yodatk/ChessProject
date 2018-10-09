package ChessGame.Logic;

/**
 * Enum represent a column in the Chess GameManager
 */
public enum Column {

    A(0),

    B(1),

    C(2),

    D(3),

    E(4),

    F(5),

    G(6),

    H(7);

    /**
     * Int number represent the int value of the column
     */
    private final int value;

    Column(int score) {
        this.value = score;
    }

    /**
     * Returns the  int value of the column
     *
     * @return int number represent the value of the column
     */
    public int getValue() {
        return value;
    }

    public Column getNext() {
        switch (this) {
            case A:
                return B;
            case B:
                return C;
            case C:
                return D;
            case D:
                return E;
            case E:
                return F;
            case F:
                return G;
            case G:
                return H;
            case H:
                return null;
            default:
                return null;
        }
    }

    public Column getPrevious() {
        switch (this) {
            case A:
                return null;
            case B:
                return A;
            case C:
                return B;
            case D:
                return C;
            case E:
                return D;
            case F:
                return E;
            case G:
                return F;
            case H:
                return G;
            default:
                return null;
        }
    }

    public static Column getColumnByValue(int value) {
        switch (value) {
            case 0:
                return A;
            case 1:
                return B;
            case 2:
                return C;
            case 3:
                return D;
            case 4:
                return E;
            case 5:
                return F;
            case 6:
                return G;
            case 7:
                return H;
            default:
                return null;
        }
    }
}

