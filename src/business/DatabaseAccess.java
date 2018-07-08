package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;

	// Database Setup
	public void setup() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "vivek",
					"multivision");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Create PassUser table.. first time user
	public void createPassUser() {
		try {
			stmt = con.createStatement();
			String createSQL = "create table PassUser(User_ID int, FirstName VARCHAR2(50), LastName VARCHAR2(50), Username VARCHAR2(20), Password VARCHAR(20), Email VARCHAR2(50), SSN int, PRIMARY KEY(User_ID))";
			stmt.executeUpdate(createSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Create PassInfo table.. info
	public void createPassInfo() {
		try {
			stmt = con.createStatement();
			String createSQL = "create table PassInfo(Info_ID int, Title VARCHAR2(50), URL VARCHAR2(50), Username VARCHAR2(20), Password VARCHAR(20), Category VARCHAR2(50), ID int, PRIMARY KEY(Info_ID), FOREIGN KEY(ID) references PassUser(User_ID))";
			stmt.executeUpdate(createSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert Data into PassUser
	public void insertPassUser(int User_ID, String firstName, String lastName,
			String username, String password, String email, String ssn) {
		try {
			String insertSQL = "insert into PassUser values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setInt(1, User_ID);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, username);
			pstmt.setString(5, password);
			pstmt.setString(6, email);
			pstmt.setString(7, ssn);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Select data from PassUser to add rows
	public PassUser selectPassUser() {
		PassUser pu = new PassUser();
		int totalRows = 0;
		try {
			stmt = con.createStatement();
			String selectSQL = "select * from PassUser";
			ResultSet rs = stmt.executeQuery(selectSQL);

			while (rs.next()) {
				pu.setTotalRows(totalRows += 1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pu;
	}

	// Select data from PassUser..to check login
	public PassUser selectPassUser(String username, String password) {
		PassUser pu = new PassUser();

		try {
			stmt = con.createStatement();
			String selectSQL = "select User_ID, Username, Password from PassUser where username = '"
					+ username + "' and password = '" + password + "' ";
			ResultSet rs = stmt.executeQuery(selectSQL);

			while (rs.next()) {
				pu.setUser_id(rs.getInt("User_ID"));
				pu.setUsername(rs.getString("Username"));
				pu.setPassword(rs.getString("Password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pu;
	}

	// Select data from PassInfo to add rows
	public PassInfo selectPassInfo() {
		PassInfo pi = new PassInfo();
		int totalRows = 0;
		try {
			stmt = con.createStatement();
			String selectSQL = "select * from PassInfo";
			ResultSet rs = stmt.executeQuery(selectSQL);

			while (rs.next()) {
				pi.setTotalRows(totalRows += 1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pi;
	}

	// Insert Data into PassInfo
	public void insertPassInfo(int Info_ID, String title, String url,
			String username, String password, String category, int ID) {
		try {
			String insertSQL = "insert into PassInfo values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setInt(1, Info_ID);
			pstmt.setString(2, title);
			pstmt.setString(3, url);
			pstmt.setString(4, username);
			pstmt.setString(5, password);
			pstmt.setString(6, category);
			pstmt.setInt(7, ID);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Select data from PassInfo..to retrieve data
	public List<PassInfo> selectPassInfo(int User_ID, String category) {
		List<PassInfo> information = new ArrayList<>();

		try {
			stmt = con.createStatement();
			String selectSQL = "select title, url, username, password from PassInfo where ID ='"
					+ User_ID + "' and category = '" + category + "' ";
			ResultSet rs = stmt.executeQuery(selectSQL);

			while (rs.next()) {
				PassInfo pi = new PassInfo();
				pi.setTitle(rs.getString("Title"));
				pi.setUrl(rs.getString("URL"));
				pi.setUsername(rs.getString("Username"));
				pi.setPassword(rs.getString("Password"));

				information.add(pi);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return information;
	}

	// Method to retrieve password
	public PassUser returnPassword(String ssn) {
		PassUser pu = new PassUser();

		try {
			stmt = con.createStatement();
			String selectSQL = "select password from PassUser where ssn = '"
					+ ssn + "' ";
			ResultSet rs = stmt.executeQuery(selectSQL);

			while (rs.next()) {
				pu.setPassword(rs.getString("Password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pu;
	}

	// Close Database
	public void close() {

		try {
			con.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// public static void main(String[] args) {
	// DatabaseAccess dao = new DatabaseAccess();
	// dao.setup();
	// dao.createPassUser();
	// dao.createPassInfo();
	// dao.close();
	// }
}
