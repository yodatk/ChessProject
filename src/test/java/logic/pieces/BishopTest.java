package logic.pieces;

import static org.junit.Assert.*;

import logic.board.Board;
import logic.board.Coordinate;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



public class BishopTest {
    private Bishop equ1 = new Bishop(Piece.Color.BLACK, Coordinate.D1);
    private Queen equ2 = new Queen(Piece.Color.BLACK, Coordinate.D1);
    private Integer equ3 = 5;
    private Bishop equ4 = new Bishop(Piece.Color.WHITE, Coordinate.D1);
    private Bishop equ5 = new Bishop(Piece.Color.BLACK, Coordinate.E5);
    private Bishop equ6 = new Bishop(Piece.Color.WHITE, Coordinate.F7);
    private Board currentBoard;



    @Test
    public void calculateAllPossibleMoves() {
        System.out.println("calculateAllPossibleMoves Test has started");
        Board currentBoard = new Board(Board.BoardMode.EMPTY);
        Set<Coordinate> possibleMoves1 = new HashSet(Arrays.asList(
                Coordinate.A8, Coordinate.G8,
                Coordinate.B7, Coordinate.F7,
                Coordinate.C6, Coordinate.E6,
                Coordinate.C4, Coordinate.E4,
                Coordinate.B3, Coordinate.F3,
                Coordinate.A2, Coordinate.G2,
                Coordinate.H1
        ));
        Set<Coordinate> possibleMoves2 = new HashSet(Arrays.asList(
                Coordinate.B7,
                Coordinate.C6,
                Coordinate.D5,
                Coordinate.E4,
                Coordinate.F3,
                Coordinate.G2,
                Coordinate.H1
        ));
        Set<Coordinate> possibleMoves3 = new HashSet(Arrays.asList(
                Coordinate.B7,
                Coordinate.C6

        ));
        Set<Coordinate> possibleMoves4 = new HashSet(Arrays.asList(
                Coordinate.F7,
                Coordinate.C6, Coordinate.E6,
                Coordinate.C4
        ));
        //Bishop on d5 without obstacles
        Bishop toTest = new Bishop(Piece.Color.WHITE, Coordinate.D5);
        currentBoard.setGivenPieceOnBoard(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        Set<Coordinate> results = toTest.getPossibleMoves();
        assertEquals("Error --> when Bishop on D5", possibleMoves1, results);
        System.out.println("Bishop on D5 passed");
        currentBoard.emptyAGivenTileCoordination(Coordinate.D5);

        //Bishop on a8 without obstacles
        toTest.setCoordinate(Coordinate.A8);
        currentBoard.setGivenPieceOnBoard(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Bishop on A8", possibleMoves2, results);
        System.out.println("Bishop on A8 passed");
        //Bishop on a8 with obstacles
        currentBoard.setGivenPieceOnBoard(new Rook(Piece.Color.WHITE, Coordinate.A7));
        currentBoard.setGivenPieceOnBoard(new Rook(Piece.Color.BLACK, Coordinate.B8));
        currentBoard.setGivenPieceOnBoard(new Rook(Piece.Color.WHITE, Coordinate.D5));
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Bishop on A8 with obstacles", possibleMoves3, results);
        System.out.println("Bishop on A8 with obstacles passed");
        currentBoard.emptyAGivenTileCoordination(Coordinate.A7);
        currentBoard.emptyAGivenTileCoordination(Coordinate.B8);
        currentBoard.emptyAGivenTileCoordination(Coordinate.D5);
        currentBoard.emptyAGivenTileCoordination(Coordinate.B6);
        currentBoard.emptyAGivenTileCoordination(Coordinate.A8);
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
        assertEquals("Error --> when Bishop on D5 with obstacles", possibleMoves4, results);
        System.out.println("Bishop on D5 with obstacles passed");

    }

    @Test
    public void equals() {
        Bishop toTest = new Bishop(Piece.Color.BLACK, Coordinate.D1);
        assertTrue("Error --> 1st sample", toTest.equals(equ1));
        assertFalse("Error --> 2nd sample", toTest.equals(equ2));
        assertFalse("Error --> 3rd sample", toTest.equals(equ3));
        assertFalse("Error --> 4th sample", toTest.equals(equ4));
        assertFalse("Error --> 5th sample", toTest.equals(equ5));
        assertFalse("Error --> 6th sample", toTest.equals(equ6));
        System.out.println("Equals test passed!");
    }
}