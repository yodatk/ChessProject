package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class KnightTest {
    private Knight equ1 = new Knight(Piece.Color.BLACK, Coordinate.D1);
    private Rook equ2 = new Rook(Piece.Color.BLACK, Coordinate.D1);
    private Integer equ3 = 5;
    private Knight equ4 = new Knight(Piece.Color.WHITE, Coordinate.D1);
    private Knight equ5 = new Knight(Piece.Color.BLACK, Coordinate.E5);
    private Knight equ6 = new Knight(Piece.Color.WHITE, Coordinate.F7);

    private Board currentBoard;


    @Test
    public void calculateAllPossibleMoves() {
        System.out.println("calculateAllPossibleMoves Test has started");
        currentBoard = new Board(Board.BoardMode.EMPTY);
        Set<Coordinate> possibleMoves1 = new HashSet(Arrays.asList(
                Coordinate.C7, Coordinate.E7,
                Coordinate.B6, Coordinate.F6,
                Coordinate.B4, Coordinate.F4,
                Coordinate.C3, Coordinate.E3
        ));
        Set<Coordinate> possibleMoves2 = new HashSet(Arrays.asList(
                Coordinate.B6, Coordinate.C7
        ));
        Set<Coordinate> possibleMoves3 = new HashSet(Arrays.asList(
                Coordinate.C7
        ));
        Set<Coordinate> possibleMoves4 = new HashSet(Arrays.asList(
                Coordinate.E7,
                Coordinate.B6, Coordinate.F6,
                Coordinate.B4,
                Coordinate.C3, Coordinate.E3
        ));
        //knight on d5 without obstacles
        Knight toTest = new Knight(Piece.Color.WHITE, Coordinate.D5);
        currentBoard.getTileByCoordination(Coordinate.D5).setCurrentPiece(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        Set<Coordinate> results = toTest.getPossibleMoves();
        assertEquals("Error --> when Knight on D5", possibleMoves1, results);
        System.out.println("Knight on D5 passed");
        currentBoard.getTileByCoordination(Coordinate.D5).setCurrentPiece(null);
        //knight on a8 without obstacles
        toTest.setCoordinate(Coordinate.A8);
        currentBoard.getTileByCoordination(Coordinate.A8).setCurrentPiece(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Knight on A8", possibleMoves2, results);
        System.out.println("Knight on A8 passed");
        //knight on a8 with obstacles
        currentBoard.getTileByCoordination(Coordinate.C7).setCurrentPiece(new Rook(Piece.Color.BLACK, Coordinate.C7));
        currentBoard.getTileByCoordination(Coordinate.B7).setCurrentPiece(new Rook(Piece.Color.WHITE, Coordinate.B7));
        currentBoard.getTileByCoordination(Coordinate.B6).setCurrentPiece(new Rook(Piece.Color.WHITE, Coordinate.B6));
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Knight on A8 with obstacles", possibleMoves3, results);
        System.out.println("Knight on A8 with obstacles passed");
        currentBoard = new Board(Board.BoardMode.EMPTY);
        toTest.setCoordinate(Coordinate.D5);
        currentBoard.getTileByCoordination(Coordinate.D5).setCurrentPiece(toTest);

        currentBoard.getTileByCoordination(Coordinate.B6).setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinate.B6));
        currentBoard.getTileByCoordination(Coordinate.C7).setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinate.C7));
        currentBoard.getTileByCoordination(Coordinate.F4).setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinate.F4));
        currentBoard.getTileByCoordination(Coordinate.E3).setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinate.E3));

        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Knight on D5 with obstacles", possibleMoves4, results);
        System.out.println("Knight on D5 with obstacles passed");


    }

    @Test
    public void equals() {
        Knight toTest = new Knight(Piece.Color.BLACK, Coordinate.D1);
        assertTrue("Error --> 1st sample", toTest.equals(equ1));
        assertFalse("Error --> 2nd sample", toTest.equals(equ2));
        assertFalse("Error --> 3rd sample", toTest.equals(equ3));
        assertFalse("Error --> 4th sample", toTest.equals(equ4));
        assertFalse("Error --> 5th sample", toTest.equals(equ5));
        assertFalse("Error --> 6th sample", toTest.equals(equ6));
        System.out.println("Equals test passed!");
    }
}