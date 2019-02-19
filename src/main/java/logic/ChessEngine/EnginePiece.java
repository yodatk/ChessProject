package logic.ChessEngine;

import javafx.util.Pair;
import logic.board.Board;
import logic.board.Coordinate;
import logic.board.Move;
import logic.pieces.Piece;

import java.util.concurrent.Future;

/**
 * Class to calculate the best move for a single piece on the board.
 */
public class EnginePiece implements Runnable {
    /**
     * Piece that is on the board that needs to be calculated
     */
    private Piece piece;
    /**
     * Board represents the chess board before calculations
     */
    private Board initialBoard;

    public boolean isFinished() {
        return isFinished;
    }

    /**
     * boolean to checkWhether the calculation is done or not
     */
    private boolean isFinished;

    /**
     * Integer to represent the current board value
     */
    private int currentMoveValue;

    private Pair<Coordinate, Coordinate> finalResult;

    /**
     * Default Constructor
     * @param piece                     Piece that needs to be calculated.
     * @param initialBoard              ChessBoard where the given piece is in.
     */
    public EnginePiece(Piece piece, Board initialBoard) {
        this.piece = piece;
        this.initialBoard = initialBoard;
        this.isFinished = false;
        this.finalResult = null;
        if(this.piece.getPieceColor() == Piece.Color.WHITE){
            this.currentMoveValue = Integer.MIN_VALUE;
        }
        else{
            this.currentMoveValue = Integer.MAX_VALUE;
        }
    }

    @Override
    public void run() {
        piece.calculateAllPossibleMoves(initialBoard);

        //after all calculations - mark the calculations as finished
        this.isFinished = true;
    }
}
