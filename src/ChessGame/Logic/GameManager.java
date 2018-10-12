package ChessGame.Logic;

import ChessGame.Logic.Pieces.*;

import java.util.*;

public class GameManager {
    /**
     * Board object represent the board of the chess game and the pieces on it.
     */
    private Board gameBoard;
    /**
     * Stack of all the pieces that died in this game(for scoring and undo purposes)
     */
    private Stack<Piece> deadPieces;

    /**
     * Color represent the current player that supposed to play
     */
    private Piece.Color currentPlayer;

    /**
     * the only pawn on the board(if at all) that after it's first move, can be killed from behind.
     */
    private Pawn thePawnThatCanBeBackStabbed;

    /**
     * integer represent the number of moves made
     */
    private int moveCounter;

    public GameManager() {
        this.gameBoard = new Board(Board.BoardMode.START_GAME);
        this.deadPieces = new Stack<>();
        this.currentPlayer = Piece.Color.WHITE;
        this.thePawnThatCanBeBackStabbed = null;
        this.moveCounter = 0;

    }

    public Piece.Color getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Piece.Color currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void resetGame() {
        this.deadPieces.clear();
        this.currentPlayer = Piece.Color.WHITE;
        this.gameBoard.resetBoard();
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public Stack<Piece> getDeadPieces() {
        return deadPieces;
    }

    public SpecialMove movePiece(Coordinate currentPosition, Coordinate targetLocation) {
        Piece chosenPiece = getGameBoard().getTileByCoordination(currentPosition).getCurrentPiece();
        if (chosenPiece == null) {
            // - if there is no piece in the selected coordinate
            // --> don't change the board , and return INVALID_MOVE
            System.out.println("error");
            return SpecialMove.INVALID_MOVE;
        } else {
            SpecialMove output = null;
            //erasing the piece from the previous Tile, and updating it's location to the new tile.

            if (chosenPiece instanceof Pawn) {
                Pawn chosenPawn = (Pawn)chosenPiece;
                if(chosenPawn.isHasBeenMoved()){
                    chosenPawn.setHasBeenMoved(true);
                    if(((chosenPawn.getPieceColor() == Piece.Color.WHITE) && (chosenPawn.getCoordinate().getRow() == Row.EIGHT)) ||
                            ((chosenPawn.getPieceColor() == Piece.Color.BLACK) && (chosenPawn.getCoordinate().getRow() == Row.ONE))){
                        output = SpecialMove.PAWN_PROMOTING;
                    }
                }

            } else if (chosenPiece instanceof King) {
                if (!((King) chosenPiece).isHasBeenMoved()) {
                    ((King) chosenPiece).setHasBeenMoved(true);
                    //checking for castling
                    if (this.currentPlayer == Piece.Color.WHITE) {
                        //if the current player is white
                        //small castling
                        if (targetLocation == Coordinate.G1) {
                            //moving the rook to the new location
                            Board.h1Rook.setCoordinate(Coordinate.F1);
                            this.gameBoard.getTileByCoordination(Coordinate.H1).setCurrentPiece(null);
                            this.gameBoard.getTileByCoordination(Coordinate.F1).setCurrentPiece(Board.h1Rook);
                            Board.h1Rook.setHasBeenMoved(true);
                            output = SpecialMove.WHITE_SMALL_CASTLING;

                            //todo replace this with the fitting code
                            System.out.println("white_small");


                        } else if (targetLocation == Coordinate.C1) {
                            //moving the rook to the new location
                            Board.a1Rook.setCoordinate(Coordinate.D1);
                            this.gameBoard.getTileByCoordination(Coordinate.A1).setCurrentPiece(null);
                            this.gameBoard.getTileByCoordination(Coordinate.D1).setCurrentPiece(Board.a1Rook);
                            Board.a1Rook.setHasBeenMoved(true);
                            output = SpecialMove.WHITE_BIG_CASTLING;
                            //todo replace this with the fitting code
                            System.out.println("white_big");

                        }
                    } else {
                        //if the current player is black
                        //small castling
                        if (targetLocation == Coordinate.G8) {
                            //moving the rook to the new location
                            Board.h8Rook.setCoordinate(Coordinate.F8);
                            this.gameBoard.getTileByCoordination(Coordinate.H8).setCurrentPiece(null);
                            this.gameBoard.getTileByCoordination(Coordinate.F8).setCurrentPiece(Board.h8Rook);
                            Board.h8Rook.setHasBeenMoved(true);
                            output = SpecialMove.BLACK_SMALL_CASTLING;
                            //todo replace this with the fitting code
                            System.out.println("black_small");

                        } else if (targetLocation == Coordinate.C8) {
                            //moving the rook to the new location
                            Board.a8Rook.setCoordinate(Coordinate.D8);
                            this.gameBoard.getTileByCoordination(Coordinate.A8).setCurrentPiece(null);
                            this.gameBoard.getTileByCoordination(Coordinate.D8).setCurrentPiece(Board.a8Rook);
                            Board.a8Rook.setHasBeenMoved(true);
                            output = SpecialMove.BLACK_BIG_CASTLING;
                            //todo replace this with the fitting code
                            System.out.println("black_big");

                        }
                    }
                }
            }

            movePiece(currentPosition, targetLocation, chosenPiece);

            if (output == null) {
                output = SpecialMove.NORMAL_MOVE;
                //todo replace this with the fitting code
                System.out.println("normal");
            }
            this.moveCounter++;
            return output;
        }
    }

    private void movePiece(Coordinate currentPosition, Coordinate targetLocation, Piece chosenPiece) {
        //setting the current location tile piece to null.
        getGameBoard().getTileByCoordination(currentPosition).setCurrentPiece(null);
        //updating piece location in the piece
        chosenPiece.setCoordinate(targetLocation);
        Piece otherPiece = getGameBoard().getTileByCoordination(targetLocation).getCurrentPiece();
        //updating the piece location on the board.
        getGameBoard().getTileByCoordination(targetLocation).setCurrentPiece(null);
        getGameBoard().getTileByCoordination(targetLocation).setCurrentPiece(chosenPiece);

        if (otherPiece != null) {
            //if there is another piece in the target tile --> remove it from the board, and add to the dead pieces.
            this.deadPieces.add(otherPiece);
            if (otherPiece.getPieceColor() == Piece.Color.WHITE) {
                this.gameBoard.getWhitesPieces().remove(otherPiece);
            } else {
                this.gameBoard.getBlacksPieces().remove(otherPiece);
            }
        }
    }

    public GameMod afterMoveResult(Piece movedPiece) {
        if (movedPiece instanceof King) {
            ((King) movedPiece).setHasBeenMoved(true);
        } else if (movedPiece instanceof Rook) {
            ((Rook) movedPiece).setHasBeenMoved(true);
        } else if (movedPiece instanceof Pawn) {
            if (!((Pawn) movedPiece).isHasBeenMoved()) {
                //setting the first move of pawn, and setting if this pawn could be killed from behind.
                ((Pawn) movedPiece).setHasBeenMoved(true);
                if ((movedPiece.getCoordinate().getRow().getValue() == 4) || (movedPiece.getCoordinate().getRow().getValue() == 3))
                    ((Pawn) movedPiece).setCanBeKilledFromBehind(true);
                this.thePawnThatCanBeBackStabbed = (Pawn) movedPiece;
            }

        }
        //if there is a pawn that can be stabbed from behind on the board --> disable that option.
        if (this.thePawnThatCanBeBackStabbed != null) {
            thePawnThatCanBeBackStabbed.setCanBeKilledFromBehind(false);
            thePawnThatCanBeBackStabbed = null;
        }
        GameMod output;
        //Calculating the next possible moves.
        if (this.currentPlayer == Piece.Color.WHITE) {
            reCalculateMoves(this.gameBoard.getBlacksPieces());
        } else {
            reCalculateMoves(this.gameBoard.getWhitesPieces());
        }
        Piece.Color oppositePlayer = this.currentPlayer.next();
        if (oppositePlayer == Piece.Color.WHITE) {
            Set<Coordinate> allWhiteMoves = this.gameBoard.allPossibleWhiteMoves();
            boolean isInThreat = this.gameBoard.checkForWhiteKingSafety();

            if (isInThreat) {
                if (allWhiteMoves.isEmpty()) {
                    //if the white king is threaten, and there is no possible move for white
                    // -->
                    // checkmate for black, black won
                    output = GameMod.BLACK_WON;
                } else {
                    //if the king is just threaten, so there is a check on the white king
                    output = GameMod.WHITE_IS_CHECKED;
                }
            } else {
                // if it's neither of those two above --> than the game will continue normally
                output = GameMod.MID_GAME;
            }

        } else {
            Set<Coordinate> allBlackMoves = this.gameBoard.allPossibleBlackMoves();
            boolean isInThreat = this.gameBoard.checkForBlackKingSafety();

            if (isInThreat) {
                if (allBlackMoves.isEmpty()) {
                    //if the black king is threaten, and there is no possible move for black
                    // -->
                    // checkmate for white, white won
                    output = GameMod.WHITE_WON;
                } else {
                    //if the king is just threaten, so there is a check on the black king
                    output = GameMod.BLACK_IS_CHECKED;
                }
            } else {
                // if it's neither of those two above --> than the game will continue normally
                output = GameMod.MID_GAME;
            }
        }


        //changing the color of the current player
        this.currentPlayer = this.currentPlayer.next();

        return output;
    }

    /**
     * Calculate and update the possible moves of each of piece in the given set.
     *
     * @param pieces Set of pieces that needs to be updated
     */
    private void reCalculateMoves(Set<Piece> pieces) {
        for (Piece piece : pieces) {
            piece.calculateAllPossibleMoves(this.gameBoard);
        }

    }
}


//            if(moveCounter>4){
//                for(Coordinate coordinate : Coordinate.allCoordinates.values()){
//                    System.out.print(coordinate+": ");
//                    Piece currentPiece = this.gameBoard.getTileByCoordination(coordinate).getCurrentPiece();
//                    if(currentPiece != null){
//                        System.out.println(currentPiece);
//                    }
//                    else{
//                        System.out.println("empty");
//                    }
//                }
//            }

