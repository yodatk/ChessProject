package ChessGame.Logic.Pieces;

import ChessGame.Logic.Column;
import ChessGame.Logic.Coordinate;
import ChessGame.Logic.Row;
import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class KingTest {
    private King equ1 = new King(Piece.Color.BLACK, Coordinate.D1);
    private Rook equ2 = new Rook(Piece.Color.BLACK,Coordinate.D1);
    private Integer equ3 = 5;
    private King equ4 = new King(Piece.Color.WHITE,Coordinate.D1);
    private King equ5 = new King(Piece.Color.BLACK,Coordinate.E5);
    private King equ6 = new King(Piece.Color.WHITE,Coordinate.F7);
    @Test
    public void calculateAllPossibleMoves() {
        fail("Test not Written yet!");

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