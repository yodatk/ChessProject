package logic.pieces;


import logic.board.Board;
import logic.board.Coordinate;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class QueenTest {


    private Queen equ1 = new Queen(Piece.Color.BLACK, Coordinate.D1);
    private Rook equ2 = new Rook(Piece.Color.BLACK, Coordinate.D1);
    private Integer equ3 = 5;
    private Queen equ4 = new Queen(Piece.Color.WHITE, Coordinate.D1);
    private Queen equ5 = new Queen(Piece.Color.BLACK, Coordinate.E5);
    private Queen equ6 = new Queen(Piece.Color.WHITE, Coordinate.F7);
    private Queen equ7 = null;


    private Board currentBoard;

    @Test
    public void calculateAllPossibleMoves() {
        System.out.println("calculateAllPossibleMoves Test has started");
        currentBoard = new Board(Board.BoardMode.EMPTY);
        Set<Coordinate> possibleMoves1 = new HashSet(Arrays.asList(
                Coordinate.A8, Coordinate.D8, Coordinate.G8,
                Coordinate.B7, Coordinate.D7, Coordinate.F7,
                Coordinate.C6, Coordinate.D6, Coordinate.E6,
                Coordinate.A5, Coordinate.B5, Coordinate.C5, Coordinate.E5, Coordinate.F5, Coordinate.G5, Coordinate.H5,
                Coordinate.C4, Coordinate.D4, Coordinate.E4,
                Coordinate.B3, Coordinate.D3, Coordinate.F3,
                Coordinate.A2, Coordinate.D2, Coordinate.G2,
                Coordinate.D1, Coordinate.H1
        ));
        Set<Coordinate> possibleMoves2 = new HashSet(Arrays.asList(
                Coordinate.B8, Coordinate.C8, Coordinate.D8, Coordinate.E8, Coordinate.F8, Coordinate.G8, Coordinate.H8,
                Coordinate.A7, Coordinate.B7,
                Coordinate.A6, Coordinate.C6,
                Coordinate.A5, Coordinate.D5,
                Coordinate.A4, Coordinate.E4,
                Coordinate.A3, Coordinate.F3,
                Coordinate.A2, Coordinate.G2,
                Coordinate.A1, Coordinate.H1
        ));
        Set<Coordinate> possibleMoves3 = new HashSet(Arrays.asList(
                Coordinate.B8,
                Coordinate.B7,
                Coordinate.C6,
                Coordinate.D5,
                Coordinate.E4,
                Coordinate.F3,
                Coordinate.G2,
                Coordinate.H1
        ));
        Set<Coordinate> possibleMoves4 = new HashSet(Arrays.asList(
                Coordinate.D7, Coordinate.F7,
                Coordinate.C6, Coordinate.D6, Coordinate.E6,
                Coordinate.B5, Coordinate.C5, Coordinate.E5,
                Coordinate.C4, Coordinate.D4
        ));
        //queen on d5 without obstacles
        Queen toTest = new Queen(Piece.Color.WHITE, Coordinate.D5);
        currentBoard.setGivenPieceOnBoard(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        Set<Coordinate> results = toTest.getPossibleMoves();
        assertEquals("Error --> when queen on D5", possibleMoves1, results);
        System.out.println("queen on D5 passed");
        currentBoard.emptyAGivenTileCoordination(Coordinate.D5);

        //queen on a8 without obstacles
        toTest.setCoordinate(Coordinate.A8);
        currentBoard.setGivenPieceOnBoard(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when queen on A8", possibleMoves2, results);
        System.out.println("queen on A8 passed");
        //queen on a8 with obstacles
        currentBoard.setGivenPieceOnBoard(new Rook(Piece.Color.WHITE, Coordinate.A7));
        currentBoard.setGivenPieceOnBoard(new Rook(Piece.Color.BLACK, Coordinate.B8));
        currentBoard.setGivenPieceOnBoard(new Rook(Piece.Color.WHITE, Coordinate.B6));
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when queen on A8 with obstacles", possibleMoves3, results);
        System.out.println("queen on A8 with obstacles passed");
        currentBoard.initEmptyBoard();
        toTest.setCoordinate(Coordinate.D5);
        currentBoard.setGivenPieceOnBoard(toTest);

        currentBoard.setGivenPieceOnBoard(new Pawn(Piece.Color.WHITE, Coordinate.B7));
        currentBoard.setGivenPieceOnBoard(new Pawn(Piece.Color.BLACK, Coordinate.D7));
        currentBoard.setGivenPieceOnBoard(new Pawn(Piece.Color.BLACK, Coordinate.F7));
        currentBoard.setGivenPieceOnBoard(new Pawn(Piece.Color.BLACK, Coordinate.B5));
        currentBoard.setGivenPieceOnBoard(new Pawn(Piece.Color.WHITE, Coordinate.F5));
        currentBoard.setGivenPieceOnBoard(new Pawn(Piece.Color.BLACK, Coordinate.C4));
        currentBoard.setGivenPieceOnBoard(new Pawn(Piece.Color.WHITE, Coordinate.E4));
        currentBoard.setGivenPieceOnBoard(new Pawn(Piece.Color.WHITE, Coordinate.B3));
        currentBoard.setGivenPieceOnBoard(new Pawn(Piece.Color.WHITE, Coordinate.D3));
        currentBoard.setGivenPieceOnBoard(new Pawn(Piece.Color.BLACK, Coordinate.F3));
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when queen on D5 with obstacles", possibleMoves4, results);
        System.out.println("queen on D5 with obstacles passed");


    }

    @Test
    public void equals() {
        Queen toTest = new Queen(Piece.Color.BLACK, Coordinate.D1);
        assertTrue("Error --> first sample", toTest.equals(equ1));
        assertTrue("Error --> 1st sample", toTest.equals(equ1));
        assertFalse("Error --> 2nd sample", toTest.equals(equ2));
        assertFalse("Error --> 3rd sample", toTest.equals(equ3));
        assertFalse("Error --> 4th sample", toTest.equals(equ4));
        assertFalse("Error --> 5th sample", toTest.equals(equ5));
        assertFalse("Error --> 6th sample", toTest.equals(equ6));
        assertFalse("Error --> 7th sample", toTest.equals(equ7));

        System.out.println("Equals test passed!");

    }
}