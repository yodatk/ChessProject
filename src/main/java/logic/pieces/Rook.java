package logic.pieces;

import UI.SourceURL;
import logic.board.Board;
import logic.board.Coordinate;

import java.util.HashSet;


/**
 * Class represent the Rook Piece in Chess.
 * in charge of the Rook characteristics in the game
 */
public class Rook extends Piece {
    //region Fields

    private boolean hasBeenMoved;

    //endregion Fields

    //region Constructors
    public Rook(Color pieceColor, Coordinate coordinate, King king) {
        super(pieceColor, coordinate, king);
        this.name = "Rook";
        this.hasBeenMoved = false;
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 50;

        }
        else{
            this.pieceValue = -50;
        }
    }
    public Rook(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
        this.name = "Rook";
        this.hasBeenMoved = false;
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 50;

        }
        else{
            this.pieceValue = -50;
        }
    }
    //endregion

    //region Getters & Setters
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
        this.hasBeenMoved = false;
    }

    @Override
    protected void setImage() {
        if(this.pieceColor == Color.WHITE){
            this.imageURL = SourceURL.LIGHT_ROOK;
        }
        else{
            this.imageURL = SourceURL.DARK_ROOK;
        }
    }


    @Override
    public void calculateSecondDegreeMoves(Board currentBoard) {
        //resetting the possible moves.
        this.possibleMoves = new HashSet<Coordinate>();
        whileUp(currentBoard);
        whileDown(currentBoard);
        whileRight(currentBoard);
        whileLeft(currentBoard);
    }
    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        //adding all the possible moves for this rook.
        calculateSecondDegreeMoves(currentBoard);
        //removing all the invalid moves.
        removeUnSafeMovesForKing(currentBoard);
    }



    /**
     * Calculates all the possible moves in the Left in the current row this Rook is standing on,
     * and adds them to the possible moves set.
     * @param currentBoard Board object represent The current board this Rook is in.
     */
    private void whileLeft(Board currentBoard) {
        boolean can_Left = true;
        Coordinate next = this.coordinate;
        while (can_Left) {
            //as long as the rook can go left.
            next = next.getWest();
            if (next == null) {
                //if the next tile is not valid.
                can_Left = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Left = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }
    /**
     * Calculates all the possible moves in the Right from the current row this Rook is standing on,
     * and adds them to the possible moves set.
     * @param currentBoard Board object represent The current board this Rook is in.
     */
    private void whileRight(Board currentBoard) {
        boolean can_Right = true;
        Coordinate next = this.coordinate;
        while (can_Right) {
            //as long as the rook can go right.
            next = next.getEast();
            if (next == null) {
                //if the next tile is not valid.
                can_Right = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Right = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    /**
     * Calculates all the possible moves in Down direction from the current Column this Rook is standing on,
     * and adds them to the possible moves set.
     * @param currentBoard Board object represent The current board this Rook is in.
     */
    private void whileDown(Board currentBoard) {
        boolean can_Down = true;
        Coordinate next = this.coordinate;
        while (can_Down) {
            // as long as the rook can go down.
            next = next.getSouth();
            if (next == null) {
                //if the next tile is not valid.
                can_Down = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Down = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    /**
     * Calculates all the possible moves in Up direction from the current Column this Rook is standing on,
     * and adds them to the possible moves set.
     * @param currentBoard Board object represent The current board this Rook is in.
     */
    private void whileUp(Board currentBoard) {
        boolean can_Up = true;
        Coordinate next = this.coordinate;
        while (can_Up) {
            //as long as the rook can go up.
            next = next.getNorth();
            if (next == null) {
                //if the next tile is not valid.
                can_Up = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Up = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof Rook);
    }
}
