package logic.board;


import logic.pieces.*;

import java.util.*;

/**
 * Class represents the Board of the chess game.
 */
public class Board {

    /**
     * Enum represent the two different modes you can initialise a board:
     *  -- EMPTY: Initialising all the valid tiles there are in a chess board, but with no Pieces on it.
     *            Mainly for tests purposes.
     *  -- START_GAME: Initialising all the valid tiles there are in a chess board,
     *                 with all the pieces in their valid starting tiles.
     *
     */
    public enum BoardMode {
        EMPTY,
        START_GAME
    }

    //region General Chess Pieces

    //region Black Pieces

    // ==== BLACK PIECES ===
    //-->BLACK King
    public static King blackKing;

    //-->BLACK Queen
    public static Queen blackQueen;



    // -->BLACK Pawns
    public static Pawn a7Pawn;
    public static Pawn b7Pawn;
    public static Pawn c7Pawn;
    public static Pawn d7Pawn;
    public static Pawn e7Pawn;
    public static Pawn f7Pawn;
    public static Pawn g7Pawn;
    public static Pawn h7Pawn;

    //-->BLACK Rooks
    public static Rook a8Rook;
    public static Rook h8Rook;

    //-->BLACK Knights
    public static Knight b8Knight;
    public static Knight g8Knight;

    //-->BLACK Bishops
    public static Bishop c8Bishop;
    public static Bishop f8Bishop;
    //endregion BlackPieces

    //region White Pieces

    // ==== WHITE PIECES ===

    //-->WHITE King
    public static King whiteKing;

    //-->WHITE Queen
    public static Queen whiteQueen;



    // -->WHITE Pawns
    public static Pawn a2Pawn;
    public static Pawn b2Pawn;
    public static Pawn c2Pawn;
    public static Pawn d2Pawn;
    public static Pawn e2Pawn;
    public static Pawn f2Pawn;
    public static Pawn g2Pawn;
    public static Pawn h2Pawn;

    //-->WHITE Rooks
    public static Rook a1Rook;
    public static Rook h1Rook;

    //-->WHITE Knights
    public static Knight b1Knight;
    public static Knight g1Knight;

    //-->WHITE Bishops
    public static Bishop c1Bishop;
    public static Bishop f1Bishop;

    //endregion White Pieces


    public static Set<Piece> allBlackPieces;
    public static Set<Piece> allWhitePieces;
    //endregion General Chess Pieces

    //region Initialising Pieces
    static {
        // ==== BLACK PIECES ===
        //-->BLACK King
        blackKing = new King(Piece.Color.BLACK, Coordinate.E8);

        //-->BLACK Queen
        blackQueen = new Queen(Piece.Color.BLACK, Coordinate.D8, blackKing);



        // -->BLACK Pawns
        a7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.A7, blackKing);
        b7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.B7, blackKing);
        c7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.C7, blackKing);
        d7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.D7, blackKing);
        e7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.E7, blackKing);
        f7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.F7, blackKing);
        g7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.G7, blackKing);
        h7Pawn = new Pawn(Piece.Color.BLACK, Coordinate.H7, blackKing);

        //-->BLACK Rooks
        a8Rook = new Rook(Piece.Color.BLACK, Coordinate.A8, blackKing);
        h8Rook = new Rook(Piece.Color.BLACK, Coordinate.H8, blackKing);

        //-->BLACK Knights
        b8Knight = new Knight(Piece.Color.BLACK, Coordinate.B8, blackKing);
        g8Knight = new Knight(Piece.Color.BLACK, Coordinate.G8, blackKing);

        //-->BLACK Bishops
        c8Bishop = new Bishop(Piece.Color.BLACK, Coordinate.C8, blackKing);
        f8Bishop = new Bishop(Piece.Color.BLACK, Coordinate.F8, blackKing);


        allBlackPieces = new HashSet<Piece>(Arrays.asList(
                a7Pawn, b7Pawn, c7Pawn, d7Pawn, e7Pawn, f7Pawn, g7Pawn, h7Pawn,
                a8Rook, h8Rook,
                g8Knight, b8Knight,
                c8Bishop, f8Bishop,
                blackQueen, blackKing
        ));


        // ==== WHITE PIECES ===

        //-->WHITE King
        whiteKing = new King(Piece.Color.WHITE, Coordinate.E1);

        //-->WHITE Queen
        whiteQueen = new Queen(Piece.Color.WHITE, Coordinate.D1, whiteKing);



        // -->WHITE Pawns
        a2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.A2, whiteKing);
        b2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.B2, whiteKing);
        c2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.C2, whiteKing);
        d2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.D2, whiteKing);
        e2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.E2, whiteKing);
        f2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.F2, whiteKing);
        g2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.G2, whiteKing);
        h2Pawn = new Pawn(Piece.Color.WHITE, Coordinate.H2, whiteKing);

        //-->WHITE Rooks
        a1Rook = new Rook(Piece.Color.WHITE, Coordinate.A1, whiteKing);
        h1Rook = new Rook(Piece.Color.WHITE, Coordinate.H1, whiteKing);

        //-->WHITE Knights
        b1Knight = new Knight(Piece.Color.WHITE, Coordinate.B1, whiteKing);
        g1Knight = new Knight(Piece.Color.WHITE, Coordinate.G1, whiteKing);

        //-->WHITE Bishops
        c1Bishop = new Bishop(Piece.Color.WHITE, Coordinate.C1,whiteKing);
        f1Bishop = new Bishop(Piece.Color.WHITE, Coordinate.F1,whiteKing);



        allWhitePieces = new HashSet<Piece>(Arrays.asList(
                a2Pawn, b2Pawn, c2Pawn, d2Pawn, e2Pawn, f2Pawn, g2Pawn, h2Pawn,
                a1Rook, h1Rook,
                g1Knight, b1Knight,
                c1Bishop, f1Bishop,
                whiteQueen, whiteKing
        ));

    }
    //endregion Initialising Pieces

    //region Fields
    /**
     * 2D array of Tiles represent the current board of the chess game
     */
    private Piece[][] board;
    /**
     * Set of Pieces represent the black pieces in the chess game
     */
    private Set<Piece> blacksPieces;
    /**
     * Set of Pieces represent the white pieces in the chess game
     */
    private Set<Piece> whitesPieces;
    /**
     * The only pawn on the board(if at all) that after it's first move, can be killed from behind.
     */
    private Pawn thePawnThatCanBeBackStabbed;

    /**
     * Stack of all the pieces that died in this game(for scoring and undo purposes)
     */
    private Stack<Piece> deadPieces;

    /**
     * Stack of all the moves that happen in the game
     */
    private Stack<Move> movesStack;
    //endregion Fields

    // default Constructor
    public Board(BoardMode mode) {
        this.board = new Piece[8][8];
        this.whitesPieces = new HashSet<>();
        this.blacksPieces = new HashSet<>();
        initEmptyBoard();
        if (mode == BoardMode.START_GAME) {
            initPieces();
        }
        this.thePawnThatCanBeBackStabbed = null;
        this.deadPieces = new Stack<>();
        this.movesStack = new Stack<>();
    }

    //Copy Constructor
    public Board(Board boardToCopy){
        this.board = new Piece[8][8];
        //copying pieces
        for(int i = 0 ; i < 8 ;i++){
            for(int j = 0; j < 8; j++){
                this.board[i][j] = boardToCopy.board[i][j];
            }
        }
        this.whitesPieces = new HashSet<>(boardToCopy.getWhitesPieces());
        this.blacksPieces = new HashSet<>(boardToCopy.getBlacksPieces());
        if(boardToCopy.thePawnThatCanBeBackStabbed!=null){
            this.setThePawnThatCanBeBackStabbed((Pawn)this.getPieceByCoordinate(boardToCopy.thePawnThatCanBeBackStabbed.getCoordinate()));
        }
        else{
            this.thePawnThatCanBeBackStabbed = null;
        }
        this.deadPieces = new Stack<>();
        for(Piece deadToCopy : boardToCopy.getDeadPieces()){
            this.getDeadPieces().push(deadToCopy);
        }
        this.movesStack = new Stack<>();
        for(Move move : boardToCopy.movesStack){
            this.movesStack.push(move);
        }
    }

    //region Getters & Setters
    public Pawn getThePawnThatCanBeBackStabbed() {
        return thePawnThatCanBeBackStabbed;
    }

    public void setThePawnThatCanBeBackStabbed(Pawn thePawnThatCanBeBackStabbed) {
        this.thePawnThatCanBeBackStabbed = thePawnThatCanBeBackStabbed;
    }

    public Set<Piece> getBlacksPieces() {
        return blacksPieces;
    }

    public Set<Piece> getWhitesPieces() {
        return whitesPieces;
    }

    public Stack<Piece> getDeadPieces() {
        return deadPieces;
    }

    public void setDeadPieces(Stack<Piece> deadPieces) {
        this.deadPieces = deadPieces;
    }

    public Stack<Move> getMovesStack() {
        return movesStack;
    }

    public void setMovesStack(Stack<Move> movesStack) {
        this.movesStack = movesStack;
    }

    //endregion Getters & Setters


    /**
     * Init all the Tiles of this board to be empty
     */
    public void initEmptyBoard() {
        for (Coordinate coordinates : Coordinate.allCoordinates.values()) {
            this.board[coordinates.getRow().getValue()][coordinates.getColumn().getValue()] = null;
        }

    }

    /**
     * Init all the Tiles of this Board with all the chess pieces , each piece in its right initial Coordinate.
     */
    public void initPieces() {
        for (Piece whitePiece : allWhitePieces) {
            //adding all white pieces
            whitePiece.resetPiece();
            setGivenPieceOnBoard(whitePiece);
            this.whitesPieces.add(whitePiece);

        }
        for (Piece blackPiece : allBlackPieces) {
            //adding all black pieces
            blackPiece.resetPiece();
            setGivenPieceOnBoard(blackPiece);
            this.blacksPieces.add(blackPiece);
        }
        for(Piece whitePiece : this.getWhitesPieces()){
            //calculating all possible moves for white pieces
            whitePiece.calculateAllPossibleMoves(this);
        }
        for(Piece blackPiece : this.getBlacksPieces()){
            //calculating all possible moves for black pieces
            blackPiece.calculateAllPossibleMoves(this);
        }

    }




    public Piece getPieceByCoordinate(Coordinate c){
        return board[c.getRow().getValue()][c.getColumn().getValue()];
    }

    /**
     * Returns the Piece that matches the given row and column indexes
     * @param row int represent the number of the row in the board.
     * @param col int represent the number of the column in the board
     * @return Piece object that matches the given Indexes.
     * @throws IllegalArgumentException if the given indexes are out of the valid bound of a chess board.
     */
    public Piece getPieceByIndexes(int row, int col){
        if((row < 0) | (col < 0 )| (row > 7) | (col > 7)){
            throw new IllegalArgumentException("index of tile is out of bound");
        }

        return this.board[row][col];
    }

    public void setGivenPieceOnBoard(Piece piece){
        if(piece != null){
            this.board[piece.getCoordinate().getRow().getValue()][piece.getCoordinate().getColumn().getValue()] = piece;
        }
    }
    public void emptyAGivenTileCoordination(Coordinate c){
        this.board[c.getRow().getValue()][c.getColumn().getValue()] = null;
    }

    /**
     * Reset this board to it's initial State
     */
    public void resetBoard(){
        //removing white pieces from the board
        for(Piece whitePiece : this.whitesPieces){
            emptyAGivenTileCoordination(whitePiece.getCoordinate());
        }
        //removing black pieces from the board
        for(Piece blackPiece : this.blacksPieces){
            emptyAGivenTileCoordination(blackPiece.getCoordinate());

        }

        //removing all the pieces from the pieces sets
        this.blacksPieces.clear();
        this.whitesPieces.clear();

        //clearing the moves stack and dead pieces stack.
        this.deadPieces.clear();
        this.movesStack.clear();

        //resetting the pieces coordination's
        for(Piece whitePiece: allWhitePieces){
            whitePiece.resetPiece();
        }
        for(Piece blackPiece : allBlackPieces){
            blackPiece.resetPiece();
        }
        //putting the pieces back on the board
        initPieces();

    }

    /**
     * Calculates if the black king is in danger.
     * @return 'true' if the black king is in fact in danger 'false' otherwise.
     */
    public boolean checkForBlackKingSafety(){
        blackKing.calculateIfInDanger(this);
        return blackKing.isThreaten();
    }
    /**
     * Calculates if the white king is in danger.
     * @return 'true' if the white king is in fact in danger 'false' otherwise.
     */
    public boolean checkForWhiteKingSafety(){
        whiteKing.calculateIfInDanger(this);
        return whiteKing.isThreaten();
    }

    /**
     * Returns the possible moves of ALL of the White pieces that are still on the board.
     * @return Set of Coordinates represent all the possible moves by all the White Pieces
     */
    public Set<Coordinate> allPossibleWhiteMoves(){
        Set<Coordinate> allWhiteMoves = new HashSet<Coordinate>();
        for(Piece whitePiece : whitesPieces){
            allWhiteMoves.addAll(whitePiece.getPossibleMoves());
        }
        return allWhiteMoves;
    }
    /**
     * Returns the possible moves of ALL of the Black pieces that are still on the board.
     * @return Set of Coordinates represent all the possible moves by all the Black Pieces
     */
    public Set<Coordinate> allPossibleBlackMoves(){
        Set<Coordinate> allBlackMoves = new HashSet<Coordinate>();
        for(Piece blackPiece : blacksPieces){
            allBlackMoves.addAll(blackPiece.getPossibleMoves());
        }
        return allBlackMoves;
    }

    /**
     * This Method is called in the "movePiece" function.
     * it's updating the board and the piece itself on it's new location
     * @param currentPosition   Coordinate of the given piece before the move is made.
     * @param targetLocation    Coordinate of the updated location of the piece after the move is made
     * @param chosenPiece       Piece that it's location needs to be updated.
     */
    public void movePieceToNewLocation(Coordinate currentPosition, Coordinate targetLocation, Piece chosenPiece) {
        //setting the current location tile piece to null.
        this.emptyAGivenTileCoordination(currentPosition);
        //updating piece location in the piece
        chosenPiece.setCoordinate(targetLocation);
        Piece otherPiece = this.getPieceByCoordinate(targetLocation);
        //updating the piece location on the board.
        this.emptyAGivenTileCoordination(targetLocation);
        this.setGivenPieceOnBoard(chosenPiece);

        //adding this move to the move stack
        Move thisMove = new Move(chosenPiece, currentPosition, targetLocation, otherPiece);
        this.movesStack.add(thisMove);

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
    public void removePieceFromBoard(Piece otherPiece) {
        this.deadPieces.add(otherPiece);
        if (otherPiece.getPieceColor() == Piece.Color.WHITE) {
            this.getWhitesPieces().remove(otherPiece);
        } else {
            this.getBlacksPieces().remove(otherPiece);
        }
    }

    /**
     * undo the last move that was occurred on the board.
     */
    public void undoMove(){
        if(!this.movesStack.empty()){
            Move lastMove = this.movesStack.pop();
            Piece lastMovedPiece = lastMove.getPiece();
            Piece otherPiece = lastMove.getWasBeforePiece();
            if(otherPiece != null){
                this.deadPieces.pop();
                if(otherPiece.getPieceColor() == Piece.Color.WHITE){
                    this.whitesPieces.add(otherPiece);
                }
                else{
                    this.blacksPieces.add(otherPiece);
                }
                otherPiece.setCoordinate(lastMove.getTargetTile());
                this.setGivenPieceOnBoard(otherPiece);
            }
            else{
                this.emptyAGivenTileCoordination(lastMove.getTargetTile());
            }

            lastMovedPiece.setCoordinate(lastMove.getFromTile());
            this.setGivenPieceOnBoard(lastMovedPiece);

        }


    }


}
