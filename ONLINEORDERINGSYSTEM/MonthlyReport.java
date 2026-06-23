import java.sql.*;

public class MonthlyReport {

    public static void generateMonthlyReport() {

        String query =
        """
        SELECT MONTH(order_date),
               SUM(total_amount)
        FROM Orders
        GROUP BY MONTH(order_date)
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
                        "Month : "
                        + rs.getInt(1)
                        + " Revenue : "
                        + rs.getDouble(2));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}