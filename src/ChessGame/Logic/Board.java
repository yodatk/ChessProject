package ChessGame.Logic;

import ChessGame.Logic.Pieces.*;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Board {
    private Tile[][] tiles;
    private List<Piece>  whitePlayerPieces;
    private List<Piece>  blackPlayerPieces;
    private Stack<Piece> deadPieces;

    public Board() {
        this.tiles = new Tile[8][8];
        this.whitePlayerPieces = new LinkedList<>();
        this.blackPlayerPieces = new LinkedList<>();
        initTiles();
    }

    /**
     * This function is called during the "initBoard" Method, when dealing with the first, second, seventh or eighth rows.
     * this function determines by the given coordinates:
     * 1  What piece should be in that place on the board,
     * 2. What color should it have,
     * and returns the piece back
     *
     * @param coordinate the Row and Column of the tile to put a piece on
     * @return a Piece Object that fits the given coordinate, by the rules of chess in the beginning state
     */
    public Piece initPieceOnTile(Pair<Column, Row> coordinate) {
        Column column = coordinate.getKey();
        Row row = coordinate.getValue();
        Piece piece;
        Piece.Color color;
        //==== if it's white player tiles
        if (((row == Row.ONE) || (row == Row.TWO))) {
            color = Piece.Color.WHITE;
        } else {
            color = Piece.Color.BLACK;
        }
        if ((row == Row.TWO) || (row == Row.SEVEN)) {
            //--> if it's the second or seventh row , than it must be a pawn

            piece = new Pawn(color, coordinate);
        } else {//--> if it's the first row

            if ((column == Column.A) || (column == Column.H)) {
                //placing a rook
                piece = new Rook(color, coordinate);
            } else if ((column == Column.B) || (column == Column.G)) {
                //placing a Knight
                piece = new Knight(color, coordinate);
            } else if ((column == Column.C) || (column == Column.F)) {
                //placing a Bishop
                piece = new Bishop(color, coordinate);
            } else if (column == Column.E) {
                //placing a King
                piece = new King(color, coordinate);
            } else {
                //placing a Queen
                piece = new Queen(color, coordinate);
            }
        }
        if(piece.getPieceColor() == Piece.Color.BLACK){
            this.blackPlayerPieces.add(piece);
        }else{
            this.whitePlayerPieces.add(piece);
        }
        return piece;
    }

    /**
     * This Method initialising the Tiles array, with the appropriate pieces in the right tiles.
     */
    public void initTiles() {
        for (Column column : Column.values()) {
            for (Row row : Row.values()) {
                Tile tile;
                Piece piece;

                Pair<Column, Row> coordinate = new Pair<>(column, row);
                if ((row == Row.ONE) || (row == Row.TWO) || (row == Row.SEVEN) || (row == Row.EIGHT)) {
                    piece = initPieceOnTile(coordinate);
                    tile = new Tile(coordinate, piece);
                    this.tiles[row.getValue()][column.getValue()] = tile;
                } else {
                    //any other row --> creating a tile without a piece
                    piece = null;
                }
                tile = new Tile(coordinate, piece);
                this.tiles[row.getValue()][column.getValue()] = tile;
            }
        }
    }
}

