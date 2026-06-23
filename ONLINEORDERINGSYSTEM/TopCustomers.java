import java.sql.*;

public class TopCustomers {

    public static void showTopCustomers() {

        String query =
        """
        SELECT c.customer_id,
               c.customer_name,
               COUNT(o.order_id) total_orders
        FROM Customers c
        JOIN Orders o
        ON c.customer_id=o.customer_id
        GROUP BY c.customer_id,c.customer_name
        ORDER BY total_orders DESC
        LIMIT 5
        """;

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(query);

            while(rs.next()) {

                System.out.println(
                        rs.getInt(1) + " "
                        + rs.getString(2) + " "
                        + rs.getInt(3));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}