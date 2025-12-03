package java_backend;

public class Order {
    private int id;
    private String productName;
    private int quantity;

    public Order(int id, String productName, int quantity) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
}
