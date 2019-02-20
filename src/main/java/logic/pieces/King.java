package logic.pieces;



import UI.SourceURL;
import logic.board.Board;
import logic.board.Coordinate;

import java.util.HashSet;
import java.util.Set;

/**
 * Class represent the King Piece in Chess.
 * in charge of the King characteristics in the game.
 */
public class King extends Piece {

    //region Fields
    private boolean isThreaten;
    private boolean hasBeenMoved;
    //endregion Fields

    //Constructor
    public King(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
        //assuming the king wouldn't be moved to a threaten tile
        this.isThreaten = false;
        this.hasBeenMoved = false;
        this.name = "King";
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 900;
        }
        else{
            this.pieceValue = -900;
        }

    }

    public King(King other){
        super(other.pieceColor,other.coordinate);
        this.isThreaten = other.isThreaten;
        this.hasBeenMoved = other.hasBeenMoved;
        this.name = other.name;
        if(this.pieceColor == Color.WHITE){
            this.pieceValue = 900;
        }
        else{
            this.pieceValue = -900;
        }
    }

    //region Getters & Setters
    public boolean isThreaten() {
        return isThreaten;
    }

    public void setThreaten(boolean threaten) {
        isThreaten = threaten;
    }

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
        this.isThreaten = false;
        this.hasBeenMoved = false;
    }

    @Override
    protected void setImage() {
        if(this.pieceColor == Color.WHITE){
            this.imageURL = SourceURL.LIGHT_KING;
        }
        else{
            this.imageURL = SourceURL.DARK_KING;
        }
    }

    @Override
    public void calculateSecondDegreeMoves(Board currentBoard) {
        this.possibleMoves = new HashSet<>();
        Coordinate next;
        next = this.coordinate.getNorth();
        if (next != null) {
            //if north is a valid tile.
            this.possibleMoves.add(next);
        }

        //north_east
        next = this.coordinate.getNorth_east();
        if (next != null) {
            //if north-east is a valid tile
            this.possibleMoves.add(next);        }

        //north_west
        next = this.coordinate.getNorth_west();
        if (next != null) {
            //if north-west is a valid tile
            this.possibleMoves.add(next);        }

        //south
        next = this.coordinate.getSouth();
        if (next != null) {
            //if south is a valid tile
            this.possibleMoves.add(next);        }

        //south_east
        next = this.coordinate.getSouth_east();
        if (next != null) {
            //if south-east is a valid tile
            this.possibleMoves.add(next);        }

        //south_west
        next = this.coordinate.getSouth_west();
        if (next != null) {
            //if south-west is a valid tile
            this.possibleMoves.add(next);        }

        //east
        next = this.coordinate.getEast();
        if (next != null) {
            //if east is a valid tile
            this.possibleMoves.add(next);        }

        //west
        next = this.coordinate.getWest();
        if (next != null) {
            //if west is a valid tile
            this.possibleMoves.add(next);
        }
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        this.possibleMoves = new HashSet<>();
        calculateSecondDegreeMoves(currentBoard);
        Set<Coordinate> tempSet = this.possibleMoves;
        this.possibleMoves = new HashSet<>();

        for(Coordinate move : tempSet){
            checkSafeToGoThere(currentBoard, move);
        }

        //adding possible castling moves
        checkForCastling(currentBoard);
    }

    /**
     * Checking according to the current board situation , if there are any castling moves possible.
     * If there are, adding them to the possible moves set.
     *
     * @param currentBoard Board object represent The current board this Bishop is in.
     */
    private void checkForCastling(Board currentBoard) {
        if ((!hasBeenMoved) & (!isThreaten)) {
            if (this.pieceColor == Color.WHITE) {
                //if this king is white, checking for the white tiles.
                Set<Coordinate> enemyPossibleMoves = new HashSet<Coordinate>();
                for (Piece piece : currentBoard.getBlacksPieces()) {
                    enemyPossibleMoves.addAll(piece.getPossibleMoves());
                }
                //check small castle
                if (
                    //only if none of those tiles are threaten
                        ((!(enemyPossibleMoves.contains(Coordinate.E1))) &&
                                (!(enemyPossibleMoves.contains(Coordinate.F1))) &&
                                (!(enemyPossibleMoves.contains(Coordinate.G1)))) &&
                                //only if those tiles are empty
                                (currentBoard.getPieceByCoordinate(Coordinate.F1) == null) &&
                                (currentBoard.getPieceByCoordinate(Coordinate.G1) == null)) {

                    Piece piece = currentBoard.getPieceByCoordinate(Coordinate.H1);
                    if(piece instanceof Rook){
                        if(!((Rook) piece).isHasBeenMoved()){
                            //only if there is a rook over there, and it didn't move yet  --> adding the castling move
                            this.possibleMoves.add(coordinate.G1);
                        }
                    }

                }
                //check big castle
                if (
                    //only if none of those tiles are threaten
                        ((!(enemyPossibleMoves.contains(Coordinate.E1))) &&
                                (!(enemyPossibleMoves.contains(Coordinate.D1))) &&
                                (!(enemyPossibleMoves.contains(Coordinate.C1)))) &&
                                (!(enemyPossibleMoves.contains(Coordinate.B1))) &&
                                //only if those tiles are empty
                                (currentBoard.getPieceByCoordinate(Coordinate.D1) == null) &&
                                (currentBoard.getPieceByCoordinate(Coordinate.C1) == null) &&
                                (currentBoard.getPieceByCoordinate(Coordinate.B1) == null)) {
                    Piece piece = currentBoard.getPieceByCoordinate(Coordinate.A1);
                    if(piece instanceof Rook){
                        if(((Rook)piece).isHasBeenMoved() == false){
                            //only if there is a Rook over there that has'nt move yet --> adding the castling move
                            this.possibleMoves.add(coordinate.C1);
                        }
                    }

                }


            } else {
                //if this is not white --> checking on the tile of the black king.
                Set<Coordinate> enemyPossibleMoves = new HashSet<Coordinate>();
                for (Piece piece : currentBoard.getWhitesPieces()) {
                    enemyPossibleMoves.addAll(piece.getPossibleMoves());
                }
                //check small castle
                if (    //only if none of those tiles are threaten
                        ((!(enemyPossibleMoves.contains(Coordinate.E8))) &&
                                (!(enemyPossibleMoves.contains(Coordinate.F8))) &&
                                (!(enemyPossibleMoves.contains(Coordinate.G8)))) &&
                                //only if those tiles are empty
                                (currentBoard.getPieceByCoordinate(Coordinate.F8) == null) &&
                                (currentBoard.getPieceByCoordinate(Coordinate.G8) == null)) {
                    Piece piece = currentBoard.getPieceByCoordinate(Coordinate.H8);
                    if(piece instanceof Rook){
                        if(!((Rook) piece).isHasBeenMoved()){
                            //only if there is a rook over there, and it didn't move yet  --> adding the castling move
                            this.possibleMoves.add(coordinate.G8);
                        }
                    }

                }
                //check big castle
                if (    //only if none of those tiles are threaten
                        ((!(enemyPossibleMoves.contains(Coordinate.E8))) &&
                                (!(enemyPossibleMoves.contains(Coordinate.D8))) &&
                                (!(enemyPossibleMoves.contains(Coordinate.C8)))) &&
                                (!(enemyPossibleMoves.contains(Coordinate.B8))) &&
                                //only if those tiles are empty
                                (currentBoard.getPieceByCoordinate(Coordinate.D8) == null) &&
                                (currentBoard.getPieceByCoordinate(Coordinate.C8) == null) &&
                                (currentBoard.getPieceByCoordinate(Coordinate.B8) == null)) {
                    Piece piece = currentBoard.getPieceByCoordinate(Coordinate.A8);
                    if(piece instanceof Rook){
                        if(((Rook)piece).isHasBeenMoved() == false){
                            //only if there is a rook over there, and it didn't move yet --> adding the castling move
                            this.possibleMoves.add(coordinate.C8);
                        }
                    }

                }

            }
        }

    }

    /**
     * Checks if with the current situation on the board, the king can go to a certain Tile without being threaten.
     * if so, will add it to the possible moves set.
     *
     * @param currentBoard Board object represent the current Board situation
     * @param next         Coordinate needs to  be checked on the board as a possible move
     */
    private void checkSafeToGoThere(Board currentBoard, Coordinate next) {
        if (checkForPieces(this.possibleMoves, next, currentBoard)) {
            //Tile currentTile = currentBoard.getTileByCoordination(next);
            //saving the target coordinate piece
            Piece pieceSaver = currentBoard.getPieceByCoordinate(next);
            Coordinate coordinateSaver = this.coordinate;
            this.setCoordinate(next);
            //replacing coordinates
            currentBoard.setGivenPieceOnBoard(this);
            currentBoard.emptyAGivenTileCoordination(coordinateSaver);
            if (checkIfValid(next, currentBoard)) {
                //if the move is safe for the king --> add coordinate as a possible move
                this.possibleMoves.add(next);
            }
            //replacing back
            if(pieceSaver != null){
                currentBoard.setGivenPieceOnBoard(pieceSaver);
            }
            else{
                currentBoard.emptyAGivenTileCoordination(next);
            }
            this.setCoordinate(coordinateSaver);
            currentBoard.setGivenPieceOnBoard(this);

        }
    }

    /**
     * This function is called when calling the checkSafeToGoThere function.
     * Checks with ALL the opponents pieces to see if any of them can get to the tile that the king consider to go to.
     *
     * @param toCheck      Coordinate of a tile that it's safety needs to be checked
     * @param currentBoard Board Object represent the current board situation
     * @return 'true' if the the tile is safe for this king, 'false' otherwise.
     */
    public boolean checkIfValid(Coordinate toCheck, Board currentBoard) {
        Set<Piece> opponentsPieces;
        // configuring the opponents pieces
        if (this.pieceColor == Color.WHITE) {
            opponentsPieces = currentBoard.getBlacksPieces();
        } else {
            opponentsPieces = currentBoard.getWhitesPieces();
        }

        for (Piece piece : opponentsPieces) {
            //for each enemy piece, check it's possible moves.
            piece.calculateSecondDegreeMoves(currentBoard);
            Set<Coordinate> dangerTiles = piece.getPossibleMoves();
            if (dangerTiles.contains(toCheck)) {
                //if the the toCheck is in the possible move of the enemy piece --> means that this tile is not safe:
                return false;
            }
        }
        // if the "toCheck" tile is not in anyone of the possible moves of the enemy --> that coordinate is valid
        return true;
    }

    /**
     * Calculates if this king is currently in danger in the current board.
     * @param currentBoard Board object represent the current board this king is in.
     * @return 'true' if the king is currently threaten, 'false' if the king is safe.
     */
    public boolean calculateIfInDanger(Board currentBoard) {
        Set<Piece> enemyPieces;
        if (this.pieceColor == Color.WHITE) {
            enemyPieces = currentBoard.getBlacksPieces();
        } else {
            enemyPieces = currentBoard.getWhitesPieces();
        }

        for (Piece enemyPiece : enemyPieces) {
            enemyPiece.calculateSecondDegreeMoves(currentBoard);
            if (enemyPiece.getPossibleMoves().contains(this.coordinate)) {
                //if one of the pieces can get to the king --> return true
                this.isThreaten = true;
                return true;
            }


        }
        //if no enemy piece is threatening the king --> return false
        this.setThreaten(false);
        return false;
    }

    @Override
    protected boolean checkForPieces(Set<Coordinate> possibleMoves, Coordinate toCheck, Board currentBoard) {
        //Tile nextTile = currentBoard.getTileByCoordination(toCheck);
        Piece theOtherPiece = currentBoard.getPieceByCoordinate(toCheck);
        if (theOtherPiece != null) {
            //if there is a piece in the next tile
            if (this.getPieceColor() != theOtherPiece.getPieceColor()) {
                //if the found piece is the opponent piece
                return true;
            }
            //return false, since the piece can't move pass the piece with the same color
            return false;
        } else {
            //if the next tile is valid, with no pieces --> return true;
            return true;
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof King);
    }

}

