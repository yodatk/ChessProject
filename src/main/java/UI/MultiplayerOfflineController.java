package UI;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.board_v1.Coordinate;
import logic.board_v1.GameManager;
import logic.board_v1.GameMod;
import logic.board_v1.SpecialMove;
import logic.pieces.Pawn;
import logic.pieces.Piece;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Controller for the offline game window.
 */
public class MultiplayerOfflineController {

    //region String Label Constants
    protected final String WHITE_WON_LABEL = "Checkmate!\n White player Won";
    protected final String BLACK_WON_LABEL = "Checkmate!\n Black player Won";
    protected final String WHITE_IS_CHECKED = "Check On White";
    protected final String BLACK_IS_CHECKED = "Check On Black";
    protected final String WHITE_TURN = "White's Turn";
    protected final String BLACK_TURN = "Black's Turn";
    protected final String STALEMATE = "## Stalemate ##";

    protected final String BLACK_WON_MSG = "Black won the game!";
    protected final String WHITE_WON_MSG = "White won the game!";
    protected final String BLACK_RESIGNED_MSG = "Black Resigned";
    protected final String WHITE_RESIGNED_MSG = "White Resigned";
    //endregion String Label Constants

    //region ALL tiles
    //region 1st Row
    @FXML
    protected Button tile_00;
    @FXML
    protected Button tile_01;
    @FXML
    protected Button tile_02;
    @FXML
    protected Button tile_03;
    @FXML
    protected Button tile_04;
    @FXML
    protected Button tile_05;
    @FXML
    protected Button tile_06;
    @FXML
    protected Button tile_07;
    //endregion FirstRow

    //region 2nd row
    @FXML
    protected Button tile_10;
    @FXML
    protected Button tile_11;
    @FXML
    protected Button tile_12;
    @FXML
    protected Button tile_13;
    @FXML
    protected Button tile_14;
    @FXML
    protected Button tile_15;
    @FXML
    protected Button tile_16;
    @FXML
    protected Button tile_17;
    //endregion 2nd row

    //region 3rd row
    @FXML
    protected Button tile_20;
    @FXML
    protected Button tile_21;
    @FXML
    protected Button tile_22;
    @FXML
    protected Button tile_23;
    @FXML
    protected Button tile_24;
    @FXML
    protected Button tile_25;
    @FXML
    protected Button tile_26;
    @FXML
    protected Button tile_27;
    //endregion 3rd row

    //region 4rd row
    @FXML
    protected Button tile_30;
    @FXML
    protected Button tile_31;
    @FXML
    protected Button tile_32;
    @FXML
    protected Button tile_33;
    @FXML
    protected Button tile_34;
    @FXML
    protected Button tile_35;
    @FXML
    protected Button tile_36;
    @FXML
    protected Button tile_37;
    //endregion 4rd row

    //region 5th row
    @FXML
    protected Button tile_40;
    @FXML
    protected Button tile_41;
    @FXML
    protected Button tile_42;
    @FXML
    protected Button tile_43;
    @FXML
    protected Button tile_44;
    @FXML
    protected Button tile_45;
    @FXML
    protected Button tile_46;
    @FXML
    protected Button tile_47;
    //endregion 5th row

    //region 6th row
    @FXML
    protected Button tile_50;
    @FXML
    protected Button tile_51;
    @FXML
    protected Button tile_52;
    @FXML
    protected Button tile_53;
    @FXML
    protected Button tile_54;
    @FXML
    protected Button tile_55;
    @FXML
    protected Button tile_56;
    @FXML
    protected Button tile_57;
    //endregion 6th row

    //region 7th row
    @FXML
    protected Button tile_60;
    @FXML
    protected Button tile_61;
    @FXML
    protected Button tile_62;
    @FXML
    protected Button tile_63;
    @FXML
    protected Button tile_64;
    @FXML
    protected Button tile_65;
    @FXML
    protected Button tile_66;
    @FXML
    protected Button tile_67;
    //endregion 7th row

    //region 8th row
    @FXML
    protected Button tile_70;
    @FXML
    protected Button tile_71;
    @FXML
    protected Button tile_72;
    @FXML
    protected Button tile_73;
    @FXML
    protected Button tile_74;
    @FXML
    protected Button tile_75;
    @FXML
    protected Button tile_76;
    @FXML
    protected Button tile_77;
    //endregion 8th row
    //endregion ALLTiles

    //region Fields

    /**
     * GridPane where all the tiles of the board_v1 are contained.
     */
    @FXML
    protected GridPane mainBoard;

    /**
     * Label which tells what is the current situation on the board_v1.
     */
    @FXML
    protected Label infoLabel;
    /**
     * Button to resign the game.
     */
    @FXML
    protected Button resign_btn;
    /**
     * Button to go back to the main menu
     */
    @FXML
    protected Button main_menu_btn;


    /**
     * Images Dictionary to get the right image when needed.
     */
    protected ImagesDictionary imgDictionary;

    /**
     * 2D array of button represent the buttons that are inside the GridPane.
     */
    protected Button[][] fxBoard;

    /**
     * GameManager object to handle the logic of the pieces on the board_v1.
     */
    protected GameManager gameManager;

    /**
     * Set of button represent the current possible moves of a chosen piece.
     */
    protected Set<Button> possibleMovesBTN;

    /**
     * Color of the point of view of the player on the board_v1, to know how to print the board_v1.
     */
    protected Piece.Color playerView;

    /**
     * Event handler when a piece is selected on the board_v1.
     */
    protected EventHandler<MouseEvent> beforeSelected;
    /**
     * Event handler when the user chose to move a piece on the board_v1.
     */
    protected EventHandler<MouseEvent> moveSelected;

    /**
     * Coordinate of the current selected tile.
     */
    protected Coordinate selectedTile;

    //endregion Fields

    public void initialize() {
        initialisingEventsAndTiles();
        initialisingBoardAndVisuals();
    }

    protected void initialisingBoardAndVisuals() {
        this.gameManager = new GameManager();
        imgDictionary = new ImagesDictionary();
        imgDictionary.initImages();
        this.resign_btn.setDisable(true);
    }

    protected void initialisingEventsAndTiles() {
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
    }

    /**
     * This function is called whenever the user pressed on a button on the tile board_v1, which is not a possible move.
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
        if (this.playerView == Piece.Color.BLACK) {
            //if the chosen point of view is black --> reversing the board_v1.
            colIndex = 7 - colIndex;
            rowIndex = 7 - rowIndex;
        }
        Coordinate selectedTile = getCoordinateWithRowAndCol(colIndex, rowIndex);

        Piece selectedPiece = this.gameManager.getGameBoard().getPieceByIndexes(rowIndex, colIndex);
        possibleMovesBTN.clear();
        if ((selectedPiece != null) && (selectedPiece.getPieceColor() == this.gameManager.getCurrentPlayer())) {
            //if there is a piece on the tile, and it's the same color as the current player

            Set<Coordinate> selectedPossibleMoves = selectedPiece.getPossibleMoves();
            for (Coordinate move : selectedPossibleMoves) {
                //for each possible move of the chosen piece
                rowIndex = move.getRow().getValue();
                colIndex = move.getColumn().getValue();
                if (this.playerView == Piece.Color.BLACK) {
                    //if the chosen point of view is black --> reversing the board_v1.
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
     * Gets a certain coordinates on the board_v1 according to the indexes of the row and column (of a pressed button)
     * @param colIndex  Int number represent the index of a Column
     * @param rowIndex  Int number represent the index of a Row
     * @return Coordinate that matches the given indexes.
     */
    protected Coordinate getCoordinateWithRowAndCol(int colIndex, int rowIndex) {
        StringBuilder tileIndexes = new StringBuilder();
        tileIndexes.append(rowIndex).append(",").append(colIndex);
        return Coordinate.allCoordinates.get(tileIndexes.toString());
    }

    /**
     * Reset all the current Possible moves that are shown on the board_v1, and returning the Button to their default style.
     */
    protected void resetPossibleMovesBTN() {

        for (Button btn : possibleMovesBTN) {
            btn.setStyle("-fx-border-color: none");
            btn.setOnMousePressed(this.beforeSelected);
        }
    }

    /**
     * This Function is called whenever a user chose where he wants to move it's piece.
     * The function moving the piece in the logic board_v1 ad on the UI board_v1, and checks if there are any Special occasions
     * as result of the movement (check, checkmate, and so on)
     * @param e MouseEvent from the Pressed button in the UI board_v1.
     */
    @FXML
    public void moveThere(MouseEvent e) {

        //getting the indexes of the pressed button .
        Button source = (Button) e.getSource();
        int colIndex = GridPane.getColumnIndex(source);
        int rowIndex = GridPane.getRowIndex(source);
        if (this.playerView == Piece.Color.BLACK) {
            //if the chosen point of view is black --> reversing the board_v1.
            colIndex = 7 - colIndex;
            rowIndex = 7 - rowIndex;
        }
        Coordinate target = getCoordinateWithRowAndCol(colIndex, rowIndex);
        makeTheMove(target);
    }

    /**
     * Get the piece from the selected Tile Field, and moves it to the target Coordinate. after
     * The function moving the piece in the logic board_v1 ad on the UI board_v1, and checks if there are any Special occasions
     *   As result of the movement (check, checkmate, and so on)
     * @param target        Coordinate of the target location of the selected piece
     */
    protected void makeTheMove(Coordinate target) {
        Piece selectedPiece = this.gameManager.getGameBoard().getPieceByCoordinate(selectedTile);
        //moving the chosen piece in the logic board_v1.
        SpecialMove moveSucceeded = gameManager.movePiece(selectedTile, target);
        if (moveSucceeded != SpecialMove.INVALID_MOVE) {
            //if the move succeeded

            if(moveSucceeded == SpecialMove.PAWN_PROMOTING){
                //if there is a pawn promotion --> updating the entire board_v1.
                pawnPromotion((Pawn)selectedPiece);
                this.resetImages();
            }
            else{
                //if it's a normal move \ castling \ pawn killed from behind --> check the whole board_v1 to refresh button images
                this.resetImages();
            }
            //checking to see if there is any special result from the last move that has been made
            declaringMoveResults(selectedPiece);

        }
        resetPossibleMovesBTN();
    }

    /**
     * Changing labels and game modes according to the last move that was made.
     * @param selectedPiece The piece that made the last move
     */
    protected void declaringMoveResults(Piece selectedPiece) {
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
                this.resign_btn.setDisable(true);
                this.main_menu_btn.setDisable(false);

                break;
            case WHITE_WON:
                this.infoLabel.setStyle("-fx-text-fill: white");
                this.infoLabel.setText(WHITE_WON_LABEL);
                this.resign_btn.setDisable(true);
                this.main_menu_btn.setDisable(false);
                break;
            case STALEMATE:
                this.infoLabel.setStyle("-fx-text-fill: yellow");
                this.infoLabel.setText(STALEMATE);
                this.resign_btn.setDisable(true);
                this.main_menu_btn.setDisable(false);

        }
    }

    /**
     * updating the Images of all the buttons according to the current logic board_v1 in the game manager
     */
    protected void resetImages(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                int row = i ;
                int col = j ;
                if(playerView == Piece.Color.BLACK){
                    row = 7 - i;
                    col = 7 - j;
                }
                Coordinate thisTileCoordinate = getCoordinateWithRowAndCol(col, row);
                Piece thisTilePiece = this.gameManager.getGameBoard().getPieceByCoordinate(thisTileCoordinate);
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
     * This Function is called when a pawn reached the end of the board_v1, and needs to be promoted.
     *
     * opens up the Pawn Promotion dialog, to let the user Chose what promotion he wants.
     * the Game manager updates the pieces on the board_v1 accordingly.
     * @param toPromote     Pawn that needs to be promoted.
     */
    protected void pawnPromotion(Pawn toPromote){
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
     * The Function opens up a dialog that let the user choose his point of view on the board_v1: as Black player, Or White player.
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
        Image icon = new Image("file:" + SourceURL.GAME_ICON);

        Stage stage = (Stage) new_Game_Dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(icon);

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
        this.resign_btn.setDisable(false);
        this.main_menu_btn.setDisable(true);


    }

    /**
     * This function is activated when pressing the "Resign" button.
     * It will announce the winner to the users, and afterwards return to the main menu.
     *
     *
     * @param event MouseEvent coming from the "resign" button.
     */
    @FXML
    public void resign(MouseEvent event){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game is Finished");
        if(this.gameManager.getCurrentPlayer() == Piece.Color.BLACK){
            alert.setHeaderText(BLACK_RESIGNED_MSG);
            alert.setContentText(WHITE_WON_MSG);
        }
        else{
            alert.setHeaderText(WHITE_RESIGNED_MSG);
            alert.setContentText(BLACK_WON_MSG);
        }
        Image icon = new Image("file:" + SourceURL.GAME_ICON);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(icon);
        alert.showAndWait();
        toMainMenu(event);
    }
    @FXML
    public void toMainMenu(MouseEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("UI/FirstMenu.fxml"));
            Stage stage2 = new Stage();
            stage2.setTitle("Chess");
            stage2.setScene(new Scene(root, 600, 650));
            stage2.show();
            // Hide this current window
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            printError(e,"Couldn't open the main window");
        }
        catch (NullPointerException e){
            printError(e,"Couldn't open the main window");

        }

    }

    /**
     * Resets the Logic Board, and draw the Pieces again on the board_v1 in their initial place.
     * @param playerColor
     */
    protected void setPiecesOnBoard(Piece.Color playerColor) {

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
     * Draw the Images of the given sets of pieces on the board_v1 according to chosen point of view.
     * @param playerColor   Color represent the chosen point of view of the board_v1.
     * @param pieces        Set of pieces to draw images on the UI board_v1.
     */
    protected void drawPieces(Piece.Color playerColor, Set<Piece> pieces) {
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

    protected void printError(Exception e, String PersonalMessage){
        System.out.println();
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println("===============");
        System.out.println();
        e.printStackTrace();
    }
}

