package weather;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
        primaryStage.setTitle("MeteoMateo");
        primaryStage.setScene(new Scene(root, 1100, 400));
        primaryStage.show();
    }
}