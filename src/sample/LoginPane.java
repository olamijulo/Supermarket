package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginPane implements Initializable {


    @FXML
    private TableView<modalClass> table;

    @FXML
    private TableColumn<?, ?> userIDColumn;

    @FXML
    private TableColumn<?, ?> userNameColumn;

    @FXML
    private TableColumn<?, ?> passwordColumn;

    @FXML
    private TableColumn<?, ?> roleColumn;

    @FXML
    private TableColumn<?, ?> employeeNameColumn;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXTextField employeeName;

    @FXML
    private JFXTextField searchBox;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXComboBox<String> roleCombo;

    @FXML
    private JFXComboBox<String> userIDCombo;

    @FXML
    private Pane history;

    @FXML
    private Pane stock;

    @FXML
    private Pane employee;

    @FXML
    private Pane login;

    @FXML
    private Pane category;

    @FXML
    private Pane supplier;


    void UserIDCombo() {

        userIDCombo.getItems().clear();
        try {
            Connection con = dbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select UserID from Login");
            while (rs.next()) {

                String result = rs.getString("UserID");
                userIDCombo.getItems().add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tableDisplay() throws SQLException {
        ObservableList<modalClass> oblist = FXCollections.observableArrayList();
        Connection con = dbConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("select * from Login");

        while (rs.next())
        {
            oblist.add(new modalClass(rs.getString("UserID"),rs.getString("UserName"),rs.getString("Password"),rs.getString("Role"), rs.getString("EmployeeName")));
        }

        userIDColumn.setCellValueFactory(new PropertyValueFactory<>("userid"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("Password"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        table.setItems(oblist);
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
        else if(evt.getSource()==history) {
            history.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==category) {
            category.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==supplier) {
            supplier.setEffect(new Glow(1.0));
        }
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

    @FXML
    void logOut(MouseEvent eve) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
        primaryStage.setX(447.0);
        primaryStage.setY(104.0);
        primaryStage.setScene(new Scene(pane, 472, 457));
    }

    @FXML
    void close(MouseEvent event) {
        System.exit(0);
    }


    @FXML
    void search(MouseEvent event) throws SQLException {
        String user = searchBox.getText();

        ObservableList<modalClass> oblist = FXCollections.observableArrayList();
        Connection con = dbConnection.getConnection();
        PreparedStatement  ps = con.prepareStatement("select * from Login where UserName = ?");
        ResultSet rs;
        ps.setString(1, user);
        rs = ps.executeQuery();

        while (rs.next())
        {
            oblist.add(new modalClass(rs.getString("UserID"),rs.getString("UserName"),rs.getString("Password"),rs.getString("Role"), rs.getString("EmployeeName")));
        }

        userIDColumn.setCellValueFactory(new PropertyValueFactory<>("userid"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("Password"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));

        table.setItems(oblist);
    }

    @FXML
    void employeeLink(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("employee.fxml"));
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
    void stockLink(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("stock.fxml"));
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(pane, 1200, 700));
    }

    @FXML
    void add(MouseEvent event) throws SQLException {
        String id = null;
        String username = userName.getText();
        String pass = password.getText();
        String role = roleCombo.getValue();
        String employeename = employeeName.getText();
        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into Login values (?,?,?,?,?)");
        ps.setString(1, id);
        ps.setString(2, username);
        ps.setString(3, pass);
        ps.setString(4, role);
        ps.setString(5, employeename);
        ps.executeUpdate();
        tableDisplay();
        UserIDCombo();
    }

    @FXML
    void delete(MouseEvent event) throws SQLException {

        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from Login where UserID = ?");
        ps.setString(1, userIDCombo.getValue());
        ps.executeUpdate();
        tableDisplay();
        userIDCombo.setValue(null);
        employeeName.setText("");
        userName.setText("");
        password.setText("");
        roleCombo.setValue(null);

        UserIDCombo();


    }

    @FXML
    void update(MouseEvent event) throws SQLException {
        String username = userName.getText();
        String pass = password.getText();
        String role = roleCombo.getValue();
        String employeename = employeeName.getText();
        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("update  Login set EmployeeName = ?, Password = ?, Role = ? WHERE UserName = ?");
        ps.setString(1, employeename);
        ps.setString(2, pass);
        ps.setString(3, role);
        ps.setString(4, username);
        ps.executeUpdate();
        tableDisplay();

    }

    @FXML
    void clear(MouseEvent event) {
        userIDCombo.setValue(null);
        userName.setText("");
        password.setText("");
        roleCombo.setValue(null);
        employeeName.setText("");
    }

    @FXML
    void employeePage(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("employee.fxml"));
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(pane, 1200, 700));
    }

    @FXML
    void minimize(MouseEvent eve) {
        Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
    }

    @FXML
    void autoDisplay(ActionEvent event) throws SQLException {
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        PreparedStatement pst = con.prepareStatement("select * from Login where UserID = ?");
        pst.setString(1, userIDCombo.getValue());
        rs = pst.executeQuery();

        while(rs.next())
        {
            userName.setText(rs.getString("UserName"));
            password.setText(rs.getString("Password"));
            employeeName.setText(rs.getString("EmployeeName"));
            roleCombo.setValue(rs.getString("Role"));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roleCombo.getItems().add("ADMIN");
        roleCombo.getItems().add("USER");

        UserIDCombo();


      }


}

