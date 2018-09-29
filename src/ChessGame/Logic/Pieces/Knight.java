package ChessGame.Logic.Pieces;

import ChessGame.Logic.Column;
import ChessGame.Logic.Row;
import ChessGame.Logic.Tile;
import javafx.util.Pair;

public class Knight extends Piece{
    public Knight(Color pieceColor, Pair<Column, Row> coordinate) {
        super(pieceColor, coordinate);
    }

    @Override
    public void calculateAllPossibleMoves(Tile[][] currentBoard) {

    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof Knight);

    }
}
