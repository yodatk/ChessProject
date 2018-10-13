package ChessGame.UI;

import ChessGame.Logic.*;
import ChessGame.Logic.Pieces.Pawn;
import ChessGame.Logic.Pieces.Piece;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Controller for the offline game window.
 */
public class GameWindowController {

    //region String Label Constants
    private final String WHITE_WON_LABEL = "Checkmate!\n White player Won";
    private final String BLACK_WON_LABEL = "Checkmate!\n Black player Won";
    private final String WHITE_IS_CHECKED = "Check On White";
    private final String BLACK_IS_CHECKED = "Check On Black";
    private final String WHITE_TURN = "White's Turn";
    private final String BLACK_TURN = "Black's Turn";
    //endregion String Label Constants


    //region ALL tiles
    //region 1st Row
    @FXML
    private Button tile_00;
    @FXML
    private Button tile_01;
    @FXML
    private Button tile_02;
    @FXML
    private Button tile_03;
    @FXML
    private Button tile_04;
    @FXML
    private Button tile_05;
    @FXML
    private Button tile_06;
    @FXML
    private Button tile_07;
    //endregion FirstRow

    //region 2nd row
    @FXML
    private Button tile_10;
    @FXML
    private Button tile_11;
    @FXML
    private Button tile_12;
    @FXML
    private Button tile_13;
    @FXML
    private Button tile_14;
    @FXML
    private Button tile_15;
    @FXML
    private Button tile_16;
    @FXML
    private Button tile_17;
    //endregion 2nd row

    //region 3rd row
    @FXML
    private Button tile_20;
    @FXML
    private Button tile_21;
    @FXML
    private Button tile_22;
    @FXML
    private Button tile_23;
    @FXML
    private Button tile_24;
    @FXML
    private Button tile_25;
    @FXML
    private Button tile_26;
    @FXML
    private Button tile_27;
    //endregion 3rd row

    //region 4rd row
    @FXML
    private Button tile_30;
    @FXML
    private Button tile_31;
    @FXML
    private Button tile_32;
    @FXML
    private Button tile_33;
    @FXML
    private Button tile_34;
    @FXML
    private Button tile_35;
    @FXML
    private Button tile_36;
    @FXML
    private Button tile_37;
    //endregion 4rd row

    //region 5th row
    @FXML
    private Button tile_40;
    @FXML
    private Button tile_41;
    @FXML
    private Button tile_42;
    @FXML
    private Button tile_43;
    @FXML
    private Button tile_44;
    @FXML
    private Button tile_45;
    @FXML
    private Button tile_46;
    @FXML
    private Button tile_47;
    //endregion 5th row

    //region 6th row
    @FXML
    private Button tile_50;
    @FXML
    private Button tile_51;
    @FXML
    private Button tile_52;
    @FXML
    private Button tile_53;
    @FXML
    private Button tile_54;
    @FXML
    private Button tile_55;
    @FXML
    private Button tile_56;
    @FXML
    private Button tile_57;
    //endregion 6th row

    //region 7th row
    @FXML
    private Button tile_60;
    @FXML
    private Button tile_61;
    @FXML
    private Button tile_62;
    @FXML
    private Button tile_63;
    @FXML
    private Button tile_64;
    @FXML
    private Button tile_65;
    @FXML
    private Button tile_66;
    @FXML
    private Button tile_67;
    //endregion 7th row

    //region 8th row
    @FXML
    private Button tile_70;
    @FXML
    private Button tile_71;
    @FXML
    private Button tile_72;
    @FXML
    private Button tile_73;
    @FXML
    private Button tile_74;
    @FXML
    private Button tile_75;
    @FXML
    private Button tile_76;
    @FXML
    private Button tile_77;
    //endregion 8th row
    //endregion ALLTiles

    /**
     * GridPane where all the tiles of the board are contained.
     */
    @FXML
    private GridPane mainBoard;

    /**
     * Label which tells what is the current situation on the board.
     */
    @FXML
    private Label infoLabel;

    /**
     * Images Dictionary to gether the right image when needed.
     */
    private ImagesDictionary imgDictionary;

    /**
     * 2D array of button represent the buttons that are inside the GridPane.
     */
    private Button[][] fxBoard;

    /**
     * GameManager object to handle the logic of the pieces on the board.
     */
    private GameManager gameManager;

    /**
     * Set of button represent the current possible moves of a chosen piece.
     */
    private Set<Button> possibleMovesBTN;

    /**
     * Color of the point of view of the player on the board, to know how to print the board.
     */
    private Piece.Color playerView;

    /**
     * Event handler when a piece is selected on the board.
     */
    public EventHandler<MouseEvent> beforeSelected;
    /**
     * Event handler when the user chose to move a piece on the board.
     */
    public EventHandler<MouseEvent> moveSelected;

    /**
     * Coordinate of the current selected tile.
     */
    private Coordinate selectedTile;

    public void initialize() {
        this.beforeSelected = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                whenSelected(event);
            }
        };

        this.moveSelected = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                moveThere(event);
            }
        };

        this.possibleMovesBTN = new HashSet<>();
        this.gameManager = new GameManager();
        fxBoard = new Button[][]{
                {tile_00, tile_01, tile_02, tile_03, tile_04, tile_05, tile_06, tile_07},
                {tile_10, tile_11, tile_12, tile_13, tile_14, tile_15, tile_16, tile_17},
                {tile_20, tile_21, tile_22, tile_23, tile_24, tile_25, tile_26, tile_27},
                {tile_30, tile_31, tile_32, tile_33, tile_34, tile_35, tile_36, tile_37},
                {tile_40, tile_41, tile_42, tile_43, tile_44, tile_45, tile_46, tile_47},
                {tile_50, tile_51, tile_52, tile_53, tile_54, tile_55, tile_56, tile_57},
                {tile_60, tile_61, tile_62, tile_63, tile_64, tile_65, tile_66, tile_67},
                {tile_70, tile_71, tile_72, tile_73, tile_74, tile_75, tile_76, tile_77}};


        mainBoard.getChildren().forEach(item -> {
            item.setOnMousePressed(event -> {
                whenSelected(event);
            });
        });

        imgDictionary = new ImagesDictionary();
        imgDictionary.initImages();

    }

    /**
     * This function is called whenever the user pressed on a button on the tile board, which is not a possible move.
     * @param e MouseEvent from the pressed Button.
     */
    @FXML
    public void whenSelected(MouseEvent e) {
        //erasing the current possible move buttons
        resetPossibleMovesBTN();
        //getting the index of the chosen tile.
        Button source = (Button) e.getSource();
        int colIndex = GridPane.getColumnIndex(source);
        int rowIndex = GridPane.getRowIndex(source);
        Coordinate selectedTile = getCoordinateWithRowAndCol(colIndex, rowIndex);

        if (this.playerView == Piece.Color.BLACK) {
            //if the chosen point of view is black --> reversing the board.
            colIndex = 7 - colIndex;
            rowIndex = 7 - rowIndex;
        }


        Piece selectedPiece = this.gameManager.getGameBoard().getTileByIndexes(rowIndex, colIndex).getCurrentPiece();
        possibleMovesBTN.clear();
        if ((selectedPiece != null) && (selectedPiece.getPieceColor() == this.gameManager.getCurrentPlayer())) {
            //if there is a piece on the tile, and it's the same color as the current player

            Set<Coordinate> selectedPossibleMoves = selectedPiece.getPossibleMoves();
            for (Coordinate move : selectedPossibleMoves) {
                //for each possible move of the chosen piece
                rowIndex = move.getRow().getValue();
                colIndex = move.getColumn().getValue();
                if (this.playerView == Piece.Color.BLACK) {
                    //if the chosen point of view is black --> reversing the board.
                    colIndex = 7 - colIndex;
                    rowIndex = 7 - rowIndex;
                }
                //painting the borders of the possible moves button in green, to show to the user
                Button selected = fxBoard[rowIndex][colIndex];
                selected.setOnMousePressed(this.moveSelected);
                selected.setStyle("-fx-border-color: green");
                possibleMovesBTN.add(selected);
                this.selectedTile = selectedTile;
            }

        }

    }

    /**
     * Gets a certain coordinates on the board according to the indexes of the row and column (of a pressed button)
     * @param colIndex  Int number represent the index of a Column
     * @param rowIndex  Int number represent the index of a Row
     * @return Coordinate that matches the given indexes.
     */
    private Coordinate getCoordinateWithRowAndCol(int colIndex, int rowIndex) {
        StringBuilder tileIndexes = new StringBuilder();
        tileIndexes.append(rowIndex).append(",").append(colIndex);
        return Coordinate.allCoordinates.get(tileIndexes.toString());
    }

    /**
     * Reset all the current Possible moves that are shown on the board, and returning the Button to their default style.
     */
    private void resetPossibleMovesBTN() {

        for (Button btn : possibleMovesBTN) {
            btn.setStyle("-fx-border-color: none");
            btn.setOnMousePressed(this.beforeSelected);
        }
    }

    /**
     * This Function is called whenever a user chose where he wants to move it's piece.
     * The function moving the piece in the logic board ad on the UI board, and checks if there are any Special occasions
     * as result of the movement (check, checkmate, and so on)
     * @param e MouseEvent from the Pressed button in the UI board.
     */
    @FXML
    public void moveThere(MouseEvent e) {

        //getting the indexes of the presed button .
        Button source = (Button) e.getSource();
        int colIndex = GridPane.getColumnIndex(source);
        int rowIndex = GridPane.getRowIndex(source);
        if (this.playerView == Piece.Color.BLACK) {
            //if the chosen point of view is black --> reversing the board.
            colIndex = 7 - colIndex;
            rowIndex = 7 - rowIndex;
        }
        Coordinate target = getCoordinateWithRowAndCol(colIndex, rowIndex);
        Piece selectedPiece = this.gameManager.getGameBoard().getTileByCoordination(selectedTile).getCurrentPiece();
        //moving the chosen piece in the logic board.
        SpecialMove moveSucceeded = gameManager.movePiece(selectedTile, target);
        if (moveSucceeded != SpecialMove.INVALID_MOVE) {
            //if the move succeeded
            if (moveSucceeded == SpecialMove.NORMAL_MOVE) {

                //if there was no special move --> just updating the images of two buttons
                int row1 = selectedTile.getRow().getValue();
                int col1 = selectedTile.getColumn().getValue();
                if (this.playerView == Piece.Color.BLACK) {
                    colIndex = 7 - colIndex;
                    rowIndex = 7 - rowIndex;
                    row1 = 7 - row1;
                    col1 = 7 - col1;
                }
                Button selectedPiece_btn = fxBoard[row1][col1];
                Button selectedTarget_btn = fxBoard[rowIndex][colIndex];
                Image img = imgDictionary.getImage(selectedPiece.getImageURL());
                selectedTarget_btn.setGraphic(new ImageView(img));
                selectedPiece_btn.setGraphic(new ImageView());
            }
            else if(moveSucceeded == SpecialMove.PAWN_PROMOTING){
                //if there is a pawn promotion --> updating the entire board.
                pawnPromotion((Pawn)selectedPiece);
                this.resetImages();
            }
            else{
                //if it's castling \ pawn killed from behind --> check the whole board to refresh button images
                this.resetImages();
            }

            //checking for special results after the move is made.
            GameMod moveResult = this.gameManager.afterMoveResult(selectedPiece);

            //changing the info label according to the new situation.
            switch(moveResult){
                case MID_GAME:

                    Piece.Color currentPlayerTurnColor = this.gameManager.getCurrentPlayer();
                    //setting the label according to who's turn it is.
                    if(currentPlayerTurnColor == Piece.Color.BLACK){
                        this.infoLabel.setStyle("-fx-text-fill: black");
                        this.infoLabel.setText(BLACK_TURN);
                    }
                    else{
                        this.infoLabel.setStyle("-fx-text-fill: white");
                        this.infoLabel.setText(WHITE_TURN);
                    }
                    break;

                case BLACK_IS_CHECKED:

                    this.infoLabel.setStyle("-fx-text-fill: black");
                    this.infoLabel.setText(BLACK_IS_CHECKED);
                    break;
                case WHITE_IS_CHECKED:

                    this.infoLabel.setStyle("-fx-text-fill: white");
                    this.infoLabel.setText(WHITE_IS_CHECKED);
                    break;
                case BLACK_WON:
                    this.infoLabel.setStyle("-fx-text-fill: black");
                    this.infoLabel.setText(BLACK_WON_LABEL);
                    break;
                case WHITE_WON:
                    this.infoLabel.setStyle("-fx-text-fill: white");
                    this.infoLabel.setText(WHITE_WON_LABEL);
                    break;
            }
        }
        resetPossibleMovesBTN();
    }

    /**
     * updating the Images of all the buttons according to the current logic board in the game manager
     */
    private void resetImages(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                int row = i ;
                int col = j ;
                if(playerView == Piece.Color.BLACK){
                    row = 7 - i;
                    col = 7 - j;
                }
                Coordinate thisTileCoordinate = getCoordinateWithRowAndCol(col, row);
                Piece thisTilePiece = this.gameManager.getGameBoard().getTileByCoordination(thisTileCoordinate).getCurrentPiece();
                if(thisTilePiece == null){
                    fxBoard[i][j].setGraphic(new ImageView());
                }
                else{
                    Image thisTileImage = imgDictionary.getImage(thisTilePiece.getImageURL());
                    fxBoard[i][j].setGraphic(new ImageView(thisTileImage));

                }
                fxBoard[i][j].setStyle("-fx-border-color: none");
                fxBoard[i][j].setOnMousePressed(this.beforeSelected);
            }
        }
    }

    /**
     * This Function is called when a pawn reached the end of the board, and needs to be promoted.
     *
     * opens up the Pawn Promotion dialog, to let the user Chose what promotion he wants.
     * the Game manager updates the pieces on the board accordingly.
     * @param toPromote     Pawn that needs to be promoted.
     */
    private void pawnPromotion(Pawn toPromote){
        Alert pawn_Promotion_Dialog = new Alert(Alert.AlertType.CONFIRMATION);
        pawn_Promotion_Dialog.setTitle("Pawn Promotion");
        pawn_Promotion_Dialog.setHeaderText("To what piece do you want to promote your Pawn");
        pawn_Promotion_Dialog.setContentText("Choose your option.");


        ButtonType queen_btn = new ButtonType("Queen");
        ButtonType rook_btn = new ButtonType("Rook");
        ButtonType bishop_btn = new ButtonType("Bishop");
        ButtonType knight_btn = new ButtonType("Knight");

        pawn_Promotion_Dialog.getButtonTypes().setAll(queen_btn, rook_btn,bishop_btn ,knight_btn);

        Optional<ButtonType> result = pawn_Promotion_Dialog.showAndWait();
        char promotion;
        if (result.get() == queen_btn) {
            // if the player chose queen
            promotion = 'Q';
        } else if (result.get() == rook_btn) {
            // if the player chose rook
            promotion = 'R';


        } else if (result.get() == bishop_btn) {
            // if the player chose bishop
            promotion = 'B';


        } else {
            //else --> knight
            promotion = 'N';

        }
        this.gameManager.promotionFunction(toPromote, promotion);
    }

    /**
     * This function is called when pressing the "New Game" button.
     * The Function opens up a dialog that let the user choose his point of view on the board: as Black player, Or White player.
     */
    @FXML
    public void newGameAction() {
        Alert new_Game_Dialog = new Alert(Alert.AlertType.CONFIRMATION);
        new_Game_Dialog.setTitle("New Game");
        new_Game_Dialog.setHeaderText("With what color do you want to play?");
        new_Game_Dialog.setContentText("Choose your option.");

        ButtonType white_btn = new ButtonType("White");
        ButtonType black_btn = new ButtonType("Black");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        new_Game_Dialog.getButtonTypes().setAll(white_btn, black_btn, buttonTypeCancel);

        Optional<ButtonType> result = new_Game_Dialog.showAndWait();
        if (result.get() == white_btn) {
            setPiecesOnBoard(Piece.Color.WHITE);
        } else if (result.get() == black_btn) {
            setPiecesOnBoard(Piece.Color.BLACK);
        } else {

        }
        this.infoLabel.setStyle("-fx-text-fill: white");
        this.infoLabel.setFont(Font.font("stencil",18));
        this.infoLabel.setText(WHITE_TURN);

    }

    /**
     * Resets the Logic Board, and draw the Pieces again on the board in their initial place.
     * @param playerColor
     */
    private void setPiecesOnBoard(Piece.Color playerColor) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                fxBoard[i][j].setGraphic(new ImageView());
            }
        }
        this.playerView = playerColor;
        this.gameManager = new GameManager();
        this.gameManager.setCurrentPlayer(Piece.Color.WHITE);
        drawPieces(playerColor, gameManager.getGameBoard().getWhitesPieces());
        drawPieces(playerColor, gameManager.getGameBoard().getBlacksPieces());
    }

    /**
     * Draw the Images of the given sets of pieces on the board according to chosen point of view.
     * @param playerColor   Color represent the chosen point of view of the board.
     * @param pieces        Set of pieces to draw images on the UI board.
     */
    private void drawPieces(Piece.Color playerColor, Set<Piece> pieces) {
        for (Piece piece : pieces) {
            Coordinate c = piece.getCoordinate();
            Image pieceImage = imgDictionary.getImage(piece.getImageURL());
            Button currentButton;
            if (playerColor == Piece.Color.WHITE) {
                currentButton = fxBoard[c.getRow().getValue()][c.getColumn().getValue()];
            } else {
                currentButton = fxBoard[7 - c.getRow().getValue()][7 - c.getColumn().getValue()];
            }
            currentButton.setGraphic(new ImageView(pieceImage));
        }
    }
}
