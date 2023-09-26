import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
   private Client client;
   private Date moment = new Date();
   static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
   private List<OrderItem> itensList = new ArrayList<>();
   private OrderStatus status;
   private double billOrder;
   public Order(){ };
    public Order(Client cliente, Date moment, OrderStatus status) {
        this.client = cliente;
        this.moment = moment;
        this.status = status;
        this.billOrder = this.totalBill();
    }

    public void addItem(OrderItem item){
        itensList.add(item);
    }

    public void removeItem(OrderItem item){
        itensList.remove(item);
    }

    public double totalBill( ){
        double sum = 0;
        for (OrderItem item: itensList) {
            sum += item.getPriceTotal();
        }
        return sum;
    }

    public List<OrderItem> getItensList() {
        return itensList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public StringBuilder toStringBuilder() {

        StringBuilder bigString = new StringBuilder("ORDER SUMMARY" + "\n");
        bigString.append("Order moment: " + sdf.format(this.getMoment()) + "\n");
        bigString.append("Order Status: " + this.getStatus() + "\n");

        SimpleDateFormat birthFormat = new SimpleDateFormat("dd/MM/yyyy");

        bigString.append("Cliente: " + this.getClient().getName() + "(" + birthFormat.format(this.getClient().getBirthDate())  +")" );
        bigString.append(" - " + this.getClient().getEmail() + "\n");
        bigString.append("Order items: " + "\n");

        for (OrderItem item: itensList) {
            bigString.append(item.getProduct().getName() + ", ");
            bigString.append(item.getProduct().getPrice() + ", ");
            bigString.append("Quantity: " + item.getQuantity() + ", ");
            bigString.append("Subtotal: " + item.getPriceTotal() + "\n");
        }

        bigString.append("Total price: $" + this.totalBill());

        return bigString;
    }
}
