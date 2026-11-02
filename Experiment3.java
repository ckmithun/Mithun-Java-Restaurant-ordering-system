import java.util.Scanner;

public class Experiment3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   RESTAURANT ORDERING SYSTEM");
        System.out.println("=================================");

        // Taking customer details
        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Food Item: ");
        String foodItem = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price per Item: ");
        double price = sc.nextDouble();

        // Bill Calculation
        double totalBill = quantity * price;

        // Display Bill
        System.out.println("\n========== BILL ==========");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Food Item     : " + foodItem);
        System.out.println("Quantity      : " + quantity);
        System.out.println("Price         : " + price);
        System.out.println("--------------------------");
        System.out.println("Total Bill    : " + totalBill);
        System.out.println("==========================");

        sc.close();
    }
}
