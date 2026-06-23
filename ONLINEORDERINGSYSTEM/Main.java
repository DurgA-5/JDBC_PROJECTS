package com.fooddelivery;

public class Main {

    public static void main(String[] args) {

        FoodDeliveryDAO dao =
                new FoodDeliveryDAO();

        dao.topRestaurants();

        dao.topCustomers();

        dao.monthlyReport();
    }
}
