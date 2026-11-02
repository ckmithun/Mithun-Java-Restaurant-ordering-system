import java.util.Scanner;

// Parent Class
class Restaurant {
    String restaurantName = "Food Palace";

    void displayMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Burger  - ₹120");
        System.out.println("2. Pizza   - ₹250");
        System.out.println("3. Pasta   - ₹180");
        System.out.println("4. Coffee  - ₹80");
        System.out.println("==========================");
    }
}

// Child Class (Single Inheritance)
class Order extends Restaurant {
    String customerName;
    String foodName;
    int quantity;
    double price;
    double total;

    // Constructor
    Order(String customerName, String foodName, int quantity, double price) {
        this.customerName = customerName;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }

    void calculateBill() {
        total = quantity * price;
    }

    void displayBill() {
        System.out.println("\n========== BILL ==========");
        System.out.println("Restaurant : " + restaurantName);
        System.out.println("Customer   : " + customerName);
        System.out.println("Food Item  : " + foodName);
        System.out.println("Quantity   : " + quantity);
        System.out.println("Price      : ₹" + price);
        System.out.println("--------------------------");
        System.out.println("Total Bill : ₹" + total);
        System.out.println("==========================");
        System.out.println("Thank You! Visit Again.");
    }
}

// Main Class
public class RestaurantOrderingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Restaurant menu = new Restaurant();
        menu.displayMenu();

        System.out.print("\nEnter Customer Name: ");
        String customer = sc.nextLine();

        System.out.print("Enter Choice (1-4): ");
        int choice = sc.nextInt();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        String food = "";
        double price = 0;

        // Condition Statement (if-else)
        if (choice == 1) {
            food = "Burger";
            price = 120;
        }
        else if (choice == 2) {
            food = "Pizza";
            price = 250;
        }
        else if (choice == 3) {
            food = "Pasta";
            price = 180;
        }
        else if (choice == 4) {
            food = "Coffee";
            price = 80;
        }
        else {
            System.out.println("Invalid Choice!");
            sc.close();
            return;
        }

        // Create Object
        Order obj = new Order(customer, food, quantity, price);

        // Calculate and Display Bill
        obj.calculateBill();
        obj.displayBill();

        sc.close();
    }
}
