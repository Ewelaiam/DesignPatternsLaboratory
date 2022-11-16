package pl.edu.agh.dp.Decorator.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = FXMLLoader.load(getClass().getClassLoader().getResource("decorator_app_view.fxml"));
        primaryStage.setTitle("Shape Painter");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
