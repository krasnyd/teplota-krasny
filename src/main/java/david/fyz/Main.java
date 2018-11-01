package david.fyz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Převody teplotních jednotek - David Krásný");
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.getIcons().add(new Image(getClass().getResource("/icon.png").toString()));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
