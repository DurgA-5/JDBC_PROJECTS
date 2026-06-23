import java.sql.*;

public class DailyReport {

    public static void generateReport() {

        String query =
        """
        SELECT order_date,
               COUNT(*) total_orders,
               SUM(total_amount) revenue
        FROM Orders
        GROUP BY order_date
        ORDER BY order_date
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
                        rs.getDate(1)
                        + " Orders: "
                        + rs.getInt(2)
                        + " Revenue: "
                        + rs.getDouble(3));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}