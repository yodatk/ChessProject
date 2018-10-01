package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PawnTest {
    private Pawn equ1 = new Pawn(Piece.Color.BLACK, Coordinate.D1);
    private Rook equ2 = new Rook(Piece.Color.BLACK, Coordinate.D1);
    private Integer equ3 = 5;
    private Pawn equ4 = new Pawn(Piece.Color.WHITE, Coordinate.D1);
    private Pawn equ5 = new Pawn(Piece.Color.BLACK, Coordinate.E5);
    private Pawn equ6 = new Pawn(Piece.Color.WHITE, Coordinate.F7);

    private Board currentBoard;


    @Test
    public void calculateAllPossibleMoves() {
        System.out.println("====== calculateAllPossibleMoves Test has started =====");
        currentBoard = new Board(Board.BoardMode.EMPTY);
        Set<Coordinate> possibleMoves1 = new HashSet(Arrays.asList(
                Coordinate.D3, Coordinate.D4
        ));
        Set<Coordinate> possibleMoves2 = new HashSet(Arrays.asList(
                Coordinate.D3, Coordinate.D4,
                Coordinate.C3
        ));
        Set<Coordinate> possibleMoves3 = new HashSet(Arrays.asList(

        ));
        Set<Coordinate> possibleMoves4 = new HashSet(Arrays.asList(
                Coordinate.B6, Coordinate.C6
        ));
        Set<Coordinate> possibleMoves5 = new HashSet(Arrays.asList(
                Coordinate.D6, Coordinate.C6
        ));
        //queen on d5 without obstacles
        Pawn toTest = new Pawn(Piece.Color.WHITE, Coordinate.D2);
        currentBoard.getTileByCoordination(Coordinate.D2).setCurrentPiece(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> Pawn on D2", possibleMoves1, toTest.getPossibleMoves());
        System.out.println("Pawn on D2  passed");
        currentBoard.getTileByCoordination(Coordinate.C3).setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinate.C3));
        currentBoard.getTileByCoordination(Coordinate.E3).setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinate.E3));
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> Pawn on D2 with diagonals", possibleMoves2, toTest.getPossibleMoves());
        System.out.println("Pawn on D2 with obstacles passed");
        currentBoard.getTileByCoordination(Coordinate.C3).setCurrentPiece(null);
        currentBoard.getTileByCoordination(Coordinate.E3).setCurrentPiece(null);

        currentBoard.getTileByCoordination(Coordinate.A4).setCurrentPiece(new Rook(Piece.Color.BLACK, Coordinate.A4));
        toTest.setCoordinate(Coordinate.A3);
        toTest.setHasBeenMoved(true);
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> Pawn on A3 with obstacles", possibleMoves3, toTest.getPossibleMoves());
        System.out.println("Pawn on A3 with obstacles passed");
        currentBoard.getTileByCoordination(Coordinate.A4).setCurrentPiece(null);

        currentBoard.getTileByCoordination(Coordinate.H4).setCurrentPiece(new Rook(Piece.Color.WHITE, Coordinate.H4));
        toTest.setCoordinate(Coordinate.H3);
        toTest.setHasBeenMoved(true);
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> Pawn on H3 with obstacles", possibleMoves3, toTest.getPossibleMoves());
        System.out.println("Pawn on H3 with obstacles passed");
        currentBoard.getTileByCoordination(Coordinate.H4).setCurrentPiece(null);

        toTest.setCoordinate(Coordinate.C5);
        toTest.setHasBeenMoved(true);
        currentBoard.getTileByCoordination(Coordinate.B5).setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinate.B5));
        ((Pawn) currentBoard.getTileByCoordination(Coordinate.B5).getCurrentPiece()).setCanBeKilledFromBehind(true);
        currentBoard.getTileByCoordination(Coordinate.D5).setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinate.D5));
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> Pawn on C5 kill from behind left ", possibleMoves4, toTest.getPossibleMoves());
        System.out.println("Pawn on C5 kill from behind left passed");

        ((Pawn) currentBoard.getTileByCoordination(Coordinate.B5).getCurrentPiece()).setCanBeKilledFromBehind(false);
        ((Pawn) currentBoard.getTileByCoordination(Coordinate.D5).getCurrentPiece()).setCanBeKilledFromBehind(true);
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> Pawn on C5 kill from behind right ", possibleMoves5, toTest.getPossibleMoves());
        System.out.println("Pawn on C5 kill from behind right passed");

    }

    @Test
    public void equals() {
        Pawn toTest = new Pawn(Piece.Color.BLACK, Coordinate.D1);
        assertTrue("Error --> 1st sample", toTest.equals(equ1));
        assertFalse("Error --> 2nd sample", toTest.equals(equ2));
        assertFalse("Error --> 3rd sample", toTest.equals(equ3));
        assertFalse("Error --> 4th sample", toTest.equals(equ4));
        assertFalse("Error --> 5th sample", toTest.equals(equ5));
        assertFalse("Error --> 6th sample", toTest.equals(equ6));
        System.out.println("Equals test passed!");
    }
}