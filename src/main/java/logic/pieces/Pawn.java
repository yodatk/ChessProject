package logic.pieces;



import UI.SourceURL;
import logic.board.Board;
import logic.board.Coordinate;

import java.util.HashSet;


/**
 * Class represent the Pawn Piece in Chess.
 * in charge of the Pawn characteristics in the game
 */
public class Pawn extends Piece {

    //region Fields
    /**
     * Boolean represent whether this pawn could be "killed from behind" like chess game(specific case)
     */
    private boolean canBeKilledFromBehind;

    /**
     * Boolean represent whether the pawn hasBeen moved in the game.
     */
    private boolean hasBeenMoved;
    //endregion Fields

    //region Constructors
    public Pawn(Color pieceColor, Coordinate coordinate, King king) {
        super(pieceColor, coordinate, king);
        this.initialCoordinate = coordinate;
        this.canBeKilledFromBehind = false;
        this.hasBeenMoved = false;
        this.name = "Pawn";
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 10;

        }
        else{
            this.pieceValue = -10;
        }
    }

    public Pawn(Pawn other){
        super(other.pieceColor,other.coordinate);
        this.initialCoordinate = other.coordinate;
        this.canBeKilledFromBehind = other.canBeKilledFromBehind;
        this.hasBeenMoved = other.hasBeenMoved;
        this.name = other.name;
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 10;

        }
        else{
            this.pieceValue = -10;
        }
    }

    public Pawn(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
        this.initialCoordinate = coordinate;
        this.canBeKilledFromBehind = false;
        this.hasBeenMoved = false;
        this.name = "Pawn";
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 10;

        }
        else{
            this.pieceValue = -10;
        }

    }

    public Pawn(Pawn other,King king){
        this(other);
        this.king = king;
    }
    //endregion Constructors

    //region Getters & Setters
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

    //endregion Getters & Setters

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



    @Override
    public void calculateSecondDegreeMoves(Board currentBoard) {
        this.possibleMoves = new HashSet<Coordinate>();
        if((this.hasBeenMoved)&&(this.canBeKilledFromBehind)){
            this.canBeKilledFromBehind = false;
        }
        Coordinate next;
        if(this.pieceColor == Color.WHITE){
            // if this is a white pawn --> goes north
            next = this.coordinate.getNorth();
        }
        else{
            // else --> this is a black pawn --> moves south
            next = this.coordinate.getSouth();
        }

        //Tile toCheck = currentBoard.getTileByCoordination(next);
        if ((currentBoard.getPieceByCoordinate(next) == null)) {
            //only if the tile in front of the pawn is empty
            this.possibleMoves.add(next);
        }
        if ((!hasBeenMoved) && (this.possibleMoves.size() != 0)){
            //Checking to see if the pawn can move the two-step move,
            //that is only possible when the pawn hasn't move yet.
            if(this.pieceColor == Color.WHITE){
                //if this pawn is white
                next = next.getNorth();
            }
            else{
                //else --> if this pawn is black
                next = next.getSouth();
            }
            //toCheck = currentBoard.getTileByCoordination(next);
            if ((next != null) && (currentBoard.getPieceByCoordinate(next) == null)) {
                //only if the tile in front of the pawn is empty
                this.possibleMoves.add(next);
            }
        }
        //checking if this pawn can move in diagonal
        checkAndAddDiagonals(currentBoard);
        //checks if this pawn can kill any pawn from behind.
        checkFromBehind(currentBoard);
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        //adds all the possible moves to the moves set.
        calculateSecondDegreeMoves(currentBoard);
        //removes all the invalid moves
        removeUnSafeMovesForKing(currentBoard);
    }

    /**
     * Checks if this pawn can kill other pawn from behind.
     * if so --> adds the coordinates as a possible move.
     * @param currentBoard Board object represent the board this Pawn is currently in.
     */
    private void checkFromBehind(Board currentBoard) {
        //checking left
        Coordinate temp = this.coordinate.getWest();
        addFromBehind(currentBoard, temp);

        //checking right
        temp = this.coordinate.getEast();
        addFromBehind(currentBoard, temp);

    }

    /**
     * Checks if a given Coordinate can considered  as a valid move according to the "killing from behind" rule.
     * if so, add it as a possible move
     * @param currentBoard Board object represent the board this Pawn is currently in.
     * @param temp Coordinate to check if it's a valid "kill from behind move"
     */
    private void addFromBehind(Board currentBoard, Coordinate temp) {
        if (temp != null) {
            //if the given coordinates is valid

            //Tile toCheck = currentBoard.getTileByCoordination(temp);
            Piece piece = currentBoard.getPieceByCoordinate(temp);
            if ((piece instanceof Pawn) && (piece.getPieceColor() != this.pieceColor)){

                //only if  there is a pawn, of a different color
                Pawn pawnToCheck = currentBoard.getThePawnThatCanBeBackStabbed();
                if(piece == pawnToCheck){
                    Coordinate toAdd;
                    if(this.pieceColor == Color.WHITE){
                        //if it's a white pawn --> go North
                        toAdd = temp.getNorth();
                    }
                    else{
                        //if it's a black pawn --> go South
                        toAdd = temp.getSouth();
                    }
                    this.possibleMoves.add(toAdd);
                }

            }
        }
    }

    /**
     * Check if this pawn can move in diagonals. if so, add the coordinates as a possible move.
     * @param currentBoard Board object represent the board this Pawn is currently in.
     */
    private void checkAndAddDiagonals(Board currentBoard) {
        //Left Diagonal
        Coordinate temp;
        if(this.pieceColor == Color.WHITE){
            //if it's a white pawn
            temp = this.coordinate.getNorth_west();
        }
        else{
            // if its a black pawn
            temp = this.coordinate.getSouth_west();
        }

        if (canKill(temp, currentBoard)) {
            this.possibleMoves.add(temp);
        }
        //Right  Diagonal
        if(this.pieceColor == Color.WHITE){
            //if it's a white pawn
            temp = this.coordinate.getNorth_east();
        }
        else{
            // if its a black pawn
            temp = this.coordinate.getSouth_east();
        }

        if (canKill(temp, currentBoard)) {
            //only if there is a piece in that coordinate, and it can be killed
            this.possibleMoves.add(temp);
        }
    }

    /**
     * Checks if this Pawn can kill whatever is in the given coordinates according to the board.
     * @param toCheck       Coordinates needs to be checked.
     * @param currentBoard  Board object represent the board this Pawn is currently in.
     * @return "true" if the pawn can kill and move to that tile, "false" otherwise.
     */
    private boolean canKill(Coordinate toCheck, Board currentBoard) {
        if (toCheck != null) {
            //Tile toTest = currentBoard.getTileByCoordination(toCheck);
            Piece toTest = currentBoard.getPieceByCoordinate(toCheck);
            //only if there is a piece there, and only if that piece is an enemy piece.
            return ((toTest != null) && (toTest.getPieceColor() != this.pieceColor));
        }
        return false;

    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof Pawn);
    }
}
