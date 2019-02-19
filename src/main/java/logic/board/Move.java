package logic.board;

import logic.pieces.Piece;

/**
 * Class represent a single chess move.
 */
public class Move {
    //region Fields
    /**
     * Piece that made this move
     */
    private Piece piece;

    /**
     * Coordinate represent where the piece was before the move
     */
    private Coordinate fromTile;

    /**
     * Coordinate represent where the piece is going to be after this move
     */
    private Coordinate targetTile;

    /**
     * The piece that was int the target
     */
    private Piece wasBeforePiece;
    //endregion Fields

    //region Constructors
    public Move(Piece piece, Coordinate currentTile, Coordinate targetTile, Piece wasBeforePiece) {
        this.piece = piece;
        this.fromTile = currentTile;
        this.targetTile = targetTile;
        this.wasBeforePiece = wasBeforePiece;
    }

    public Move(Piece piece, Coordinate currentTile, Coordinate targetTile) {
        this(piece,currentTile,targetTile,null);
    }
    //endregion Constructors

    //region Getters & Setters
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Coordinate getFromTile() {
        return fromTile;
    }

    public void setFromTile(Coordinate fromTile) {
        this.fromTile = fromTile;
    }

    public Coordinate getTargetTile() {
        return targetTile;
    }

    public void setTargetTile(Coordinate targetTile) {
        this.targetTile = targetTile;
    }

    public Piece getWasBeforePiece() {
        return wasBeforePiece;
    }

    public void setWasBeforePiece(Piece wasBeforePiece) {
        this.wasBeforePiece = wasBeforePiece;
    }
    //endregion Getters & Setters

}
