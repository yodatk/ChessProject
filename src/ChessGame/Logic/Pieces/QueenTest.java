package ChessGame.Logic.Pieces;

import ChessGame.Logic.Column;
import ChessGame.Logic.Row;
import ChessGame.Logic.Tile;
import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {

    private Queen equ1 = new Queen(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Rook equ2 = new Rook(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
    private Integer equ3 = 5;
    private Queen equ4 = new Queen(Piece.Color.WHITE,new Pair<>(Column.D, Row.ONE));
    private Queen equ5 = new Queen(Piece.Color.BLACK,new Pair<>(Column.E, Row.FIVE));
    private Queen equ6 = new Queen(Piece.Color.WHITE,new Pair<>(Column.F, Row.SEVEN));
    private Queen equ7 = null;




    @Test
    public void calculateAllPossibleMoves() {
        fail("Test not Written yet!");
    }

    @Test
    public void equals() {
        Queen toTest = new Queen(Piece.Color.BLACK,new Pair<>(Column.D, Row.ONE));
        assertTrue("Error --> first sample", toTest.equals(equ1));
        assertTrue("Error --> 1st sample", toTest.equals(equ1));
        assertFalse("Error --> 2nd sample", toTest.equals(equ2));
        assertFalse("Error --> 3rd sample", toTest.equals(equ3));
        assertFalse("Error --> 4th sample", toTest.equals(equ4));
        assertFalse("Error --> 5th sample", toTest.equals(equ5));
        assertFalse("Error --> 6th sample", toTest.equals(equ6));
        assertFalse("Error --> 7th sample", toTest.equals(equ7));

        System.out.println("Equals test passed!");


    }
}