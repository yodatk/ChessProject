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
        System.out.println("calculateAllPossibleMoves Test has started");
        setemptyboard1();
        Set<Pair<Column,Row>> possibleMoves1 = new HashSet(Arrays.asList(
                Coordinates.C7,Coordinates.E7,
                Coordinates.B6,Coordinates.F6,
                Coordinates.B4,Coordinates.F4,
                Coordinates.C3,Coordinates.E3
        ));
        Set<Pair<Column,Row>> possibleMoves2 = new HashSet(Arrays.asList(
                Coordinates.B6,Coordinates.C7
        ));
        Set<Pair<Column,Row>> possibleMoves3 = new HashSet(Arrays.asList(
                Coordinates.C7
        ));
        Set<Pair<Column,Row>> possibleMoves4 = new HashSet(Arrays.asList(
                Coordinates.E7,
                Coordinates.B6,Coordinates.F6,
                Coordinates.B4,
                Coordinates.C3,Coordinates.E3
        ));
        //queen on d5 without obstacles
        Knight toTest = new Knight(Piece.Color.WHITE,Coordinates.D5);
        currentBoard[3][3].setCurrentPiece(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        Set<Pair<Column,Row>> results = toTest.getPossibleMoves();
        assertEquals("Error --> when Knight on D5",possibleMoves1, results);
        System.out.println("Knight on D5 passed");
        currentBoard[3][3].setCurrentPiece(null);
        //queen on a8 without obstacles
        toTest.setCoordinate(Coordinates.A8);
        currentBoard[0][0].setCurrentPiece(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Knight on A8",possibleMoves2, results);
        System.out.println("Knight on A8 passed");
        //queen on a8 with obstacles
        currentBoard[1][2].setCurrentPiece(new Rook(Piece.Color.BLACK,Coordinates.C7));
        currentBoard[1][1].setCurrentPiece(new Rook(Piece.Color.WHITE,Coordinates.B7));
        currentBoard[2][1].setCurrentPiece(new Rook(Piece.Color.WHITE,Coordinates.B6));
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Knight on A8 with obstacles",possibleMoves3, results);
        System.out.println("Knight on A8 with obstacles passed");
        currentBoard[1][0].setCurrentPiece(null);
        currentBoard[0][1].setCurrentPiece(null);
        currentBoard[2][1].setCurrentPiece(null);
        currentBoard[0][0].setCurrentPiece(null);
        toTest.setCoordinate(Coordinates.D5);
        currentBoard[3][3].setCurrentPiece(toTest);

        currentBoard[2][1].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinates.B6));
        currentBoard[1][2].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinates.C7));
        currentBoard[4][5].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinates.F4));
        currentBoard[5][3].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinates.E3));

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