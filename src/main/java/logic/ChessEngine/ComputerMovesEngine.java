package logic.ChessEngine;


import javafx.util.Pair;
import logic.board.Board;
import logic.board.Coordinate;
import logic.pieces.Piece;

import java.util.*;

/**
 * Chess engine Which will calculate moves and act them on the board when the user want to play versus the computer.
 */
public class ComputerMovesEngine {

    /**
     * The computer calculates the best move for the given color pieces, on the given board and returned it.
     * @param computerColor     Color the computer is playing in the game.
     * @param currentBoard      Board of the current chess game.
     * @return Pair of Coordinates:
     * - The first coordinate is the coordinate of the piece that should move.
     * - The second coordinate is the coordinate of the chosen piece new location.
     */
    public static Pair<Coordinate, Coordinate> generateMove(Piece.Color computerColor, Board currentBoard) {
        List<Pair<Coordinate, Coordinate>> allPossibleMoves = new ArrayList<>();
        calculateAllMoves(computerColor, currentBoard, allPossibleMoves);
        //shuffling the list, so every time the computer will choose a different move
        Collections.shuffle(allPossibleMoves);
        return ChooseBestMove(computerColor, allPossibleMoves, currentBoard);

    }

    /**
     * Checks the best move for the given depth in the game, using board values.
     * @param depth             Number of moves to left to calculate.
     * @param currentBoard      Board of the current chess game.
     * @param computerColor     Color the computer is playing in the game.
     */
    private static int checkBestMoveDepth(int depth, Board currentBoard, Piece.Color computerColor){
        int bestMoveValue;
        if(computerColor == Piece.Color.WHITE){
            //if the computer is White --> give initial value of the smallest value possible.
            bestMoveValue = Integer.MIN_VALUE;
        }
        else{
            //if the computer is Black --> give initial value of the biggest value possible
            bestMoveValue = Integer.MAX_VALUE;
        }

        return checkBestMoveDepthRec(depth,currentBoard,computerColor,bestMoveValue);

    }

    /**
     * Checks the best move for the given depth in the game, using board values.
     * @param depth             Number of moves to left to calculate.
     * @param currentBoard      Board of the current chess game.
     * @param computerColor     Color the computer is playing in the game.
     * @param bestMoveValue     Number represent the current best Board value
     * @return
     */
    private static int checkBestMoveDepthRec(int depth, Board currentBoard, Piece.Color computerColor, int bestMoveValue) {
        List<Pair<Coordinate, Coordinate>> allPossibleMoves = new ArrayList<>();
        if(depth == 0){
            // basic state :return the current value of the board
            return calculateBoardValue(currentBoard);
        }
        else{
            calculateAllMoves(computerColor,currentBoard,allPossibleMoves);
            if(computerColor == Piece.Color.WHITE){
                //if white --> check recursively for the highest value of board.
                for(Pair<Coordinate, Coordinate> move : allPossibleMoves){
                    //making the move on the board.
                    currentBoard.movePieceToNewLocation(move.getKey(), move.getValue(), currentBoard.getPieceByCoordinate(move.getKey()));
                    //pruning --> checking if the temp move is not worse than the current one
                    int temp = calculateBoardValue(currentBoard);
                    if(temp < bestMoveValue){
                        //if the current move is leading to a worse situation --> undo it and return the current value.
                        currentBoard.undoMove();
                        return temp;
                    }
                    //recursively checking the best board value -- > the next level will get less depth, and opposite color.
                    bestMoveValue = Math.max(bestMoveValue, checkBestMoveDepthRec(depth - 1, currentBoard, computerColor.next(),bestMoveValue));
                    currentBoard.undoMove();
                }
                return bestMoveValue;
            }
            else{
                //if black --> check recursively for the lowest value of board.
                for(Pair<Coordinate, Coordinate> move : allPossibleMoves){
                    //making the move on the board.
                    currentBoard.movePieceToNewLocation(move.getKey(), move.getValue(), currentBoard.getPieceByCoordinate(move.getKey()));
                    //pruning --> checking if the temp move is not worse than the current one
                    int temp = calculateBoardValue(currentBoard);
                    if(temp > bestMoveValue){
                        //if the current move is leading to a worse situation --> undo it and return the current value.
                        currentBoard.undoMove();
                        return temp;
                    }
                    //recursively checking the best board value -- > the next level will get less depth, and opposite color.
                    bestMoveValue = Math.min(bestMoveValue, checkBestMoveDepthRec(depth - 1, currentBoard, computerColor.next(),bestMoveValue));
                    //undo the move to the original position.
                    currentBoard.undoMove();
                }
                return bestMoveValue;
            }
        }
    }


    /**
     * The method gets a List of possible moves to make, and returned the best move it finds.
     *
     * @param allPossibleMoves List of all the possible moves that that the computer can do at the moment in the given board.
     * @return Integer number represent the value of this board, according to the pieces that are on that board.
     */
    private static Pair<Coordinate, Coordinate> ChooseBestMove(Piece.Color computerColor, List<Pair<Coordinate, Coordinate>> allPossibleMoves, Board currentBoard) {

        Pair<Coordinate, Coordinate> bestMove = null;
        if(computerColor == Piece.Color.WHITE){
            //if the computer is White --> search for the move with the maximum value of board.
            int bestValueBoard = Integer.MIN_VALUE;
            for (Pair<Coordinate, Coordinate> move : allPossibleMoves) {
                Board currentBoardToCheck = new Board(currentBoard);
                currentBoard.movePieceToNewLocation(move.getKey(), move.getValue(), currentBoardToCheck.getPieceByCoordinate(move.getKey()));
                //checking 4 moves forward if this move is resulting with good value.
                int thisBoardValue = checkBestMoveDepth(7, currentBoardToCheck, computerColor);
                if (bestValueBoard < thisBoardValue) {
                    bestMove = move;
                    bestValueBoard = thisBoardValue;
                }
                currentBoardToCheck.undoMove();
            }
            return bestMove;
        }

        else{
            // if the computer is black --> search for the move with the minimum value of board.
            int bestValueBoard = Integer.MAX_VALUE;
            for (Pair<Coordinate, Coordinate> move : allPossibleMoves) {
                currentBoard.movePieceToNewLocation(move.getKey(), move.getValue(), currentBoard.getPieceByCoordinate(move.getKey()));
                int thisBoardValue = checkBestMoveDepth(7,currentBoard,computerColor);
                if (bestValueBoard > thisBoardValue) {
                    bestMove = move;
                    bestValueBoard = thisBoardValue;
                }
                currentBoard.undoMove();
            }
            return bestMove;
        }


    }



    /**
     * Calculates all the possible moves of the given color on the given chess board, and adds them to the given list.
     *
     * @param computerColor    Color of the computer at the moment
     * @param currentBoard     Board represent the current chess board
     * @param allPossibleMoves List to add all the possible moves to.
     */
    private static void calculateAllMoves(Piece.Color computerColor, Board currentBoard, List<Pair<Coordinate, Coordinate>> allPossibleMoves) {
        Set<Piece> piecesToCheck;
        //getting the matching pieces set from the board.
        if (computerColor == Piece.Color.BLACK) {
            piecesToCheck = currentBoard.getBlacksPieces();
        } else {
            piecesToCheck = currentBoard.getWhitesPieces();
        }


        for (Piece piece : piecesToCheck) {
            //for each piece, gets it's initial coordinate.
            Coordinate currentPiecePosition = piece.getCoordinate();
            //adding all the possible moves of this piece.
            for (Coordinate pieceTargetLocation : piece.getPossibleMoves()) {
                // add a possible move for the computer
                allPossibleMoves.add(new Pair<>(currentPiecePosition, pieceTargetLocation));
            }
        }
    }

    /**
     * This Function is used to calculate the best move for the computer.
     * it calculate the value of the pieces on the board :
     *
     * @param currentBoard
     * @return
     */
    private static int calculateBoardValue(Board currentBoard) {
        int sum = 0;
        for (Piece whitePiece : currentBoard.getWhitesPieces()) {
            sum += whitePiece.getPieceValue();
        }
        for (Piece blackPiece : currentBoard.getBlacksPieces()) {
            sum += blackPiece.getPieceValue();
        }
        return sum;
    }


    /**
     * The computer calculates the best move for the given color pieces, on the given board and returned it.
     * in this method, using the best move according to pieces values.
     * @param computerColor     Color the computer is playing in the game.
     * @param currentBoard      Board of the current chess game.
     * @return Pair of Coordinates:
     * - The first coordinate is the coordinate of the piece that should move.
     * - The second coordinate is the coordinate of the chosen piece new location.
     */
    protected static Pair<Coordinate, Coordinate> generatingMoveWithoutGoingDeeper(Piece.Color computerColor, Board currentBoard) {
        Set<Piece> piecesToCheck;
        List<Pair<Coordinate, Coordinate>> allPossibleMoves = new ArrayList<>();
        calculateAllMoves(computerColor, currentBoard, allPossibleMoves);
        for (int i = 0; i <= 5; i++) {
            //shuffling the list of moves 5 times, so every time the computer will choose a different move
            Collections.shuffle(allPossibleMoves);
        }
        return ChooseBestMove(computerColor, allPossibleMoves, currentBoard);
    }


    /**
     * old way to calculate best move...(give random move)
     *
     * @param allPossibleMoves all the possible moves that are now Available on the board.
     * @return a random move from the given list.
     */
    private static Pair<Coordinate, Coordinate> randomBestMove(List<Pair<Coordinate, Coordinate>> allPossibleMoves) {
        //currently, the computer plays randomly.
        int indexOfNextMove = new Random().nextInt(allPossibleMoves.size());
        return allPossibleMoves.get(indexOfNextMove);
    }

}

