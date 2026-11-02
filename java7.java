import java.util.Scanner;

// User-Defined Exception
class InvalidQuantityException extends Exception {

    InvalidQuantityException(String message) {
        super(message);
    }
}

// Restaurant Class
class Restaurant {

    String customerName;
    String foodName;
    int quantity;
    double price;

    Restaurant(String customerName, String foodName,
               int quantity, double price) {

        this.customerName = customerName;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }

    void checkQuantity() throws InvalidQuantityException {

        if (quantity <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than 0!"
            );
        }
    }

    void displayBill() {

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

// Main Class
public class java7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

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

            Restaurant order = new Restaurant(
                customerName,
                foodName,
                quantity,
                price
            );

            order.checkQuantity();

            order.displayBill();

        }
        catch (InvalidQuantityException e) {

            System.out.println("\nException: " + e.getMessage());

        }
        catch (Exception e) {

            System.out.println("\nInvalid input!");
            System.out.println("Please enter valid data.");

        }
        finally {

            System.out.println(
                "\nThank you for ordering from South Indian Palace!"
            );

            sc.close();
        }
    }
}