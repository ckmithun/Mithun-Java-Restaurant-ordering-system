import java.util.Scanner;

// Parent Class
class Restaurant {
    String restaurantName = "Food Palace";

    void displayRestaurant() {
        System.out.println("=================================");
        System.out.println("      " + restaurantName);
        System.out.println("=================================");
    }
}

// Child Class (Level 1)
class Menu extends Restaurant {
    String foodName;
    double price;

    void selectFood(int choice) {
        switch (choice) {
            case 1:
                foodName = "Burger";
                price = 120;
                break;
            case 2:
                foodName = "Pizza";
                price = 250;
                break;
            case 3:
                foodName = "Fried Rice";
                price = 180;
                break;
            case 4:
                foodName = "Pasta";
                price = 200;
                break;
            default:
                System.out.println("Invalid Choice!");
                foodName = "None";
                price = 0;
        }
    }

    void displayMenu() {
        System.out.println("\n--------- MENU ---------");
        System.out.println("1. Burger      - ₹120");
        System.out.println("2. Pizza       - ₹250");
        System.out.println("3. Fried Rice  - ₹180");
        System.out.println("4. Pasta       - ₹200");
    }
}

// Child Class (Level 2)
class Billing extends Menu {
    String customerName;
    int quantity;
    double total;

    void getOrder() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Customer Name: ");
        customerName = sc.nextLine();

        displayMenu();

        System.out.print("Enter Food Choice: ");
        int choice = sc.nextInt();

        selectFood(choice);

        System.out.print("Enter Quantity: ");
        quantity = sc.nextInt();

        total = quantity * price;
    }

    void displayBill() {
        System.out.println("\n========== BILL ==========");
        System.out.println("Restaurant : " + restaurantName);
        System.out.println("Customer   : " + customerName);
        System.out.println("Food Item  : " + foodName);
        System.out.println("Price      : ₹" + price);
        System.out.println("Quantity   : " + quantity);
        System.out.println("---------------------------");
        System.out.println("Total Bill : ₹" + total);
        System.out.println("==========================");
        System.out.println("Thank You! Visit Again.");
    }
}

// Main Class
public class RestaurantOrderingSystem {
    public static void main(String[] args) {

        Billing obj = new Billing();

        obj.displayRestaurant();
        obj.getOrder();
        obj.displayBill();
    }
}