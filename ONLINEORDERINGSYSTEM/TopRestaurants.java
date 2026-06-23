import java.sql.*;

public class TopRestaurants {

    public static void showTopRestaurants() {

        String query =
        """
        SELECT r.restaurant_id,
               r.restaurant_name,
               SUM(o.total_amount) revenue
        FROM Restaurants r
        JOIN Orders o
        ON r.restaurant_id=o.restaurant_id
        GROUP BY r.restaurant_id,r.restaurant_name
        ORDER BY revenue DESC
        LIMIT 5
        """;

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(query);

            System.out.println("Top Restaurants");

            while(rs.next()) {

                System.out.println(
                        rs.getInt(1) + " "
                        + rs.getString(2) + " "
                        + rs.getDouble(3));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}