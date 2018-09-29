package ChessGame.Logic;

import ChessGame.Logic.Pieces.Piece;
import javafx.util.Pair;

/**
 * Represent a tile in a Chess board.
 */
public class Tile {
    /**
     * The coordinate of this tile on the chess board(H8, E5 and so on...)
     */
    private Pair<Column,Row> coordinate;
    /**
     * The current chess piece on this tile. if there is no piece, this field will be 'null'
     */
    private Piece currentPiece;

    public Tile(Pair<Column, Row> coordinate, Piece currentPiece) {
        this.coordinate = coordinate;
        this.currentPiece = currentPiece;
    }

    public Pair<Column, Row> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Pair<Column, Row> coordinate) {
        this.coordinate = coordinate;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }


}
