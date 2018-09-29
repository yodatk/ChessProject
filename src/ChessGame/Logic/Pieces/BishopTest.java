package ChessGame.Logic.Pieces;

import ChessGame.Logic.Column;
import ChessGame.Logic.Row;
import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class BishopTest {
    private Bishop equ1 = new Bishop(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Queen equ2 = new Queen(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Integer equ3 = 5;
    private Bishop equ4 = new Bishop(Piece.Color.WHITE,new Pair<>(Column.D, Row.ONE));
    private Bishop equ5 = new Bishop(Piece.Color.BLACK,new Pair<>(Column.E, Row.FIVE));
    private Bishop equ6 = new Bishop(Piece.Color.WHITE,new Pair<>(Column.F, Row.SEVEN));

    @Test
    public void calculateAllPossibleMoves() {
        fail("Test not Written yet!");

    }

    @Test
    public void equals() {
        Bishop toTest = new Bishop(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
        assertTrue("Error --> first sample", toTest.equals(equ1));
        assertFalse("Error --> second sample", toTest.equals(equ2));
        assertFalse("Error --> third sample", toTest.equals(equ3));
        assertFalse("Error --> third sample", toTest.equals(equ4));
        assertFalse("Error --> third sample", toTest.equals(equ5));
        assertFalse("Error --> third sample", toTest.equals(equ6));
        System.out.println("Equals test passed!");
    }
}