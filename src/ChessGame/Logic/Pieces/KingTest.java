package ChessGame.Logic.Pieces;

import ChessGame.Logic.Board;
import ChessGame.Logic.Column;
import ChessGame.Logic.Coordinate;
import ChessGame.Logic.Row;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class KingTest {
    private King equ1 = new King(Piece.Color.BLACK, Coordinate.D1);
    private Rook equ2 = new Rook(Piece.Color.BLACK,Coordinate.D1);
    private Integer equ3 = 5;
    private King equ4 = new King(Piece.Color.WHITE,Coordinate.D1);
    private King equ5 = new King(Piece.Color.BLACK,Coordinate.E5);
    private King equ6 = new King(Piece.Color.WHITE,Coordinate.F7);

    private Board currentBoard;

    @Test
    public void calculateAllPossibleMoves() {
        Set<Coordinate> possibleMoves1 = new HashSet(Arrays.asList(
                Coordinate.C6, Coordinate.D6, Coordinate.E6,
                Coordinate.C5, Coordinate.E5,
                Coordinate.C4, Coordinate.D4, Coordinate.E4

        ));

        Set<Coordinate> possibleMoves2 = new HashSet(Arrays.asList(

                Coordinate.C6,
                Coordinate.E5,
                Coordinate.D4
        ));
        Set<Coordinate> possibleMoves3 = new HashSet(Arrays.asList(
                Coordinate.B8,
                Coordinate.A7, Coordinate.B7

        ));
        Set<Coordinate> possibleMoves4 = new HashSet(Arrays.asList(
                Coordinate.B7
        ));

        King toTest = new King(Piece.Color.WHITE,Coordinate.D5);
        System.out.println(" ==== calculateAllPossibleMoves Test has started === ");
        currentBoard = new Board(Board.BoardMode.EMPTY);
        toTest.calculateAllPossibleMoves(currentBoard);
        // King on an empty board d5
        assertEquals("Error --> King on D5",possibleMoves1, toTest.getPossibleMoves());
        System.out.println("King on D5 passed");
        //adding rooks below and above
        Rook blackRook = new Rook(Piece.Color.BLACK,Coordinate.C6);
        Rook whiteRook = new Rook(Piece.Color.WHITE,Coordinate.E4);
        currentBoard.getTileByCoordination(Coordinate.C6).setCurrentPiece(blackRook);
        currentBoard.getTileByCoordination(Coordinate.E4).setCurrentPiece(whiteRook);
        currentBoard.getWhitesPieces().add(whiteRook);
        currentBoard.getBlacksPieces().add(blackRook);
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> King on D5 with rooks",possibleMoves2, toTest.getPossibleMoves());
        System.out.println("King on D5 with rooks Passed");
        currentBoard = new Board(Board.BoardMode.EMPTY);
        toTest.setCoordinate(Coordinate.A8);
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> King on A8",possibleMoves3, toTest.getPossibleMoves());
        System.out.println("King on A8 Passed");
        Knight test4Knight1 = new Knight(Piece.Color.BLACK,Coordinate.B5);
        Knight test4Knight2 = new Knight(Piece.Color.WHITE,Coordinate.B8);

        currentBoard.getTileByCoordination(Coordinate.B5).setCurrentPiece(test4Knight1);
        currentBoard.getTileByCoordination(Coordinate.B8).setCurrentPiece(test4Knight2);
        currentBoard.getWhitesPieces().add(test4Knight2);
        currentBoard.getBlacksPieces().add(test4Knight1);
        toTest.calculateAllPossibleMoves(currentBoard);
        assertEquals("Error --> King on A8 with knights",possibleMoves4, toTest.getPossibleMoves());
        System.out.println("King on A8 with knights passed Passed");

    }

    @Test
    public void equals() {
        King toTest = new King(Piece.Color.BLACK,Coordinate.D1);
        assertTrue("Error --> 1st sample", toTest.equals(equ1));
        assertFalse("Error --> 2nd sample", toTest.equals(equ2));
        assertFalse("Error --> 3rd sample", toTest.equals(equ3));
        assertFalse("Error --> 4th sample", toTest.equals(equ4));
        assertFalse("Error --> 5th sample", toTest.equals(equ5));
        assertFalse("Error --> 6th sample", toTest.equals(equ6));
        System.out.println("Equals test passed!");
    }
}