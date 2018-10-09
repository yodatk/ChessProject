package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
import ChessGame.UI.SourceURL;
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

    public Pawn(Color pieceColor, Coordinate coordinate, King king) {
        super(pieceColor, coordinate, king);
        this.initialCoordinate = coordinate;
        this.canBeKilledFromBehind = false;
        this.hasBeenMoved = false;
        this.name = "Pawn";
    }

    public Pawn(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
        this.initialCoordinate = coordinate;
        this.canBeKilledFromBehind = false;
        this.hasBeenMoved = false;
        this.name = "Pawn";

    }

    @Override
    public void resetPiece() {
        super.resetPiece();
        this.canBeKilledFromBehind = false;
        this.hasBeenMoved = false;
    }

    @Override
    protected void setImage() {
        if(this.pieceColor == Color.WHITE){
            this.imageURL = SourceURL.LIGHT_PAWN;
        }
        else{
            this.imageURL = SourceURL.DARK_PAWN;
        }
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
    public void calculateSecondDegreeMoves(Board currentBoard) {
        this.possibleMoves = new HashSet<>();
        Coordinate next;
        if(this.pieceColor == Color.WHITE){
            next = this.coordinate.getNorth();
        }
        else{
            next = this.coordinate.getSouth();
        }
        if(next == null){
            //ToDo delete this print
            System.out.println(this);
            System.out.println("was null when this.coordinate was : "+this.coordinate);
        }
        Tile toCheck = currentBoard.getTileByCoordination(next);
        if ((toCheck!=null) &&(toCheck.getCurrentPiece() == null)) {
            //only if the tile in front of the pawn is empty
            this.possibleMoves.add(next);
        }
        if (!hasBeenMoved) {
            //Checking to see if the pawn can move the two-step move,
            //that is only possible when the pawn hasn't move yet.
            if(this.pieceColor == Color.WHITE){
                next = next.getNorth();
            }
            else{
                next = next.getSouth();
            }
            toCheck = currentBoard.getTileByCoordination(next);
            if ((toCheck.getCurrentPiece() == null)) {
                //only if the tile in front of the pawn is empty
                this.possibleMoves.add(next);
            }
        }
        checkAndAddDiagonals(currentBoard);

        checkFromBehind(currentBoard);
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        calculateSecondDegreeMoves(currentBoard);
        removeUnSafeMovesForKing(currentBoard);
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
                Coordinate toAdd;
                if(this.pieceColor == Color.WHITE){
                    toAdd = temp.getNorth();
                }
                else{
                    toAdd = temp.getSouth();
                }
                this.possibleMoves.add(toAdd);
            }
        }
    }

    private void checkAndAddDiagonals(Board currentBoard) {
        //Left Diagonal
        Coordinate temp;
        if(this.pieceColor == Color.WHITE){
            temp = this.coordinate.getNorth_west();
        }
        else{
            temp = this.coordinate.getSouth_west();
        }

        if (canKill(temp, currentBoard)) {
            this.possibleMoves.add(temp);
        }
        //Right  Diagonal
        if(this.pieceColor == Color.WHITE){
            temp = this.coordinate.getNorth_east();
        }
        else{
            temp = this.coordinate.getSouth_east();
        }

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
