import java.util.Scanner;

public class FoodDeliveryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerDAO customerDAO =
                new CustomerDAO();

        OrderDAO orderDAO =
                new OrderDAO();

        while(true) {

            System.out.println("\n===== FOOD DELIVERY SYSTEM =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Place Order");
            System.out.println("3. Top Restaurants");
            System.out.println("4. Top Customers");
            System.out.println("5. Daily Report");
            System.out.println("6. Monthly Report");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("ID : ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Name : ");
                    String name = sc.nextLine();

                    System.out.print("Phone : ");
                    String phone = sc.nextLine();

                    System.out.print("Address : ");
                    String address = sc.nextLine();

                    customerDAO.addCustomer(
                            new Customer(
                                    id,
                                    name,
                                    phone,
                                    address));

                    break;

                case 2:

                    System.out.print("Order ID : ");
                    int oid = sc.nextInt();

                    System.out.print("Customer ID : ");
                    int cid = sc.nextInt();

                    System.out.print("Restaurant ID : ");
                    int rid = sc.nextInt();

                    System.out.print("Agent ID : ");
                    int aid = sc.nextInt();

                    System.out.print("Amount : ");
                    double amount = sc.nextDouble();

                    orderDAO.placeOrder(
                            oid,cid,rid,aid,amount);

                    break;

                case 3:
                    TopRestaurants.showTopRestaurants();
                    break;

                case 4:
                    TopCustomers.showTopCustomers();
                    break;

                case 5:
                    DailyReport.generateReport();
                    break;

                case 6:
                    MonthlyReport.generateMonthlyReport();
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}