package logic.board_v1;

public enum BoardPiece {
    WHITE_PAWN(10),
    WHITE_KNIGHT(30),
    WHITE_BISHOP(30),
    WHITE_ROOK(50),
    WHITE_QUEEN(90),
    WHITE_KING(999),
    BLACK_PAWN(-10),
    BLACK_KNIGHT(-30),
    BLACK_BISHOP(-30),
    BLACK_ROOK(-50),
    BLACK_QUEEN(-90),
    BLACK_KING(-999),
    NO_PIECE(0);

    private  final int value;
    BoardPiece(int value){this.value = value;}

    public int getValue() {
        return value;
    }
}
