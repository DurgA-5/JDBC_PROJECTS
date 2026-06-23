
import java.util.Scanner;

public class EcommerceApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerDAO customerDAO =
                new CustomerDAO();

        ProductDAO productDAO =
                new ProductDAO();

        while(true) {

            System.out.println("\n===== ECOMMERCE SYSTEM =====");
            System.out.println("1.Add Customer");
            System.out.println("2.View Customers");
            System.out.println("3.Add Product");
            System.out.println("4.View Products");
            System.out.println("5.Top Customers");
            System.out.println("6.Top Products");
            System.out.println("7.Monthly Report");
            System.out.println("8.Exit");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("ID: ");
                    int cid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Name: ");
                    String cname = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    customerDAO.addCustomer(
                            new Customer(
                                    cid,
                                    cname,
                                    email));

                    break;

                case 2:
                    customerDAO.displayCustomers();
                    break;

                case 3:

                    System.out.print("Product ID: ");
                    int pid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Product Name: ");
                    String pname = sc	.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    productDAO.addProduct(
                            new Product(
                                    pid,
                                    pname,
                                    price));

                    break;

                case 4:
                    productDAO.viewProducts();
                    break;

                case 5:
                    TopCustomersReport.showReport();
                    break;

                case 6:
                    TopProductsReport.showReport();
                    break;

                case 7:
                    MonthlySalesReport.generate();
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}