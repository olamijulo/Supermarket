package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard {

    @FXML
    private Pane login;

    @FXML
    private Pane employee;

    @FXML
    private Pane stock;

    @FXML
    private Pane category;

    @FXML
    private Pane supplier;

    @FXML
    private Pane history;

    @FXML
    void back(MouseEvent evt) throws IOException {
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("role.fxml"));
        primaryStage.setScene(new Scene(pane, 572, 409));
    }

    @FXML
    void close(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void glow(MouseEvent evt) {
        if(evt.getSource()==login)
        {
            login.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==employee)
        {
            employee.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==stock)
        {
            stock.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==history)
        {
            history.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==category)
        {
            category.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==supplier)
        {
            supplier.setEffect(new Glow(1.0));
        }
    }

    @FXML
    void loginLink(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loginPane.fxml"));
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(pane, 1200, 700));
    }

    @FXML
    void employeeLink(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("employee.fxml"));
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(pane, 1200, 700));
    }

    @FXML
    void stockLink(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("stock.fxml"));
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(pane, 1200, 700));
    }


    @FXML
    void supplierLink(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("supplier.fxml"));
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(pane, 1200, 700));
    }

    @FXML
    void categoryLink(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("category.fxml"));
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(pane, 1200, 700));
    }

    @FXML
    void logout(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setX(447);
        primaryStage.setY(104);
        primaryStage.setScene(new Scene(pane, 472, 457));
    }



    @FXML
    void normal(MouseEvent event) {

        login.setEffect(null);
        employee.setEffect(null);
        stock.setEffect(null);
        history.setEffect(null);
        category.setEffect(null);
        supplier.setEffect(null);

    }

}
