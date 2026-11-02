import java.util.Scanner;

// Abstract Class
abstract class Restaurant {

    String restaurantName = "Food Palace";

    // Abstract method
    abstract void displayBill();

    // Normal method
    void displayMenu() {
        System.out.println("\n========== BREAKFAST MENU ==========");
        System.out.println("1. French Toast       - Rs.160");
        System.out.println("2. Hot Chocolate      - Rs.140");
        System.out.println("3. Japanese Cake      - Rs.180");
        System.out.println("4. Classic Hot Coffee - Rs.100");
        System.out.println("====================================");
    }
}

// Order Class
class Order extends Restaurant {

    String customerName;
    String foodName;
    int quantity;
    double price;
    double total;

    Order(String customerName, String foodName, int quantity, double price) {
        this.customerName = customerName;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
        this.total = quantity * price;
    }

    // Implementation of abstract method
    @Override
    void displayBill() {
        System.out.println("\n========== BILL ==========");
        System.out.println("Restaurant : " + restaurantName);
        System.out.println("Customer   : " + customerName);
        System.out.println("Food Item  : " + foodName);
        System.out.println("Quantity   : " + quantity);
        System.out.println("Price      : Rs." + price);
        System.out.println("--------------------------");
        System.out.println("Total Bill : Rs." + total);
        System.out.println("==========================");
    }
}

// Main Class
public class RestaurantOrderingSystem {

    // Call by Reference using Object
    static void updateQuantity(Order order, int newQuantity) {
        order.quantity = newQuantity;
        order.total = order.quantity * order.price;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Abstract class reference
        Restaurant restaurant;

        restaurant = new Order(
                "Mithun",
                "French Toast",
                2,
                160
        );

        // Display menu
        restaurant.displayMenu();

        System.out.print("\nEnter Customer Name: ");
        String customer = sc.nextLine();

        System.out.print("Enter Choice (1-4): ");
        int choice = sc.nextInt();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        String food;
        double price;

        if (choice == 1) {
            food = "French Toast";
            price = 160;
        }
        else if (choice == 2) {
            food = "Hot Chocolate";
            price = 140;
        }
        else if (choice == 3) {
            food = "Japanese Cake";
            price = 180;
        }
        else if (choice == 4) {
            food = "Classic Hot Coffee";
            price = 100;
        }
        else {
            System.out.println("Invalid Choice!");
            sc.close();
            return;
        }

        // Create Order object
        Order order = new Order(customer, food, quantity, price);

        System.out.println("\nBefore Call by Reference:");
        order.displayBill();

        // Passing object reference to method
        updateQuantity(order, quantity + 1);

        System.out.println("\nAfter Call by Reference:");
        order.displayBill();

        sc.close();
    }
}