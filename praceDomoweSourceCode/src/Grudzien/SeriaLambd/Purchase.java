package Grudzien.SeriaLambd;


import java.time.LocalDate;


public class Purchase {             // klasa reprezentuje zakup
    private Product product;        // produkt zakupiony
    private LocalDate purchaseDate; // data dokonania zakupu
    private double quantity;        // zakupiona ilość produktu
    private UNIT unit;              // jednostka zakupu (np. w gramach)

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public UNIT getUnit() {
        return unit;
    }
    public void setUnit(UNIT unit) {
        this.unit = unit;
    }

    public Purchase(Product product, LocalDate purchaseDate, double quantity, UNIT unit) {
        this.product = product;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.unit = unit;
    }


}
