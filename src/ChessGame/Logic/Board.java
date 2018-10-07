package ChessGame.Logic;

import ChessGame.Logic.Pieces.*;

import java.util.*;

public class Board {

    public enum BoardMode {
        EMPTY,
        START_GAME
    }

    //-->BLACK King
    public static King blackKing;

    //-->BLACK Queen
    public static Queen blackQueen;



    // -->BLACK Pawns
    public static Pawn a7Pawn;
    public static Pawn b7Pawn;
    public static Pawn c7Pawn;
    public static Pawn d7Pawn;
    public static Pawn e7Pawn;
    public static Pawn f7Pawn;
    public static Pawn g7Pawn;
    public static Pawn h7Pawn;

    //-->BLACK Rooks
    public static Rook a8Rook;
    public static Rook h8Rook;

    //-->BLACK Knights
    public static Knight b8Knight;
    public static Knight g8Knight;

    //-->BLACK Bishops
    public static Bishop c8Bishop;
    public static Bishop f8Bishop;


    // ==== WHITE PIECES ===

    //-->WHITE King
    public static King whiteKing;

    //-->WHITE Queen
    public static Queen whiteQueen;



    // -->WHITE Pawns
    public static Pawn a2Pawn;
    public static Pawn b2Pawn;
    public static Pawn c2Pawn;
    public static Pawn d2Pawn;
    public static Pawn e2Pawn;
    public static Pawn f2Pawn;
    public static Pawn g2Pawn;
    public static Pawn h2Pawn;

    //-->WHITE Rooks
    public static Rook a1Rook;
    public static Rook h1Rook;

    //-->WHITE Knights
    public static Knight b1Knight;
    public static Knight g1Knight;

    //-->WHITE Bishops
    public static Bishop c1Bishop;
    public static Bishop f1Bishop;


    public static List<Piece> allBlackPieces;
    public static List<Piece> allWhitePieces;


    static {
        // ==== BLACK PIECES ===
        //-->BLACK King
        blackKing = new King(Piece.Color.BLACK, Coordinate.E8);

        //-->BLACK Queen
        blackQueen = new Queen(Piece.Color.BLACK, Coordinate.D8, blackKing);



        // -->BLACK Pawns
        a7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.A7, blackKing);
        b7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.B7, blackKing);
        c7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.C7, blackKing);
        d7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.D7, blackKing);
        e7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.E7, blackKing);
        f7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.F7, blackKing);
        g7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.G7, blackKing);
        h7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.H7, blackKing);

        //-->BLACK Rooks
        a8Rook = new Rook(Piece.Color.BLACK, Coordinate.A8, blackKing);
        h8Rook = new Rook(Piece.Color.BLACK, Coordinate.H8, blackKing);

        //-->BLACK Knights
        b8Knight = new Knight(Piece.Color.BLACK, Coordinate.B8, blackKing);
        g8Knight = new Knight(Piece.Color.BLACK, Coordinate.G8, blackKing);

        //-->BLACK Bishops
        c8Bishop = new Bishop(Piece.Color.BLACK, Coordinate.C8, blackKing);
        f8Bishop = new Bishop(Piece.Color.BLACK, Coordinate.F8, blackKing);


        allBlackPieces = new LinkedList<>(Arrays.asList(
                a7Pawn, b7Pawn, c7Pawn, d7Pawn, e7Pawn, f7Pawn, g7Pawn, h7Pawn,
                a8Rook, h8Rook,
                g8Knight, b8Knight,
                c8Bishop, f8Bishop,
                blackQueen, blackKing
        ));


        // ==== WHITE PIECES ===

        //-->WHITE King
        whiteKing = new King(Piece.Color.WHITE, Coordinate.E1);

        //-->WHITE Queen
        whiteQueen = new Queen(Piece.Color.WHITE, Coordinate.D1, whiteKing);



        // -->WHITE Pawns
        a2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.A2, whiteKing);
        b2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.B2, whiteKing);
        c2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.C2, whiteKing);
        d2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.D2, whiteKing);
        e2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.E2, whiteKing);
        f2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.F2, whiteKing);
        g2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.G2, whiteKing);
        h2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.H2, whiteKing);

        //-->WHITE Rooks
        a1Rook = new Rook(Piece.Color.WHITE, Coordinate.A1, whiteKing);
        h1Rook = new Rook(Piece.Color.WHITE, Coordinate.H1, whiteKing);

        //-->WHITE Knights
        b1Knight = new Knight(Piece.Color.WHITE, Coordinate.B1, whiteKing);
        g1Knight = new Knight(Piece.Color.WHITE, Coordinate.G1, whiteKing);

        //-->WHITE Bishops
        c1Bishop = new Bishop(Piece.Color.WHITE, Coordinate.C1,whiteKing);
        f1Bishop = new Bishop(Piece.Color.WHITE, Coordinate.F1,whiteKing);



        allWhitePieces = new LinkedList<>(Arrays.asList(
                a2Pawn, b2Pawn, c2Pawn, d2Pawn, e2Pawn, f2Pawn, g2Pawn, h2Pawn,
                a1Rook, h1Rook,
                g1Knight, b1Knight,
                c1Bishop, f1Bishop,
                whiteQueen, whiteKing
        ));

    }


    private Tile[][] board;
    private List<Piece> blacksPieces;
    private List<Piece> whitesPieces;

    public Board(BoardMode mode) {
        this.board = new Tile[8][8];
        this.whitesPieces = new LinkedList<>();
        this.blacksPieces = new LinkedList<>();
        initEmptyBoard();
        if (mode == BoardMode.START_GAME) {
            initPieces();
        }
    }

    public void initEmptyBoard() {
        for (Coordinate coordinates : Coordinate.allCoordinates) {
            this.board[coordinates.getRow().getValue()][coordinates.getColumn().getValue()] =
                    new Tile(coordinates, null);
        }

    }

    public void initPieces() {
        for (Piece whitePiece : allWhitePieces) {
            //adding all white pieces
            getTileByCoordination(whitePiece.getCoordinate()).setCurrentPiece(whitePiece);
            this.whitesPieces.add(whitePiece);

        }
        for (Piece blackPiece : allBlackPieces) {
            //adding all black pieces
            getTileByCoordination(blackPiece.getCoordinate()).setCurrentPiece(blackPiece);
            this.blacksPieces.add(blackPiece);
        }
        for(Piece whitePiece : this.getWhitesPieces()){
            //calculating all possible moves for white pieces
            whitePiece.calculateAllPossibleMoves(this);
        }
        for(Piece blackPiece : this.getBlacksPieces()){
            //calculating all possible moves for black pieces
            blackPiece.calculateAllPossibleMoves(this);
        }

    }


    public Tile getTileByCoordination(Coordinate coordinates) {
        if ((coordinates == null) || (coordinates.getRow() == null) || (coordinates.getColumn() == null)) {
            //invalid tile coordinates
            return null;
        }
        return this.board[coordinates.getRow().getValue()][coordinates.getColumn().getValue()];
    }

    public Tile getTileByIndexes(int row, int col){
        if((row < 0) | (col < 0 )| (row > 7) | (col > 7)){
            throw new IllegalArgumentException("index of tile is out of bound");
        }

        return this.board[row][col];
    }

    public List<Piece> getBlacksPieces() {
        return blacksPieces;
    }

    public List<Piece> getWhitesPieces() {
        return whitesPieces;
    }

}
