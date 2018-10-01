package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
import javafx.util.Pair;

import java.util.HashSet;

public class Pawn extends Piece {

    /**
     * boolean represent whether this pawn could be "killed from behind" like chess game(specific case)
     */
    private boolean canBeKilledFromBehind;

    /**
     * boolean represent whether the pawn hasBeen moved in the game.
     */
    private boolean hasBeenMoved;

    public Pawn(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
        this.canBeKilledFromBehind = false;
        this.hasBeenMoved = false;
    }

    public boolean isCanBeKilledFromBehind() {
        return canBeKilledFromBehind;
    }

    public void setCanBeKilledFromBehind(boolean canBeKilledFromBehind) {
        this.canBeKilledFromBehind = canBeKilledFromBehind;
    }

    public boolean isHasBeenMoved() {
        return hasBeenMoved;
    }

    public void setHasBeenMoved(boolean hasBeenMoved) {
        this.hasBeenMoved = hasBeenMoved;
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        this.possibleMoves = new HashSet<>();
        Coordinate next = this.coordinate.getNorth();
        Tile toCheck = currentBoard.getTileByCoordination(next);
        if ((toCheck.getCurrentPiece() == null)) {
            //only if the tile in front of the pawn is empty
            this.possibleMoves.add(next);
        }
        if (!hasBeenMoved) {
            //Checking to see if the pawn can move the two-step move,
            //that is only possible when the pawn hasn't move yet.
            next = next.getNorth();
            toCheck = currentBoard.getTileByCoordination(next);
            if ((toCheck.getCurrentPiece() == null)) {
                //only if the tile in front of the pawn is empty
                this.possibleMoves.add(next);
            }
        }
        checkAndAddDiagonals(currentBoard);

        checkFromBehind(currentBoard);


    }

    private void checkFromBehind(Board currentBoard) {
        //checking left
        Coordinate temp = this.coordinate.getWest();
        addFromBehind(currentBoard, temp);

        //checking right
        temp = this.coordinate.getEast();
        addFromBehind(currentBoard, temp);

    }

    private void addFromBehind(Board currentBoard, Coordinate temp) {
        if (temp != null) {
            Tile toCheck = currentBoard.getTileByCoordination(temp);
            Piece piece = toCheck.getCurrentPiece();
            if ((piece instanceof Pawn) && (piece.getPieceColor() != this.pieceColor) && (((Pawn) piece).canBeKilledFromBehind)) {
                //only if  there is a pawn, of a different color, and he can be killed from behind
                Coordinate toAdd = temp.getNorth();
                this.possibleMoves.add(toAdd);
            }
        }
    }

    private void checkAndAddDiagonals(Board currentBoard) {
        //Left Diagonal
        Coordinate temp = this.coordinate.getNorth_west();
        if (canKill(temp, currentBoard)) {
            this.possibleMoves.add(temp);
        }
        //Right  Diagonal
        temp = this.coordinate.getNorth_east();
        if (canKill(temp, currentBoard)) {
            this.possibleMoves.add(temp);
        }
    }

    private boolean canKill(Coordinate toCheck, Board currentBoard) {
        if (toCheck != null) {
            Tile toTest = currentBoard.getTileByCoordination(toCheck);
            //only if there is a piece there, and only if
            return ((toTest.getCurrentPiece() != null) && (toTest.getCurrentPiece().getPieceColor() != this.pieceColor));
        }
        return false;

    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof Pawn);
    }
}
