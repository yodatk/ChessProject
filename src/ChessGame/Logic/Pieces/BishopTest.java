package ChessGame.Logic.Pieces;

import ChessGame.Logic.*;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BishopTest {
    private Bishop equ1 = new Bishop(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Queen equ2 = new Queen(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Integer equ3 = 5;
    private Bishop equ4 = new Bishop(Piece.Color.WHITE,new Pair<>(Column.D, Row.ONE));
    private Bishop equ5 = new Bishop(Piece.Color.BLACK,new Pair<>(Column.E, Row.FIVE));
    private Bishop equ6 = new Bishop(Piece.Color.WHITE,new Pair<>(Column.F, Row.SEVEN));
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
                Coordinate.A8, Coordinate.G8,
                Coordinate.B7, Coordinate.F7,
                Coordinate.C6, Coordinate.E6,
                Coordinate.C4, Coordinate.E4,
                Coordinate.B3, Coordinate.F3,
                Coordinate.A2, Coordinate.G2,
                Coordinate.H1
        ));
        Set<Pair<Column,Row>> possibleMoves2 = new HashSet(Arrays.asList(
                Coordinate.B7,
                Coordinate.C6,
                Coordinate.D5,
                Coordinate.E4,
                Coordinate.F3,
                Coordinate.G2,
                Coordinate.H1
        ));
        Set<Pair<Column,Row>> possibleMoves3 = new HashSet(Arrays.asList(
                Coordinate.B7,
                Coordinate.C6

        ));
        Set<Pair<Column,Row>> possibleMoves4 = new HashSet(Arrays.asList(
                Coordinate.F7,
                Coordinate.C6, Coordinate.E6,
                Coordinate.C4
        ));
        //queen on d5 without obstacles
        Bishop toTest = new Bishop(Piece.Color.WHITE, Coordinate.D5);
        currentBoard[3][3].setCurrentPiece(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        Set<Pair<Column,Row>> results = toTest.getPossibleMoves();
        assertEquals("Error --> when Bishop on D5",possibleMoves1, results);
        System.out.println("Bishop on D5 passed");
        currentBoard[3][3].setCurrentPiece(null);
        //queen on a8 without obstacles
        toTest.setCoordinate(Coordinate.A8);
        currentBoard[0][0].setCurrentPiece(toTest);
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Bishop on A8",possibleMoves2, results);
        System.out.println("Bishop on A8 passed");
        //queen on a8 with obstacles
        currentBoard[1][0].setCurrentPiece(new Rook(Piece.Color.WHITE, Coordinate.A7));
        currentBoard[0][1].setCurrentPiece(new Rook(Piece.Color.BLACK, Coordinate.B8));
        currentBoard[3][3].setCurrentPiece(new Rook(Piece.Color.WHITE, Coordinate.D5));
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Bishop on A8 with obstacles",possibleMoves3, results);
        System.out.println("Bishop on A8 with obstacles passed");
        currentBoard[1][0].setCurrentPiece(null);
        currentBoard[0][1].setCurrentPiece(null);
        currentBoard[2][1].setCurrentPiece(null);
        currentBoard[0][0].setCurrentPiece(null);
        toTest.setCoordinate(Coordinate.D5);
        currentBoard[3][3].setCurrentPiece(toTest);

        currentBoard[1][1].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinate.B7));
        currentBoard[1][3].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinate.D7));
        currentBoard[1][5].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinate.F7));
        currentBoard[3][1].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinate.B5));
        currentBoard[3][5].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinate.F5));
        currentBoard[4][2].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinate.C4));
        currentBoard[4][4].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinate.E4));
        currentBoard[5][1].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinate.B3));
        currentBoard[5][3].setCurrentPiece(new Pawn(Piece.Color.WHITE, Coordinate.D3));
        currentBoard[5][5].setCurrentPiece(new Pawn(Piece.Color.BLACK, Coordinate.F3));
        toTest.calculateAllPossibleMoves(currentBoard);
        results = toTest.getPossibleMoves();
        assertEquals("Error --> when Bishop on D5 with obstacles",possibleMoves4, results);
        System.out.println("Bishop on D5 with obstacles passed");

    }

    @Test
    public void equals() {
        Bishop toTest = new Bishop(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
        assertTrue("Error --> 1st sample", toTest.equals(equ1));
        assertFalse("Error --> 2nd sample", toTest.equals(equ2));
        assertFalse("Error --> 3rd sample", toTest.equals(equ3));
        assertFalse("Error --> 4th sample", toTest.equals(equ4));
        assertFalse("Error --> 5th sample", toTest.equals(equ5));
        assertFalse("Error --> 6th sample", toTest.equals(equ6));
        System.out.println("Equals test passed!");
    }
}