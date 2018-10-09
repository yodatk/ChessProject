package ChessGame.Logic;

public enum GameMod {
    /**
     * Returned when Black is CheckMated
     */
    WHITE_WON,
    /**
     * Returned when White is CheckMated
     */
    BLACK_WON,
    /**
     * Returned when White king is in check
     */
    WHITE_IS_CHECKED,
    /**
     * Returned when Black king is in Check
     */
    BLACK_IS_CHECKED,
    /**
     * Returned when none of the kings are in threat
     */
    MID_GAME,
    /**
     * Returned when there was a problem with the move request.
     */
    ERROR
}
