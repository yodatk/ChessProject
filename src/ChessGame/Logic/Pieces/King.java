package ChessGame.Logic.Pieces;

import ChessGame.Logic.Column;
import ChessGame.Logic.Row;
import ChessGame.Logic.Tile;
import javafx.util.Pair;

import java.util.HashSet;

public class King extends Piece{
    private Pawn equ1 = new Pawn(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Rook equ2 = new Rook(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Integer equ3 = 5;
    private Pawn equ4 = new Pawn(Piece.Color.WHITE,new Pair<>(Column.D, Row.ONE));
    private Pawn equ5 = new Pawn(Piece.Color.BLACK,new Pair<>(Column.E, Row.FIVE));
    private Pawn equ6 = new Pawn(Piece.Color.WHITE,new Pair<>(Column.F, Row.SEVEN));

    public King(Color pieceColor, Pair<Column, Row> coordinate) {
        super(pieceColor, coordinate);
    }

    @Override
    public void calculateAllPossibleMoves(Tile[][] currentBoard) {
        this.possibleMoves = new HashSet<>();

    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof King);
    }
}
