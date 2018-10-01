package ChessGame.Logic;

import ChessGame.Logic.Pieces.Bishop;
import ChessGame.Logic.Pieces.Piece;
import ChessGame.Logic.Pieces.Rook;
import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class TilesTest {
    private Tile equ1 = new Tile(Coordinate.H3,
                                    new Rook(Piece.Color.WHITE, Coordinate.H3));
    private Tile equ2 = new Tile(Coordinate.G3,
            new Rook(Piece.Color.WHITE, Coordinate.G3));
    private Tile equ3 = new Tile(Coordinate.H3,
            new Bishop(Piece.Color.WHITE, Coordinate.H3));
    private Tile equ4 = null;
    private Tile equ5 = new Tile(Coordinate.H3,
            new Rook(Piece.Color.BLACK,Coordinate.H3));

    @Test
    public void initBoard(){
        fail("Test not Written yet!");

    }
    @Test
    public void equals(){
        Tile toTest = new Tile(Coordinate.H3,new Rook(Piece.Color.WHITE, Coordinate.H3));
        assertTrue("Error --> 1st Sample",toTest.equals(equ1));
        assertFalse("Error --> 2nd Sample",toTest.equals(equ2));
        assertFalse("Error --> 3rd Sample",toTest.equals(equ3));
        assertFalse("Error --> 4th Sample",toTest.equals(equ4));
        assertFalse("Error --> 5th Sample",toTest.equals(equ5));
        System.out.println("Equals test passed");

    }
}