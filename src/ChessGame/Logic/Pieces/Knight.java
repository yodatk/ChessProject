package ChessGame.Logic.Pieces;

import ChessGame.Logic.Column;
import ChessGame.Logic.Row;
import ChessGame.Logic.Tile;
import com.sun.xml.internal.bind.v2.TODO;
import javafx.util.Pair;

import java.util.HashSet;

public class Knight extends Piece {
    public Knight(Color pieceColor, Pair<Column, Row> coordinate) {
        super(pieceColor, coordinate);
    }

    @Override
    public void calculateAllPossibleMoves(Tile[][] currentBoard) {
        //resetting the possibleMoves
        this.possibleMoves = new HashSet<>();
        addUp(currentBoard);
        addDown(currentBoard);
        addLeft(currentBoard);
        addRight(currentBoard);
    }

    private void addUp(Tile[][] currentBoard) {
        //checking the checking up-left
        Pair<Column, Row> nextLeft = new Pair<>(this.coordinate.getKey().getPrevious(), this.coordinate.getValue().getNext());
        if ((nextLeft.getKey() != null) && (nextLeft.getValue() != null) && nextLeft.getValue().getNext() != null) {
            nextLeft = new Pair<>(nextLeft.getKey(), nextLeft.getValue().getNext());
            checkForPieces(this.possibleMoves, nextLeft, currentBoard);
        }
        //checking the up-right
        Pair<Column, Row> nextRight = new Pair<>(this.coordinate.getKey().getNext(), this.coordinate.getValue().getNext());
        if ((nextRight.getKey() != null) && (nextRight.getValue() != null) && nextRight.getValue().getNext() != null) {
            nextRight = new Pair<>(nextRight.getKey(), nextRight.getValue().getNext());
            checkForPieces(this.possibleMoves, nextRight, currentBoard);
        }
    }

    private void addDown(Tile[][] currentBoard) {
        //checking the down-left
        Pair<Column, Row> nextLeft = new Pair<>(this.coordinate.getKey().getPrevious(), this.coordinate.getValue().getPrevious());
        if ((nextLeft.getKey() != null) && (nextLeft.getValue() != null) && (nextLeft.getValue().getPrevious() != null)) {
            nextLeft = new Pair<>(nextLeft.getKey(), nextLeft.getValue().getPrevious());
            checkForPieces(this.possibleMoves, nextLeft, currentBoard);
        }
        //checking the down-right
        Pair<Column, Row> nextRight = new Pair<>(this.coordinate.getKey().getNext(), this.coordinate.getValue().getPrevious());
        if ((nextRight.getKey() != null) && (nextRight.getValue() != null) && nextRight.getValue().getPrevious() != null) {
            nextRight = new Pair<>(nextRight.getKey(), nextRight.getValue().getPrevious());
            checkForPieces(this.possibleMoves, nextRight, currentBoard);
        }
    }

    private void addLeft(Tile[][] currentBoard) {
        //checking the Left-Up
        Pair<Column, Row> nextUp = new Pair<>(this.coordinate.getKey().getPrevious(), this.coordinate.getValue().getNext());
        if ((nextUp.getKey() != null) && (nextUp.getValue() != null) && nextUp.getKey().getPrevious() != null) {
            nextUp = new Pair<>(nextUp.getKey().getPrevious(), nextUp.getValue());
            checkForPieces(this.possibleMoves, nextUp, currentBoard);
        }
        //checking the Left-Down
        Pair<Column, Row> nextDown = new Pair<>(this.coordinate.getKey().getPrevious(), this.coordinate.getValue().getPrevious());
        if ((nextDown.getKey() != null) && (nextDown.getValue() != null) && (nextDown.getKey().getPrevious() != null)) {
            nextDown = new Pair<>(nextDown.getKey().getPrevious(), nextDown.getValue());
            checkForPieces(this.possibleMoves, nextDown, currentBoard);
        }
    }

    private void addRight(Tile[][] currentBoard) {
        //checking the Right-Up
        Pair<Column, Row> nextUp = new Pair<>(this.coordinate.getKey().getNext(), this.coordinate.getValue().getNext());
        if ((nextUp.getKey() != null) && (nextUp.getValue() != null) && nextUp.getKey().getNext() != null) {
            nextUp = new Pair<>(nextUp.getKey().getNext(), nextUp.getValue());
            checkForPieces(this.possibleMoves, nextUp, currentBoard);
        }
        //checking the Right-Down
        Pair<Column, Row> nextDown = new Pair<>(this.coordinate.getKey().getNext(), this.coordinate.getValue().getPrevious());
        if ((nextDown.getKey() != null) && (nextDown.getValue() != null) && (nextDown.getKey().getNext()) != null) {
            nextDown = new Pair<>(nextDown.getKey().getNext(), nextDown.getValue());
            checkForPieces(this.possibleMoves, nextDown, currentBoard);
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean general = super.equals(obj);
        return general && (obj instanceof Knight);

    }
}
