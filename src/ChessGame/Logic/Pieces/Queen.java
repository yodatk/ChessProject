package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
import ChessGame.UI.SourceURL;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece {
    public Queen(Color pieceColor, Coordinate coordinate, King king) {
        super(pieceColor, coordinate, king);
        this.name = "Queen";
    }

    public Queen(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
        this.name = "Queen";
    }

    @Override
    protected void setImage() {
        if(this.pieceColor == Color.WHITE){
            this.imageURL = SourceURL.LIGHT_QUEEN;
        }
        else{
            this.imageURL = SourceURL.DARK_QUEEN;
        }
    }

    @Override
    public void calculateSecondDegreeMoves(Board currentBoard) {
        this.possibleMoves = new HashSet<>();
        whileUp(currentBoard);
        whileDown(currentBoard);
        whileRight(currentBoard);
        whileLeft(currentBoard);
        whileRightUp(currentBoard);
        whileLeftUp(currentBoard);
        whileRightDown(currentBoard);
        whileLeftDown(currentBoard);
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        calculateSecondDegreeMoves(currentBoard);
        removeUnSafeMovesForKing(currentBoard);
    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof Queen);
    }

    private void whileLeft(Board currentBoard) {
        boolean can_Left = true;
        Coordinate next = this.coordinate;
        while (can_Left) {
            //as long as the rook can go left.
            next = next.getWest();
            if (next == null) {
                //if the next tile is not valid.
                can_Left = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Left = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    private void whileRight(Board currentBoard) {
        boolean can_Right = true;
        Coordinate next = this.coordinate;
        while (can_Right) {
            //as long as the rook can go right.
            next = next.getEast();
            if (next == null) {
                //if the next tile is not valid.
                can_Right = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Right = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    private void whileDown(Board currentBoard) {
        boolean can_Down = true;
        Coordinate next = this.coordinate;
        while (can_Down) {
            // as long as the rook can go down.
            next = next.getSouth();
            if (next == null) {
                //if the next tile is not valid.
                can_Down = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Down = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    private void whileUp(Board currentBoard) {
        boolean can_Up = true;
        Coordinate next = this.coordinate;
        while (can_Up) {
            //as long as the rook can go up.
            next = next.getNorth();
            if (next == null) {
                //if the next tile is not valid.
                can_Up = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                can_Up = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }
    private void whileLeftDown(Board currentBoard) {
        boolean canLeft_Down = true;
        //initialising the piece to the current location.
        Coordinate next = this.coordinate;
        while (canLeft_Down) {
            //as long as the bishop can move right & down
            next = next.getSouth_west();
            if (next == null) {
                //if the next tile is not valid.
                canLeft_Down = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                canLeft_Down = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    private void whileRightDown(Board currentBoard) {
        boolean canRight_Down = true;
        //initialising the piece to the current location.
        Coordinate next = this.coordinate;
        while (canRight_Down) {
            //as long as the bishop can move right & down

            next = next.getSouth_east();
            if (next == null) {
                //if the next tile is not valid.
                canRight_Down = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                canRight_Down = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    private void whileLeftUp(Board currentBoard) {
        boolean canLeft_Up = true;
        Coordinate next = this.coordinate;
        while (canLeft_Up) {
            //as long as the bishop can move left & up
            next = next.getNorth_west();
            if (next == null) {
                //if the next tile is not valid.
                canLeft_Up = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                canLeft_Up = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }

    private void whileRightUp(Board currentBoard) {
        boolean canRight_Up = true;
        Coordinate next = this.coordinate;
        while (canRight_Up) {
            //as long as the bishop can move right & up
            next = next.getNorth_east();
            if (next == null) {
                //if the next tile is not valid.
                canRight_Up = false;
            } else {
                //add the next move if possible, and return whether this piece can continue moving on the board.
                canRight_Up = checkForPieces(this.possibleMoves, next, currentBoard);
            }
        }
    }
}
