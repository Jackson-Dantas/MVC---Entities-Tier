public class OrderItem {
    private int quantity;
    private double priceTotal;
    private Product product;

    public OrderItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        this.priceTotal = this.subTotal();
    }

    private double subTotal( ){
        return this.quantity * product.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
