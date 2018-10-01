package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class KnightTest {
    private Knight equ1 = new Knight(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Rook equ2 = new Rook(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Integer equ3 = 5;
    private Knight equ4 = new Knight(Piece.Color.WHITE,new Pair<>(Column.D, Row.ONE));
    private Knight equ5 = new Knight(Piece.Color.BLACK,new Pair<>(Column.E, Row.FIVE));
    private Knight equ6 = new Knight(Piece.Color.WHITE,new Pair<>(Column.F, Row.SEVEN));

    private Tile[][] currentBoard;

    private void setemptyboard1(){
        GameManager board = new GameManager();
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
        System.out.println("calculateAllPossibleMoves Test has started");
        setemptyboard1();
        Set<Pair<Column,Row>> possibleMoves1 = new HashSet(Arrays.asList(
                Coordinate.C7, Coordinate.E7,
                Coordinate.B6, Coordinate.F6,
                Coordinate.B4, Coordinate.F4,
                Coordinate.C3, Coordinate.E3
        ));
        Set<Pair<Column,Row>> possibleMoves2 = new HashSet(Arrays.asList(
                Coordinate.B6, Coordinate.C7
        ));
        Set<Pair<Column,Row>> possibleMoves3 = new HashSet(Arrays.asList(
                Coordinate.C7
        ));
        Set<Pair<Column,Row>> possibleMoves4 = new HashSet(Arrays.asList(
                Coordinate.E7,
                Coordinate.B6, Coordinate.F6,
                Coordinate.B4,
                Coordinate.C3, Coordinate.E3
        ));
        //queen on d5 without obstacles
        Knight toTest = new Knight(Piece.Color.WHITE, Coordinate.D5);
        currentBoard[3][3].setCurrentPiece(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        Set<Pair<Column,Row>> results = toTest.getPossibleMoves();
        assertEquals("Error --> when Knight on D5",possibleMoves1, results);
        System.out.println("Knight on D5 passed");
        currentBoard[3][3].setCurrentPiece(null);
        //queen on a8 without obstacles
        toTest.setCoordinate(Coordinate.A8);
        currentBoard[0][0].setCurrentPiece(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Knight on A8",possibleMoves2, results);
        System.out.println("Knight on A8 passed");
        //queen on a8 with obstacles
        currentBoard[1][2].setCurrentPiece(new Rook(Piece.Color.BLACK, Coordinate.C7));
        currentBoard[1][1].setCurrentPiece(new Rook(Piece.Color.WHITE, Coordinate.B7));
        currentBoard[2][1].setCurrentPiece(new Rook(Piece.Color.WHITE, Coordinate.B6));
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Knight on A8 with obstacles",possibleMoves3, results);
        System.out.println("Knight on A8 with obstacles passed");
        currentBoard[1][0].setCurrentPiece(null);
        currentBoard[0][1].setCurrentPiece(null);
        currentBoard[2][1].setCurrentPiece(null);
        currentBoard[0][0].setCurrentPiece(null);
        toTest.setCoordinate(Coordinate.D5);
        currentBoard[3][3].setCurrentPiece(toTest);

        currentBoard[2][1].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinate.B6));
        currentBoard[1][2].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinate.C7));
        currentBoard[4][5].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinate.F4));
        currentBoard[5][3].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinate.E3));

        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Knight on D5 with obstacles",possibleMoves4, results);
        System.out.println("Knight on D5 with obstacles passed");



    }

    @Test
    public void equals() {
        Knight toTest = new Knight(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
        assertTrue("Error --> 1st sample", toTest.equals(equ1));
        assertFalse("Error --> 2nd sample", toTest.equals(equ2));
        assertFalse("Error --> 3rd sample", toTest.equals(equ3));
        assertFalse("Error --> 4th sample", toTest.equals(equ4));
        assertFalse("Error --> 5th sample", toTest.equals(equ5));
        assertFalse("Error --> 6th sample", toTest.equals(equ6));
        System.out.println("Equals test passed!");
    }
}