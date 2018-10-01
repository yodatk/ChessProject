package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PawnTest {
    private Pawn equ1 = new Pawn(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Rook equ2 = new Rook(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Integer equ3 = 5;
    private Pawn equ4 = new Pawn(Piece.Color.WHITE,new Pair<>(Column.D, Row.ONE));
    private Pawn equ5 = new Pawn(Piece.Color.BLACK,new Pair<>(Column.E, Row.FIVE));
    private Pawn equ6 = new Pawn(Piece.Color.WHITE,new Pair<>(Column.F, Row.SEVEN));

    private Tile[][] currentBoard;


    private void setemptyboard1(){
        Board board = new Board();
        currentBoard = board.getTiles();

        currentBoard[0][0].setCurrentPiece(null);
        currentBoard[0][1].setCurrentPiece(null);
        currentBoard[0][2].setCurrentPiece(null);
        currentBoard[0][3].setCurrentPiece(null);
        currentBoard[0][4].setCurrentPiece(null);
        currentBoard[0][5].setCurrentPiece(null);
        currentBoard[0][6].setCurrentPiece(null);
        currentBoard[0][7].setCurrentPiece(null);

        currentBoard[1][0].setCurrentPiece(null);
        currentBoard[1][1].setCurrentPiece(null);
        currentBoard[1][2].setCurrentPiece(null);
        currentBoard[1][3].setCurrentPiece(null);
        currentBoard[1][4].setCurrentPiece(null);
        currentBoard[1][5].setCurrentPiece(null);
        currentBoard[1][6].setCurrentPiece(null);
        currentBoard[1][7].setCurrentPiece(null);

        currentBoard[6][0].setCurrentPiece(null);
        currentBoard[6][1].setCurrentPiece(null);
        currentBoard[6][2].setCurrentPiece(null);
        currentBoard[6][3].setCurrentPiece(null);
        currentBoard[6][4].setCurrentPiece(null);
        currentBoard[6][5].setCurrentPiece(null);
        currentBoard[6][6].setCurrentPiece(null);
        currentBoard[6][7].setCurrentPiece(null);


        currentBoard[7][0].setCurrentPiece(null);
        currentBoard[7][1].setCurrentPiece(null);
        currentBoard[7][2].setCurrentPiece(null);
        currentBoard[7][3].setCurrentPiece(null);
        currentBoard[7][4].setCurrentPiece(null);
        currentBoard[7][5].setCurrentPiece(null);
        currentBoard[7][6].setCurrentPiece(null);
        currentBoard[7][7].setCurrentPiece(null);


    }

    @Test
    public void calculateAllPossibleMoves() {
        System.out.println("====== calculateAllPossibleMoves Test has started =====");
        setemptyboard1();
        Set<Pair<Column,Row>> possibleMoves1 = new HashSet(Arrays.asList(
                Coordinates.D3,Coordinates.D4
        ));
        Set<Pair<Column,Row>> possibleMoves2 = new HashSet(Arrays.asList(
                Coordinates.D3,Coordinates.D4,
                Coordinates.C3
        ));
        Set<Pair<Column,Row>> possibleMoves3 = new HashSet(Arrays.asList(

        ));
        Set<Pair<Column,Row>> possibleMoves4 = new HashSet(Arrays.asList(
                Coordinates.B6,Coordinates.C6
        ));
        Set<Pair<Column,Row>> possibleMoves5 = new HashSet(Arrays.asList(
                Coordinates.D6,Coordinates.C6
        ));
        //queen on d5 without obstacles
        Pawn toTest = new Pawn(Piece.Color.WHITE,Coordinates.D2);
        setemptyboard1();
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> Pawn on D2",possibleMoves1, toTest.getPossibleMoves());
        System.out.println("Pawn on D2  passed");
        currentBoard[5][2].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinates.C3));
        currentBoard[5][4].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinates.E3));
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> Pawn on D2 with diagonals",possibleMoves2, toTest.getPossibleMoves());
        System.out.println("Pawn on D2 with obstacles passed");
        currentBoard[5][2].setCurrentPiece(null);
        currentBoard[5][4].setCurrentPiece(null);

        currentBoard[4][0].setCurrentPiece(new Rook(Piece.Color.BLACK,Coordinates.A4));
        toTest = new Pawn(Piece.Color.WHITE,Coordinates.A3);
        toTest.setHasBeenMoved(true);
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> Pawn on A3 with obstacles",possibleMoves3, toTest.getPossibleMoves());
        System.out.println("Pawn on A3 with obstacles passed");
        currentBoard[4][0].setCurrentPiece(null);

        currentBoard[4][7].setCurrentPiece(new Rook(Piece.Color.WHITE,Coordinates.H4));
        toTest= new Pawn(Piece.Color.WHITE,Coordinates.H3);
        toTest.setHasBeenMoved(true);
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> Pawn on H3 with obstacles",possibleMoves3, toTest.getPossibleMoves());
        System.out.println("Pawn on H3 with obstacles passed");
        currentBoard[4][7].setCurrentPiece(null);

        toTest= new Pawn(Piece.Color.WHITE,Coordinates.C5);
        toTest.setHasBeenMoved(true);
        currentBoard[3][1].setCurrentPiece(new Pawn(Piece.Color.BLACK,Coordinates.B5));
        ((Pawn)currentBoard[3][1].getCurrentPiece()).setCanBeKilledFromBehind(true);
        currentBoard[3][3].setCurrentPiece(new Pawn(Piece.Color.BLACK,Coordinates.D5));
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> Pawn on C5 kill from behind left ",possibleMoves4, toTest.getPossibleMoves());
        System.out.println("Pawn on C5 kill from behind left passed");

        ((Pawn)currentBoard[3][1].getCurrentPiece()).setCanBeKilledFromBehind(false);
        ((Pawn)currentBoard[3][3].getCurrentPiece()).setCanBeKilledFromBehind(true);
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> Pawn on C5 kill from behind right ",possibleMoves5, toTest.getPossibleMoves());
        System.out.println("Pawn on C5 kill from behind right passed");

    }

    @Test
    public void equals() {
        Pawn toTest = new Pawn(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
        assertTrue("Error --> 1st sample", toTest.equals(equ1));
        assertFalse("Error --> 2nd sample", toTest.equals(equ2));
        assertFalse("Error --> 3rd sample", toTest.equals(equ3));
        assertFalse("Error --> 4th sample", toTest.equals(equ4));
        assertFalse("Error --> 5th sample", toTest.equals(equ5));
        assertFalse("Error --> 6th sample", toTest.equals(equ6));
        System.out.println("Equals test passed!");
    }
}