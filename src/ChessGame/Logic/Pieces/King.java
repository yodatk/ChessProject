package ChessGame.Logic.Pieces;

import ChessGame.Logic.Board;
import ChessGame.Logic.Coordinate;
import ChessGame.Logic.Tile;

import java.util.HashSet;

public class King extends Piece{


    public King(Color pieceColor, Coordinate coordinate) {
        super(pieceColor, coordinate);
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        this.possibleMoves = new HashSet<>();

    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof King);
    }
}
