package StudentManagementSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
  //add Student data: 
  public int addStudent(Student student) {
    String query = "insert into stu(firstName,lastName,dob,email,phnNo,address,course,yearEnrolled,semester) values (?,?,?,?,?,?,?,?,?)";

    try (Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query)) {

      pst.setString(1, student.getFirstName());
      pst.setString(2, student.getLastName());
      pst.setString(3, student.getDob());
      pst.setString(4, student.getEmail());
      pst.setString(5, student.getPhnNo());
      pst.setString(6, student.getAddress());
      pst.setString(7, student.getCourse());
      pst.setInt(8, student.getYearEnrolled());
      pst.setInt(9, student.getSemester());

      return  pst.executeUpdate();
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;

  }

  //Retrive Student data:
  public List<Student> getAllStudents() {
    List<Student> students = new ArrayList<>();
    String query = "select * from stu";

    try (Connection con = DBConnection.getConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query)) {

      while (rs.next()) {
        Student stud = new Student(
            rs.getString("firstName"),
            rs.getString("lastName"),
            rs.getString("dob"),
            rs.getString("email"),
            rs.getString("phnNo"),
            rs.getString("address"),
            rs.getString("course"),
            rs.getInt("yearEnrolled"),
            rs.getInt("semester"));
        students.add(stud);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return students;
  }

  //Update Student data:
  public int updateStudent(int stuId, Student student) throws  SQLException{
    String query = "update stu set firstName = ?, lastName = ?, dob = ?, email = ?, phnNo = ?, address = ?, course = ?, yearEnrolled = ?, semester = ? where stuId = ?";

    try (Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query)) {

     

   // Debugging: Print parameters for validation
      System.out.println("Parameters: ");
      System.out.println("firstName: " + student.getFirstName());
      System.out.println("lastName: " + student.getLastName());
      System.out.println("dob: " + student.getDob());
      System.out.println("email: " + student.getEmail());
      System.out.println("phoneNumber: " + student.getPhnNo());
      System.out.println("address: " + student.getAddress());
      System.out.println("course: " + student.getCourse());
      System.out.println("yearEnrolled: " + student.getYearEnrolled());
      System.out.println("semester: " + student.getSemester());
      System.out.println("stuId: " + stuId);
      
      pst.setString(1, student.getFirstName());
      pst.setString(2, student.getLastName());
      pst.setString(3, student.getDob());
      pst.setString(4, student.getEmail());
      pst.setString(5, student.getPhnNo());
      pst.setString(6, student.getAddress());
      pst.setString(7, student.getCourse());
      pst.setInt(8, student.getYearEnrolled());
      pst.setInt(9, student.getSemester());
      pst.setInt(10, stuId);
      return pst.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }

  //Delete Student data:
  public int deleteStudent(int stuId) {
    String query = "delete from stu where stuId = ?";

    try (Connection con = DBConnection.getConnection();

        PreparedStatement pst = con.prepareStatement(query)) {
      pst.setInt(1, stuId);

      return pst.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }
}
