package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RookTest {

    private Rook equ1 = new Rook(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Queen equ2 = new Queen(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Integer equ3 = 5;
    private Rook equ4 = new Rook(Piece.Color.WHITE,new Pair<>(Column.D, Row.ONE));
    private Rook equ5 = new Rook(Piece.Color.BLACK,new Pair<>(Column.E, Row.FIVE));
    private Rook equ6 = new Rook(Piece.Color.WHITE,new Pair<>(Column.F, Row.SEVEN));
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
    public void calculateAllPossibleMoves(){
        System.out.println("calculateAllPossibleMoves Test has started");
        setemptyboard1();
        Set<Pair<Column,Row>> possibleMoves1 = new HashSet(Arrays.asList(
                Coordinates.D8,
                Coordinates.D7,
                Coordinates.D6,
                Coordinates.A5,Coordinates.B5,Coordinates.C5,Coordinates.E5,Coordinates.F5,Coordinates.G5,Coordinates.H5,
                Coordinates.D4,
                Coordinates.D3,
                Coordinates.D2,
                Coordinates.D1
        ));
        Set<Pair<Column,Row>> possibleMoves2 = new HashSet(Arrays.asList(
                Coordinates.B8,Coordinates.C8,Coordinates.D8,Coordinates.E8,Coordinates.F8,Coordinates.G8,Coordinates.H8,
                Coordinates.A7,
                Coordinates.A6,
                Coordinates.A5,
                Coordinates.A4,
                Coordinates.A3,
                Coordinates.A2,
                Coordinates.A1
        ));
        Set<Pair<Column,Row>> possibleMoves3 = new HashSet(Arrays.asList(
                Coordinates.B8
        ));
        Set<Pair<Column,Row>> possibleMoves4 = new HashSet(Arrays.asList(
                Coordinates.D7,
                Coordinates.D6,
                Coordinates.B5,Coordinates.C5,Coordinates.E5,
                Coordinates.D4
        ));
        //queen on d5 without obstacles
        Rook toTest = new Rook(Piece.Color.WHITE,Coordinates.D5);
        currentBoard[3][3].setCurrentPiece(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        Set<Pair<Column,Row>> results = toTest.getPossibleMoves();
        assertEquals("Error --> when rook on D5",possibleMoves1, results);
        System.out.println("rook on D5 passed");
        currentBoard[3][3].setCurrentPiece(null);
        //queen on a8 without obstacles
        toTest.setCoordinate(Coordinates.A8);
        currentBoard[0][0].setCurrentPiece(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when rook on A8",possibleMoves2, results);
        System.out.println("rook on A8 passed");
        //queen on a8 with obstacles
        currentBoard[1][0].setCurrentPiece(new Rook(Piece.Color.WHITE,Coordinates.A7));
        currentBoard[0][1].setCurrentPiece(new Rook(Piece.Color.BLACK,Coordinates.B8));
        currentBoard[2][1].setCurrentPiece(new Rook(Piece.Color.WHITE,Coordinates.B6));
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when rook on A8 with obstacles",possibleMoves3, results);
        System.out.println("rook on A8 with obstacles passed");
        currentBoard[1][0].setCurrentPiece(null);
        currentBoard[0][1].setCurrentPiece(null);
        currentBoard[2][1].setCurrentPiece(null);
        currentBoard[0][0].setCurrentPiece(null);
        toTest.setCoordinate(Coordinates.D5);
        currentBoard[3][3].setCurrentPiece(toTest);

        currentBoard[1][1].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinates.B7));
        currentBoard[1][3].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinates.D7));
        currentBoard[1][5].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinates.F7));
        currentBoard[3][1].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinates.B5));
        currentBoard[3][5].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinates.F5));
        currentBoard[4][2].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinates.C4));
        currentBoard[4][4].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinates.E4));
        currentBoard[5][1].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinates.B3));
        currentBoard[5][3].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinates.D3));
        currentBoard[5][5].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinates.F3));
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when rook on D5 with obstacles",possibleMoves4, results);
        System.out.println("rook on D5 with obstacles passed");
    }

    @Test
    public void equals() {
        Rook toTest = new Rook(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
        assertTrue("Error --> 1st sample", toTest.equals(equ1));
        assertFalse("Error --> 2nd sample", toTest.equals(equ2));
        assertFalse("Error --> 3rd sample", toTest.equals(equ3));
        assertFalse("Error --> 4th sample", toTest.equals(equ4));
        assertFalse("Error --> 5th sample", toTest.equals(equ5));
        assertFalse("Error --> 6th sample", toTest.equals(equ6));
        System.out.println("Equals test passed!");

    }
}