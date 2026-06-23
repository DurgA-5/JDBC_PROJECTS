import java.sql.*;
public class StudentDAO {
	public void addStudent(Student sd) throws SQLException {
		String sql="insert into Student values(?,?,?,?,?,?)";
		try(Connection con=DBConnector.getconnection();
				PreparedStatement ps=con.prepareStatement(sql)){
			ps.setInt(1,sd.getId());
			ps.setString(2, sd.getName());
			ps.setString(3, sd.getBranch());
			ps.setInt(4,sd.getYear());
			ps.setString(5,sd.getEmail());
			ps.setFloat(6, sd.getCgpa());
			int i=ps.executeUpdate();
			System.out.println(i+ "rows created");
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void viewStudent() throws SQLException {
		Connection con=DBConnector.getconnection();
		String sql="select * from Student";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("id") + " " +
		                rs.getString("name") + " " +
		                rs.getString("email") + " " +
		                rs.getInt("year") + " " +
		                rs.getDouble("cgpa"));
			}
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void updateStudent(Student sd) throws SQLException{
		String sql="update Student set cgpa=? where id=?";
		try(Connection con=DBConnector.getconnection();
				PreparedStatement ps=con.prepareStatement(sql)){
			ps.setFloat(1, sd.getCgpa());
			ps.setInt(2, sd.getId());
			int i=ps.executeUpdate();
			System.out.println(i+" rows updated");
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	public void searchStudent(Student sd) throws SQLException{
		String sql="select * from Student where id=? and name=?";
		try(Connection con=DBConnector.getconnection();
				PreparedStatement ps=con.prepareStatement(sql)){
			
			ps.setInt(1, sd.getId());
			ps.setString(2, sd.getName());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id") + " " +
		                rs.getString("name") + " " +
		                rs.getString("email") + " " +
		                rs.getInt("year") + " " +
		                rs.getDouble("cgpa"));
			}
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void deleteStudent(Student sd) {
		String sql="delete from Student where id=?";
		try(Connection con=DBConnector.getconnection();
				PreparedStatement ps=con.prepareStatement(sql)){
			ps.setInt(1,sd.getId() );
			int rs=ps.executeUpdate();
			System.out.println(rs+" rows deleted");
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void top5Students() {
	    String sql = "SELECT * FROM Student ORDER BY cgpa DESC LIMIT 5";

	    try (Connection con = DBConnector.getconnection();
	         Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery(sql)) {

	        while (rs.next()) {
	            System.out.println(
	                rs.getInt("id") + " " +
	                rs.getString("name") + " " +
	                rs.getString("branch") + " " +
	                rs.getInt("year") + " " +
	                rs.getString("email") + " " +
	                rs.getFloat("cgpa")
	            );
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void branchWiseReport(String branch) {
	    String sql = "SELECT * FROM Student WHERE branch = ?";

	    try (Connection con = DBConnector.getconnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setString(1, branch);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            System.out.println(
	                rs.getInt("id") + " " +
	                rs.getString("name") + " " +
	                rs.getString("branch") + " " +
	                rs.getInt("year") + " " +
	                rs.getString("email") + " " +
	                rs.getFloat("cgpa")
	            );
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
