package sample;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class UserController extends Controller implements Initializable {

    @FXML
    private JFXComboBox<String> userCategoryName;

    @FXML
    private JFXTextField userSearch;

    @FXML
    private JFXComboBox<String> userItemName;

    @FXML
    private TextField userQuantity;

    @FXML
    private Label userUnitPrice;

    @FXML
    private Label userInStock;

    @FXML
    private Label userItemNumber;

    @FXML
    public Label userUserName;

    @FXML
    private TableColumn<?, ?> userItemNumberColumn;

    @FXML
    private TableColumn<?, ?> userItemNameColumn;

    @FXML
    private TableColumn<?, ?> userUnitPriceColumn;

    @FXML
    private TableColumn<?, ?> userQuantityColumn;

    @FXML
    private TableColumn<?, ?> userCategoryColumn;

    @FXML
    private TableColumn<?, ?> userEmployeeColumn;

    @FXML
    void close(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void minimize(MouseEvent evt) {
        Stage primaryStage = (Stage)((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
    }

    @FXML
    void logOut(MouseEvent eve) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
        primaryStage.setX(447.0);
        primaryStage.setY(104.0);
        primaryStage.setScene(new Scene(pane, 472, 457));
    }


    private void UserCategoryCombo() throws SQLException {
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        Statement st = con.createStatement();
        rs = st.executeQuery("select DISTINCT Category from ItemDetails");
        while(rs.next())
        {
            String catName = rs.getString("Category");
            userCategoryName.getItems().add(catName);
        }
    }

    @FXML
    void UserItemNameAutoFill(ActionEvent event) throws SQLException {
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        PreparedStatement ps = con.prepareStatement("select ItemNumber, UnitPrice, QuantityInStock, Category from ItemDetails WHERE ItemName = ?");
        ps.setString(1, userItemName.getValue());
        rs = ps.executeQuery();
        while(rs.next())
        {
            userUnitPrice.setText(rs.getString("UnitPrice"));
            userInStock.setText(rs.getString("QuantityInStock"));
            userItemNumber.setText(rs.getString("ItemNumber"));
            userCategoryName.setValue(rs.getString("Category"));
        }
    }

    @FXML
    void CategoryAutoFill(ActionEvent event) throws SQLException {
        userItemName.getItems().clear();
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        PreparedStatement ps = con.prepareStatement("select ItemName from ItemDetails WHERE Category = ?");
        ps.setString(1, userCategoryName.getValue());
        rs = ps.executeQuery();
        while(rs.next())
        {
            userItemName.getItems().add(rs.getString("ItemName"));
        }
    }

    @FXML
    void Transaction(MouseEvent event)
    {

    }


    @Override
    public void initialize(URL location, ResourceBundle Resources)
    {
        Controller c = new Controller();
        System.out.println(c.getEmpName());
        try {

            UserCategoryCombo();

            //UserItemNameCombo();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
