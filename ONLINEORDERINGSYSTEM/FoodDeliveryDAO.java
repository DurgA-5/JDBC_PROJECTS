package com.fooddelivery;

import java.sql.*;

public class FoodDeliveryDAO {

    public void topRestaurants() {

        String sql =
        "SELECT r.restaurant_name, " +
        "SUM(o.total_amount) revenue " +
        "FROM Restaurants r " +
        "JOIN Orders o " +
        "ON r.restaurant_id=o.restaurant_id " +
        "GROUP BY r.restaurant_id " +
        "ORDER BY revenue DESC LIMIT 5";

        try(Connection con=
            DBConnection.getConnection();

            PreparedStatement ps=
            con.prepareStatement(sql);

            ResultSet rs=
            ps.executeQuery()) {

            System.out.println("\nTop Restaurants");

            while(rs.next()) {

                System.out.println(
                rs.getString("restaurant_name")
                + " -> ₹"
                + rs.getDouble("revenue"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void topCustomers() {

        String sql =
        "SELECT c.customer_name, " +
        "COUNT(o.order_id) total_orders " +
        "FROM Customers c " +
        "JOIN Orders o " +
        "ON c.customer_id=o.customer_id " +
        "GROUP BY c.customer_id " +
        "ORDER BY total_orders DESC LIMIT 5";

        try(Connection con=
            DBConnection.getConnection();

            PreparedStatement ps=
            con.prepareStatement(sql);

            ResultSet rs=
            ps.executeQuery()) {

            System.out.println("\nTop Customers");

            while(rs.next()) {

                System.out.println(
                rs.getString("customer_name")
                + " -> "
                + rs.getInt("total_orders")
                + " Orders");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void monthlyReport() {

        String sql =
        "SELECT MONTH(order_date) month, " +
        "SUM(total_amount) sales " +
        "FROM Orders " +
        "GROUP BY MONTH(order_date)";

        try(Connection con=
            DBConnection.getConnection();

            PreparedStatement ps=
            con.prepareStatement(sql);

            ResultSet rs=
            ps.executeQuery()) {

            System.out.println("\nMonthly Report");

            while(rs.next()) {

                System.out.println(
                "Month "
                + rs.getInt("month")
                + " -> ₹"
                + rs.getDouble("sales"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
