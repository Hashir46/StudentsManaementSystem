package StudentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

  private static final String url = "jdbc:mysql://localhost:3306/student";
  private static final String user = "root";
  private static final String password = "Hasan@2003";

  public static Connection getConnection() throws SQLException{
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      return DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
 
  }
  
}
