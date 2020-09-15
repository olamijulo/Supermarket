package sample;

public class StockModel {
    String itemID, itemName, itemNumber, unitPrice, inStock, category, supplier, barcode;

    public StockModel(String itemID, String itemName, String itemNumber,String  unitPrice, String inStock, String category, String supplier, String barcode)
    {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.unitPrice = unitPrice;
        this.inStock = inStock;
        this.category = category;
        this.supplier = supplier;
        this.barcode = barcode;
    }

    public String getItemID()
    {
        return itemID;
    }
    public String setItemID()
    {
        return itemID;
    }
    public String getItemName()
    {
        return itemName;
    }
    public String setItemName()
    {
        return itemName;
    }
    public String getItemNumber()
    {
        return itemNumber;
    }
    public String setItemNumber()
    {
        return itemNumber;
    }
    public String getUnitPrice()
    {
        return unitPrice;
    }
    public String setUnitPrice()
    {
        return unitPrice;
    }
    public String getInStock() { return inStock; }
    public String setInStock()
    {
        return inStock;
    }
    public String getCategory() { return category; }
    public String setCateggory()
    {
        return category;
    }
    public String getSupplier() { return supplier; }
    public String setSupllier()
    {
        return supplier;
    }
    public String getBarcode() { return barcode; }
    public String setBarcode()
    {
        return barcode;
    }
}
