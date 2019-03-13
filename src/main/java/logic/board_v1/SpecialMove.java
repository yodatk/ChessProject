package logic.board_v1;


public enum SpecialMove {
    /**
     * When just a normal move is made
     */
    NORMAL_MOVE,
    /**
     * When a pawn is promoting (reach the end of the board_v1)
     */
    PAWN_PROMOTING,
    /**
     * When white is doing small castling
     */
    WHITE_SMALL_CASTLING,
    /**
     * When white is doing big castling
     */
    WHITE_BIG_CASTLING,
    /**
     * When black is doing small castling
     */
    BLACK_SMALL_CASTLING,
    /**
     * When black is doing big castling
     */
    BLACK_BIG_CASTLING,
    /**
     * When a pawn is killing another pawn from behind
     */
    KILLING_FROM_BEHIND,
    /**
     * When the requested move is illegal
     */
    INVALID_MOVE

}
