import java.sql.*;

public class OrderDAO {

    public void placeOrder(
            int orderId,
            int customerId,
            int restaurantId,
            int agentId,
            double amount) {

        String sql =
        "INSERT INTO Orders VALUES(?,?,?,?,NOW(),?,?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, orderId);
            ps.setInt(2, customerId);
            ps.setInt(3, restaurantId);
            ps.setInt(4, agentId);
            ps.setDouble(5, amount);
            ps.setString(6, "Delivered");

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Order Placed");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}