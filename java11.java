import java.util.Scanner;

// Restaurant class
class Restaurant {

    private String customerName;
    private String foodName;
    private int quantity;
    private double price;

    private final Object orderLock = new Object();
    private final Object billLock = new Object();

    // Place order with synchronization
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

    // Generate bill with synchronization
    void generateBill() {

        synchronized (billLock) {
            synchronized (orderLock) {

                System.out.println("\nBilling thread is processing the order.");

                double total = quantity * price;

                System.out.println("\n========== BILL ==========");
                System.out.println("Customer Name : " + customerName);
                System.out.println("Food Item     : " + foodName);
                System.out.println("Quantity      : " + quantity);
                System.out.println("Price         : Rs." + price);
                System.out.println("Total Bill    : Rs." + total);
                System.out.println("==========================");
            }
        }
    }

    // Demonstrate safe lock acquisition
    void updateOrder() {

        synchronized (billLock) {
            synchronized (orderLock) {
                System.out.println("Order updated safely.");
            }
        }
    }
}

// Thread for placing an order
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
        System.out.println("\nOrder Thread is RUNNING.");

        restaurant.placeOrder(
            customerName, foodName, quantity, price
        );

        System.out.println("Order Thread is COMPLETED.");
    }
}

// Thread for generating the bill
class BillingThread extends Thread {

    private Restaurant restaurant;

    BillingThread(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        System.out.println("\nBilling Thread is RUNNING.");

        restaurant.generateBill();

        System.out.println("Billing Thread is COMPLETED.");
    }
}

// Main class
public class java11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       SOUTH INDIAN PALACE");
        System.out.println(" THREAD LIFECYCLE MANAGEMENT");
        System.out.println("=================================");
        System.out.println("1. Masala Dosa       - Rs.80");
        System.out.println("2. Idli Sambar       - Rs.60");
        System.out.println("3. Vada              - Rs.50");
        System.out.println("4. Pongal            - Rs.70");
        System.out.println("5. Lemon Rice        - Rs.90");
        System.out.println("=================================");

        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Food Name: ");
        String foodName = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Restaurant restaurant = new Restaurant();

        OrderThread orderThread = new OrderThread(
            restaurant, customerName, foodName, quantity, price
        );

        BillingThread billingThread = new BillingThread(restaurant);

        System.out.println("\n========== THREAD LIFECYCLE ==========");

        System.out.println("Order Thread State: " + orderThread.getState());
        System.out.println("Billing Thread State: " + billingThread.getState());

        System.out.println("\nStarting Order Thread...");
        orderThread.start();

        System.out.println("Order Thread State: " + orderThread.getState());

        try {
            orderThread.join();
        } catch (InterruptedException e) {
            System.out.println("Order thread interrupted.");
            Thread.currentThread().interrupt();
            sc.close();
            return;
        }

        System.out.println("Order Thread State: " + orderThread.getState());

        System.out.println("\nStarting Billing Thread...");
        billingThread.start();

        System.out.println("Billing Thread State: " + billingThread.getState());

        try {
            billingThread.join();
        } catch (InterruptedException e) {
            System.out.println("Billing thread interrupted.");
            Thread.currentThread().interrupt();
            sc.close();
            return;
        }

        System.out.println("Billing Thread State: " + billingThread.getState());

        System.out.println("\n========== RESULT ==========");
        System.out.println("Thread lifecycle management demonstrated.");
        System.out.println("Synchronization prevents unsafe concurrent access.");
        System.out.println("Consistent lock ordering prevents circular-wait deadlocks.");
        System.out.println("Thank you for ordering from South Indian Palace!");

        sc.close();
    }
}