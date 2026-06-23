
import java.sql.*;

public class TopProductsReport {

    public static void showReport() {

        String query =
                """
                SELECT p.product_id,
                       p.product_name,
                       SUM(oi.quantity) total_sales
                FROM Products p
                JOIN Order_Items oi
                ON p.product_id=oi.product_id
                GROUP BY p.product_id,p.product_name
                ORDER BY total_sales DESC
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
                        rs.getInt(1)+" "
                                +rs.getString(2)+" "
                                +rs.getInt(3));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}