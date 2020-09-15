package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Supplier implements Initializable{

    @FXML
    private JFXTextField supplierName;

    @FXML
    private JFXComboBox<String> supplierID;

    @FXML
    private TableView<supplierModal> table;

    @FXML
    private TableColumn<?, ?> supplierIDColumn;

    @FXML
    private TableColumn<?, ?> supplierNameColumn;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField phoneNumber;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private TableColumn<?, ?> phoneNumberColumn;

    @FXML
    private TableColumn<?, ?> addressColumn;

    @FXML
    private JFXTextField email;

    @FXML
    private Pane history;

    @FXML
    private Pane stock;

    @FXML
    private Pane employee;

    @FXML
    private Pane login;

    @FXML
    private Pane supplier;

    @FXML
    private Pane category;

    void suppllierIDCombo() {

        supplierID.getItems().clear();
        try {
            Connection con = dbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select supplierID from SupplierDetails");
            while (rs.next()) {

                String result = rs.getString("SupplierID");
                supplierID.getItems().add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void autoDisplay(ActionEvent event) throws SQLException {
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        PreparedStatement pst = con.prepareStatement("select * from SupplierDetails where SupplierID = ?");
        pst.setString(1, supplierID.getValue());
        rs = pst.executeQuery();

        while(rs.next())
        {
            supplierName.setText(rs.getString("SupplierName"));
            phoneNumber.setText(rs.getString("PhoneNumber"));
            address.setText(rs.getString("Address"));
            email.setText(rs.getString("Email"));

        }

    }

    public void tableDisplay() throws SQLException {
        ObservableList<supplierModal> oblist = FXCollections.observableArrayList();
        Connection con = dbConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("select * from SupplierDetails");

        while (rs.next())
        {
            oblist.add(new supplierModal(rs.getString("SupplierID"),rs.getString("SupplierName"), rs.getString("PhoneNumber"),
                    rs.getString("Address"),rs.getString("Email")));
        }

        supplierIDColumn.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
        supplierNameColumn.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.setItems(oblist);
        con.close();
    }


    @FXML
    void add(MouseEvent event) throws SQLException {
        String id = null;
        String supplierNameText = supplierName.getText();
        String phoneNumberText = phoneNumber.getText();
        String addressText = address.getText();
        String emailText = email.getText();
        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into SupplierDetails values (?,?,?,?,?)");
        ps.setString(1, id);
        ps.setString(2, supplierNameText);
        ps.setString(3, phoneNumberText);
        ps.setString(4, addressText);
        ps.setString(5, emailText);
        ps.executeUpdate();
        suppllierIDCombo();
        tableDisplay();

    }

    @FXML
    void clear(MouseEvent event) {
        supplierID.setValue(null);
        supplierName.setText("");
        phoneNumber.setText("");
        address.setText("");
        email.setText("");
    }

    @FXML
    void close(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void delete(MouseEvent event) throws SQLException {
        String id = supplierID.getValue();
        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE from SupplierDetails WHERE SupplierID = ?");
        ps.setString(1, id);
        suppllierIDCombo();
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
    void logOut(MouseEvent eve) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
        primaryStage.setX(447.0);
        primaryStage.setY(104.0);
        primaryStage.setScene(new Scene(pane, 472, 457));
    }


    @FXML
    void minimize(MouseEvent evt) {
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
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
    void employeeLink(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("employee.fxml"));
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(pane, 1200, 700));
    }

    @FXML
    void loginLink(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loginPane.fxml"));
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
    void update(MouseEvent event) throws SQLException {
        String id = supplierID.getValue();
        String supplierNameText = supplierName.getText();
        String phoneNumberText = phoneNumber.getText();
        String addressText = address.getText();
        String emailText = email.getText();
        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("update  SupplierDetails set SupplierName = ? , PhoneNumber = ?, Address = ?, Email = ? WHERE SupplierID = ?");
        ps.setString(1, supplierNameText);
        ps.setString(2, phoneNumberText);
        ps.setString(3, addressText);
        ps.setString(4, emailText);
        ps.setString(5, id);
        ps.executeUpdate();
        tableDisplay();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        suppllierIDCombo();

    }
}
