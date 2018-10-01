//package ChessGame.Logic;
//
//import ChessGame.Logic.Pieces.*;
//import javafx.util.Pair;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class BoardTest {
//
//    private Pair<Column,Row> A1 = new Pair<>(Column.A,Row.ONE);
//    private Pair<Column,Row> A2 = new Pair<>(Column.A,Row.TWO);
//    private Pair<Column,Row> A3 = new Pair<>(Column.A,Row.THREE);
//    private Pair<Column,Row> A4 = new Pair<>(Column.A,Row.FOUR);
//    private Pair<Column,Row> A5 = new Pair<>(Column.A,Row.FIVE);
//    private Pair<Column,Row> A6 = new Pair<>(Column.A,Row.SIX);
//    private Pair<Column,Row> A7 = new Pair<>(Column.A,Row.SEVEN);
//    private Pair<Column,Row> A8 = new Pair<>(Column.A,Row.EIGHT);
//
//    private Pair<Column,Row> B1 = new Pair<>(Column.B,Row.ONE);
//    private Pair<Column,Row> B2 = new Pair<>(Column.B,Row.TWO);
//    private Pair<Column,Row> B3 = new Pair<>(Column.B,Row.THREE);
//    private Pair<Column,Row> B4 = new Pair<>(Column.B,Row.FOUR);
//    private Pair<Column,Row> B5 = new Pair<>(Column.B,Row.FIVE);
//    private Pair<Column,Row> B6 = new Pair<>(Column.B,Row.SIX);
//    private Pair<Column,Row> B7 = new Pair<>(Column.B,Row.SEVEN);
//    private Pair<Column,Row> B8 = new Pair<>(Column.B,Row.EIGHT);
//
//    private Pair<Column,Row> C1 = new Pair<>(Column.C,Row.ONE);
//    private Pair<Column,Row> C2 = new Pair<>(Column.C,Row.TWO);
//    private Pair<Column,Row> C3 = new Pair<>(Column.C,Row.THREE);
//    private Pair<Column,Row> C4 = new Pair<>(Column.C,Row.FOUR);
//    private Pair<Column,Row> C5 = new Pair<>(Column.C,Row.FIVE);
//    private Pair<Column,Row> C6 = new Pair<>(Column.C,Row.SIX);
//    private Pair<Column,Row> C7 = new Pair<>(Column.C,Row.SEVEN);
//    private Pair<Column,Row> C8 = new Pair<>(Column.C,Row.EIGHT);
//
//    private Pair<Column,Row> D1 = new Pair<>(Column.D,Row.ONE);
//    private Pair<Column,Row> D2 = new Pair<>(Column.D,Row.TWO);
//    private Pair<Column,Row> D3 = new Pair<>(Column.D,Row.THREE);
//    private Pair<Column,Row> D4 = new Pair<>(Column.D,Row.FOUR);
//    private Pair<Column,Row> D5 = new Pair<>(Column.D,Row.FIVE);
//    private Pair<Column,Row> D6 = new Pair<>(Column.D,Row.SIX);
//    private Pair<Column,Row> D7 = new Pair<>(Column.D,Row.SEVEN);
//    private Pair<Column,Row> D8 = new Pair<>(Column.D,Row.EIGHT);
//
//    private Pair<Column,Row> E1 = new Pair<>(Column.E,Row.ONE);
//    private Pair<Column,Row> E2 = new Pair<>(Column.E,Row.TWO);
//    private Pair<Column,Row> E3 = new Pair<>(Column.E,Row.THREE);
//    private Pair<Column,Row> E4 = new Pair<>(Column.E,Row.FOUR);
//    private Pair<Column,Row> E5 = new Pair<>(Column.E,Row.FIVE);
//    private Pair<Column,Row> E6 = new Pair<>(Column.E,Row.SIX);
//    private Pair<Column,Row> E7 = new Pair<>(Column.E,Row.SEVEN);
//    private Pair<Column,Row> E8 = new Pair<>(Column.E,Row.EIGHT);
//
//    private Pair<Column,Row> F1 = new Pair<>(Column.F,Row.ONE);
//    private Pair<Column,Row> F2 = new Pair<>(Column.F,Row.TWO);
//    private Pair<Column,Row> F3 = new Pair<>(Column.F,Row.THREE);
//    private Pair<Column,Row> F4 = new Pair<>(Column.F,Row.FOUR);
//    private Pair<Column,Row> F5 = new Pair<>(Column.F,Row.FIVE);
//    private Pair<Column,Row> F6 = new Pair<>(Column.F,Row.SIX);
//    private Pair<Column,Row> F7 = new Pair<>(Column.F,Row.SEVEN);
//    private Pair<Column,Row> F8 = new Pair<>(Column.F,Row.EIGHT);
//
//    private Pair<Column,Row> G1 = new Pair<>(Column.G,Row.ONE);
//    private Pair<Column,Row> G2 = new Pair<>(Column.G,Row.TWO);
//    private Pair<Column,Row> G3 = new Pair<>(Column.G,Row.THREE);
//    private Pair<Column,Row> G4 = new Pair<>(Column.G,Row.FOUR);
//    private Pair<Column,Row> G5 = new Pair<>(Column.G,Row.FIVE);
//    private Pair<Column,Row> G6 = new Pair<>(Column.G,Row.SIX);
//    private Pair<Column,Row> G7 = new Pair<>(Column.G,Row.SEVEN);
//    private Pair<Column,Row> G8 = new Pair<>(Column.G,Row.EIGHT);
//
//    private Pair<Column,Row> H1 = new Pair<>(Column.H,Row.ONE);
//    private Pair<Column,Row> H2 = new Pair<>(Column.H,Row.TWO);
//    private Pair<Column,Row> H3 = new Pair<>(Column.H,Row.THREE);
//    private Pair<Column,Row> H4 = new Pair<>(Column.H,Row.FOUR);
//    private Pair<Column,Row> H5 = new Pair<>(Column.H,Row.FIVE);
//    private Pair<Column,Row> H6 = new Pair<>(Column.H,Row.SIX);
//    private Pair<Column,Row> H7 = new Pair<>(Column.H,Row.SEVEN);
//    private Pair<Column,Row> H8 = new Pair<>(Column.H,Row.EIGHT);
//
//    private Pawn pawna2 = new Pawn(Piece.Color.WHITE,A2);
//    private Pawn pawnb2 = new Pawn(Piece.Color.WHITE,B2);
//    private Pawn pawnc2 = new Pawn(Piece.Color.WHITE,C2);
//    private Pawn pawnd2 = new Pawn(Piece.Color.WHITE,D2);
//    private Pawn pawne2 = new Pawn(Piece.Color.WHITE,E2);
//    private Pawn pawnf2 = new Pawn(Piece.Color.WHITE,F2);
//    private Pawn pawng2 = new Pawn(Piece.Color.WHITE,G2);
//    private Pawn pawnh2 = new Pawn(Piece.Color.WHITE,H2);
//
//    private Rook rookA1 = new Rook(Piece.Color.WHITE,A1);
//    private Rook rookH1 = new Rook(Piece.Color.WHITE,H1);
//    private Rook rookA8 = new Rook(Piece.Color.BLACK,A8);
//    private Rook rookH8 = new Rook(Piece.Color.BLACK,H8);
//
//    private Bishop bishopC1 = new Bishop(Piece.Color.WHITE,C1);
//    private Bishop bishopF1 = new Bishop(Piece.Color.WHITE,F1);
//    private Bishop bishopC8 = new Bishop(Piece.Color.BLACK,C8);
//    private Bishop bishopF8 = new Bishop(Piece.Color.BLACK,F8);
//
//    private Knight knightB1 = new Knight(Piece.Color.WHITE,B1);
//    private Knight knightG1 = new Knight(Piece.Color.WHITE,G1);
//    private Knight knightB8 = new Knight(Piece.Color.BLACK,B8);
//    private Knight knightG8 = new Knight(Piece.Color.BLACK,G8);
//
//    private Queen queend1 = new Queen(Piece.Color.WHITE,D1);
//    private Queen queend8 = new Queen(Piece.Color.BLACK,D8);
//
//    private King kinge1 = new King(Piece.Color.WHITE, E1);
//    private King kinge8 = new King(Piece.Color.BLACK, E8);
//
//    private Pawn pawna7 = new Pawn(Piece.Color.BLACK,A7);
//    private Pawn pawnb7 = new Pawn(Piece.Color.BLACK,B7);
//    private Pawn pawnc7 = new Pawn(Piece.Color.BLACK,C7);
//    private Pawn pawnd7 = new Pawn(Piece.Color.BLACK,D7);
//    private Pawn pawne7 = new Pawn(Piece.Color.BLACK,E7);
//    private Pawn pawnf7 = new Pawn(Piece.Color.BLACK,F7);
//    private Pawn pawng7 = new Pawn(Piece.Color.BLACK,G7);
//    private Pawn pawnh7 = new Pawn(Piece.Color.BLACK,H7);
//
//    private Piece nullPiece = null;
//
//    private Tile[][] rightBoard = new Tile[8][8];
//
//
//    public void initRightBoard(Tile[][] rightBoard){
//        rightBoard[0][0] = new Tile(A8,rookA8);
//        rightBoard[0][1] = new Tile(B8,knightB8);
//        rightBoard[0][2] = new Tile(C8,bishopC8);
//        rightBoard[0][3] = new Tile(D8,queend8);
//        rightBoard[0][4] = new Tile(E8,kinge8);
//        rightBoard[0][5] = new Tile(F8,bishopF8);
//        rightBoard[0][6] = new Tile(G8,knightG8);
//        rightBoard[0][7] = new Tile(H8,rookH8);
//
//        rightBoard[1][0] = new Tile(A7,pawna7);
//        rightBoard[1][1] = new Tile(B7,pawnb7);
//        rightBoard[1][2] = new Tile(C7,pawnc7);
//        rightBoard[1][3] = new Tile(D7,pawnd7);
//        rightBoard[1][4] = new Tile(E7,pawne7);
//        rightBoard[1][5] = new Tile(F7,pawnf7);
//        rightBoard[1][6] = new Tile(G7,pawng7);
//        rightBoard[1][7] = new Tile(H7,pawnh7);
//
//        rightBoard[2][0] = new Tile(A6,null);
//        rightBoard[2][1] = new Tile(B6,null);
//        rightBoard[2][2] = new Tile(C6,null);
//        rightBoard[2][3] = new Tile(D6,null);
//        rightBoard[2][4] = new Tile(E6,null);
//        rightBoard[2][5] = new Tile(F6,null);
//        rightBoard[2][6] = new Tile(G6,null);
//        rightBoard[2][7] = new Tile(H6,null);
//
//
//        rightBoard[3][0] = new Tile(A5,null);
//        rightBoard[3][1] = new Tile(B5,null);
//        rightBoard[3][2] = new Tile(C5,null);
//        rightBoard[3][3] = new Tile(D5,null);
//        rightBoard[3][4] = new Tile(E5,null);
//        rightBoard[3][5] = new Tile(F5,null);
//        rightBoard[3][6] = new Tile(G5,null);
//        rightBoard[3][7] = new Tile(H5,null);
//
//        rightBoard[4][0] = new Tile(A4,null);
//        rightBoard[4][1] = new Tile(B4,null);
//        rightBoard[4][2] = new Tile(C4,null);
//        rightBoard[4][3] = new Tile(D4,null);
//        rightBoard[4][4] = new Tile(E4,null);
//        rightBoard[4][5] = new Tile(F4,null);
//        rightBoard[4][6] = new Tile(G4,null);
//        rightBoard[4][7] = new Tile(H4,null);
//
//        rightBoard[5][0] = new Tile(A3,null);
//        rightBoard[5][1] = new Tile(B3,null);
//        rightBoard[5][2] = new Tile(C3,null);
//        rightBoard[5][3] = new Tile(D3,null);
//        rightBoard[5][4] = new Tile(E3,null);
//        rightBoard[5][5] = new Tile(F3,null);
//        rightBoard[5][6] = new Tile(G3,null);
//        rightBoard[5][7] = new Tile(H3,null);
//
//        rightBoard[6][0] = new Tile(A2,pawna2);
//        rightBoard[6][1] = new Tile(B2,pawnb2);
//        rightBoard[6][2] = new Tile(C2,pawnc2);
//        rightBoard[6][3] = new Tile(D2,pawnd2);
//        rightBoard[6][4] = new Tile(E2,pawne2);
//        rightBoard[6][5] = new Tile(F2,pawnf2);
//        rightBoard[6][6] = new Tile(G2,pawng2);
//        rightBoard[6][7] = new Tile(H2,pawnh2);
//
//        rightBoard[7][0] = new Tile(A1,rookA1);
//        rightBoard[7][1] = new Tile(B1,knightB1);
//        rightBoard[7][2] = new Tile(C1,bishopC1);
//        rightBoard[7][3] = new Tile(D1,queend1);
//        rightBoard[7][4] = new Tile(E1,kinge1);
//        rightBoard[7][5] = new Tile(F1,bishopF1);
//        rightBoard[7][6] = new Tile(G1,knightG1);
//        rightBoard[7][7] = new Tile(H1,rookH1);
//
//
//    }
//
//    @Test
//    public void initTiles() {
//        Tile[][] rightBoard1 = new Tile[8][8];
//        initRightBoard(rightBoard1);
//        GameManager board = new GameManager();
//        Tile toTest[][] = board.getTiles();
//        for(int i = 0; i < 8; i++){
//                assertArrayEquals(toTest[i], rightBoard1[i]);
//        }
//
//
//    }
//}