package ChessGame.Logic.Pieces;


import ChessGame.Logic.Column;
import ChessGame.Logic.Row;
import ChessGame.Logic.Tile;
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
    protected Pair<Column, Row> coordinate;
    protected Set<Pair<Column, Row>> possibleMoves;

    public Color getPieceColor() {
        return pieceColor;
    }

    public Piece(Color pieceColor, Pair<Column, Row> coordinate) {
        this.pieceColor = pieceColor;
        this.coordinate = coordinate;
        this.possibleMoves = new HashSet<>();

    }

    public Pair<Column, Row> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Pair<Column, Row> coordinate) {
        this.coordinate = coordinate;
    }

    public Set<Pair<Column, Row>> getPossibleMoves() {
        return possibleMoves;
    }

    /**
     * Will after a piece moves on the board, will calculate the new possible moves for this piece.
     */
    public abstract void calculateAllPossibleMoves(Tile[][] currentBoard);

    protected boolean checkForPieces(Set<Pair<Column,Row>> possibleMoves, Pair<Column,Row> toCheck,
                                     Tile[][] currentBoard){
        Tile nextTile = currentBoard[toCheck.getValue().getValue()][toCheck.getKey().getValue()];
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
