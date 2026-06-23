
import java.sql.*;

public class ProductDAO {

    public void addProduct(Product p) {

        String query =
                "INSERT INTO Products VALUES(?,?,?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1,p.getProductId());
            ps.setString(2,p.getProductName());
            ps.setDouble(3,p.getPrice());

            ps.executeUpdate();

            System.out.println("Product Added");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void viewProducts() {

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM Products");

            while(rs.next()) {

                System.out.println(
                        rs.getInt(1)+" "
                                +rs.getString(2)+" "
                                +rs.getDouble(3));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}