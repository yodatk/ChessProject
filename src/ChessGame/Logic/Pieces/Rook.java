package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
import javafx.util.Pair;

import java.util.HashSet;

public class Rook extends Piece{
    public Rook(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        //resetting the possible moves.
        this.possibleMoves = new HashSet<>();

        whileUp(currentBoard);
        whileDown(currentBoard);
        whileRight(currentBoard);
        whileLeft(currentBoard);

    }

    private void whileLeft(Board currentBoard) {
        boolean can_Left = true;
        Coordinate next = this.coordinate;
        while(can_Left){
            //as long as the rook can go left.
            next = next.getWest();
            if(next == null){
                //if the next tile is not valid.
                can_Left = false;
            }
            else{
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Left = checkForPieces(this.possibleMoves,next,currentBoard);
            }
        }
    }

    private void whileRight(Board currentBoard) {
        boolean can_Right = true;
        Coordinate next = this.coordinate;
        while(can_Right){
            //as long as the rook can go right.
            next = next.getEast();
            if(next == null){
                //if the next tile is not valid.
                can_Right = false;
            }
            else{
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Right= checkForPieces(this.possibleMoves,next,currentBoard);
            }
        }
    }

    private void whileDown(Board currentBoard) {
        boolean can_Down = true;
        Coordinate next = this.coordinate;
        while(can_Down){
            // as long as the rook can go down.
            next = next.getSouth();
            if(next == null){
                //if the next tile is not valid.
                can_Down = false;
            }
            else{
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Down= checkForPieces(this.possibleMoves,next,currentBoard);
            }
        }
    }

    private void whileUp(Board currentBoard) {
        boolean can_Up = true;
        Coordinate next = this.coordinate;
        while(can_Up){
            //as long as the rook can go up.
            next = next.getNorth();
            if(next == null){
                //if the next tile is not valid.
                can_Up = false;
            }
            else{
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Up= checkForPieces(this.possibleMoves,next,currentBoard);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof Rook);
    }
}
