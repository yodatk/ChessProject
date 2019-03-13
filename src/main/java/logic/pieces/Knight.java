package logic.pieces;


import UI.SourceURL;
import logic.board_v1.Board;
import logic.board_v1.Coordinate;

import java.util.HashSet;

/**
 * Class represent the Knight Piece in Chess.
 * in charge of the Knight characteristics in the game
 */
public class Knight extends Piece {

    //region Constructors
    public Knight(Color pieceColor, Coordinate coordinate, King king) {
        super(pieceColor, coordinate, king);
        this.name = "Knight";
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 30;

        }
        else{
            this.pieceValue = -30;
        }
    }
    public Knight(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
        this.name = "Knight";
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 30;

        }
        else{
            this.pieceValue = -30;
        }
    }

    public Knight(Knight other){
        super(other.pieceColor,other.coordinate);
        this.name = other.name;
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 30;

        }
        else{
            this.pieceValue = -30;
        }
    }

    public Knight(Knight other,King king){
        this(other);
        this.king = king;
    }
    //endregion Constructors


    @Override
    protected void setImage() {
        if(this.pieceColor == Color.WHITE){
            this.imageURL = SourceURL.LIGHT_KNIGHT;
        }
        else{
            this.imageURL = SourceURL.DARK_KNIGHT;
        }
    }


    @Override
    public void calculateSecondDegreeMoves(Board currentBoard) {
        //resetting the possibleMoves
        this.possibleMoves = new HashSet<Coordinate>();
        addUp(currentBoard);
        addDown(currentBoard);
        addLeft(currentBoard);
        addRight(currentBoard);
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        //adds all possible moves.
        calculateSecondDegreeMoves(currentBoard);
        //remove invalid moves
        removeUnSafeMovesForKing(currentBoard);

    }

    /**
     * Adds all the possible moves for this Knight that are North from it's current Position on the board_v1.
     * @param currentBoard Board object represent the current board_v1 this Knight is on.
     */
    private void addUp(Board currentBoard) {
        //checking the checking up-left
        Coordinate nextLeft = this.coordinate.getNorth_west();
        if (nextLeft != null) {
            //if north-west is  valid tile
            nextLeft = nextLeft.getNorth();
            if (nextLeft != null) {
                //if another north is a valid tile.
                checkForPieces(this.possibleMoves, nextLeft, currentBoard);
            }
        }
        //checking the up-right
        Coordinate nextRight = this.coordinate.getNorth_east();
        if (nextRight != null) {
            //if north-east is a valid tile
            nextRight = nextRight.getNorth();
            if (nextRight != null) {
                //if another north is a valid tile
                checkForPieces(this.possibleMoves, nextRight, currentBoard);
            }
        }
    }
    /**
     * Adds all the possible moves for this Knight that are South from it's current Position on the board_v1.
     * @param currentBoard Board object represent the current board_v1 this Knight is on.
     */
    private void addDown(Board currentBoard) {
        //checking the down-left
        Coordinate nextLeft = this.coordinate.getSouth_west();
        if (nextLeft != null) {
            //if south-west is a valid tile
            nextLeft = nextLeft.getSouth();
            if (nextLeft != null) {
                //if another south is a valid tile
                checkForPieces(this.possibleMoves, nextLeft, currentBoard);
            }
        }

        //checking the down-right
        Coordinate nextRight = this.coordinate.getSouth_east();
        if (nextRight != null) {
            //if south east is a valid tile
            nextRight = nextRight.getSouth();
            if (nextRight != null) {
                //if another south is a valid tile
                checkForPieces(this.possibleMoves, nextRight, currentBoard);
            }
        }
    }
    /**
     * Adds all the possible moves for this Knight that are West from it's current Position on the board_v1.
     * @param currentBoard Board object represent the current board_v1 this Knight is on.
     */
    private void addLeft(Board currentBoard) {
        //checking the Left-Up
        Coordinate nextUp = this.coordinate.getWest();
        if (nextUp != null) {
            //if west is a valid tile
            nextUp = nextUp.getNorth_west();
            if (nextUp != null) {
                //if another north-west is a valid tile
                checkForPieces(this.possibleMoves, nextUp, currentBoard);
            }
        }
        //checking the Left-Down
        Coordinate nextDown = this.coordinate.getWest();
        if (nextDown != null) {
            //if west is a valid tile
            nextDown = nextDown.getSouth_west();
            if (nextDown != null) {
                //if another south west is a valid tile
                checkForPieces(this.possibleMoves, nextDown, currentBoard);
            }
        }
    }
    /**
     * Adds all the possible moves for this Knight that are East from it's current Position on the board_v1.
     * @param currentBoard Board object represent the current board_v1 this Knight is on.
     */
    private void addRight(Board currentBoard) {
        //checking the Right-Up
        Coordinate nextUp = this.coordinate.getEast();
        if (nextUp != null) {
            //if east is a valid tile.
            nextUp = nextUp.getNorth_east();
            if (nextUp != null) {
                //if another north-east is a valid tile.
                checkForPieces(this.possibleMoves, nextUp, currentBoard);
            }
        }
        //checking the Right-Down
        Coordinate nextDown = this.coordinate.getEast();
        if (nextDown != null) {
            //if east is a valid tile
            nextDown = nextDown.getSouth_east();
            if (nextDown != null) {
                //if another south east is a valid tile
                checkForPieces(this.possibleMoves, nextDown, currentBoard);
            }
        }

    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof Knight);

    }
}
