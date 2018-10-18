package ChessGame.UI;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstMenuController {

    /**
     * Button in charge of opening a game of two players on the same computer
     */
    @FXML
    private Button Offline_Two_btn;
    /**
     * Button in charge of opening a game of the user VS the Computer
     */
    @FXML
    private Button Offline_Com_btn;
    /**
     * Button in charge of opening an Online game when the user chose to be white.
     */
    @FXML
    private Button Online_As_White;
    /**
     * Button in charge of opening an Online game when the user chose to be black.
     */
    @FXML
    private Button Online_As_Black;

    private EventHandler<MouseEvent> not_ready_event;

    private EventHandler<MouseEvent> offline_game_two_players;
    



    public void initialize() {
        not_ready_event = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                notReadyYetDialog();
            }
        };

        offline_game_two_players = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                open_Offline_game(mouseEvent);
            }
        };

        Offline_Two_btn.setOnMouseClicked(offline_game_two_players);

        //ToDo --> write the actual events.
        Offline_Com_btn.setOnMouseClicked(not_ready_event);
        Online_As_Black.setOnMouseClicked(not_ready_event);
        Online_As_White.setOnMouseClicked(not_ready_event);

    }


    private void notReadyYetDialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Unfinished Feature");
        alert.setHeaderText("Sorry");
        alert.setContentText("But this feature is not ready yet");
        Image icon = new Image("file:" + SourceURL.GAME_ICON);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(icon);
        alert.showAndWait();
    }

    private void open_Offline_game(MouseEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("ChessGame/UI/GameWindow.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Chess");
            stage.setScene(new Scene(root, 600, 400));
            Image icon = new Image("file:" + SourceURL.GAME_ICON);
            stage.getIcons().add(icon);
            stage.show();
            // Hide this current window
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            printError(e,"Error --> couldn't open the offline two player window");
        }
        catch (NullPointerException e){
            printError(e,"Error --> couldn't open the offline two player window");
        }
    }

    private void printError(Exception e, String PersonalMessage){
        System.out.println();
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println("===============");
        System.out.println();
        e.printStackTrace();
    }

}
