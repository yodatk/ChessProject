package ChessGame.Logic;

import ChessGame.Logic.Pieces.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GameManager {
    /**
     * Board object represent the board of the chess game and the pieces on it.
     */
    private Board gameBoard;
    /**
     * Stack of all the pieces that died in this game(for scoring and undo purposes)
     */
    private Stack<Piece> deadPieces;

    public GameManager() {
        this.gameBoard = new Board(Board.BoardMode.START_GAME);
        this.deadPieces = new Stack<>();

    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public Stack<Piece> getDeadPieces() {
        return deadPieces;
    }
}

