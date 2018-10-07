package ChessGame.UI;

import ChessGame.Logic.Coordinate;
import ChessGame.Logic.GameManager;
import ChessGame.Logic.Pieces.Piece;
import ChessGame.Logic.Tile;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class Controller {

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

    private ImagesDictionary imgDictionary;
    //    private ButtonTile[][] fxBoard;
    private Button[][] fxBoard;

    private GameManager gameManager;

    private Piece.Color currentPlayerColor;

    private Set<Button> possibleMovesBTN;

    public EventHandler<MouseEvent> beforeSelected;

    public  EventHandler<MouseEvent> moveSelected;



    public void initialize() {

        //region init buttons
//        tile_00 = new ButtonTile();
//        tile_01 = new ButtonTile();
//        tile_02 = new ButtonTile();
//        tile_03 = new ButtonTile();
//        tile_04 = new ButtonTile();
//        tile_05 = new ButtonTile();
//        tile_06 = new ButtonTile();
//        tile_07 = new ButtonTile();
//
//        tile_10 = new ButtonTile();
//        tile_11 = new ButtonTile();
//        tile_12 = new ButtonTile();
//        tile_13 = new ButtonTile();
//        tile_14 = new ButtonTile();
//        tile_15 = new ButtonTile();
//        tile_16 = new ButtonTile();
//        tile_17 = new ButtonTile();
//
//        tile_20 = new ButtonTile();
//        tile_21 = new ButtonTile();
//        tile_22 = new ButtonTile();
//        tile_23 = new ButtonTile();
//        tile_24 = new ButtonTile();
//        tile_25 = new ButtonTile();
//        tile_26 = new ButtonTile();
//        tile_27 = new ButtonTile();
//
//        tile_30 = new ButtonTile();
//        tile_31 = new ButtonTile();
//        tile_32 = new ButtonTile();
//        tile_33 = new ButtonTile();
//        tile_34 = new ButtonTile();
//        tile_35 = new ButtonTile();
//        tile_36 = new ButtonTile();
//        tile_37 = new ButtonTile();
//
//        tile_40 = new ButtonTile();
//        tile_41 = new ButtonTile();
//        tile_42 = new ButtonTile();
//        tile_43 = new ButtonTile();
//        tile_44 = new ButtonTile();
//        tile_45 = new ButtonTile();
//        tile_46 = new ButtonTile();
//        tile_47 = new ButtonTile();
//
//        tile_50 = new ButtonTile();
//        tile_51 = new ButtonTile();
//        tile_52 = new ButtonTile();
//        tile_53 = new ButtonTile();
//        tile_54 = new ButtonTile();
//        tile_55 = new ButtonTile();
//        tile_56 = new ButtonTile();
//        tile_57 = new ButtonTile();
//
//        tile_60 = new ButtonTile();
//        tile_61 = new ButtonTile();
//        tile_62 = new ButtonTile();
//        tile_63 = new ButtonTile();
//        tile_64 = new ButtonTile();
//        tile_65 = new ButtonTile();
//        tile_66 = new ButtonTile();
//        tile_67 = new ButtonTile();
//
//        tile_70 = new ButtonTile();
//        tile_71 = new ButtonTile();
//        tile_72 = new ButtonTile();
//        tile_73 = new ButtonTile();
//        tile_74 = new ButtonTile();
//        tile_75 = new ButtonTile();
//        tile_76 = new ButtonTile();
//        tile_77 = new ButtonTile();
        //endregion init Buttons


        /*fxBoard = new ButtonTile[][]
                                {{(ButtonTile)tile_00, (ButtonTile) tile_01,  (ButtonTile)tile_02,  (ButtonTile)tile_03, (ButtonTile) tile_04,  (ButtonTile)tile_05,  (ButtonTile)tile_06,  (ButtonTile)tile_07},
                                { (ButtonTile)tile_10,  (ButtonTile)tile_11,  (ButtonTile)tile_12,  (ButtonTile)tile_13, (ButtonTile) tile_14,  (ButtonTile)tile_15, (ButtonTile) tile_16,  (ButtonTile)tile_17},
                                { (ButtonTile)tile_20,  (ButtonTile)tile_21,  (ButtonTile)tile_22,  (ButtonTile)tile_23,  (ButtonTile)tile_24,  (ButtonTile)tile_25,  (ButtonTile)tile_26,  (ButtonTile)tile_27},
                                { (ButtonTile)tile_30,  (ButtonTile)tile_31, (ButtonTile) tile_32,  (ButtonTile)tile_33,  (ButtonTile)tile_34,  (ButtonTile)tile_35, (ButtonTile)tile_36,  (ButtonTile)tile_37},
                                {(ButtonTile) tile_40, (ButtonTile) tile_41,  (ButtonTile)tile_42,  (ButtonTile)tile_43,  (ButtonTile)tile_44,  (ButtonTile)tile_45,  (ButtonTile)tile_46,  (ButtonTile)tile_47},
                                { (ButtonTile)tile_50,  (ButtonTile)tile_51,  (ButtonTile)tile_52,  (ButtonTile)tile_53,  (ButtonTile)tile_54,  (ButtonTile)tile_55,  (ButtonTile)tile_56,  (ButtonTile)tile_57},
                                { (ButtonTile)tile_60, (ButtonTile) tile_61,  (ButtonTile)tile_62, (ButtonTile) tile_63,  (ButtonTile)tile_64,  (ButtonTile)tile_65, (ButtonTile) tile_66,  (ButtonTile)tile_67},
                                { (ButtonTile)tile_70,  (ButtonTile)tile_71,  (ButtonTile)tile_72,  (ButtonTile)tile_73,  (ButtonTile)tile_74,  (ButtonTile)tile_75,  (ButtonTile)tile_76,  (ButtonTile)tile_77}};*/


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
        for(Button btn : possibleMovesBTN){
            btn.setStyle("-fx-border-color: none");
            btn.setOnMousePressed(this.beforeSelected);
        }
        Button source = (Button) e.getSource();
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        if (currentPlayerColor == Piece.Color.BLACK) {
            colIndex = 7 - colIndex;
            rowIndex = 7 - rowIndex;
        }


        Piece selectedPiece = gameManager.getGameBoard().getTileByIndexes(rowIndex, colIndex).getCurrentPiece();
        if ((selectedPiece != null) && (selectedPiece.getPieceColor() == gameManager.getCurrentPlayer())) {
            possibleMovesBTN.clear();
            Set<Coordinate> selectedPossibleMoves = selectedPiece.getPossibleMoves();
            for (Coordinate move : selectedPossibleMoves) {
                rowIndex = move.getRow().getValue();
                colIndex = move.getColumn().getValue();
                if (currentPlayerColor == Piece.Color.BLACK) {
                    colIndex = 7 - colIndex;
                    rowIndex = 7 - rowIndex;
                }
                Button selected = fxBoard[rowIndex][colIndex];
                selected.setOnMousePressed(this.moveSelected);
                selected.setStyle("-fx-border-color: green");
                possibleMovesBTN.add(selected);
            }

        }

    }
    @FXML
    public void moveThere(MouseEvent e){
        Button source = (Button) e.getSource();
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.println("row="+rowIndex +", column="+colIndex);


       // gameManager.setCurrentPlayer(this.currentPlayerColor.next());
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

    }

    private void setPiecesOnBoard(Piece.Color playerColor) {
        this.currentPlayerColor = playerColor;
        drawPieces(playerColor, gameManager.getGameBoard().getWhitesPieces());
        drawPieces(playerColor, gameManager.getGameBoard().getBlacksPieces());
    }

    private void drawPieces(Piece.Color playerColor, List<Piece> pieces) {
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
