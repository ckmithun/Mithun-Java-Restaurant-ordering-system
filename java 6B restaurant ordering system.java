import java.util.Scanner;

// First Interface
interface RestaurantMenu {

    void displayMenu();
}

// Second Interface
interface BillDetails {

    void displayBill();
}

// Class implementing multiple interfaces
class RestaurantOrder implements RestaurantMenu, BillDetails {

    String restaurantName = "Punjab Food Palace";
    String customerName;
    String foodName;
    int quantity;
    double price;
    double total;

    RestaurantOrder(String customerName, String foodName,
                    int quantity, double price) {

        this.customerName = customerName;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
        this.total = quantity * price;
    }

    // Implementation of RestaurantMenu interface
    @Override
    public void displayMenu() {

        System.out.println("\n========== NORTH INDIAN MENU ==========");
        System.out.println("1. Chole Bhature       - Rs.180");
        System.out.println("2. Paneer Butter Masala - Rs.220");
        System.out.println("3. Aloo Paratha        - Rs.120");
        System.out.println("4. Rajma Chawal        - Rs.160");
        System.out.println("=======================================");
    }

    // Implementation of BillDetails interface
    @Override
    public void displayBill() {

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

    // Call by Reference using Object
    static void updateQuantity(RestaurantOrder order, int newQuantity) {

        order.quantity = newQuantity;
        order.total = order.quantity * order.price;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Temporary object for displaying menu
        RestaurantOrder order =
                new RestaurantOrder("Guest", "Chole Bhature", 1, 180);

        // Display menu
        order.displayMenu();

        System.out.print("\nEnter Customer Name: ");
        String customer = sc.nextLine();

        System.out.print("Enter Choice (1-4): ");
        int choice = sc.nextInt();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        String food;
        double price;

        // Select food item
        if (choice == 1) {
            food = "Chole Bhature";
            price = 180;
        }
        else if (choice == 2) {
            food = "Paneer Butter Masala";
            price = 220;
        }
        else if (choice == 3) {
            food = "Aloo Paratha";
            price = 120;
        }
        else if (choice == 4) {
            food = "Rajma Chawal";
            price = 160;
        }
        else {
            System.out.println("Invalid Choice!");
            sc.close();
            return;
        }

        // Create final order object
        order = new RestaurantOrder(
                customer,
                food,
                quantity,
                price
        );

        System.out.println("\nBefore Call by Reference:");
        order.displayBill();

        // Call by Reference
        updateQuantity(order, quantity + 1);

        System.out.println("\nAfter Call by Reference:");
        order.displayBill();

        sc.close();
    }
}