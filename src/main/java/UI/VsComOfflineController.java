package UI;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Pair;
import logic.ChessEngine.ComputerMovesEngine;
import logic.board_v1.Coordinate;
import logic.board_v1.GameManager;
import logic.pieces.Piece;

import java.util.Optional;

public class VsComOfflineController extends MultiplayerOfflineController{

    /**
     * The color of the Computer in this game
     */
    private Piece.Color computerColor;

    /**
     * Engine to calculate the best move for the computer in the game
     */
    private ComputerMovesEngine engine;

    public VsComOfflineController() {
        super();
        this.engine = new ComputerMovesEngine();
    }

    @Override
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
        this.computerColor = this.playerView.next();
        this.gameManager = new GameManager(this.playerView);

        //make a computer move if the computer color is white.
        ComputerMove();
        resetImages();
    }

    /**
     * generate a move by the computer, and paint the board_v1 after wards
     */
    protected void ComputerMove() {
        if(this.computerColor == this.gameManager.getCurrentPlayer()){
            String currentMode = this.infoLabel.getText();
            if((currentMode != this.BLACK_WON_LABEL) && (currentMode != this.WHITE_WON_LABEL) && (currentMode != this.STALEMATE)){
                Pair<Coordinate,Coordinate> computerMove = this.engine.generateMove(this.computerColor, this.gameManager.getGameBoard());
                this.selectedTile = computerMove.getKey();
                makeTheMove(computerMove.getValue());
            }
        }
    }

    @Override
    protected void makeTheMove(Coordinate target) {
        super.makeTheMove(target);
        //the computer makes a move in return
        ComputerMove();
        //draw the new board_v1
        resetImages();

    }
}

