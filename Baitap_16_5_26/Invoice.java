package Baitap_16_5_26;
public class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    // Constructor
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    // --- Getters và Setters ---
    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        // Nếu số lượng không dương, đặt thành 0
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        // Nếu giá không dương, đặt thành 0.0
        if (pricePerItem > 0.0) {
            this.pricePerItem = pricePerItem;
        } else {
            this.pricePerItem = 0.0;
        }
    }

    // --- Phương thức tính tiền ---
    public double getInvoiceAmount() {
        return this.quantity * this.pricePerItem;
    }

    // Phương thức toString để in thông tin cho đẹp
    @Override
    public String toString() {
        return String.format("Mã MH: %-6s | Mô tả: %-25s | Số lượng: %-4d | Đơn giá: %-12.2f | Thành tiền: %.2f", 
                             partNumber, partDescription, quantity, pricePerItem, getInvoiceAmount());
    }
}