package ChessGame.Logic.Pieces;

import ChessGame.Logic.Column;
import ChessGame.Logic.Row;
import ChessGame.Logic.Tile;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece{
    public Rook(Color pieceColor, Pair<Column, Row> coordinate) {
        super(pieceColor, coordinate);
    }

    @Override
    public void calculateAllPossibleMoves(Tile[][] currentBoard) {
        //resetting the possible moves.
        this.possibleMoves = new HashSet<>();

        whileUp(currentBoard);
        whileDown(currentBoard);
        whileRight(currentBoard);
        whileLeft(currentBoard);

    }

    private void whileLeft(Tile[][] currentBoard) {
        boolean can_Left = true;
        Pair<Column,Row> next = new Pair<>(this.getCoordinate().getKey(),
                this.getCoordinate().getValue());
        while(can_Left){
            //as long as the rook can go left.
            next = new Pair<>(next.getKey().getPrevious(), next.getValue());
            if(next.getKey() == null){
                //if the next tile is not valid.
                can_Left = false;
            }
            else{
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Left = checkForPieces(this.possibleMoves,next,currentBoard);
            }
        }
    }

    private void whileRight(Tile[][] currentBoard) {
        boolean can_Right = true;
        Pair<Column,Row> next = new Pair<>(this.getCoordinate().getKey(),
                this.getCoordinate().getValue());
        while(can_Right){
            //as long as the rook can go right.
            next = new Pair<>(next.getKey().getNext(),next.getValue());
            if(next.getKey() == null){
                //if the next tile is not valid.
                can_Right = false;
            }
            else{
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Right= checkForPieces(this.possibleMoves,next,currentBoard);
            }
        }
    }

    private void whileDown(Tile[][] currentBoard) {
        boolean can_Down = true;
        Pair<Column,Row> next = new Pair<>(this.getCoordinate().getKey(),
                this.getCoordinate().getValue());
        while(can_Down){
            // as long as the rook can go down.
            next = new Pair<>(next.getKey(), next.getValue().getPrevious());
            if(next.getValue() == null){
                //if the next tile is not valid.
                can_Down = false;
            }
            else{
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Down= checkForPieces(this.possibleMoves,next,currentBoard);
            }
        }
    }

    private void whileUp(Tile[][] currentBoard) {
        boolean can_Up = true;
        Pair<Column,Row> next = new Pair<>(this.getCoordinate().getKey(),
                this.getCoordinate().getValue().getNext());
        while(can_Up){
            //as long as the rook can go up.
            next = new Pair<>(next.getKey(), next.getValue().getNext());
            if(next.getValue() == null){
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
