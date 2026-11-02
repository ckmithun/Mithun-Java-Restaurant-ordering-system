import java.util.Scanner;

// Restaurant class
class Restaurant {

    private String customerName;
    private String foodName;
    private int quantity;
    private double price;

    // Two locks for synchronization
    private final Object orderLock = new Object();
    private final Object billLock = new Object();

    // Place order
    void placeOrder(String customerName, String foodName,
                    int quantity, double price) {

        synchronized (orderLock) {

            this.customerName = customerName;
            this.foodName = foodName;
            this.quantity = quantity;
            this.price = price;

            System.out.println("\nOrder placed successfully!");
            System.out.println("Customer : " + customerName);
            System.out.println("Food     : " + foodName);
            System.out.println("Quantity : " + quantity);
        }
    }

    // Generate bill
    void generateBill() {

        synchronized (billLock) {

            synchronized (orderLock) {

                System.out.println("\nOrder received by billing thread.");

                double total = quantity * price;

                System.out.println("\n========== BILL ==========");
                System.out.println("Customer Name : " + customerName);
                System.out.println("Food Item     : " + foodName);
                System.out.println("Quantity      : " + quantity);
                System.out.println("Price         : ₹" + price);
                System.out.println("Total Bill    : ₹" + total);
                System.out.println("==========================");
            }
        }
    }

    // Demonstrates safe synchronized access
    void updateOrder() {

        synchronized (billLock) {

            synchronized (orderLock) {

                System.out.println(
                    "\nOrder updated safely without deadlock."
                );
            }
        }
    }
}

// Thread for placing order
class OrderThread extends Thread {

    private Restaurant restaurant;
    private String customerName;
    private String foodName;
    private int quantity;
    private double price;

    OrderThread(Restaurant restaurant, String customerName,
                String foodName, int quantity, double price) {

        this.restaurant = restaurant;
        this.customerName = customerName;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }

    public void run() {

        restaurant.placeOrder(
            customerName,
            foodName,
            quantity,
            price
        );
    }
}

// Thread for generating bill
class BillingThread extends Thread {

    private Restaurant restaurant;

    BillingThread(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        restaurant.generateBill();
    }
}

// Main class
public class java10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       SOUTH INDIAN PALACE");
        System.out.println("=================================");
        System.out.println("1. Masala Dosa       - ₹80");
        System.out.println("2. Idli Sambar       - ₹60");
        System.out.println("3. Vada              - ₹50");
        System.out.println("4. Pongal            - ₹70");
        System.out.println("5. Lemon Rice        - ₹90");
        System.out.println("=================================");

        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Food Name: ");
        String foodName = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        // Create Restaurant object
        Restaurant restaurant = new Restaurant();

        // Create threads
        OrderThread orderThread = new OrderThread(
            restaurant,
            customerName,
            foodName,
            quantity,
            price
        );

        BillingThread billingThread = new BillingThread(restaurant);

        System.out.println("\nStarting threads...");
        System.out.println("Synchronization is used to prevent deadlock.");

        // Start order thread first
        orderThread.start();

        try {
            // Ensure order is placed before billing
            orderThread.join();
        } catch (InterruptedException e) {
            System.out.println("Order thread interrupted.");
        }

        // Start billing thread
        billingThread.start();

        try {
            billingThread.join();
        } catch (InterruptedException e) {
            System.out.println("Billing thread interrupted.");
        }

        System.out.println(
            "\nDeadlock prevented successfully using thread synchronization."
        );

        System.out.println(
            "Thank you for ordering from South Indian Palace!"
        );

        sc.close();
    }
}