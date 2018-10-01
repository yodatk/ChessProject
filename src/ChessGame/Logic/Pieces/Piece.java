package ChessGame.Logic.Pieces;


import ChessGame.Logic.*;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * abstract class describes a general chess piece
 */
public abstract class Piece {
    public enum Color{
        BLACK, WHITE;
    }


    protected Color pieceColor;
    protected Coordinate coordinate;
    protected Set<Coordinate> possibleMoves;

    public Color getPieceColor() {
        return pieceColor;
    }

    public Piece(Color pieceColor, Coordinate coordinate) {
        this.pieceColor = pieceColor;
        this.coordinate = coordinate;
        this.possibleMoves = new HashSet<>();

    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Set<Coordinate> getPossibleMoves() {
        return possibleMoves;
    }

    /**
     * After a piece moves on the board, will calculate the new possible moves for this piece.
     */
    public abstract void calculateAllPossibleMoves(Board currentBoard);

    protected boolean checkForPieces(Set<Coordinate> possibleMoves, Coordinate toCheck,
                                     Board currentBoard){
        Tile nextTile = currentBoard.getTileByCoordination(toCheck);
        Piece theOtherPiece = nextTile.getCurrentPiece();
        if(theOtherPiece != null){
            //if there is a piece in the next tile
            if(this.getPieceColor() != theOtherPiece.getPieceColor()){
                //if the found piece is the opponent piece --> add it to the possible moves
                possibleMoves.add(toCheck);
            }
            //return false, since the piece can't move pass the piece.
            return false;
        }
        else{
            //if the next tile is valid, with no pieces -->
            //      will add the piece and return true;
            possibleMoves.add(toCheck);
            return true;
        }
    }


    @Override
    /**
     *  - if obj is not instance of Piece --> return false.
     *  - piece will be equal to another piece only if both pieces are in the same coordinates, and with same color.
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Piece)){
            return false;
        }
        else{
            Piece other = (Piece)obj;
            boolean sameColor = other.pieceColor == this.pieceColor;
            boolean sameCoordinates = other.coordinate.equals(this.coordinate);
            return sameColor & sameCoordinates;
        }
    }
}
