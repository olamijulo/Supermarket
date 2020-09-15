package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    public TextField username;

    @FXML
    public PasswordField password;

    @FXML
    private Label error;

    String user;
    String pass;
    private String empName;

    @FXML
    void submit(MouseEvent eve) throws IOException, SQLException {
            user = username.getText();
            pass = password.getText();

            Connection con = dbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Login WHERE UserName = ? AND Password = ?");
            ResultSet rs;
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();


            while (rs.next()) {


                if (rs.getString("Role").equals("ADMIN") && user.equals(rs.getString("UserName")) && pass.equals(rs.getString("Password"))) {

                    AnchorPane pane = FXMLLoader.load(getClass().getResource("category.fxml"));
                    Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
                    primaryStage.setScene(new Scene(pane, 1200, 700));
                    primaryStage.setX(90);
                    primaryStage.setY(40);
                } else if (rs.getString("Role").equals("USER") && user.equals(rs.getString("UserName")) && pass.equals(rs.getString("Password"))) {

                    String empName = rs.getString("EmployeeName");
                    this.empName = empName;
                    System.out.println(this.empName);

                    AnchorPane pane = FXMLLoader.load(getClass().getResource("user.fxml"));
                    Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
                    primaryStage.setScene(new Scene(pane, 1200, 700));
                    primaryStage.setX(90);
                    primaryStage.setY(40);

                } else if (!user.equals(rs.getString("UserName")) && !pass.equals(rs.getString("Password"))) {
                    error.setVisible(true);
                }

            }

    }

    public String getEmpName(){

        return this.empName;
    }

    @FXML
    void clear(ActionEvent evt) throws SQLException, IOException {

        username.setText("");
        password.setText("");
    }

    @FXML
    void close(MouseEvent event) {
        System.exit(0);
    }


    @FXML
    void minimize(MouseEvent eve) {
        Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}



