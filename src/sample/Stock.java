package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
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


public class Stock implements Initializable {

    @FXML
    private TableView<StockModel> table;

    @FXML
    private JFXComboBox<String> itemID;

    @FXML
    private JFXTextField itemNumber;

    @FXML
    private JFXTextField itemName;

    @FXML
    private JFXTextField unitPrice;

    @FXML
    private JFXTextField inStock;

    @FXML
    private JFXComboBox<String> category;

    @FXML
    private JFXComboBox<String> supplier;

    @FXML
    private Label barCode;

    @FXML
    private TableColumn<?, ?> itemIDColumn;

    @FXML
    private TableColumn<?, ?> itemNumberColumn;

    @FXML
    private TableColumn<?, ?> itemNameColumn;

    @FXML
    private TableColumn<?, ?> unitPriceColumn;

    @FXML
    private TableColumn<?, ?> inStockColumn;

    @FXML
    private TableColumn<?, ?> categoryColumn;

    @FXML
    private TableColumn<?, ?> supplierColumn;

    @FXML
    private TableColumn<?, ?> barcodeColumn;

    @FXML
    private Pane history;

    @FXML
    private Pane stock;

    @FXML
    private Pane employee;

    @FXML
    private Pane login;

    @FXML
    private Pane categoryButton;

    @FXML
    private Pane supplierButton;

    String categoryid;
    String supplierid;

    void ItemIDCombo() {

        itemID.getItems().clear();
        try {
            Connection con = dbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select ItemID from ItemDetails");
            while (rs.next()) {

                String result = rs.getString("ItemID");
                itemID.getItems().add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void autoDisplay(ActionEvent event) throws SQLException {
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        PreparedStatement pst = con.prepareStatement("select * from ItemDetails where ItemID  = ?");
        pst.setString(1, itemID.getValue());
        rs = pst.executeQuery();

        while(rs.next())
        {
            itemName.setText(rs.getString("ItemName"));
            itemNumber.setText(rs.getString("ItemNumber"));
            unitPrice.setText(rs.getString("UnitPrice"));
            inStock.setText(rs.getString("QuantityInStock"));
            //dateOfBirth.setValue(rs.getString("DateOfBirth"));
            category.setValue(rs.getString("Category"));
            supplier.setValue(rs.getString("Supplier"));
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
            category.getItems().add(rs.getString("CategoryName"));
        }
    }


    void SupplierCombo() throws SQLException {
        Connection con = dbConnection.getConnection();
        ResultSet rs;
        Statement st = con.createStatement();
        rs = st.executeQuery("select SupplierName from SupplierDetails");

        while(rs.next())
        {
            supplier.getItems().add(rs.getString("SupplierName"));
        }
    }

    public void tableDisplay() throws SQLException {
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
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        supplierColumn.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        barcodeColumn.setCellValueFactory(new PropertyValueFactory<>("barcode"));


        table.setItems(oblist);
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
    void add(MouseEvent event) throws SQLException {

        String itemID = null;
        String ItemName = itemName.getText();
        String ItemNumber = itemNumber.getText();
        String UnitPrice = unitPrice.getText();
        String InStock = inStock.getText();
        String Category = category.getValue();
        String Supplier = supplier.getValue();
        String BarCode = barCode.getText();

        Connection con = dbConnection.getConnection();
        Connection con1 = dbConnection.getConnection();
        Connection con2 = dbConnection.getConnection();
        ResultSet rs, rs2;
        PreparedStatement ps1 = con1.prepareStatement("select CategoryID from ProductCategory WHERE CategoryName = ?");
        String ccategory = category.getValue();
        ps1.setString(1, ccategory);
        rs=ps1.executeQuery();

        while(rs.next()) {
            this.categoryid = rs.getString("CategoryID");
        }
        con1.close();
        PreparedStatement ps2 = con2.prepareStatement("select SupplierID from SupplierDetails WHERE SupplierName = ?");
        String ssupplier = supplier.getValue();
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
        tableDisplay();
        con.close();

    }

    @FXML
    void clear(MouseEvent event) {
        itemID.setValue(null);
        itemName.setText("");
        itemNumber.setText("");
        unitPrice.setText("");
        inStock.setText("");
        category.setValue(null);
        supplier.setValue(null);
        barCode.setVisible(false);
    }

    @FXML
    void close(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void delete(MouseEvent event) throws SQLException {
        Connection con = dbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("DELETE  FROM  ItemDetails WHERE ItemID = ?");
        pst.executeUpdate();
        itemID.setValue(null);
        itemName.setText("");
        itemNumber.setText("");
        unitPrice.setText("");
        inStock.setText("");
        category.setValue(null);
        supplier.setValue(null);
        barCode.setVisible(false);
        tableDisplay();
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
        else if(evt.getSource()==categoryButton) {
            categoryButton.setEffect(new Glow(1.0));
        }
        else if(evt.getSource()==supplierButton) {
            supplierButton.setEffect(new Glow(1.0));
        }
    }

    @FXML
    void minimize(MouseEvent eve) {
        Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
    }

    @FXML
    void normal(MouseEvent event) {
        login.setEffect(null);
        employee.setEffect(null);
        stock.setEffect(null);
        history.setEffect(null);
        categoryButton.setEffect(null);
        supplierButton.setEffect(null);
    }

    @FXML
    void DisplayTable(MouseEvent event) throws SQLException {
        tableDisplay();
    }

    @FXML
    void update(MouseEvent event) throws SQLException {
        String itemid = itemID.getValue();
        String ItemName = itemName.getText();
        String ItemNumber = itemNumber.getText();
        String UnitPrice = unitPrice.getText();
        String InStock = inStock.getText();
        String Category = category.getValue();
        String Supplier = supplier.getValue();
        String BarCode = barCode.getText();

        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE  ItemDetails SET ItemName = ?, ItemNumber = ?, UnitPrice = ?," +
                " QuantityInStock = ?, Category = ?, Supplier = ?, Barcode = ?, WHERE ItemID = ?");

        ps.setString(1, ItemName);
        ps.setString(2, ItemNumber);
        ps.setString(3, UnitPrice);
        ps.setString(4, InStock);
        ps.setString(5, Category);
        ps.setString(6, Supplier);
        ps.setString(7, BarCode);
        ps.setString(8, itemid);
        ps.executeUpdate();
        tableDisplay();
        con.close();
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
    void loginLink(MouseEvent evt) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loginPane.fxml"));
        Stage primaryStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(pane, 1200, 700));
    }

    @FXML
    void logOut(MouseEvent eve) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage primaryStage = (Stage) ((Node) eve.getSource()).getScene().getWindow();
        primaryStage.setX(447.0);
        primaryStage.setY(104.0);
        primaryStage.setScene(new Scene(pane, 472, 457));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            ItemIDCombo();
            CategoryCombo();
            SupplierCombo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

