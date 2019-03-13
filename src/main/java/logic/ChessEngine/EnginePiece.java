package logic.ChessEngine;

import javafx.util.Pair;
import logic.board_v1.Board;
import logic.board_v1.Coordinate;
import logic.pieces.Piece;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * Class to calculate the best move for a single piece on the board_v1.
 */
public class EnginePiece implements Runnable {
    /**
     * Piece that is on the board_v1 that needs to be calculated
     */
    private Piece piece;
    /**
     * Board represents the chess board_v1 before calculations
     */
    private Board initialBoard;

    /**
     * Integer represent the total value of the pieces on the board_v1.
     */
    private volatile int currentMoveValue;

    /**
     * boolean to checkWhether the calculation is done or not
     */
    private volatile boolean isFinished;

    public boolean isFinished() {
        return isFinished;
    }




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

    }

    public int getCurrentMoveValue() {
        return currentMoveValue;
    }

    public Pair<Coordinate, Coordinate> getFinalResult() {
        return finalResult;
    }

    @Override
    public synchronized void run() {


        Vector<Pair<Coordinate, Coordinate>> initialPossibleMoves = new Vector<>();
        Set<Pair<Pair<Coordinate, Coordinate>,Integer>> movesWithValues = new HashSet<>();
        //creating moves for this piece
        for(Coordinate move: this.piece.getPossibleMoves()){
            Pair<Coordinate,Coordinate> possibleMove = new Pair<>(this.piece.getCoordinate(),move);
            initialPossibleMoves.add(possibleMove);
        }

        //calculating for each move it's best possible value
        for(Pair<Coordinate,Coordinate> move : initialPossibleMoves){
            Set<Pair<Coordinate,Coordinate>> currentMoveToCheck = new HashSet<>();
            currentMoveToCheck.add(move);
           int currentValue =  this.calculateBestMove(3,this.piece.getPieceColor(),this.initialBoard,currentMoveToCheck);
           movesWithValues.add(new Pair<>(move,currentValue));
        }
        this.finalResult = null;
        //choosing the the move with the best value
        if(this.piece.getPieceColor() == Piece.Color.WHITE){
            this.currentMoveValue = Integer.MIN_VALUE;
            for(Pair<Pair<Coordinate, Coordinate>,Integer> current : movesWithValues){
                if(current.getValue() > this.currentMoveValue){
                    this.finalResult = current.getKey();
                    this.currentMoveValue = current.getValue();
                }
            }
        }
        else{
            this.currentMoveValue = Integer.MAX_VALUE;
            for(Pair<Pair<Coordinate, Coordinate>,Integer> current : movesWithValues){
                if(current.getValue() < this.currentMoveValue){
                    this.finalResult = current.getKey();
                    this.currentMoveValue = current.getValue();
                }
            }
        }
        //after all calculations - mark the calculations as finished
        this.isFinished = true;
    }

    public int calculateBestMove(int depth,Piece.Color currentPlayerColor, Board currentBoard, Collection<Pair<Coordinate, Coordinate>> possibleMoves){
        if(depth == 0){
            return ComputerMovesEngine.calculateBoardValue(this.initialBoard);
        }
        else{
            if(currentPlayerColor == Piece.Color.WHITE){
                //looking for max Value
                int bestMoveValue = Integer.MIN_VALUE;
                for(Pair<Coordinate, Coordinate> move : possibleMoves){
                    currentBoard.movePieceToNewLocation(move.getKey(),move.getValue(),this.initialBoard.getPieceByCoordinate(move.getKey()));
                    Set<Pair<Coordinate,Coordinate>> newPossibleMove =  currentBoard.reCalculateMoves(currentBoard.getBlacksPieces());
                    bestMoveValue = Math.max(bestMoveValue,calculateBestMove(depth-1,Piece.Color.BLACK,this.initialBoard,newPossibleMove));
                    currentBoard.undoMove();
                }
                return bestMoveValue;
            }
            else{
                //looking for min Value
                int bestMoveValue = Integer.MAX_VALUE;
                for(Pair<Coordinate, Coordinate> move : possibleMoves){
                    currentBoard.movePieceToNewLocation(move.getKey(),move.getValue(),this.initialBoard.getPieceByCoordinate(move.getKey()));
                    Set<Pair<Coordinate,Coordinate>> newPossibleMove =  currentBoard.reCalculateMoves(currentBoard.getBlacksPieces());
                    bestMoveValue = Math.min(bestMoveValue,calculateBestMove(depth-1,Piece.Color.WHITE,this.initialBoard,newPossibleMove));
                    currentBoard.undoMove();
                }
                return bestMoveValue;
            }
        }
    }
}
