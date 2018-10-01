package ChessGame.Logic;

import ChessGame.Logic.Pieces.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Board {

    public enum BoardMode{
        EMPTY,
        START_GAME
    }


    public static List<Piece> blackPieces;
    public static List<Piece> whitePieces;


    static{
        // ==== BLACK PIECES ===
        // -->BLACK Pawns
        Pawn a7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.A7);
        Pawn b7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.B7);
        Pawn c7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.C7);
        Pawn d7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.D7);
        Pawn e7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.E7);
        Pawn f7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.F7);
        Pawn g7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.G7);
        Pawn h7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.H7);

        //-->BLACK Rooks
        Rook a8Rook = new Rook(Piece.Color.BLACK, Coordinate.A8);
        Rook h8Rook = new Rook(Piece.Color.BLACK, Coordinate.H8);

        //-->BLACK Knights
        Knight b8Knight = new Knight(Piece.Color.BLACK, Coordinate.B8);
        Knight g8Knight = new Knight(Piece.Color.BLACK, Coordinate.G8);

        //-->BLACK Bishops
        Bishop c8Bishop = new Bishop(Piece.Color.BLACK, Coordinate.C8);
        Bishop f8Bishop = new Bishop(Piece.Color.BLACK, Coordinate.F8);

        //-->BLACK Queen
        Queen d8Queen = new Queen(Piece.Color.BLACK, Coordinate.D8);

        //-->BLACK King
        King e8King = new King(Piece.Color.BLACK, Coordinate.E8);
        blackPieces = new LinkedList<>(Arrays.asList(
                a7Pawn,b7Pawn,c7Pawn,d7Pawn,e7Pawn,f7Pawn,g7Pawn,h7Pawn,
                a8Rook,h8Rook,
                g8Knight,b8Knight,
                c8Bishop,f8Bishop,
                d8Queen,e8King
        ));


        // ==== WHITE PIECES ===
        // -->WHITE Pawns
        Pawn a2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.A2);
        Pawn b2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.B2);
        Pawn c2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.C2);
        Pawn d2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.D2);
        Pawn e2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.E2);
        Pawn f2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.F2);
        Pawn g2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.G2);
        Pawn h2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.H2);

        //-->WHITE Rooks
        Rook a1Rook = new Rook(Piece.Color.WHITE, Coordinate.A1);
        Rook h1Rook = new Rook(Piece.Color.WHITE, Coordinate.H1);

        //-->WHITE Knights
        Knight b1Knight = new Knight(Piece.Color.WHITE, Coordinate.B1);
        Knight g1Knight = new Knight(Piece.Color.WHITE, Coordinate.G1);

        //-->WHITE Bishops
        Bishop c1Bishop = new Bishop(Piece.Color.WHITE, Coordinate.C1);
        Bishop f1Bishop = new Bishop(Piece.Color.WHITE, Coordinate.F1);

        //-->WHITE Queen
        Queen d1Queen = new Queen(Piece.Color.WHITE, Coordinate.D1);

        //-->WHITE King
        King e1King = new King(Piece.Color.WHITE, Coordinate.E1);

        whitePieces = new LinkedList<>(Arrays.asList(
                a2Pawn,b2Pawn,c2Pawn,d2Pawn,e2Pawn,f2Pawn,g2Pawn,h2Pawn,
                a1Rook,h1Rook,
                g1Knight,b1Knight,
                c1Bishop,f1Bishop,
                d1Queen,e1King
        ));

    }


    private Tile[][] board;


    public Board(BoardMode mode){
        this.board = new Tile[8][8];
        initEmptyBoard();
        if(mode == BoardMode.START_GAME){
            initPieces();
        }
    }
    public void initEmptyBoard(){
        for(Coordinate coordinates : Coordinate.allCoordinates){
            this.board[coordinates.getRow().getValue()][coordinates.getColumn().getValue()] =
                                new Tile(coordinates,null);
        }

    }

    public void initPieces(){
        for(Piece whitePiece : whitePieces){
            getTileByCoordination(whitePiece.getCoordinate()).setCurrentPiece(whitePiece);
        }
        for(Piece blackPiece : blackPieces){
            getTileByCoordination(blackPiece.getCoordinate()).setCurrentPiece(blackPiece);
        }
    }



    public Tile getTileByCoordination(Coordinate coordinates){
        if((coordinates == null) ||(coordinates.getRow() == null) || (coordinates.getColumn() == null)){
            //invalid tile coordinates
            return null;
        }
        return this.board[coordinates.getRow().getValue()][coordinates.getColumn().getValue()];
    }
}
