import java.sql.*;

public class CustomerDAO {

    public void addCustomer(Customer c) {

        String sql =
        "INSERT INTO Customers VALUES(?,?,?,?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getPhone());
            ps.setString(4, c.getAddress());

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Customer Added");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}