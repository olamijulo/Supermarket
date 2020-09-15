package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Category implements Initializable {


    //Side Pane
    @FXML
    private Pane sidePane;

    @FXML
    private Pane orderDetails;

    @FXML
    private Pane stock;

    @FXML
    private Pane employee;

    @FXML
    private Pane login;

    @FXML
    private Pane supplier;

    @FXML
    private Pane stockPage;

    @FXML
    private Pane category;

    //Employee Page declaration

    @FXML
    private Pane employeePage;

    @FXML
    private ImageView avarta;

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
    private JFXTextField address1;

    @FXML
    private JFXTextField city;

    @FXML
    private JFXComboBox<String> employeeID;

    @FXML
    private TableView<employeeModal> employeeTable;

    @FXML
    private TableColumn<?, ?> empIDColumn;

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
    private TableColumn<?, ?> addressColumn1;

    @FXML
    private TableColumn<?, ?> cityColumn;

    @FXML
    private JFXTextField searchBox1;

    //Login Page declaration

    @FXML
    private Pane loginPage;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXPasswordField loginPassword;

    @FXML
    private JFXComboBox<String> roleCombo;

    @FXML
    private JFXComboBox<String> userIDCombo;

    @FXML
    private JFXTextField employeeName;

    @FXML
    private  TableView<modalClass> loginTable;

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
    private JFXTextField searchBox;

    //Supplier Page declaration
    @FXML
    private Pane supplierPage;

    @FXML
    private JFXTextField supplierName;

    @FXML
    private JFXComboBox<String> supplierID;

    @FXML
    private TableView<supplierModal> supplierDetailsTable;

    @FXML
    private TableColumn<?, ?> supplierIDColumn;

    @FXML
    private TableColumn<?, ?> supplierNameColumn;

    @FXML
    private TableColumn<?, ?> addressColumn;

    @FXML
    private TableColumn<?, ?> phoneNumberColumn;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField phoneNumber;

    @FXML
    private JFXTextField email;

    //Order Details
    @FXML
    private Pane orderDetailsPage;

    //Dashboard declarations
    @FXML
    private Pane dashboard;

    @FXML
    private Pane login1;

    @FXML
    private Pane employee1;

    @FXML
    private Pane stock1;

    @FXML
    private Pane orderDetails1;

    @FXML
    private Pane category1;

    @FXML
    private Pane supplier1;

    @FXML
    private Pane productCategoryPage;

    //Category page declarations

    @FXML
    private JFXComboBox<String> categoryID;

    @FXML
    private JFXTextField categoryName;

    @FXML
    private TableView<categoryModal> ProductCatTable;

    @FXML
    private TableColumn<?, ?> categoryIDColumn;

    @FXML
    private TableColumn<?, ?> categoryColumn;

    //Stock page declarations

    @FXML
    private JFXComboBox<String> itemIDCombo;

    @FXML
    private JFXTextField itemNumber;

    @FXML
    private JFXTextField itemName;

    @FXML
    private JFXTextField unitPrice;

    @FXML
    private JFXTextField inStock;

    @FXML
    private JFXTextField stockSearchBox;

    @FXML
    private JFXComboBox<String> stockCategory;

    @FXML
    private JFXComboBox<String> stockSupplier;

    @FXML
    private Label barCode;

    @FXML
    private TableView<StockModel> stockTable;

    @FXML
    private TableColumn<?, ?> itemIDColumn;

    @FXML
    private TableColumn<?, ?> itemNameColumn;

    @FXML
    private TableColumn<?, ?> itemNumberColumn;

    @FXML
    private TableColumn<?, ?> stockCategoryColumn;

    @FXML
    private TableColumn<?, ?> unitPriceColumn;

    @FXML
    private TableColumn<?, ?> inStockColumn;

    @FXML
    private TableColumn<?, ?> barcodeColumn;

    @FXML
    private TableColumn<?, ?> supplierColumn;

    //declarations for user
    @FXML
    private Pane userPage;
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
    private Label userUserName;

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

    //Authentication declarations
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label error;


    /*-------------------------------------------------------------------------------------------------
        GENERAL CODE
     --------------------------------------------------------------------------------------------------*/

    @FXML
    void DashBoardGlow(MouseEvent evt) {
        if(evt.getSource()==login1)
        {
            login1.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==employee1)
        {
            employee1.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==stock1)
        {
            stock1.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==orderDetails1) {
            orderDetails1.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==category1) {
            category1.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==supplier1) {
            supplier1.setEffect(new Glow(1.0));
        }
    }

    @FXML
    void SidePaneGlow(MouseEvent evt) {
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
        else if(evt.getSource()==orderDetails) {
            orderDetails.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==category) {
            category.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==supplier) {
            supplier.setEffect(new Glow(1.0));
        }
    }

    @FXML
    void loginLink(MouseEvent evt) throws IOException {
        loginPage.toFront();
        sidePane.toFront();
    }

    @FXML
    void employeeLink(MouseEvent evt) throws IOException {
        employeePage.toFront();
        sidePane.toFront();
    }

    @FXML
    void stockLink(MouseEvent evt) throws IOException {
        stockPage.toFront();
        sidePane.toFront();
    }


    @FXML
    void supplierLink(MouseEvent evt) throws IOException {
        supplierPage.toFront();
        sidePane.toFront();
    }

    @FXML
    void orderDetailsLink(MouseEvent evt) throws IOException {
        orderDetailsPage.toFront();
        sidePane.toFront();
    }

    @FXML
    void categoryLink(MouseEvent evt) throws IOException {
        productCategoryPage.toFront();
        sidePane.toFront();
    }


    @FXML
    void normal(MouseEvent event) {
        login.setEffect(null);
        employee.setEffect(null);
        stock.setEffect(null);
        orderDetails.setEffect(null);
        category.setEffect(null);
        supplier.setEffect(null);
        login1.setEffect(null);
        employee1.setEffect(null);
        stock1.setEffect(null);
        orderDetails1.setEffect(null);
        category1.setEffect(null);
        supplier1.setEffect(null);
    }

    @FXML
    void close(MouseEvent event) {
        dashboard.toFront();
        System.exit(0);
    }

    @FXML
    void minimize(MouseEvent evt) {
        Stage primaryStage = (Stage)((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
    }

    @FXML
    void logOut(MouseEvent eve) throws IOException {
        dashboard.toFront();
        Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
        primaryStage.hide();
        primaryStage.setWidth(472);
        primaryStage.setHeight(457);
        primaryStage.setX(480);
        primaryStage.setY(120);
        userPage.setVisible(false);
        stockPage.setVisible(false);
        orderDetailsPage.setVisible(false);
        sidePane.setVisible(false);
        loginPage.setVisible(false);
        supplierPage.setVisible(false);
        employeePage.setVisible(false);
        productCategoryPage.setVisible(false);
        dashboard.setVisible(false);
        error.setVisible(false);
        login.setVisible(true);
        primaryStage.show();
    }

    /*---------------------------------------------------------------------------------------------
    CODE FOR AUTHENTICATION
//     ---------------------------------------------------------------------------------------------*/
    String user;
    String pass;
    String empName;

    @FXML
    void submit(MouseEvent eve) throws IOException, SQLException {

        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from Login WHERE UserName = ? AND Password = ?");
        ResultSet rs;
        ps.setString(1, username.getText());
        ps.setString(2, password.getText());
        rs = ps.executeQuery();


        while (rs.next()) {
            user = username.getText();
            pass = password.getText();

            if (rs.getString("Role").equals("ADMIN") && user.equals(rs.getString("UserName")) && pass.equals(rs.getString("Password"))) {

                Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
                primaryStage.hide();
                primaryStage.setWidth(1200);
                primaryStage.setHeight(700);
                //login.setVisible(false);
                stockPage.setVisible(true);
                orderDetailsPage.setVisible(true);
                sidePane.setVisible(true);
                loginPage.setVisible(true);
                supplierPage.setVisible(true);
                employeePage.setVisible(true);
                productCategoryPage.setVisible(true);
                dashboard.setVisible(true);
                primaryStage.show();

                username.setText("");
                password.setText("");

                primaryStage.setX(90);
                primaryStage.setY(40);
            } else if (rs.getString("Role").equals("USER") && user.equals(rs.getString("UserName")) && pass.equals(rs.getString("Password"))) {
                Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
                primaryStage.hide();
                primaryStage.setWidth(1200);
                primaryStage.setHeight(700);
                login.setVisible(false);
                userPage.setVisible(true);
                stockPage.setVisible(true);
                orderDetailsPage.setVisible(true);
                sidePane.setVisible(true);
                loginPage.setVisible(true);
                supplierPage.setVisible(true);
                employeePage.setVisible(true);
                productCategoryPage.setVisible(true);
                dashboard.setVisible(true);
                userPage.toFront();
                primaryStage.show();
                username.setText("");
                password.setText("");

                primaryStage.setX(90);
                primaryStage.setY(40);

                empName = rs.getString("EmployeeName");
                userUserName.setText(empName);
            }
        }
        error.setVisible(true);
    }

    @FXML
    void clear(ActionEvent evt) throws SQLException, IOException {

        username.setText("");
        password.setText("");
    }

    /*---------------------------------------------------------------------------------------
    CODE FOR USER
     ----------------------------------------------------------------------------------------*/
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

    /*---------------------------------------------------------------------------------------------
        CODE FOR CATEGORY
     ------------------------------------------------------------------------------------------------*/

    void categoryIDCombo() {

        categoryID.getItems().clear();
        try {
            Connection con = dbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select categoryID from ProductCategory");
            while (rs.next()) {

                String result = rs.getString("CategoryID");
                categoryID.getItems().add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void ProductCatAdd(MouseEvent event) throws SQLException {
        String id = null;
        String categoryname = categoryName.getText();
        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into ProductCategory values (?,?)");
        ps.setString(1, id);
        ps.setString(2, categoryname);
        ps.executeUpdate();
        categoryIDCombo();
        ProductCatTableDisplay();
    }

    @FXML
    void ProductCatClear(MouseEvent event) {
        categoryID.setValue(null);
        categoryName.setText("");
    }

    @FXML
    void ProductCatDelete(MouseEvent event) throws SQLException {
        String id = categoryID.getValue();
        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE from ProductCategory WHERE CategoryID = ?");
        ps.setString(1, id);
        ps.execute();
        categoryIDCombo();
        ProductCatTableDisplay();
    }

    @FXML
    void CatIDAutoDisplay(ActionEvent event) throws SQLException {
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        PreparedStatement pst = con.prepareStatement("select * from ProductCategory where CategoryID = ?");
        pst.setString(1, categoryID.getValue());
        rs = pst.executeQuery();

        while(rs.next())
        {
            categoryName.setText(rs.getString("CategoryName"));
        }

    }

    @FXML
    void ProductCatTableDisplay() throws SQLException {
        ObservableList<categoryModal> oblist = FXCollections.observableArrayList();
        Connection con = dbConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("select * from ProductCategory");

        while (rs.next())
        {
            oblist.add(new categoryModal(rs.getString("CategoryID"),rs.getString("CategoryName")));
        }

        categoryIDColumn.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

        ProductCatTable.setItems(oblist);
    }

    @FXML
    void ProductCatUpdate(MouseEvent event) throws SQLException {
        String id = categoryID.getValue();
        String categoryname = categoryName.getText();
        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE  ProductCategory SET CategoryName = ? WHERE CategoryID = ?");
        ps.setString(1, categoryname);
        ps.setString(2, id);
        ps.execute();
        ProductCatTableDisplay();
    }

    /*------------------------------------------------------------------------------------------
        CODE FOR LOGIN
     -------------------------------------------------------------------------------------------*/

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

    public void LoginTableDisplay() throws SQLException {
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
        loginTable.setItems(oblist);
    }

    @FXML
    void LoginSearch(MouseEvent event) throws SQLException {
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

        loginTable.setItems(oblist);
    }


    @FXML
    void LoginAdd(MouseEvent event) throws SQLException {
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
        LoginTableDisplay();
        UserIDCombo();
    }

    @FXML
    void LoginDelete(MouseEvent event) throws SQLException {

        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from Login where UserID = ?");
        ps.setString(1, userIDCombo.getValue());
        ps.executeUpdate();
        LoginTableDisplay();
        userIDCombo.setValue(null);
        employeeName.setText("");
        userName.setText("");
        password.setText("");
        roleCombo.setValue(null);

        UserIDCombo();


    }

    @FXML
    void LoginUpdate(MouseEvent event) throws SQLException {
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
        LoginTableDisplay();

    }

    @FXML
    void LoginClear(MouseEvent event) {
        userIDCombo.setValue(null);
        userName.setText("");
        password.setText("");
        roleCombo.setValue(null);
        employeeName.setText("");
    }

    @FXML
    void LoginAutoDisplay(ActionEvent event) throws SQLException {
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


    /*------------------------------------------------------------------------------------------
        CODE FOR STOCK
     -------------------------------------------------------------------------------------------*/
    String categoryid;
    String supplierid;

    void ItemIDCombo() {

        itemIDCombo.getItems().clear();
        try {
            Connection con = dbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select ItemID from ItemDetails ORDER  by ItemID ASC ");
            while (rs.next()) {

                String result = rs.getString("ItemID");
                itemIDCombo.getItems().add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GenerateRandomNum(MouseEvent event) {
        long number = (long) Math.floor(Math.random()*9_000_000_000L)+1_000_000_000L;
        itemNumber.setText(Long.toString(number));
    }

    @FXML
    void StockAutoDisplay(ActionEvent event) throws SQLException {
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        PreparedStatement pst = con.prepareStatement("select * from ItemDetails where ItemID  = ?");
        pst.setString(1, itemIDCombo.getValue());
        rs = pst.executeQuery();

        while(rs.next())
        {
            itemName.setText(rs.getString("ItemName"));
            itemNumber.setText(rs.getString("ItemNumber"));
            unitPrice.setText(rs.getString("UnitPrice"));
            inStock.setText(rs.getString("QuantityInStock"));
            stockCategory.setValue(rs.getString("Category"));
            stockSupplier.setValue(rs.getString("Supplier"));
            barCode.setText(rs.getString("Barcode"));
        }

    }

    void CategoryCombo() throws SQLException {
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        Statement st = con.createStatement();
        rs = st.executeQuery("select CategoryName from ProductCategory");

        while(rs.next())
        {
            stockCategory.getItems().add(rs.getString("CategoryName"));
        }
    }


    void SupplierCombo() throws SQLException {
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        Statement st = con.createStatement();
        rs = st.executeQuery("select SupplierName from SupplierDetails");

        while(rs.next())
        {
            stockSupplier.getItems().add(rs.getString("SupplierName"));
        }
    }

    public void StockTable() throws SQLException {
        ObservableList<StockModel> oblist = FXCollections.observableArrayList();
        Connection con = dbConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM ItemDetails");

        while (rs.next())
        {
            oblist.add(new StockModel(rs.getString("ItemID"),rs.getString("ItemName"), rs.getString("ItemNumber"),
                    rs.getString("UnitPrice"),rs.getString("QuantityInStock"),rs.getString("Category")
                    ,rs.getString("Supplier"),rs.getString("Barcode")));
        }

        itemIDColumn.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemNumberColumn.setCellValueFactory(new PropertyValueFactory<>("itemNumber"));
        unitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        inStockColumn.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        stockCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        supplierColumn.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        barcodeColumn.setCellValueFactory(new PropertyValueFactory<>("barcode"));

        stockTable.setItems(oblist);
        con.close();
    }

    @FXML
    void getItemNumber(MouseEvent event) {

        String itemNo = itemNumber.getText();
        barCode.setText(itemNo);


    }

    private void pageSetup(Node node, Stage PrimaryStage)
    {
        //creating the printer job
        PrinterJob job = PrinterJob.createPrinterJob();
        if(job == null)
        {
            return;
        }
        //show page setup dialog
        boolean proceed = job.showPrintDialog(PrimaryStage);
        if(proceed)
        {
            print(job, node);
        }
    }

    private void print(PrinterJob job, Node node)
    {
        //set the job status message

        //print the node
        boolean printed = job.printPage(node);
        if(printed)
        {
            job.endJob();
        }
    }

    @FXML
    void printBarcode(MouseEvent evt) {
        pageSetup(barCode, (Stage) ((Node) evt.getSource()).getScene().getWindow());
    }

    @FXML
    void StockAdd(MouseEvent event) throws SQLException {

        String itemID = null;
        String ItemName = itemName.getText();
        String ItemNumber = itemNumber.getText();
        String UnitPrice = unitPrice.getText();
        String InStock = inStock.getText();
        String Category = stockCategory.getValue();
        String Supplier = stockSupplier.getValue();
        String BarCode = barCode.getText();

        Connection con = dbConnection.getConnection();
        Connection con1 = dbConnection.getConnection();
        Connection con2 = dbConnection.getConnection();
        ResultSet rs, rs2;
        PreparedStatement ps1 = con1.prepareStatement("select CategoryID from ProductCategory WHERE CategoryName = ?");
        String ccategory = stockCategory.getValue();
        ps1.setString(1, ccategory);
        rs=ps1.executeQuery();

        while(rs.next()) {
            this.categoryid = rs.getString("CategoryID");
        }
        con1.close();
        PreparedStatement ps2 = con2.prepareStatement("select SupplierID from SupplierDetails WHERE SupplierName = ?");
        String ssupplier = stockSupplier.getValue();
        ps2.setString(1, ssupplier);
        rs2=ps2.executeQuery();
        while(rs2.next()) {
            this.supplierid = rs2.getString("SupplierID");
        }
        con2.close();
        PreparedStatement ps = con.prepareStatement("insert into ItemDetails values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        ps.setString(1, itemID);
        ps.setString(2, ItemName);
        ps.setString(3, ItemNumber);
        ps.setString(4, UnitPrice);
        ps.setString(5, InStock);
        ps.setString(6, this.categoryid);
        ps.setString(7, Category);
        ps.setString(8, this.supplierid);
        ps.setString(9, Supplier);
        ps.setString(10, BarCode);
        ps.executeUpdate();
        ItemIDCombo();
        StockTable();
        con.close();

    }

    @FXML
    void StockSearch(MouseEvent event) throws SQLException {
        ObservableList<StockModel> oblist = FXCollections.observableArrayList();
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        PreparedStatement ps = con.prepareStatement("select * from ItemDetails WHERE ItemName = ?");
        String search = stockSearchBox.getText();
        ps.setString(1, search);
        rs=ps.executeQuery();
        while (rs.next())
        {
            oblist.add(new StockModel(rs.getString("ItemID"),rs.getString("ItemName"), rs.getString("ItemNumber"),
                    rs.getString("UnitPrice"),rs.getString("QuantityInStock"),rs.getString("Category")
                    ,rs.getString("Supplier"),rs.getString("Barcode")));
        }
        itemIDColumn.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemNumberColumn.setCellValueFactory(new PropertyValueFactory<>("itemNumber"));
        unitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        inStockColumn.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        stockCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        supplierColumn.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        barcodeColumn.setCellValueFactory(new PropertyValueFactory<>("barcode"));

        stockTable.setItems(oblist);
    }

    @FXML
    void StockClear(MouseEvent event) {
        itemIDCombo.setValue(null);
        itemName.setText("");
        itemNumber.setText("");
        unitPrice.setText("");
        inStock.setText("");
        stockCategory.setValue(null);
        stockSupplier.setValue(null);
        barCode.setText(null);
    }


    @FXML
    void StockDelete(MouseEvent event) throws SQLException {
        Connection con = dbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("DELETE  FROM  ItemDetails WHERE ItemID = ?");
        pst.setString(1, itemIDCombo.getValue());
        pst.executeUpdate();
        itemIDCombo.setValue(null);
        itemName.setText("");
        itemNumber.setText("");
        unitPrice.setText("");
        inStock.setText("");
        stockCategory.setValue(null);
        stockSupplier.setValue(null);
        barCode.setVisible(false);
        ItemIDCombo();
        StockTable();
    }

    @FXML
    void StockDisplayTable(MouseEvent event) throws SQLException {
        StockTable();
    }

    @FXML
    void StockUpdate(MouseEvent event) throws SQLException {
        String itemid = itemIDCombo.getValue();
        String ItemName = itemName.getText();
        String ItemNumber = itemNumber.getText();
        String UnitPrice = unitPrice.getText();
        String InStock = inStock.getText();
        String Category = stockCategory.getValue();
        String Supplier = stockSupplier.getValue();
        String BarCode = barCode.getText();

        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE  ItemDetails SET ItemName = ?, ItemNumber = ?, UnitPrice = ?," +
                " QuantityInStock = ?, Category = ?, Supplier = ?, Barcode = ? WHERE ItemID = ?");

        ps.setString(1, ItemName);
        ps.setString(2, ItemNumber);
        ps.setString(3, UnitPrice);
        ps.setString(4, InStock);
        ps.setString(5, Category);
        ps.setString(6, Supplier);
        ps.setString(7, BarCode);
        ps.setString(8, itemid);
        ps.executeUpdate();
        StockTable();
        con.close();
    }

    /*------------------------------------------------------------------------------------------
        CODE FOR EMPLOYEE
     ------------------------------------------------------------------------------------------*/
    public void EmpIDCombo() throws SQLException {
        Connection con = dbConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("select EmployeeID from Employee");
        while(rs.next())
        {

            String result = rs.getString("EmployeeID");
            employeeID.getItems().add(result);
        }

    }

    public void EmployeeTableDisplay() throws SQLException {
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

        employeeTable.setItems(oblist);
        con.close();
    }

    @FXML
    void EmployeeAdd(MouseEvent event) throws SQLException, IOException {
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
        EmployeeTableDisplay();

    }

    @FXML
    void EmployeeClear(MouseEvent event) {
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
    void EmployeeSearch(MouseEvent event) {

    }

    @FXML
    void EmployeeUpdate(MouseEvent event) throws SQLException {
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
        EmployeeTableDisplay();

    }


    @FXML
    void EmployeeDelete(MouseEvent event) throws SQLException {
        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("delete  from Employee where EmployeeID = ? ");
        ps.executeUpdate();
        EmployeeTableDisplay();
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
    void EmployeeTable(MouseEvent event) throws SQLException {
        EmployeeTableDisplay();
    }

    @FXML
    void EmployeeAutoDisplay(ActionEvent event) throws SQLException {
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



    /*------------------------------------------------------------------------------------------
        CODE FOR SUPPLIER
     -------------------------------------------------------------------------------------------*/

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
    void SupplierAutoDisplay(ActionEvent event) throws SQLException {
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

    public void SupplierTableDisplay() throws SQLException {
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

        supplierDetailsTable.setItems(oblist);
        con.close();
    }

    @FXML
    void DisplaySupplierTable(ActionEvent event) throws SQLException {
        SupplierTableDisplay();
    }

    @FXML
    void SupplierAdd(MouseEvent event) throws SQLException {
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
        SupplierTableDisplay();

    }

    @FXML
    void SupplierClear(MouseEvent event) {
        supplierID.setValue(null);
        supplierName.setText("");
        phoneNumber.setText("");
        address.setText("");
        email.setText("");
    }

    @FXML
    void SupplierDelete(MouseEvent event) throws SQLException {
        String id = supplierID.getValue();
        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE from SupplierDetails WHERE SupplierID = ?");
        ps.setString(1, id);
        ps.executeUpdate();
        supplierID.setValue(null);
        supplierName.setText("");
        phoneNumber.setText("");
        address.setText("");
        email.setText("");
        suppllierIDCombo();
        SupplierTableDisplay();
    }

    @FXML
    void SupplierUpdate(MouseEvent event) throws SQLException {
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
        SupplierTableDisplay();
    }
/*-------------------------------------------------------------
    CODE FOR ORDER DETAILS
 --------------------------------------------------------------*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoryIDCombo();
        ItemIDCombo();
        roleCombo.getItems().addAll("ADMIN","USER");

        try {

            UserCategoryCombo();
//            UserItemNameCombo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            StockTable();
            LoginTableDisplay();
            EmployeeTableDisplay();
            SupplierTableDisplay();
            SupplierTableDisplay();
            UserIDCombo();
            suppllierIDCombo();
            EmpIDCombo();
            ProductCatTableDisplay();
            CategoryCombo();
            SupplierCombo();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

