package ChessGame.Logic.Pieces;

import ChessGame.Logic.Column;
import ChessGame.Logic.Row;
import ChessGame.Logic.Tile;
import javafx.util.Pair;

import java.util.HashSet;

public class Pawn extends Piece{

    /**
     * boolean represent whether this pawn could be "killed from behind" like chess game(specific case)
     */
    private boolean canBeKilledFromBehind;

    /**
     * boolean represent whether the pawn hasBeen moved in the game.
     */
    private boolean hasBeenMoved;

    public Pawn(Color pieceColor, Pair<Column, Row> coordinate) {
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
    public void calculateAllPossibleMoves(Tile[][] currentBoard) {
        this.possibleMoves = new HashSet<>();
        Pair<Column, Row> next = new Pair<>(this.coordinate.getKey(), this.coordinate.getValue().getNext());
        Tile toCheck = currentBoard[next.getValue().getValue()][next.getKey().getValue()];
        if((toCheck.getCurrentPiece() == null)){
            //only if the tile in front of the pawn is empty
            this.possibleMoves.add(next);
        }
        if(!hasBeenMoved){
            //Checking to see if the pawn can move the two-step move,
            //that is only possible when the pawn hasn't move yet.
            next = new Pair<>(next.getKey(), next.getValue().getNext());
            toCheck = currentBoard[next.getValue().getValue()][next.getKey().getValue()];
            if((toCheck.getCurrentPiece() == null)){
                //only if the tile in front of the pawn is empty
                this.possibleMoves.add(next);
            }
        }
        checkAndAddDiagonals(currentBoard);

        checkFromBehind(currentBoard);


    }
    private void checkFromBehind(Tile[][] currentBoard){
        //checking left
        Pair<Column,Row> temp = new Pair<>(this.coordinate.getKey().getPrevious(),this.coordinate.getValue());
        addFromBehind(currentBoard, temp);

        //checking right
        temp = new Pair<>(this.coordinate.getKey().getNext(),this.coordinate.getValue());
        addFromBehind(currentBoard, temp);

    }

    private void addFromBehind(Tile[][] currentBoard, Pair<Column, Row> temp) {
        if((temp.getKey() != null) && ( temp.getValue() != null)){
            Tile toCheck = currentBoard[temp.getValue().getValue()][temp.getKey().getValue()];
            Piece piece = toCheck.getCurrentPiece();
            if((piece instanceof Pawn) && (piece.getPieceColor()!=this.pieceColor)&&(((Pawn) piece).canBeKilledFromBehind)){
                //only if  there is a pawn, of a different color, and he can be killed from behind
                Pair<Column,Row> toAdd = new Pair<>(temp.getKey(),temp.getValue().getNext());
                this.possibleMoves.add(toAdd);
            }
        }
    }

    private void checkAndAddDiagonals(Tile[][] currentBoard) {
        //Left Diagonal
        Pair<Column,Row> temp = new Pair<>(this.coordinate.getKey().getPrevious(),
                                            this.coordinate.getValue().getNext());
        if(canKill(temp,currentBoard)){
            this.possibleMoves.add(temp);
        }
        //Right  Diagonal
        temp = new Pair<>(this.coordinate.getKey().getNext(),
                            this.coordinate.getValue().getNext());
        if(canKill(temp, currentBoard)){
            this.possibleMoves.add(temp);
        }
    }

    private boolean canKill(Pair<Column,Row> toCheck, Tile[][] currentBoard){
        if((toCheck.getKey()!=null)&&(toCheck.getValue()!=null)){
            Tile toTest = currentBoard[toCheck.getValue().getValue()][toCheck.getKey().getValue()];
            //only if there is a piece there, and only if
            return((toTest.getCurrentPiece() != null)&&(toTest.getCurrentPiece().getPieceColor()!=this.pieceColor));
        }
        return false;

    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof Pawn);
    }
}
