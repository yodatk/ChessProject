package ChessGame.Logic.Pieces;

import ChessGame.Logic.Column;
import ChessGame.Logic.Row;
import ChessGame.Logic.Tile;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece{
    public Queen(Color pieceColor, Pair<Column, Row> coordinate) {
        super(pieceColor, coordinate);
    }

    @Override
    public void calculateAllPossibleMoves(Tile[][] currentBoard) {
        Rook tempRook = new Rook(this.pieceColor,this.coordinate);
        tempRook.calculateAllPossibleMoves(currentBoard);
        Bishop tempBishop = new Bishop(this.pieceColor,this.coordinate);
        tempBishop.calculateAllPossibleMoves(currentBoard);
        //resetting the possible moves.
        this.possibleMoves = new HashSet<>();

        Set<Pair<Column,Row>> bishopMoves = tempBishop.getPossibleMoves();

        Set<Pair<Column,Row>> rookMoves = tempRook.getPossibleMoves();
        // adding diagonals
        this.possibleMoves.addAll(bishopMoves);
        // adding pluses
        this.possibleMoves.addAll(rookMoves);

    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof Queen);
    }
}
