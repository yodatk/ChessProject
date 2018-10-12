package ChessGame.Logic.Pieces;

import ChessGame.Logic.Board;
import ChessGame.Logic.Coordinate;
import ChessGame.Logic.Tile;
import ChessGame.UI.SourceURL;

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
        this.name = "King";
    }

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
        return;
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        this.possibleMoves = new HashSet<>();
        // before moving to a tile, need to make sure that tile is not threaten by any piece
        Coordinate next;
        boolean isThreat;
        //north
        next = this.coordinate.getNorth();
        if (next != null) {

            checkSafeToGoThere(currentBoard, next);
        }

        //north_east
        next = this.coordinate.getNorth_east();
        if (next != null) {
            checkSafeToGoThere(currentBoard, next);
        }

        //north_west
        next = this.coordinate.getNorth_west();
        if (next != null) {
            checkSafeToGoThere(currentBoard, next);
        }

        //south
        next = this.coordinate.getSouth();
        if (next != null) {
            checkSafeToGoThere(currentBoard, next);
        }

        //south_east
        next = this.coordinate.getSouth_east();
        if (next != null) {
            checkSafeToGoThere(currentBoard, next);
        }

        //south_west
        next = this.coordinate.getSouth_west();
        if (next != null) {
            checkSafeToGoThere(currentBoard, next);
        }

        //east
        next = this.coordinate.getEast();
        if (next != null) {
            checkSafeToGoThere(currentBoard, next);
        }

        //west
        next = this.coordinate.getWest();
        if (next != null) {
            checkSafeToGoThere(currentBoard, next);
        }

        //adding castling
        checkForCastling(currentBoard);


    }

    private void checkForCastling(Board currentBoard) {
        if ((!hasBeenMoved) & (!isThreaten)) {
            if (this.pieceColor == Color.WHITE) {
                Set<Coordinate> enemyPossibleMoves = new HashSet<>();
                for (Piece piece : currentBoard.getBlacksPieces()) {
                    enemyPossibleMoves.addAll(piece.getPossibleMoves());
                }
                //check small castle
                if (((!(enemyPossibleMoves.contains(Coordinate.E1))) &&
                        (!(enemyPossibleMoves.contains(Coordinate.F1))) &&
                        (!(enemyPossibleMoves.contains(Coordinate.G1)))) &&
                        (currentBoard.getTileByCoordination(Coordinate.F1).getCurrentPiece() == null) &&
                        (currentBoard.getTileByCoordination(Coordinate.G1).getCurrentPiece() == null)) {
                    Piece piece = currentBoard.getTileByCoordination(Coordinate.H1).getCurrentPiece();
                    if(piece instanceof Rook){
                        if(((Rook)piece).isHasBeenMoved() == false){
                            this.possibleMoves.add(coordinate.G1);
                        }
                    }

                }
                //check big castle
                if (((!(enemyPossibleMoves.contains(Coordinate.E1))) &&
                        (!(enemyPossibleMoves.contains(Coordinate.D1))) &&
                        (!(enemyPossibleMoves.contains(Coordinate.C1)))) &&
                        (!(enemyPossibleMoves.contains(Coordinate.B1))) &&
                        (currentBoard.getTileByCoordination(Coordinate.D1).getCurrentPiece() == null) &&
                        (currentBoard.getTileByCoordination(Coordinate.C1).getCurrentPiece() == null) &&
                        (currentBoard.getTileByCoordination(Coordinate.B1).getCurrentPiece() == null)) {
                    Piece piece = currentBoard.getTileByCoordination(Coordinate.A1).getCurrentPiece();
                    if(piece instanceof Rook){
                        if(((Rook)piece).isHasBeenMoved() == false){
                            this.possibleMoves.add(coordinate.C1);
                        }
                    }

                }


            } else {
                Set<Coordinate> enemyPossibleMoves = new HashSet<>();
                for (Piece piece : currentBoard.getWhitesPieces()) {
                    enemyPossibleMoves.addAll(piece.getPossibleMoves());
                }
                //check small castle
                if (((!(enemyPossibleMoves.contains(Coordinate.E8))) &&
                        (!(enemyPossibleMoves.contains(Coordinate.F8))) &&
                        (!(enemyPossibleMoves.contains(Coordinate.G8)))) &&
                        (currentBoard.getTileByCoordination(Coordinate.F8).getCurrentPiece() == null) &&
                        (currentBoard.getTileByCoordination(Coordinate.G8).getCurrentPiece() == null)) {
                    Piece piece = currentBoard.getTileByCoordination(Coordinate.H8).getCurrentPiece();
                    if(piece instanceof Rook){
                        if(((Rook)piece).isHasBeenMoved() == false){
                            this.possibleMoves.add(coordinate.G8);
                        }
                    }

                }
                //check big castle
                if (((!(enemyPossibleMoves.contains(Coordinate.E8))) &&
                        (!(enemyPossibleMoves.contains(Coordinate.D8))) &&
                        (!(enemyPossibleMoves.contains(Coordinate.C8)))) &&
                        (!(enemyPossibleMoves.contains(Coordinate.B8))) &&
                        (currentBoard.getTileByCoordination(Coordinate.D8).getCurrentPiece() == null) &&
                        (currentBoard.getTileByCoordination(Coordinate.C8).getCurrentPiece() == null) &&
                        (currentBoard.getTileByCoordination(Coordinate.B8).getCurrentPiece() == null)) {
                    Piece piece = currentBoard.getTileByCoordination(Coordinate.A8).getCurrentPiece();
                    if(piece instanceof Rook){
                        if(((Rook)piece).isHasBeenMoved() == false){
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
            Tile currentTile = currentBoard.getTileByCoordination(next);
            Piece pieceSaver = currentTile.getCurrentPiece();
            //replacing coordinates
            currentTile.setCurrentPiece(this);
            currentBoard.getTileByCoordination(this.coordinate).setCurrentPiece(null);
            if (checkIfValid(next, currentBoard)) {
                //if the move is safe for the king --> add coordinate as a possible move
                this.possibleMoves.add(next);
            }
            //replacing back
            currentTile.setCurrentPiece(pieceSaver);
            currentBoard.getTileByCoordination(this.coordinate).setCurrentPiece(this);

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
        if (this.pieceColor == Color.WHITE) {
            opponentsPieces = currentBoard.getBlacksPieces();
        } else {
            opponentsPieces = currentBoard.getWhitesPieces();
        }
        for (Piece piece : opponentsPieces) {
            piece.calculateSecondDegreeMoves(currentBoard);
            Set<Coordinate> dangerTiles = piece.getPossibleMoves();
            if (dangerTiles.contains(toCheck)) {
                return false;
            }
        }
        return true;
    }

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
        Tile nextTile = currentBoard.getTileByCoordination(toCheck);
        Piece theOtherPiece = nextTile.getCurrentPiece();
        if (theOtherPiece != null) {
            //if there is a piece in the next tile
            if (this.getPieceColor() != theOtherPiece.getPieceColor()) {
                //if the found piece is the opponent piece
                //possibleMoves.add(toCheck);
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
