package ChessGame.Logic.Pieces;

import ChessGame.Logic.Column;
import ChessGame.Logic.Row;
import ChessGame.Logic.Tile;
import javafx.util.Pair;

import java.util.HashSet;


public class Bishop extends Piece {
    public Bishop(Color pieceColor, Pair<Column, Row> coordinate) {
        super(pieceColor, coordinate);
    }

    @Override
    public void calculateAllPossibleMoves(Tile[][] currentBoard) {
        //resetting the possible moves.
        this.possibleMoves = new HashSet<>();

        whileRightUp(currentBoard);
        whileLeftUp(currentBoard);
        whileRightDown(currentBoard);
        whileLeftDown(currentBoard);


    }


    private void whileLeftDown(Tile[][] currentBoard) {
        boolean canLeft_Down = true;
        //initialising the piece to the current location.
        Pair<Column, Row> next = new Pair<>(this.getCoordinate().getKey(),
                this.getCoordinate().getValue());
        while (canLeft_Down) {
            //as long as the bishop can move right & down
            next = new Pair<>(next.getKey().getPrevious(),
                    next.getValue().getPrevious());
            if ((next.getKey() == null) || (next.getValue() == null)) {
                //if the next tile is not valid.
                canLeft_Down = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                canLeft_Down = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    private void whileRightDown(Tile[][] currentBoard) {
        boolean canRight_Down = true;
        //initialising the piece to the current location.
        Pair<Column, Row> next = new Pair<>(this.getCoordinate().getKey(),
                this.getCoordinate().getValue());
        while (canRight_Down) {
            //as long as the bishop can move right & down

            next = new Pair<>(next.getKey().getNext(),
                    next.getValue().getPrevious());
            if ((next.getKey() == null) || (next.getValue() == null)) {
                //if the next tile is not valid.
                canRight_Down = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                canRight_Down = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    private void whileLeftUp(Tile[][] currentBoard) {
        boolean canLeft_Up = true;
        Pair<Column, Row> next = new Pair<>(this.getCoordinate().getKey(),
                this.getCoordinate().getValue());
        while (canLeft_Up) {
            //as long as the bishop can move left & up
            next = new Pair<>(next.getKey().getPrevious(),
                    next.getValue().getNext());
            if ((next.getKey() == null) || (next.getValue() == null)) {
                //if the next tile is not valid.
                canLeft_Up = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                canLeft_Up = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    private void whileRightUp(Tile[][] currentBoard) {
        boolean canRight_Up = true;
        Pair<Column, Row> next = new Pair<>(this.getCoordinate().getKey(),
                this.getCoordinate().getValue());
        while (canRight_Up) {
            //as long as the bishop can move right & up

            next = new Pair<>(next.getKey().getNext(),
                    next.getValue().getNext());
            if ((next.getKey() == null) || (next.getValue() == null)) {
                //if the next tile is not valid.
                canRight_Up = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                canRight_Up = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof Bishop);
    }
}
