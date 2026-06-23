package com.ecommerce;

import java.sql.*;

public class AnalyticsDAO {

    public void topCustomers() {

        String sql =
        "SELECT c.name, SUM(o.total_amount) total " +
        "FROM Customers c " +
        "JOIN Orders o ON c.customer_id=o.customer_id " +
        "GROUP BY c.customer_id " +
        "ORDER BY total DESC LIMIT 5";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            System.out.println("\nTop Customers");

            while(rs.next()) {

                System.out.println(
                        rs.getString("name")
                        + " -> ₹"
                        + rs.getDouble("total"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void bestSellingProducts() {

        String sql =
        "SELECT p.product_name, SUM(oi.quantity) qty " +
        "FROM Products p " +
        "JOIN Order_Items oi " +
        "ON p.product_id=oi.product_id " +
        "GROUP BY p.product_id " +
        "ORDER BY qty DESC LIMIT 5";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            System.out.println("\nBest Selling Products");

            while(rs.next()) {

                System.out.println(
                        rs.getString("product_name")
                        + " -> "
                        + rs.getInt("qty"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void monthlySalesReport() {

        String sql =
        "SELECT MONTH(order_date) month, " +
        "SUM(total_amount) sales " +
        "FROM Orders " +
        "GROUP BY MONTH(order_date)";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            System.out.println("\nMonthly Sales");

            while(rs.next()) {

                System.out.println(
                        "Month "
                        + rs.getInt("month")
                        + " = ₹"
                        + rs.getDouble("sales"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
