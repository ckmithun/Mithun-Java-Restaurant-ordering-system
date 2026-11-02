import java.util.Scanner;

class Restaurant {
    String customerName;
    String foodName;
    int quantity;
    double price;

    // Default Constructor
    Restaurant() {
        customerName = "Guest";
        foodName = "Burger";
        quantity = 1;
        price = 100;
    }

    // Parameterized Constructor
    Restaurant(String customerName, String foodName, int quantity, double price) {
        this.customerName = customerName;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }

    void displayBill() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Food Name     : " + foodName);
        System.out.println("Quantity      : " + quantity);
        System.out.println("Price         : " + price);
        System.out.println("Total Bill    : " + (quantity * price));
    }
}

public class Experiment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Default Constructor
        Restaurant r1 = new Restaurant();

        System.out.println("Order 1 (Default Constructor)");
        r1.displayBill();

        // User Input
        System.out.println("\nEnter details for Order 2:");

        System.out.print("Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Food Name: ");
        String food = sc.nextLine();

        System.out.print("Quantity: ");
        int qty = sc.nextInt();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        // Parameterized Constructor
        Restaurant r2 = new Restaurant(name, food, qty, price);

        System.out.println("\nOrder 2");
        r2.displayBill();

        sc.close();
    }
}