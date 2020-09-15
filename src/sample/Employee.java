package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Employee implements Initializable {

    @FXML
    private Pane history;

    @FXML
    private Pane stock;

    @FXML
    private Pane employee;

    @FXML
    private Pane login;

    @FXML
    private JFXTextField firstName;

    @FXML
    private JFXTextField lastName;

    @FXML
    private JFXDatePicker dateOfBirth;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField middleName;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXTextField employeeName;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField city;

    @FXML
    private Pane category;

    @FXML
    private Pane supplier;

    @FXML
    private ImageView avarta;

    @FXML
    private JFXComboBox<String> employeeID;

    @FXML
    private TableColumn<?, ?> firstNameColumn;

    @FXML
    private TableColumn<?, ?> middleNameColumn;

    @FXML
    private TableColumn<?, ?> lastNameColumn;

    @FXML
    private TableColumn<?, ?> ageColumn;

    @FXML
    private TableColumn<?, ?> dateOfBirthColumn;

    @FXML
    private TableColumn<?, ?> phoneColumn;

    @FXML
    private TableColumn<?, ?> addressColumn;

    @FXML
    private TableColumn<?, ?> cityColumn;

    @FXML
    private TableColumn<?, ?> empIDColumn;

    @FXML
    private TableView<employeeModal> table;

    public void tableDisplay() throws SQLException {
        ObservableList<employeeModal> oblist = FXCollections.observableArrayList();
        Connection con = dbConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("select * from Employee");

        while (rs.next())
        {
            oblist.add(new employeeModal(rs.getString("EmployeeID"),rs.getString("FirstName"), rs.getString("MiddleName"),
                    rs.getString("LastName"),rs.getString("Age"),rs.getString("DateOfBirth"),
                    rs.getString("PhoneNumber"),rs.getString("Address"),rs.getString("City")));
        }

        empIDColumn.setCellValueFactory(new PropertyValueFactory<>("empID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleNameColumn.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));

        table.setItems(oblist);
        con.close();
    }

    @FXML
    void close(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void add(MouseEvent event) throws SQLException, IOException {
        String filename = null;
        File image = new File(filename);
        FileInputStream fis = new FileInputStream(image);
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int readnum; (readnum = fis.read(buf)) != -1;) {
            bas.write(buf, 0, readnum);
        }
        //passport = bas.toByteArray();

        String id = null;
        String firstname = firstName.getText();
        String middlename = middleName.getText();
        String lastname = lastName.getText();
        String age1 = age.getText();
        LocalDate dobLoc = dateOfBirth.getValue();
        DateTimeFormatter dobTim = DateTimeFormatter.ofPattern("dd MM yyyy");
        String dobStr = dobLoc.format(dobTim);
        String phonenumber = phone.getText();
        String addresss = address.getText();
        String cityy = city.getText();

        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into Employee values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

        ps.setString(1, id);
        ps.setString(2, firstname);
        ps.setString(3, middlename);
        ps.setString(4, lastname);
        ps.setString(5, age1);
        ps.setString(6, dobStr);
        ps.setString(7, phonenumber);
        ps.setString(8, addresss);
        ps.setString(9, cityy);
        ps.executeUpdate();
        con.close();
        tableDisplay();

    }

    @FXML
    void clear(MouseEvent event) {
        employeeID.setValue(null);
        firstName.setText("");
        middleName.setText("");
        lastName.setText("");
        age.setText("");
        //dateOfBirth.setValue(rs.getString("DateOfBirth"));
        phone.setText("");
        address.setText("");
        city.setText("");
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
    void normal(MouseEvent event) {
        login.setEffect(null);
        employee.setEffect(null);
        stock.setEffect(null);
        history.setEffect(null);
        category.setEffect(null);
        supplier.setEffect(null);
    }

    @FXML
    void search(MouseEvent event) {

    }

    @FXML
    void update(MouseEvent event) throws SQLException {
        String id = null;
        String firstname = firstName.getText();
        String middlename = middleName.getText();
        String lastname = lastName.getText();
        String age1 = age.getText();
        LocalDate dobLoc = dateOfBirth.getValue();
        DateTimeFormatter dobTim = DateTimeFormatter.ofPattern("dd MM yyyy");
        String dobStr = dobLoc.format(dobTim);
        String phonenumber = phone.getText();
        String addresss = address.getText();
        String cityy = city.getText();

        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("update  Employee set FirstName = ?, MiddleName = ?, LastName = ?," +
                "Age = ?, DateOfBirth = ? , PhoneNumber = ?, Address = ?, City = ? where FirstName = ?");


        ps.setString(1, firstname);
        ps.setString(2, middlename);
        ps.setString(3, lastname);
        ps.setString(4, age1);
        ps.setString(5, dobStr);
        ps.setString(6, phonenumber);
        ps.setString(7, addresss);
        ps.setString(8, cityy);
        ps.setString(9, firstname);
        ps.executeUpdate();
        con.close();
        tableDisplay();

    }


    @FXML
    void stockLink(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("stock.fxml"));
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(pane, 1200, 700));
    }

    @FXML
    void delete(MouseEvent event) throws SQLException {
        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("delete  from Employee where EmployeeID = ? ");
        ps.executeUpdate();
        tableDisplay();
    }

    @FXML
    void openFile(MouseEvent eve) {
        Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
        FileChooser chooser = new FileChooser();
        File selectedFile = chooser.showOpenDialog(primaryStage);
        if(selectedFile !=null) {

            Image avartaImage = new Image(selectedFile.toURI().toString());
            avarta.setImage(avartaImage);
        }

    }

    @FXML
    void tableButton(MouseEvent event) throws SQLException {
        tableDisplay();
    }

    @FXML
    void autoDispaly(ActionEvent event) throws SQLException {
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        PreparedStatement pst = con.prepareStatement("select * from Employee where EmployeeID = ?");
        pst.setString(1, employeeID.getValue());
        rs = pst.executeQuery();

        while(rs.next())
        {
            firstName.setText(rs.getString("FirstName"));
            middleName.setText(rs.getString("MiddleName"));
            lastName.setText(rs.getString("LastName"));
            age.setText(rs.getString("Age"));
            //dateOfBirth.setValue(rs.getString("DateOfBirth"));
            phone.setText(rs.getString("PhoneNumber"));
            address.setText(rs.getString("Address"));
            city.setText(rs.getString("City"));
        }

    }

    @FXML
    void minimize(MouseEvent eve) {
        Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
    }


    @FXML
    void loginPage(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loginPane.fxml"));
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(pane, 1200, 700));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try {
            Connection con = dbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select EmployeeID from Employee");
            while(rs.next())
            {

                String result = rs.getString("EmployeeID");
                employeeID.getItems().add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
