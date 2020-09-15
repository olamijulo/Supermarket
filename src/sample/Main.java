 package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Category.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 472, 457));
        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException {
        launch(args);

    }
}
