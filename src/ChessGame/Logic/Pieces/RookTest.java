package ChessGame.Logic.Pieces;

import ChessGame.Logic.Column;
import ChessGame.Logic.Row;
import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class RookTest {
    private Rook equ1 = new Rook(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Queen equ2 = new Queen(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Integer equ3 = 5;
    private Rook equ4 = new Rook(Piece.Color.WHITE,new Pair<>(Column.D, Row.ONE));
    private Rook equ5 = new Rook(Piece.Color.BLACK,new Pair<>(Column.E, Row.FIVE));
    private Rook equ6 = new Rook(Piece.Color.WHITE,new Pair<>(Column.F, Row.SEVEN));
    @Test
    public void calculateAllPossibleMoves() {
        fail("Test not Written yet!");
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