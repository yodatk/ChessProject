package logic.pieces;


import UI.SourceURL;
import logic.board_v1.Board;
import logic.board_v1.Coordinate;

import java.util.HashSet;

/**
 * Class represent the Bishop Piece in Chess.
 * in charge of the Bishop characteristics in the game
 */
public class Bishop extends Piece {

    //region Constructors
    public Bishop(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 30;

        }
        else{
            this.pieceValue = -30;
        }
    }
    public Bishop(Color pieceColor, Coordinate coordinate, King king) {
        super(pieceColor, coordinate, king);
        this.name = "Bishop";
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 30;

        }
        else{
            this.pieceValue = -30;
        }
    }

    public Bishop(Bishop other){
        super(other.pieceColor,other.getCoordinate());
        this.name = other.name;
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 30;
        }
        else{
            this.pieceValue = -30;
        }
    }
    public Bishop(Bishop other,King king){
        this(other);
        this.king = king;
    }
    //endregion Constructors

    @Override
    protected void setImage() {
        if(this.pieceColor == Color.WHITE){
            this.imageURL = SourceURL.LIGHT_BISHOP;
        }
        else{
            this.imageURL = SourceURL.DARK_BISHOP;
        }
    }



    @Override
    public void calculateSecondDegreeMoves(Board currentBoard) {
        //resetting the possible moves.
        this.possibleMoves = new HashSet<Coordinate>();
        whileRightUp(currentBoard);
        whileLeftUp(currentBoard);
        whileRightDown(currentBoard);
        whileLeftDown(currentBoard);
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        //adding the moves to the set.
        calculateSecondDegreeMoves(currentBoard);
        //removing the invalid moves from the set.
        removeUnSafeMovesForKing(currentBoard);
    }


    /**
     * Calculates all the possible moves in the Left-Down diagonal and adds them to the possible moves set.
     * @param currentBoard Board object represent The current board_v1 this Bishop is in.
     */
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
                //add the next move if possible, and return whether this piece can continue moving on the board_v1.
                canLeft_Down = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }
    /**
     * Calculates all the possible moves in the Right-Down diagonal and adds them to the possible moves set.
     * @param currentBoard Board object represent The current board_v1 this piece is in.
     */
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
                //add the next move if possible, and return whether this piece can continue moving on the board_v1.
                canRight_Down = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }
    /**
     * Calculates all the possible moves in the Left-Up diagonal and adds them to the possible moves set.
     * @param currentBoard Board object represent The current board_v1 this piece is in.
     */
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
                //add the next move if possible, and return whether this piece can continue moving on the board_v1.
                canLeft_Up = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }
    /**
     * Calculates all the possible moves in the Right-Up diagonal and adds them to the possible moves set.
     * @param currentBoard Board object represent The current board_v1 this piece is in.
     */
    private void whileRightUp(Board currentBoard) {
        boolean canRight_Up = true;
        Coordinate next = this.coordinate;
        while (canRight_Up) {
            //as long as the bishop can move right & up
            next = next.getNorth_east();
            if (next == null) {
                //if the next tile is not valid.
                canRight_Up = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board_v1.
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
