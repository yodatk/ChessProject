package ChessGame.Logic.Pieces;


import ChessGame.Logic.*;
import ChessGame.UI.SourceURL;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * abstract class describes a general chess piece
 */
public abstract class Piece {

    /**
     * Enum to declare the two only option for a piece color in chess
     */
    public enum Color {
        BLACK, WHITE;

        public Color next(){
            if(this == BLACK){
                return WHITE;
            }
            else{
                return BLACK;
            }
        }
    }

    /**
     * The Color of this piece(Black or White)
     */
    protected Color pieceColor;
    /**
     * The Coordinate of this piece on the board.
     */
    protected Coordinate coordinate;
    /**
     * Set of the current coordinates this piece can go
     */
    protected Set<Coordinate> possibleMoves;

    /**
     * This piece king.
     */
    protected King king;

    /**
     * Name of this piece.
     */
    protected String name;
    /**
     * SourceURL represent the url of the image of this piece
     */
    protected SourceURL imageURL;


    public Piece(Color pieceColor, Coordinate coordinate) {
        this.pieceColor = pieceColor;
        this.coordinate = coordinate;
        this.possibleMoves = new HashSet<>();
        this.king = null;
        setImage();
    }

    public Piece(Color pieceColor, Coordinate coordinate, King king) {
        this.pieceColor = pieceColor;
        this.coordinate = coordinate;
        this.king = king;
        this.possibleMoves = new HashSet<>();
        setImage();
    }
    public King getKing() {
        return king;
    }

    public Color getPieceColor() {
        return pieceColor;
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

    public SourceURL getImageURL() {
        return imageURL;
    }

    protected abstract void setImage();

    /**
     * After a piece moves on the board, will calculate the new possible moves for this piece.
     * @param currentBoard Board represent the current board situation
     */
    public abstract void calculateAllPossibleMoves(Board currentBoard);

    /**
     * After a piece moves on the board, will calculate the new possible moves for this piece,
     * without taking the king to conclusion
     * @param currentBoard Board represent the current board situation
     */
    public abstract void calculateSecondDegreeMoves(Board currentBoard);

    protected boolean checkForPieces(Set<Coordinate> possibleMoves, Coordinate toCheck,
                                     Board currentBoard) {
        Tile nextTile = currentBoard.getTileByCoordination(toCheck);
        Piece theOtherPiece = nextTile.getCurrentPiece();
        if (theOtherPiece != null) {
            //if there is a piece in the next tile
            if (this.getPieceColor() != theOtherPiece.getPieceColor()) {
                //if the found piece is the opponent piece --> add it to the possible moves
                possibleMoves.add(toCheck);
            }
            //return false, since the piece can't move pass the piece with the same color
            return false;
        } else {
            //if the next tile is valid, with no pieces --> will add the piece and return true;
            possibleMoves.add(toCheck);
            return true;
        }
    }


    public void setPossibleMoves(Set<Coordinate> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    protected void removeUnSafeMovesForKing(Board currentBoard){
        if(this.king!=null){
            Coordinate coordinateSaver = this.coordinate;
            Set<Coordinate> newPossibleMoves = new HashSet<>();

            for(Coordinate move : this.possibleMoves){
                boolean kingSafety = this.king.isThreaten();
                Piece pieceSaver = currentBoard.getTileByCoordination(move).getCurrentPiece();
                if(pieceSaver != null){
                    if(pieceSaver.getPieceColor() == Color.BLACK){
                        currentBoard.getBlacksPieces().remove(pieceSaver);
                    }
                    else{
                        currentBoard.getWhitesPieces().remove(pieceSaver);
                    }
                }

                currentBoard.getTileByCoordination(this.getCoordinate()).setCurrentPiece(null);
                currentBoard.getTileByCoordination(move).setCurrentPiece(this);
                this.coordinate = move;

                if(!(this.king.calculateIfInDanger(currentBoard))){
                    newPossibleMoves.add(move);
                }
                currentBoard.getTileByCoordination(move).setCurrentPiece(pieceSaver);
               // currentBoard.getTileByCoordination(this.getCoordinate()).setCurrentPiece(this);
                this.king.setThreaten(kingSafety);
                if(pieceSaver!=null){
                    if(pieceSaver.getPieceColor() == Color.BLACK){
                        currentBoard.getBlacksPieces().add(pieceSaver);
                    }
                    else{
                        currentBoard.getWhitesPieces().add(pieceSaver);
                    }
                }

            }
            this.possibleMoves = newPossibleMoves;
            this.coordinate = coordinateSaver;
            currentBoard.getTileByCoordination(coordinateSaver).setCurrentPiece(this);

        }
    }

    @Override
    /**
     *  - if obj is not instance of Piece --> return false.
     *  - piece will be equal to another piece only if both pieces are in the same coordinates, and with same color.
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Piece)) {
            return false;
        } else {
            Piece other = (Piece) obj;
            boolean sameColor = other.pieceColor == this.pieceColor;
            boolean sameCoordinates = other.coordinate.equals(this.coordinate);
            return sameColor & sameCoordinates;
        }
    }

    @Override
    public String toString() {
        return "Piece{" +
                "name='" + name + '\'' +
                ", pieceColor=" + pieceColor +
                ", coordinate=" + coordinate +
                '}';
    }
}
