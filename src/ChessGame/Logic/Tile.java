package ChessGame.Logic;

import ChessGame.Logic.Pieces.Piece;

/**
 * Represent a tile in a Chess board.
 */
public class Tile {
    /**
     * The coordinate of this tile on the chess board(H8, E5 and so on...)
     */
    private Coordinate coordinate;
    /**
     * The current chess piece on this tile. if there is no piece, this field will be 'null'
     */
    private Piece currentPiece;

    public Tile(Coordinate coordinate, Piece currentPiece) {
        this.coordinate = coordinate;
        this.currentPiece = currentPiece;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tile)) {
            return false;
        } else {
            Tile other = (Tile) obj;
            boolean sameCoordinates = this.coordinate.equals(other.getCoordinate());
            boolean samePiece;
            if (this.getCurrentPiece() == null) {
                samePiece = other.currentPiece == null;
            } else {
                samePiece = this.currentPiece.equals(other.getCurrentPiece());
            }
            return sameCoordinates & samePiece;

        }
    }
}
