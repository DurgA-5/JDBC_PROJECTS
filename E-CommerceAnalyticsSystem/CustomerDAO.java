

import java.sql.*;

public class CustomerDAO {

    public void addCustomer(Customer c) {

        String query =
                "INSERT INTO Customers VALUES(?,?,?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, c.getCustomerId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getEmail());

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Customer Added");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void displayCustomers() {

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM Customers");

            while(rs.next()) {

                System.out.println(
                        rs.getInt(1) + " "
                                + rs.getString(2) + " "
                                + rs.getString(3));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}