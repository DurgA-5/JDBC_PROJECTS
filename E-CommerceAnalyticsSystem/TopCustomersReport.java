

public class TopCustomersReport {

    public static void showReport() {

        String query =
                """
                SELECT c.customer_id,
                       c.name,
                       SUM(o.total_amount) total
                FROM Customers c
                JOIN Orders o
                ON c.customer_id=o.customer_id
                GROUP BY c.customer_id,c.name
                ORDER BY total DESC
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
                                +rs.getDouble(3));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}