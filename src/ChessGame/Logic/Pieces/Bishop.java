package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
import javafx.util.Pair;

import java.util.HashSet;


public class Bishop extends Piece {
    public Bishop(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        //resetting the possible moves.
        this.possibleMoves = new HashSet<>();

        whileRightUp(currentBoard);
        whileLeftUp(currentBoard);
        whileRightDown(currentBoard);
        whileLeftDown(currentBoard);


    }


    private void whileLeftDown(Board currentBoard) {
        boolean canLeft_Down = true;
        //initialising the piece to the current location.
        Coordinate next = this.coordinate;
        while (canLeft_Down) {
            //as long as the bishop can move right & down
            next = next.getSouth_west();
            if (next == null) {
                //if the next tile is not valid.
                canLeft_Down = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                canLeft_Down = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    private void whileRightDown(Board currentBoard) {
        boolean canRight_Down = true;
        //initialising the piece to the current location.
        Coordinate next = this.coordinate;
        while (canRight_Down) {
            //as long as the bishop can move right & down

            next = next.getSouth_east();
            if (next == null) {
                //if the next tile is not valid.
                canRight_Down = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                canRight_Down = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    private void whileLeftUp(Board currentBoard) {
        boolean canLeft_Up = true;
        Coordinate next = this.coordinate;
        while (canLeft_Up) {
            //as long as the bishop can move left & up
            next = next.getNorth_west();
            if (next == null) {
                //if the next tile is not valid.
                canLeft_Up = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                canLeft_Up = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    private void whileRightUp(Board currentBoard) {
        boolean canRight_Up = true;
        Coordinate next = this.coordinate;
        while (canRight_Up) {
            //as long as the bishop can move right & up
            next = coordinate.getNorth_east();
            if (next == null) {
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
