import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();

        System.out.print("Email:" );
        String email = sc.next();

        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Birth Date: ");
        Date clientBirth = simple.parse(sc.next());

        System.out.println("Enter order Data: ");
        System.out.print("Status: ");
        String status = sc.next();

        System.out.print("How many items to this order? ");
        int numberOfItens = sc.nextInt();

        Order jose = new Order(new Client(clientName, email, clientBirth), new Date(), OrderStatus.valueOf(status));

        for (int i = 1; i <= numberOfItens ; i++) {

            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.next();

            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();

            jose.addItem(new OrderItem(productQuantity, new Product(productName, productPrice)));
        }

        System.out.println(jose.toStringBuilder());

        sc.close();

    }
}