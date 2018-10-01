package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
import javafx.util.Pair;

import java.util.HashSet;

public class Knight extends Piece {
    public Knight(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        //resetting the possibleMoves
        this.possibleMoves = new HashSet<>();
        addUp(currentBoard);
        addDown(currentBoard);
        addLeft(currentBoard);
        addRight(currentBoard);
    }

    private void addUp(Board currentBoard) {
        //checking the checking up-left
        Coordinate nextLeft = this.coordinate.getNorth_west().getNorth();
        if (nextLeft != null) {
            checkForPieces(this.possibleMoves, nextLeft, currentBoard);
        }
        //checking the up-right
        Coordinate nextRight = this.coordinate.getNorth_east().getNorth();
        if (nextLeft != null) {
            checkForPieces(this.possibleMoves, nextRight, currentBoard);
        }
    }

    private void addDown(Board currentBoard) {
        //checking the down-left
        Coordinate nextLeft = this.coordinate.getSouth_west().getSouth();
        if (nextLeft != null) {
            checkForPieces(this.possibleMoves, nextLeft, currentBoard);
        }
        //checking the down-right
        Coordinate nextRight = this.coordinate.getSouth_east().getSouth();
        if (nextRight != null) {
            checkForPieces(this.possibleMoves, nextRight, currentBoard);
        }
    }

    private void addLeft(Board currentBoard) {
        //checking the Left-Up
        Coordinate nextUp = this.coordinate.getWest().getNorth_west();
        if (nextUp != null) {
            checkForPieces(this.possibleMoves, nextUp, currentBoard);
        }
        //checking the Left-Down
        Coordinate nextDown = this.coordinate.getWest().getSouth_west();
        if (nextDown != null) {
            checkForPieces(this.possibleMoves, nextDown, currentBoard);
        }
    }

    private void addRight(Board currentBoard) {
        //checking the Right-Up
        Coordinate nextUp = this.coordinate.getEast().getNorth_east();
        if (nextUp != null) {
            checkForPieces(this.possibleMoves, nextUp, currentBoard);
        }
        //checking the Right-Down
        Coordinate nextDown = this.coordinate.getEast().getSouth_east();
        if (nextDown != null) {
            checkForPieces(this.possibleMoves, nextDown, currentBoard);
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof Knight);

    }
}
