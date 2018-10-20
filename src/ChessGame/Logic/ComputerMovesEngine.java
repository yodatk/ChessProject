package ChessGame.Logic;

import ChessGame.Logic.Pieces.Piece;
import javafx.util.Pair;

import java.util.*;

/**
 * Chess engine Which will calculate moves and act them on the board when the user want to play versus the computer.
 */
public class ComputerMovesEngine {

    /**
     * The computer calculates the best move for the given color pieces, on the given board and returned it.
     * @param currentBoard  Board of the current chess game.
     * @return Pair of Coordinates:
     *          - The first coordinate is the coordinate of the piece that should move.
     *          - The second coordinate is the coordinate of the chosen piece new location.
     */
    public static  Pair<Coordinate,Coordinate> generateMove(Piece.Color computerColor, Board currentBoard ){
        Set<Piece> piecesToCheck;
        List<Pair<Coordinate,Coordinate>> allPossibleMoves = new ArrayList<>();
        calculateAllMoves(computerColor, currentBoard, allPossibleMoves);

        return ChooseBestMove(computerColor,allPossibleMoves, currentBoard);
    }

    /**
     * the method gets a List of possible moves to make, and returned the best move it finds.
     * @param allPossibleMoves List of all the possible moves that that the computer can do at the moment in the given board.
     * @return
     */
    private static  Pair<Coordinate, Coordinate> ChooseBestMove(Piece.Color computerColor, List<Pair<Coordinate, Coordinate>> allPossibleMoves, Board currentBoard) {
        //currently, the computer plays randomly.
        int indexOfNextMove = new Random().nextInt(allPossibleMoves.size());
        return allPossibleMoves.get(indexOfNextMove);
    }

    /**
     * Calculates all the possible moves of the given color on the given chess board, and adds them to the given list.
     * @param computerColor         Color of the computer at the moment
     * @param currentBoard          Board represent the current chess board
     * @param allPossibleMoves      List to add all the possible moves to.
     */
    private static void calculateAllMoves(Piece.Color computerColor, Board currentBoard, List<Pair<Coordinate, Coordinate>> allPossibleMoves) {
        Set<Piece> piecesToCheck;
        //getting the matching pieces set from the board.
        if(computerColor == Piece.Color.BLACK){
            piecesToCheck = currentBoard.getBlacksPieces();
        }
        else{
            piecesToCheck = currentBoard.getWhitesPieces();
        }


        for(Piece piece : piecesToCheck){
            //for each piece, gets it's initial coordinate.
            Coordinate currentPiecePosition = piece.getCoordinate();
            //adding all the possible moves of this piece.
            for(Coordinate pieceTargetLocation : piece.getPossibleMoves()){
                // add a possible move for the computer
                allPossibleMoves.add(new Pair<>(currentPiecePosition, pieceTargetLocation));
            }
        }
    }

    /**
     * This Function is used to calculate the best move for the computer.
     *  it calculate the value of the pieces on the board :
     * @param currentValue
     * @return
     */
    private static int calculateBoardValue(Piece.Color computerColor, Board currentBoard){
        int whiteValue=0, blackValue = 0;
        for(Piece whitePiece : currentBoard.getWhitesPieces()){
            whiteValue += whitePiece.getPieceValue();
        }
        for(Piece blackPiece : currentBoard.getBlacksPieces()){
            blackValue += blackPiece.getPieceValue();
        }
        if(computerColor == Piece.Color.WHITE){
            return whiteValue-blackValue;
        }
        else{
            return blackValue-whiteValue;
        }
    }

}
