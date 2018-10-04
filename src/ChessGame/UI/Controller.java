package ChessGame.UI;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;




public class Controller {

    //region ALL tiles
    //region 1st Row
    @FXML
    private Pane tile_00;
    @FXML
    private Pane tile_01;
    @FXML
    private Pane tile_02;
    @FXML
    private Pane tile_03;
    @FXML
    private Pane tile_04;
    @FXML
    private Pane tile_05;
    @FXML
    private Pane tile_06;
    @FXML
    private Pane tile_07;
    //endregion FirstRow
    //region 2nd row
    @FXML
    private Pane tile_10;
    @FXML
    private Pane tile_11;
    @FXML
    private Pane tile_12;
    @FXML
    private Pane tile_13;
    @FXML
    private Pane tile_14;
    @FXML
    private Pane tile_15;
    @FXML
    private Pane tile_16;
    @FXML
    private Pane tile_17;
    //endregion 2nd row
    //region 3rd row
    @FXML
    private Pane tile_20;
    @FXML
    private Pane tile_21;
    @FXML
    private Pane tile_22;
    @FXML
    private Pane tile_23;
    @FXML
    private Pane tile_24;
    @FXML
    private Pane tile_25;
    @FXML
    private Pane tile_26;
    @FXML
    private Pane tile_27;
    //endregion 3rd row
    //region 4rd row
    @FXML
    private Pane tile_30;
    @FXML
    private Pane tile_31;
    @FXML
    private Pane tile_32;
    @FXML
    private Pane tile_33;
    @FXML
    private Pane tile_34;
    @FXML
    private Pane tile_35;
    @FXML
    private Pane tile_36;
    @FXML
    private Pane tile_37;
    //endregion 4rd row
    //region 5th row
    @FXML
    private Pane tile_40;
    @FXML
    private Pane tile_41;
    @FXML
    private Pane tile_42;
    @FXML
    private Pane tile_43;
    @FXML
    private Pane tile_44;
    @FXML
    private Pane tile_45;
    @FXML
    private Pane tile_46;
    @FXML
    private Pane tile_47;
    //endregion 5th row
    //region 6th row
    @FXML
    private Pane tile_50;
    @FXML
    private Pane tile_51;
    @FXML
    private Pane tile_52;
    @FXML
    private Pane tile_53;
    @FXML
    private Pane tile_54;
    @FXML
    private Pane tile_55;
    @FXML
    private Pane tile_56;
    @FXML
    private Pane tile_57;
    //endregion 6th row
    //region 7th row
    @FXML
    private Pane tile_60;
    @FXML
    private Pane tile_61;
    @FXML
    private Pane tile_62;
    @FXML
    private Pane tile_63;
    @FXML
    private Pane tile_64;
    @FXML
    private Pane tile_65;
    @FXML
    private Pane tile_66;
    @FXML
    private Pane tile_67;
    //endregion 7th row
    //region 8th row
    @FXML
    private Pane tile_70;
    @FXML
    private Pane tile_71;
    @FXML
    private Pane tile_72;
    @FXML
    private Pane tile_73;
    @FXML
    private Pane tile_74;
    @FXML
    private Pane tile_75;
    @FXML
    private Pane tile_76;
    @FXML
    private Pane tile_77;
    //endregion 8th row
    //endregion ALLTiles

    @FXML
    private GridPane mainBoard;

    private ImagesDictionary imgDictionary;
    private Pane[][] fxBoard;

    public void initialize() {
        fxBoard = new Pane[][] {{tile_00, tile_01, tile_02, tile_03, tile_04, tile_05, tile_06, tile_07},
                                {tile_10, tile_11, tile_12, tile_13, tile_14, tile_15, tile_16, tile_17},
                                {tile_20, tile_21, tile_22, tile_23, tile_24, tile_25, tile_26, tile_27},
                                {tile_30, tile_31, tile_32, tile_33, tile_34, tile_35, tile_36, tile_37},
                                {tile_40, tile_41, tile_42, tile_43, tile_44, tile_45, tile_46, tile_47},
                                {tile_50, tile_51, tile_52, tile_53, tile_54, tile_55, tile_56, tile_57},
                                {tile_60, tile_61, tile_62, tile_63, tile_64, tile_65, tile_66, tile_67},
                                {tile_70, tile_71, tile_72, tile_73, tile_74, tile_75, tile_76, tile_77}};

        mainBoard.getChildren().forEach( item ->{
            item.setOnMouseClicked(event -> {
                whenSelected(event);
            });
        });
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                fxBoard[i][j].getChildren().forEach( item ->{
                    item.setOnMouseClicked(event -> {
                        whenSelected(event);
                    });
                });
            }
        }
        imgDictionary = new ImagesDictionary();
        imgDictionary.initImages();

    }

    @FXML
    public void whenSelected(MouseEvent e){
        Node source =  (Node)e.getSource() ;
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        Pane selected = fxBoard[rowIndex][colIndex];
        System.out.println("row: "+rowIndex +", col: "+colIndex);


    }
}
