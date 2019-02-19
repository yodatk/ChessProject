package logic.pieces;

import UI.SourceURL;
import logic.board.Board;
import logic.board.Coordinate;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract class describes a general chess piece
 */
public abstract class Piece {

    /**
     * Enum to declare the two only option for a piece color in chess
     */
    public enum Color {
        BLACK, WHITE;

        /**
         * Returns the opposite Color of this color.
         * @return if this is 'WHITE' --> returns 'BLACK'
         *          else return 'BLACK'
         */
        public Color next(){
            if(this == BLACK){
                return WHITE;
            }
            else{
                return BLACK;
            }
        }
    }

    //region Fields
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
    /**
     * Coordinate represent the first tile of this piece
     */
    protected Coordinate initialCoordinate;

    /**
     * Integer value represent the value of this piece.
     */
    protected int pieceValue;
    //endregion Fields

    //region Constructors
    public Piece(Color pieceColor, Coordinate coordinate) {
        this.pieceColor = pieceColor;
        this.coordinate = coordinate;
        this.initialCoordinate = coordinate;
        this.possibleMoves = new HashSet<Coordinate>();
        this.king = null;
        setImage();
    }

    public Piece(Color pieceColor, Coordinate coordinate, King king) {
        this.pieceColor = pieceColor;
        this.coordinate = coordinate;
        this.initialCoordinate = coordinate;
        this.king = king;
        this.possibleMoves = new HashSet<Coordinate>();
        setImage();
    }
    //endregion Constructors

    //region Getters & Setters
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

    public void setPossibleMoves(Set<Coordinate> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public int getPieceValue() {
        return pieceValue;
    }

    //endregion Getters & Setters

    /**
     * reset this piece to it's original state when the game begun.
     */
    public void resetPiece(){
        this.coordinate = this.initialCoordinate;
        this.possibleMoves.clear();
    }

    /**
     * set Image Icon for this piece
     */
    protected abstract void setImage();

    /**
     * After a piece moves on the board, will calculate the new possible moves for this piece.
     * @param currentBoard Board represent the current board situation
     */
    public abstract void calculateAllPossibleMoves(Board currentBoard);

    /**
     * After a piece moves on the board, will calculate the new possible moves for this piece,
     * without taking the king to conclusion
     * @param currentBoard Board represent the current board situation this Piece is in.
     */
    public abstract void calculateSecondDegreeMoves(Board currentBoard);

    /**
     * Checks according to the current board, if in the given coordinate there is another piece :
     *  - If there is another piece and it's in the same color as this piece -->
     *          return false,since this piece cannot replace a friendly piece.
     *
     *  - If there is another piece and it's the opposite color -->
     *          adds its coordinates to the possible moves set, and return false since this piece cant move past that piece.
     *
     *  - If there is no piece at all -->
     *          adds the coordinate to the possible moves set and return true since there is nothing to stop this piece from moving.
     * @param possibleMoves     Set of Coordinates, represent the current possible moves of this piece
     * @param toCheck           Coordinate to check if this piece can go to (according to the pieces there)
     * @param currentBoard      Board represent the current board situation this Piece is in.
     * @return 'true' if this piece can go further after that coordinate, 'false' otherwise.
     */
    protected boolean checkForPieces(Set<Coordinate> possibleMoves, Coordinate toCheck,
                                     Board currentBoard) {
        //Tile nextTile = currentBoard.getTileByCoordination(toCheck);
        //getting the piece from the target tile
        Piece theOtherPiece = currentBoard.getPieceByCoordinate(toCheck);
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


    /**
     * Gets a Set of Possible moves this piece, and removes from it all the moves that aren't safe for this piece king,
     * and therefore not valid.
     * @param currentBoard  Board represent the current board situation this Piece is in.
     */
    protected void  removeUnSafeMovesForKing(Board currentBoard){
        if(this.king!=null){
            Coordinate coordinateSaver = this.coordinate;
            Set<Coordinate> newPossibleMoves = new HashSet<>();

            for(Coordinate move : this.possibleMoves){
                //for each move in this Piece possible moves set

                //saving the original state of this Piece king,
                // and the Other Piece that was originally in the 'move' coordinate.
                boolean kingSafety = this.king.isThreaten();
                Piece pieceSaver = currentBoard.getPieceByCoordinate(move);
                if(pieceSaver != null){
                    //if there is a piece in the 'move' coordinate:
                    if(pieceSaver.getPieceColor() == Color.BLACK){
                        //if it's black --> removing it from the black pieces set.
                        currentBoard.getBlacksPieces().remove(pieceSaver);
                    }
                    else{
                        //if it's white --> removing it from the white pieces set
                        currentBoard.getWhitesPieces().remove(pieceSaver);
                    }
                }

                //putting temporarily this piece instead of that other piece.
                this.coordinate = move;
                currentBoard.emptyAGivenTileCoordination(coordinateSaver);
                currentBoard.setGivenPieceOnBoard(this);


                if(!(this.king.calculateIfInDanger(currentBoard))){
                    //if the king is not in danger by making this move --> than this move is valid so it can stay.
                    newPossibleMoves.add(move);
                }
                //restoring the board and the king to their original state.
                this.king.setThreaten(kingSafety);
                if(pieceSaver !=null ){
                    currentBoard.setGivenPieceOnBoard(pieceSaver);
                    //only if there was another piece in the 'move' coordinate.
                    if(pieceSaver.getPieceColor() == Color.BLACK){
                        //if it's black --> adding it back to the black pieces set.
                        currentBoard.getBlacksPieces().add(pieceSaver);
                    }
                    else{
                        //if it's white --> adding it back to the white pieces set.
                        currentBoard.getWhitesPieces().add(pieceSaver);
                    }
                }
                else{
                    currentBoard.emptyAGivenTileCoordination(move);
                }

            }
            //after checking all the possible moves, remove all the ones that weren't valid.
            this.possibleMoves = newPossibleMoves;
            //restoring this Piece original state.
            this.coordinate = coordinateSaver;
            currentBoard.setGivenPieceOnBoard(this);

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

    /**
     *
     * Returns a String representation of this Piece
     * @return String which is a Representation of this Piece, contains : the name of the piece, it's color, and coordinate.
     */
    @Override

    public String toString() {
        return "Piece{" +
                "name='" + name + '\'' +
                ", pieceColor=" + pieceColor +
                ", coordinate=" + coordinate +
                '}';
    }
}
