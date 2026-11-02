import java.util.Scanner;

class Restaurant {

    // Static Variable
    static String restaurantName = "Food Palace";

    String customerName;
    String foodName;
    int quantity;
    double price;

    // Constructor
    Restaurant(String customerName, String foodName, int quantity, double price) {
        this.customerName = customerName;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }

    // Method Overloading - Bill without discount
    void calculateBill() {
        double total = quantity * price;

        System.out.println("\n--------- BILL ---------");
        System.out.println("Restaurant : " + restaurantName);
        System.out.println("Customer   : " + customerName);
        System.out.println("Food Item  : " + foodName);
        System.out.println("Quantity   : " + quantity);
        System.out.println("Price      : " + price);
        System.out.println("Total Bill : " + total);
    }

    // Method Overloading - Bill with discount
    void calculateBill(double discount) {
        double total = quantity * price;
        double finalBill = total - discount;

        System.out.println("\n--------- BILL ---------");
        System.out.println("Restaurant : " + restaurantName);
        System.out.println("Customer   : " + customerName);
        System.out.println("Food Item  : " + foodName);
        System.out.println("Quantity   : " + quantity);
        System.out.println("Price      : " + price);
        System.out.println("Total Bill : " + total);
        System.out.println("Discount   : " + discount);
        System.out.println("Final Bill : " + finalBill);
    }

    // Static Method
    static void welcomeMessage() {
        System.out.println("==================================");
        System.out.println(" Welcome to " + restaurantName);
        System.out.println(" Restaurant Ordering System");
        System.out.println("==================================");
    }
}

public class Experiment2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Calling Static Method
        Restaurant.welcomeMessage();

        System.out.print("Enter Customer Name : ");
        String customer = sc.nextLine();

        System.out.print("Enter Food Name : ");
        String food = sc.nextLine();

        System.out.print("Enter Quantity : ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price : ");
        double price = sc.nextDouble();

        Restaurant order = new Restaurant(customer, food, quantity, price);

        System.out.print("Do you want to give discount? (yes=1 / no=0): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter Discount Amount : ");
            double discount = sc.nextDouble();

            // Overloaded Method
            order.calculateBill(discount);
        } else {

            // Overloaded Method
            order.calculateBill();
        }

        sc.close();
    }
}

