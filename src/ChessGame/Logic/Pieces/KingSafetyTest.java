package ChessGame.Logic.Pieces;
import ChessGame.Logic.*;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

public class KingSafetyTest {

    private Board board;

    @Test
    public void kingSafetyTest(){
        System.out.println(" === King safety test begins ===");
        board = new Board(Board.BoardMode.EMPTY);
        King whiteKing = new King(Piece.Color.WHITE,Coordinate.H1);
        Queen blackQueen = new Queen(Piece.Color.BLACK,Coordinate.F3);
        // test#1 --> king on H1, queen on F3
        Set<Coordinate> possibleMoves1 =  new HashSet<>(Arrays.asList(
                Coordinate.G1,Coordinate.H2
        ));
        board.getTileByCoordination(Coordinate.H1).setCurrentPiece(whiteKing);
        board.getTileByCoordination(Coordinate.F3).setCurrentPiece(blackQueen);
        board.getBlacksPieces().add(blackQueen);
        board.getWhitesPieces().add(whiteKing);

        blackQueen.calculateAllPossibleMoves(board);
        whiteKing.calculateAllPossibleMoves(board);
        assertEquals("Error --> king on H1",possibleMoves1,whiteKing.getPossibleMoves());
        System.out.println(" --> King on H1 with queen test passed");
        board.getTileByCoordination(Coordinate.H1).setCurrentPiece(null);
        board.getTileByCoordination(Coordinate.F3).setCurrentPiece(null);
        board.getBlacksPieces().remove(blackQueen);


        // test#2&3 --> king on G1, queen on A1, Rook on F2
        Set<Coordinate> possibleMoves2 =  new HashSet<>(Arrays.asList(
                Coordinate.G2,Coordinate.H2
        ));
        Set<Coordinate> possibleMoves3 =  new HashSet<>(Arrays.asList(
                Coordinate.F1
        ));

        whiteKing.setCoordinate(Coordinate.G1);
        //blackQueen.setCoordinate(Coordinate.A1);
        blackQueen = new Queen(Piece.Color.BLACK,Coordinate.A1);
        Rook whiteRook = new Rook(Piece.Color.WHITE,Coordinate.F2, whiteKing);

        board.getTileByCoordination(Coordinate.F2).setCurrentPiece(whiteRook);
        board.getTileByCoordination(Coordinate.G1).setCurrentPiece(whiteKing);
        board.getTileByCoordination(Coordinate.A1).setCurrentPiece(blackQueen);
        board.getBlacksPieces().add(blackQueen);
        board.getWhitesPieces().add(whiteRook);

        blackQueen.calculateAllPossibleMoves(board);
        whiteRook.calculateAllPossibleMoves(board);
        whiteKing.calculateAllPossibleMoves(board);

        assertEquals("Error --> invalid king moves when king on G1(test2)",possibleMoves2,whiteKing.getPossibleMoves());
        System.out.println(" --> King on G1:\nTest 2 passed");
        assertEquals("Error --> invalid rook moves when king on G1(test3)",possibleMoves3,whiteRook.getPossibleMoves());
        System.out.println("Test 3 passed");

        whiteRook.setCoordinate(Coordinate.F1);
        board.getTileByCoordination(Coordinate.F2).setCurrentPiece(null);
        board.getTileByCoordination(Coordinate.F1).setCurrentPiece(whiteRook);

        blackQueen.calculateAllPossibleMoves(board);
        whiteRook.calculateAllPossibleMoves(board);
        whiteKing.calculateAllPossibleMoves(board);
        Set<Coordinate> possibleMoves4 =  new HashSet<>(Arrays.asList(
                Coordinate.G2,Coordinate.H2, Coordinate.F2,
                Coordinate.H1
        ));
        Set<Coordinate> possibleMoves5 =  new HashSet<>(Arrays.asList(
                Coordinate.E1,Coordinate.D1,Coordinate.C1,Coordinate.B1,Coordinate.A1
        ));
        assertEquals("Error --> invalid king moves when king on G1(test4)",possibleMoves4,whiteKing.getPossibleMoves());
        System.out.println("Test 4 passed");
        assertEquals("Error --> invalid rook moves when king on G1(test5)",possibleMoves5,whiteRook.getPossibleMoves());
        System.out.println("Test 5 passed");

        board = new Board(Board.BoardMode.EMPTY);
        Rook whiteRook2 = new Rook (Piece.Color.WHITE,Coordinate.H1,whiteKing);
        Pawn p1 = new Pawn(Piece.Color.WHITE,Coordinate.H2,whiteKing);
        Pawn p2 = new Pawn(Piece.Color.WHITE,Coordinate.G2,whiteKing);
        Pawn p3 = new Pawn(Piece.Color.WHITE,Coordinate.F2,whiteKing);
        Knight blackKnight = new Knight(Piece.Color.BLACK,Coordinate.F3);


        board.getTileByCoordination(Coordinate.F1).setCurrentPiece(whiteRook);
        board.getTileByCoordination(Coordinate.G1).setCurrentPiece(whiteKing);
        board.getTileByCoordination(Coordinate.H1).setCurrentPiece(whiteRook2);
        board.getTileByCoordination(Coordinate.H2).setCurrentPiece(p1);
        board.getTileByCoordination(Coordinate.G2).setCurrentPiece(p2);
        board.getTileByCoordination(Coordinate.F2).setCurrentPiece(p3);
        board.getTileByCoordination(Coordinate.F3).setCurrentPiece(blackKnight);

        board.getWhitesPieces().add(whiteKing);
        board.getWhitesPieces().add(whiteRook);
        board.getWhitesPieces().add(whiteRook2);
        board.getWhitesPieces().add(p1);
        board.getWhitesPieces().add(p2);
        board.getWhitesPieces().add(p3);
        board.getBlacksPieces().add(blackKnight);



        blackKnight.calculateAllPossibleMoves(board);
        whiteRook.calculateAllPossibleMoves(board);
        whiteRook2.calculateAllPossibleMoves(board);
        p1.calculateAllPossibleMoves(board);
        p2.calculateAllPossibleMoves(board);
        p3.calculateAllPossibleMoves(board);
        whiteKing.calculateAllPossibleMoves(board);

        Set<Coordinate> possibleMoves6 =  new HashSet<>(Arrays.asList(
                Coordinate.F3
        ));
        Set<Coordinate> possibleMoves7 =  new HashSet<>(Arrays.asList(

        ));

        assertEquals("Error --> invalid pawn moves when king is stuck on G1(test6)",possibleMoves6,p2.getPossibleMoves());
        System.out.println("Test 6 passed");
        assertEquals("Error --> invalid pawn moves when king is stuck on G1(test7)",possibleMoves7,p1.getPossibleMoves());
        System.out.println("Test 7 passed");
        assertEquals("Error --> invalid pawn moves when king is stuck on G1(test8)",possibleMoves7,p3.getPossibleMoves());
        System.out.println("Test 8 passed");
        assertEquals("Error --> invalid king moves when king is stuck on G1(test9)",possibleMoves7,whiteKing.getPossibleMoves());
        System.out.println("Test 9 passed");
        assertEquals("Error --> invalid rook moves when king is stuck on G1(test10)",possibleMoves7,whiteRook.getPossibleMoves());
        System.out.println("Test 10 passed");
        assertEquals("Error --> invalid rook moves when king is stuck on G1(test11)",possibleMoves7,whiteRook2.getPossibleMoves());
        System.out.println("Test 11 passed");


        board.getBlacksPieces().clear();
        King blackKing = Board.blackKing;

        board.getTileByCoordination(blackKing.getCoordinate()).setCurrentPiece(blackKing);
        blackKnight = new Knight(Piece.Color.BLACK,Coordinate.F3,blackKing);
        board.getTileByCoordination(blackKing.getCoordinate()).setCurrentPiece(blackKnight);
        board.getBlacksPieces().add(blackKing);
        board.getBlacksPieces().add(blackKnight);

        blackKing.calculateAllPossibleMoves(board);
        blackKnight.calculateAllPossibleMoves(board);
        whiteRook.calculateAllPossibleMoves(board);
        whiteRook2.calculateAllPossibleMoves(board);
        p1.calculateAllPossibleMoves(board);
        p2.calculateAllPossibleMoves(board);
        p3.calculateAllPossibleMoves(board);
        whiteKing.calculateAllPossibleMoves(board);


        assertEquals("Error --> invalid pawn moves when king is stuck on G1(Test 12)",possibleMoves6,p2.getPossibleMoves());
        System.out.println("Test 12 passed");
        assertEquals("Error --> invalid pawn moves when king is stuck on G1(Test 13)",possibleMoves7,p1.getPossibleMoves());
        System.out.println("Test 13 passed");
        assertEquals("Error --> invalid pawn moves when king is stuck on G1(Test 14)",possibleMoves7,p3.getPossibleMoves());
        System.out.println("Test 14 passed");
        assertEquals("Error --> invalid king moves when king is stuck on G1(Test 15)",possibleMoves7,whiteKing.getPossibleMoves());
        System.out.println("Test 15 passed");
        assertEquals("Error --> invalid rook moves when king is stuck on G1(Test 16)",possibleMoves7,whiteRook.getPossibleMoves());
        System.out.println("Test 16 passed");
        assertEquals("Error --> invalid rook moves when king is stuck on G1(Test 17)",possibleMoves7,whiteRook2.getPossibleMoves());
        System.out.println("Test 17 passed");
        
    }
}
