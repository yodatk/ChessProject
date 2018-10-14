package ChessGame.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FirstMenu.fxml"));
        primaryStage.setTitle("Chess");
        primaryStage.setScene(new Scene(root, 600, 650));
        Image icon = new Image("file:" + SourceURL.GAME_ICON);
        primaryStage.getIcons().add(icon);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
