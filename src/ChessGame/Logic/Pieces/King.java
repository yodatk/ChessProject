package ChessGame.Logic.Pieces;

import ChessGame.Logic.Board;
import ChessGame.Logic.Coordinate;
import ChessGame.Logic.Tile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class King extends Piece {

    private boolean isThreaten;
    private boolean hasBeenMoved;
    public King(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
        //assuming the king wouldn't be moved to a threaten tile
        this.isThreaten = false;
        this.hasBeenMoved = false;
    }
    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        this.possibleMoves = new HashSet<>();
        // before moving to a tile, need to make sure that tile is not threaten by any piece
        Coordinate next;
        boolean isThreat;
        //north
        next = this.coordinate.getNorth();
        if(next != null){

            checkSafeToGoThere(currentBoard, next);

        }

        //north_east
        next = this.coordinate.getNorth_east();
        if(next != null){
            checkSafeToGoThere(currentBoard, next);
        }

        //north_west
        next = this.coordinate.getNorth_west();
        if(next != null){
            checkSafeToGoThere(currentBoard, next);
        }

        //south
        next = this.coordinate.getSouth();
        if(next != null){
            checkSafeToGoThere(currentBoard, next);
        }

        //south_east
        next = this.coordinate.getSouth_east();
        if(next != null){
            checkSafeToGoThere(currentBoard, next);
        }

        //south_west
        next = this.coordinate.getSouth_west();
        if(next != null){
            checkSafeToGoThere(currentBoard, next);
        }

        //east
        next = this.coordinate.getEast();
        if(next != null){
            checkSafeToGoThere(currentBoard, next);
        }

        //west
        next = this.coordinate.getWest();
        if(next != null){
            checkSafeToGoThere(currentBoard, next);
        }

    }

    /**
     * Checks if with the current situation on the board, the king can go to a certain Tile without being threaten.
     * if so, will add it to the possible moves set.
     * @param currentBoard Board object represent the current Board situation
     * @param next Coordinate needs to  be checked on the board as a possible move
     */
    private void checkSafeToGoThere(Board currentBoard, Coordinate next) {
        if(checkForPieces(this.possibleMoves,next,currentBoard)){
            Tile currentTile = currentBoard.getTileByCoordination(next);
            Piece pieceSaver = currentTile.getCurrentPiece();
            //replacing coordinates
            currentTile.setCurrentPiece(this);
            currentBoard.getTileByCoordination(this.coordinate).setCurrentPiece(null);
            if(checkIfValid(next,currentBoard)){
                //if the move is safe for the king --> add coordinate as a possible move
                this.possibleMoves.add(next);
            }
            //replacing back
            currentTile.setCurrentPiece(pieceSaver);
            currentBoard.getTileByCoordination(this.coordinate).setCurrentPiece(this);

        }
    }

    /**
     * This funciton is called when calling the checkSafeToGoThere function.
     * Checks with ALL the opponents pieces to see if any of them can get to the tile that the king consider to go to.
     * @param toCheck Coordinate of a tile that it's safety needs to be checked
     * @param currentBoard Board Object represent the current board situation
     * @return 'true' if the the tile is safe for this king, 'false' otherwise.
     */
    public boolean checkIfValid(Coordinate toCheck, Board currentBoard){
        List<Piece> opponentsPieces;
        if(this.pieceColor == Color.WHITE){
            opponentsPieces = currentBoard.getBlacksPieces();
        }
        else{
            opponentsPieces = currentBoard.getWhitesPieces();
        }
        for(Piece piece : opponentsPieces){
            piece.calculateAllPossibleMoves(currentBoard);
            Set<Coordinate> dangerTiles = piece.getPossibleMoves();
            if(dangerTiles.contains(toCheck)){
                return false;
            }
        }
        return true;
    }

    public boolean calculateIfInDanger(Board currentBoard){
        List<Piece> enemyPieces;
        if(this.pieceColor == Color.WHITE){
            enemyPieces = currentBoard.getBlacksPieces();
        }
        else{
            enemyPieces = currentBoard.getWhitesPieces();
        }

        for (Piece enemyPiece : enemyPieces){
            enemyPiece.calculateAllPossibleMoves(currentBoard);
            if(enemyPiece.getPossibleMoves().contains(this.coordinate)){
                //if one of the pieces can get to the king --> return true
                this.isThreaten = true;
                return true;
            }
        }
        //if no enemy piece is threatening the king --> return false
        return false;
    }

    @Override
    protected boolean checkForPieces(Set<Coordinate> possibleMoves, Coordinate toCheck, Board currentBoard) {
        Tile nextTile = currentBoard.getTileByCoordination(toCheck);
        Piece theOtherPiece = nextTile.getCurrentPiece();
        if (theOtherPiece != null) {
            //if there is a piece in the next tile
            if (this.getPieceColor() != theOtherPiece.getPieceColor()) {
                //if the found piece is the opponent piece --> add it to the possible moves
                //possibleMoves.add(toCheck);
                return true;
            }
            //return false, since the piece can't move pass the piece with the same color
            return false;
        } else {
            //if the next tile is valid, with no pieces --> return true;
            //possibleMoves.add(toCheck);
            return true;
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof King);
    }

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
}
