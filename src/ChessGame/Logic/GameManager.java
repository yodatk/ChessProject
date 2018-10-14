package ChessGame.Logic;

import ChessGame.Logic.Pieces.*;

import java.util.*;

/**
 * Class represent a single game manager.
 * In Charge of:
 *   - Pieces exchange.
 *   - Special moves and special situation in the game like , check, checkmate.
 *   - Determines who won the game.
 * Acts as an communicator between the UI to the logic of the pieces and boards.
 */
public class GameManager {
    //region Fields
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
     * integer represent the number of moves made
     */
    private int moveCounter;
    //endregion Fields

    //Constructor
    public GameManager() {
        this.gameBoard = new Board(Board.BoardMode.START_GAME);
        this.deadPieces = new Stack<>();
        this.currentPlayer = Piece.Color.WHITE;
        this.moveCounter = 0;
    }

    //region Getters & Setters
    public Piece.Color getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Piece.Color currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public Stack<Piece> getDeadPieces() {
        return deadPieces;
    }

    public void resetGame() {
        this.deadPieces.clear();
        this.currentPlayer = Piece.Color.WHITE;
        this.gameBoard.resetBoard();
    }
    //endregion Getters & Setters


    /**
     * Moves a piece that is found in the one Coordinate, to the other one, and updates the board, and the pieces on it.
     * if there is a special occasion with that specific moves, act accordingly.
     * @param currentPosition   Coordinate represent the initial location of the piece before it moved.
     * @param targetLocation    Coordinate represent the location the player chose to move the selected piece.
     * @return      SpecialMove Enum to indicate if any special move was preformed( as castling or pawn promotion)
     *              so the UI could act accordingly.
     */
    public SpecialMove movePiece(Coordinate currentPosition, Coordinate targetLocation) {
        Piece chosenPiece = getGameBoard().getTileByCoordination(currentPosition).getCurrentPiece();
        if (chosenPiece == null) {
            // - if there is no piece in the selected coordinate
            // --> don't change the board , and return INVALID_MOVE
            System.out.println("error");
            return SpecialMove.INVALID_MOVE;
        } else {
            SpecialMove output = null;

            if (chosenPiece instanceof Pawn) {
                //if the selected piece is a Pawn
                Pawn chosenPawn = (Pawn)chosenPiece;

                if(!chosenPawn.isHasBeenMoved()) {
                    chosenPawn.setHasBeenMoved(true);
                }
                if(((chosenPawn.getPieceColor() == Piece.Color.WHITE) && (targetLocation.getRow() == Row.EIGHT)) ||
                            ((chosenPawn.getPieceColor() == Piece.Color.BLACK) && (targetLocation.getRow() == Row.ONE))){
                    //checking whether the selected pawn supposed to be promoted.
                        output = SpecialMove.PAWN_PROMOTING;
                }

                if(this.gameBoard.getThePawnThatCanBeBackStabbed() != null){
                    //checking if the pawn just killed from behind
                    Pawn tempPawn = this.gameBoard.getThePawnThatCanBeBackStabbed();
                    if(
                            //if this is a white pawn, and the "canBeKilled" is south of him, and it's not it's first move
                            ((chosenPawn.getPieceColor()== Piece.Color.WHITE) && (targetLocation.getSouth() == tempPawn.getCoordinate()) && (currentPosition.getRow() != Row.TWO))
                             ||// OR
                            //if this is a black pawn, and the "canBeKilled" is north of him, and it's not it's first move
                             ((chosenPawn.getPieceColor()== Piece.Color.BLACK) && (targetLocation.getNorth() == tempPawn.getCoordinate()) && (currentPosition.getRow() != Row.SEVEN))
                        ){

                        //means that the selected pawn just killed a piece from behind:
                        Tile whereTheKilledPawnWas = this.gameBoard.getTileByCoordination(tempPawn.getCoordinate());
                        //removing the killed pawn from the board
                        whereTheKilledPawnWas.setCurrentPiece(null);
                        removePieceFromBoard(tempPawn);
                        this.gameBoard.setThePawnThatCanBeBackStabbed(null);

                        output = SpecialMove.KILLING_FROM_BEHIND;
                    }
                }

            } else if (chosenPiece instanceof King) {
                //if the selected piece is a King
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

                        } else if (targetLocation == Coordinate.C1) {
                            //moving the rook to the new location
                            Board.a1Rook.setCoordinate(Coordinate.D1);
                            this.gameBoard.getTileByCoordination(Coordinate.A1).setCurrentPiece(null);
                            this.gameBoard.getTileByCoordination(Coordinate.D1).setCurrentPiece(Board.a1Rook);
                            Board.a1Rook.setHasBeenMoved(true);
                            output = SpecialMove.WHITE_BIG_CASTLING;

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


                        } else if (targetLocation == Coordinate.C8) {
                            //moving the rook to the new location
                            Board.a8Rook.setCoordinate(Coordinate.D8);
                            this.gameBoard.getTileByCoordination(Coordinate.A8).setCurrentPiece(null);
                            this.gameBoard.getTileByCoordination(Coordinate.D8).setCurrentPiece(Board.a8Rook);
                            Board.a8Rook.setHasBeenMoved(true);
                            output = SpecialMove.BLACK_BIG_CASTLING;
                        }
                    }
                }
            }

            movePieceToNewLocation(currentPosition, targetLocation, chosenPiece);

            if (output == null) {
                //if nothing special happen
                output = SpecialMove.NORMAL_MOVE;
            }
            this.moveCounter++;
            return output;
        }
    }

    /**
     * This Method is called in the "movePiece" function.
     * it's updating the board and the piece itself on it's new location
     * @param currentPosition   Coordinate of the given piece before the move is made.
     * @param targetLocation    Coordinate of the updated location of the piece after the move is made
     * @param chosenPiece       Piece that it's location needs to be updated.
     */
    private void movePieceToNewLocation(Coordinate currentPosition, Coordinate targetLocation, Piece chosenPiece) {
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
            removePieceFromBoard(otherPiece);
        }
    }

    /**
     * Removes a given piece from it's matching set of Pieces that matches it's color.
     *    - If the given piece is Black --> will remove it from the set of the Black Pieces.
     *    - If the given piece is White --> will remove it from the set of the White Pieces.
     * @param otherPiece    Piece represent the piece that's need to be removed.
     */
    private void removePieceFromBoard(Piece otherPiece) {
        this.deadPieces.add(otherPiece);
        if (otherPiece.getPieceColor() == Piece.Color.WHITE) {
            this.gameBoard.getWhitesPieces().remove(otherPiece);
        } else {
            this.gameBoard.getBlacksPieces().remove(otherPiece);
        }
    }

    /**
     * This method needs to be called after a certain move is made.
     * The method checks various situations, and  the Following :
     *      - If it was a Rook, King, or a Pawn --> change their "hasBeenMoved" property to 'true'
     *      - Change the "Can be killed from behind pawn" property according to the new situation on the board.
     *
     *      - If either of the player won (if there is a checkmate)
     *      - If either of the kings is threaten (checked)
     * If nothing special happened, return the MID_GAME property, to notify the game is still running
     *
     * 
     * @param movedPiece  Piece represent the last moving piece on the Chess Board.
     * @return GameMod Enum , represent the special cases in the game:
     *                  1.MID_GAME          -->     normal game still running.
     *                  2.WHITE_WON         -->     checkmate for black
     *                  3.BLACK_WON         -->     checkmate for white
     *                  4.WHITE_IS_CHECKED  -->     white king is in threat
     *                  5.BLACK_IS_CHECKED  -->     black king is in threat
     */
    public GameMod afterMoveResult(Piece movedPiece) {
        if(this.gameBoard.getThePawnThatCanBeBackStabbed() != null){
            //if currently there is a Pawn in the field of "can be killed from behind --> change it back to null.
            this.gameBoard.getThePawnThatCanBeBackStabbed().setCanBeKilledFromBehind(false);
            this.gameBoard.setThePawnThatCanBeBackStabbed(null);
        }
        if (movedPiece instanceof King) {
            //if the moving piece is a king --> setting it's movement to 'true'
            ((King) movedPiece).setHasBeenMoved(true);
        } else if (movedPiece instanceof Rook) {
            //if the moving piece is a rook --> setting it's movement to 'true'
            ((Rook) movedPiece).setHasBeenMoved(true);

        } else if (movedPiece instanceof Pawn) {
            //if the moving piece is a Pawn --> setting it's movement to 'true'
            if (!((Pawn) movedPiece).isHasBeenMoved()) {
                //setting the first move of pawn, and setting if this pawn could be killed from behind.
                ((Pawn) movedPiece).setHasBeenMoved(true);
            }
            if (
                        ((movedPiece.getPieceColor()== Piece.Color.WHITE) && (movedPiece.getCoordinate().getRow() == Row.FOUR))
                        ||
                        ((movedPiece.getPieceColor()== Piece.Color.BLACK) && (movedPiece.getCoordinate().getRow() == Row.FIVE))
                )
                {
                    //if the pawn started the game with a double step --> set the pawn to the next "kill from behind" pawn
                    ((Pawn) movedPiece).setCanBeKilledFromBehind(true);
                    this.gameBoard.setThePawnThatCanBeBackStabbed((Pawn) movedPiece);
                }

            }

        GameMod output;
        //Calculating the next possible moves.
        if (this.currentPlayer == Piece.Color.WHITE) {
            //if the current is white --> calculate ALL the possible moves by Black.
            reCalculateMoves(this.gameBoard.getBlacksPieces());
        } else {
            //if the current is black --> calculate ALL the possible moves by White
            reCalculateMoves(this.gameBoard.getWhitesPieces());
        }
        Piece.Color oppositePlayer = this.currentPlayer.next();
        if (oppositePlayer == Piece.Color.WHITE) {
            //if the next player is white --> gather all it's possible movement and  checks whether the king is in threat
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
                if(allWhiteMoves.isEmpty()){
                    //if the White King is not threatened but also have no legal move to do --> it's a stalemate.
                    output = GameMod.STALEMATE;

                }
                else{
                    // if it's neither of those two above --> than the game will continue normally
                    output = GameMod.MID_GAME;
                }

            }

        } else {
            //if the next player is black --> gather all it's possible movement and  checks whether the king is in threat
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
                if(allBlackMoves.isEmpty()){
                    //if the Black King is not threatened but also have no legal move to do --> it's a stalemate.
                    output = GameMod.STALEMATE;

                }
                else{
                    // if it's neither of those two above --> than the game will continue normally
                    output = GameMod.MID_GAME;
                }

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

    /**
     * This function is called when a pawn get to the end of the board.
     * it takes a given pawn , and promote it according to the user Choice.
     * @param toPromote     Pawn object to promote.
     * @param promotion     Char indicates the choice of the user for the pawn's promotion
     */
    public void promotionFunction(Pawn toPromote, char promotion){
        Tile pawn_to_promote_tile = this.gameBoard.getTileByCoordination(toPromote.getCoordinate());
        Piece promotionPiece;
        switch(promotion){
            //creating the new piece according to the player choice
            case 'Q':
                promotionPiece = new Queen(toPromote.getPieceColor(),toPromote.getCoordinate(),toPromote.getKing());
                break;
            case 'R':
                promotionPiece = new Rook(toPromote.getPieceColor(),toPromote.getCoordinate(),toPromote.getKing());
                break;
            case 'B':
                promotionPiece = new Bishop(toPromote.getPieceColor(),toPromote.getCoordinate(),toPromote.getKing());
                break;
            case 'N':
                promotionPiece = new Knight(toPromote.getPieceColor(),toPromote.getCoordinate(),toPromote.getKing());
                break;
            default:
                //in default --> will create a new Knight
                promotionPiece = new Knight(toPromote.getPieceColor(),toPromote.getCoordinate(),toPromote.getKing());
                break;
        }
        //removing the pawn and adding the promotion piece instead
        removePieceFromBoard(toPromote);
        pawn_to_promote_tile.setCurrentPiece(null);
        pawn_to_promote_tile.setCurrentPiece(promotionPiece);
        if(promotionPiece.getPieceColor() == Piece.Color.WHITE){
            this.gameBoard.getWhitesPieces().add(promotionPiece);
        }
        else{
            this.gameBoard.getBlacksPieces().add(promotionPiece);
        }
    }
}


