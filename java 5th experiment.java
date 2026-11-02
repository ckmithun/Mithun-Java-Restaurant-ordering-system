import java.util.Scanner;

// Parent Class
class Restaurant {

    String restaurantName = "Food Palace";

    void displayMenu() {
        System.out.println("\n========== FRENCH BREAKFAST MENU ==========");
        System.out.println("1. French Toast       - Rs.160");
        System.out.println("2. Hot Chocolate      - Rs.140");
        System.out.println("3. Japanese Cake      - Rs.180");
        System.out.println("4. Classic Hot Coffee - Rs.100");
        System.out.println("===========================================");
    }

    // Method to be overridden
    void displayBill() {
        System.out.println("Restaurant: " + restaurantName);
    }
}

// Intermediate Class
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
    }

    void calculateBill() {
        total = quantity * price;
    }

    // Method Overriding
    @Override
    void displayBill() {
        System.out.println("\n========== ORDER ==========");
        System.out.println("Customer : " + customerName);
        System.out.println("Food     : " + foodName);
        System.out.println("Quantity : " + quantity);
        System.out.println("===========================");
    }
}

// Child Class
class Bill extends Order {

    Bill(String customerName, String foodName, int quantity, double price) {
        super(customerName, foodName, quantity, price);
    }

    // Method Overriding
    @Override
    void displayBill() {
        System.out.println("\n========== FINAL BILL ==========");
        System.out.println("Restaurant : " + restaurantName);
        System.out.println("Customer   : " + customerName);
        System.out.println("Food Item  : " + foodName);
        System.out.println("Quantity   : " + quantity);
        System.out.println("Price      : Rs." + price);
        System.out.println("--------------------------------");
        System.out.println("Total Bill : Rs." + total);
        System.out.println("================================");
        System.out.println("Thank You! Visit Again.");
    }
}

// Main Class
public class RestaurantOrderingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Restaurant object
        Restaurant menu = new Restaurant();

        // Display Menu
        menu.displayMenu();

        // Get customer name
        System.out.print("\nEnter Customer Name: ");
        String customer = sc.nextLine();

        // Get food choice
        System.out.print("Enter Choice (1-4): ");
        int choice = sc.nextInt();

        // Get quantity
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        String food;
        double price;

        // Select food
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

        // Create Bill object
        Bill obj = new Bill(customer, food, quantity, price);

        // Calculate total
        obj.calculateBill();

        // Calls overridden method
        obj.displayBill();

        sc.close();
    }
}