package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
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
    public void calculateSecondDegreeMoves(Board currentBoard) {
        Rook tempRook = new Rook(this.pieceColor, this.coordinate);
        tempRook.calculateSecondDegreeMoves(currentBoard);
        Bishop tempBishop = new Bishop(this.pieceColor, this.coordinate);
        tempBishop.calculateSecondDegreeMoves(currentBoard);
        //resetting the possible moves.
        this.possibleMoves = new HashSet<>();

        Set<Coordinate> bishopMoves = tempBishop.getPossibleMoves();

        Set<Coordinate> rookMoves = tempRook.getPossibleMoves();
        // adding diagonals
        this.possibleMoves.addAll(bishopMoves);
        // adding pluses
        this.possibleMoves.addAll(rookMoves);
    }

    @Override
    public void calculateAllPossibleMoves(Board currentBoard) {
        Rook tempRook = new Rook(this.pieceColor, this.coordinate);
        tempRook.calculateAllPossibleMoves(currentBoard);
        Bishop tempBishop = new Bishop(this.pieceColor, this.coordinate);
        tempBishop.calculateAllPossibleMoves(currentBoard);
        //resetting the possible moves.
        this.possibleMoves = new HashSet<>();

        Set<Coordinate> bishopMoves = tempBishop.getPossibleMoves();

        Set<Coordinate> rookMoves = tempRook.getPossibleMoves();
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
