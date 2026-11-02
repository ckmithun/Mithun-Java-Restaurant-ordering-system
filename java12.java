
import java.util.*;

class Restaurant {

    private String customerName;
    private List<String> foodList;
    private Set<String> uniqueFoods;
    private Map<String, Double> menu;
    private Queue<String> orderQueue;

    Restaurant() {
        foodList = new ArrayList<>();
        uniqueFoods = new LinkedHashSet<>();
        menu = new LinkedHashMap<>();
        orderQueue = new LinkedList<>();

        menu.put("Masala Dosa", 80.0);
        menu.put("Idli Sambar", 60.0);
        menu.put("Vada", 50.0);
        menu.put("Pongal", 70.0);
        menu.put("Lemon Rice", 90.0);
    }

    void displayMenu() {
        System.out.println("\n========== SOUTH INDIAN PALACE ==========");
        System.out.println("MENU");
        for (Map.Entry<String, Double> item : menu.entrySet()) {
            System.out.println(item.getKey() + " - Rs." + item.getValue());
        }
    }

    void placeOrder(String customerName, Scanner sc) {
        this.customerName = customerName;

        System.out.print("Enter number of food items to order: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Enter food item " + (i + 1) + ": ");
            String food = sc.nextLine().trim();

            String matchedFood = null;
            for (String item : menu.keySet()) {
                if (item.equalsIgnoreCase(food)) {
                    matchedFood = item;
                    break;
                }
            }

            if (matchedFood != null) {
                foodList.add(matchedFood);
                uniqueFoods.add(matchedFood);
                orderQueue.offer(matchedFood);
                System.out.println(matchedFood + " added to order.");
            } else {
                System.out.println("Food item not found in menu.");
            }
        }
    }

    void displayCollections() {
        System.out.println("\n========== COLLECTION DETAILS ==========");

        System.out.println("\n1. LIST - Ordered food items:");
        System.out.println(foodList);

        System.out.println("\n2. SET - Unique food items:");
        System.out.println(uniqueFoods);

        System.out.println("\n3. MAP - Menu and prices:");
        for (Map.Entry<String, Double> item : menu.entrySet()) {
            System.out.println(item.getKey() + " : Rs." + item.getValue());
        }

        System.out.println("\n4. QUEUE - Orders in processing order:");
        System.out.println(orderQueue);
    }

    void generateBill() {
        double total = 0;

        System.out.println("\n========== CUSTOMER BILL ==========");
        System.out.println("Customer Name: " + customerName);

        for (String food : foodList) {
            double price = menu.get(food);
            System.out.println(food + " - Rs." + price);
            total += price;
        }

        System.out.println("-----------------------------------");
        System.out.println("Total Bill: Rs." + total);
        System.out.println("===================================");
    }

    void processQueue() {
        System.out.println("\n========== PROCESSING ORDERS ==========");

        while (!orderQueue.isEmpty()) {
            System.out.println("Processing: " + orderQueue.poll());
        }

        System.out.println("All orders processed.");
    }
}

public class java12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        System.out.println("========================================");
        System.out.println("       SOUTH INDIAN PALACE");
        System.out.println(" GENERIC COLLECTION-BASED APPLICATION");
        System.out.println("========================================");

        restaurant.displayMenu();

        System.out.print("\nEnter Customer Name: ");
        String customerName = sc.nextLine();

        restaurant.placeOrder(customerName, sc);
        restaurant.displayCollections();
        restaurant.generateBill();
        restaurant.processQueue();

        System.out.println("\nThank you for ordering from South Indian Palace!");

        sc.close();
    }
}
