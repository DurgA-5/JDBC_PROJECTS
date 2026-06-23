package com.ecommerce;

public class Main {

    public static void main(String[] args) {

        AnalyticsDAO dao =
                new AnalyticsDAO();

        dao.topCustomers();

        dao.bestSellingProducts();

        dao.monthlySalesReport();
    }
}
