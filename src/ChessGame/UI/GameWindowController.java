package ChessGame.UI;

import ChessGame.Logic.*;
import ChessGame.Logic.Pieces.Piece;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class GameWindowController {

    private final String WHITE_WON_LABEL = "Checkmate!\n White player Won";
    private final String BLACK_WON_LABEL = "Checkmate!\n Black player Won";
    private final String WHITE_IS_CHECKED = "Check On White";
    private final String BLACK_IS_CHECKED = "Check On Black";
    private final String WHITE_TURN = "White's Turn";
    private final String BLACK_TURN = "Black's Turn";


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

    @FXML
    private GridPane mainBoard;

    @FXML
    private Label currentMode_Label;

    private ImagesDictionary imgDictionary;

    private Button[][] fxBoard;

    private GameManager gameManager;

    private Set<Button> possibleMovesBTN;

    private Piece.Color playerView;

    public EventHandler<MouseEvent> beforeSelected;

    public EventHandler<MouseEvent> moveSelected;

    private Coordinate selectedTile;

    private String infoLabel;



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

    @FXML
    public void whenSelected(MouseEvent e) {
        resetPossibleMovesBTN();
        Button source = (Button) e.getSource();
        int colIndex = GridPane.getColumnIndex(source);
        int rowIndex = GridPane.getRowIndex(source);
        Coordinate selectedTile = getCoordinateWithRowAndCol(colIndex, rowIndex);

        if (this.playerView == Piece.Color.BLACK) {
            colIndex = 7 - colIndex;
            rowIndex = 7 - rowIndex;
        }


        Piece selectedPiece = this.gameManager.getGameBoard().getTileByIndexes(rowIndex, colIndex).getCurrentPiece();
        possibleMovesBTN.clear();
        if ((selectedPiece != null) && (selectedPiece.getPieceColor() == this.gameManager.getCurrentPlayer())) {

            Set<Coordinate> selectedPossibleMoves = selectedPiece.getPossibleMoves();
            for (Coordinate move : selectedPossibleMoves) {
                rowIndex = move.getRow().getValue();
                colIndex = move.getColumn().getValue();
                if (this.playerView == Piece.Color.BLACK) {
                    colIndex = 7 - colIndex;
                    rowIndex = 7 - rowIndex;
                }
                Button selected = fxBoard[rowIndex][colIndex];
                selected.setOnMousePressed(this.moveSelected);
                selected.setStyle("-fx-border-color: green");
                possibleMovesBTN.add(selected);
                this.selectedTile = selectedTile;
            }

        }

    }

    private Coordinate getCoordinateWithRowAndCol(int colIndex, int rowIndex) {
        StringBuilder tileIndexes = new StringBuilder();
        tileIndexes.append(rowIndex).append(",").append(colIndex);
        return Coordinate.allCoordinates.get(tileIndexes.toString());
    }

    private void resetPossibleMovesBTN() {

        for (Button btn : possibleMovesBTN) {
            btn.setStyle("-fx-border-color: none");
            btn.setOnMousePressed(this.beforeSelected);
        }
    }

    @FXML
    public void moveThere(MouseEvent e) {

        Button source = (Button) e.getSource();
        int colIndex = GridPane.getColumnIndex(source);
        int rowIndex = GridPane.getRowIndex(source);
        if (this.playerView == Piece.Color.BLACK) {
            colIndex = 7 - colIndex;
            rowIndex = 7 - rowIndex;
        }
        Coordinate target = getCoordinateWithRowAndCol(colIndex, rowIndex);
        Piece selectedPiece = this.gameManager.getGameBoard().getTileByCoordination(selectedTile).getCurrentPiece();
        SpecialMove moveSucceeded = gameManager.movePiece(selectedTile, target);
        if (moveSucceeded != SpecialMove.INVALID_MOVE) {
            if (moveSucceeded == SpecialMove.NORMAL_MOVE) {
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
                //todo open widow of pawn promoting
            }
            else{
                this.resetImages();
            }

            GameMod moveResult = this.gameManager.afterMoveResult(selectedPiece);
            switch(moveResult){
                case MID_GAME:
                    Piece.Color currentPlayerTurnColor = this.gameManager.getCurrentPlayer();
                    if(currentPlayerTurnColor == Piece.Color.BLACK){
                        this.currentMode_Label.setStyle("-fx-text-fill: black");
                        this.currentMode_Label.setText("Black's turn");
                    }
                    else{
                        this.currentMode_Label.setStyle("-fx-text-fill: white");
                        this.currentMode_Label.setText("White's turn");
                    }
                    break;
                case BLACK_IS_CHECKED:
                    this.currentMode_Label.setStyle("-fx-text-fill: black");
                    this.currentMode_Label.setText("Black is Checked!");
                    break;
                case WHITE_IS_CHECKED:
                    this.currentMode_Label.setStyle("-fx-text-fill: white");
                    this.currentMode_Label.setText("White is Checked!");
                    break;
                case BLACK_WON:
                    this.currentMode_Label.setStyle("-fx-text-fill: black");
                    this.currentMode_Label.setText("Black Won!");
                    break;
                case WHITE_WON:
                    this.currentMode_Label.setStyle("-fx-text-fill: white");
                    this.currentMode_Label.setText("White Won!");
                    break;
            }
//            if(moveResult == GameMod.MID_GAME){
//
//            }

        }

        resetPossibleMovesBTN();
        
    }
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
        this.currentMode_Label.setStyle("-fx-text-fill: white");
        this.currentMode_Label.setText("White Turn");

    }

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
