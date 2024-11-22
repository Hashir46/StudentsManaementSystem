package StudentManagementSystem;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSys {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StudentDAO sDao = new StudentDAO();

    while (true) {
      System.out.println("Student Management System: ");
      System.out.println("1.Add Student: ");
      System.out.println("2.View All Student: ");
      System.out.println("3.Update Student: ");
      System.out.println("4.Delete Student: ");
      System.out.println("5.Exit");

      System.out.println("Choose an option: ");
      int choice = sc.nextInt();
      sc.nextLine();

     switch (choice) {
      case 1:
        System.out.println("Enter FirstName: ");
        String fname = sc.nextLine();
        System.out.println("Enter LastName: ");
        String lname = sc.nextLine();
        System.out.println("Enter Date of Birth (YYYY-MM-DD): ");
        String dob = sc.nextLine();
        System.out.println("Enter Email: ");
        String email = sc.nextLine();
        System.out.println("Enter Phone Number: ");
        String pNo = sc.nextLine();
        System.out.println("Enter Address: ");
        String addr = sc.nextLine();
        System.out.println("Enter Course Name: ");
        String course = sc.nextLine();
        System.out.println("Enter Year Enrolled: ");
        int yrEnroll = sc.nextInt();
        System.out.println("Enter Your Semester: ");
        int sem = sc.nextInt();
        
        Student s = new Student(fname, lname, dob, email, pNo, addr, course, yrEnroll, sem);
        sDao.addStudent(s);
        System.out.println("Student added successfully");
        break;

     case 2:
     List<Student> stud =  sDao.getAllStudents();
     for(Student student : stud){
      System.out.println(student.getFirstName() + "," + student.getLastName() + "," +  student.getCourse() + "," + student.getEmail() + "," + student.getPhnNo());
     }
     break;

     case 3:
     System.out.println("Enter studId: ");
     int updStuId = sc.nextInt();
     sc.nextLine();

    Student existStudent = null;
    List<Student> students = sDao.getAllStudents();
    for (Student student : students) {
      if(student.getStuId() == updStuId){
        existStudent = student;
        break;
      }
    }
    if(existStudent == null){
      System.out.println("Student with id " + updStuId + " not found");
      break;
    }

    System.out.println("Which detail do you want to update?");
    System.out.println("1. First Name");
    System.out.println("2. Last Name");
    System.out.println("3. Date of Birth");
    System.out.println("4. Email");
    System.out.println("5. Phone Number");
    System.out.println("6. Address");
    System.out.println("7. Course Name");
    System.out.println("8. Year Enrolled");
    System.out.println("9. Semester");
     
    System.out.print("Enter the number corresponding to the detail you want to update: ");
    int updateChoice = sc.nextInt();
    sc.nextLine();  // Consume newline after nextInt()

    // Perform the update based on user choice
    switch (updateChoice) {
        case 1:
            System.out.println("Enter new First Name: ");
            String newFname = sc.nextLine();
            existStudent.setFirstName(newFname);
            break;
        case 2:
            System.out.println("Enter new Last Name: ");
            String newLname = sc.nextLine();
            existStudent.setLastName(newLname);
            break;
        case 3:
            System.out.println("Enter new Date of Birth (YYYY-MM-DD): ");
            String newDob = sc.nextLine();
            existStudent.setDob(newDob);
            break;
        case 4:
            System.out.println("Enter new Email: ");
            String newEmail = sc.nextLine();
            existStudent.setEmail(newEmail);
            break;
        case 5:
            System.out.println("Enter new Phone Number: ");
            String newPNo = sc.nextLine();
            existStudent.setPhnNo(newPNo);
            break;
        case 6:
            System.out.println("Enter new Address: ");
            String newAddr = sc.nextLine();
            existStudent.setAddress(newAddr);
            break;
        case 7:
            System.out.println("Enter new Course Name: ");
            String newCourse = sc.nextLine();
            existStudent.setCourse(newCourse);
            break;
        case 8:
            System.out.println("Enter new Year Enrolled: ");
            int newYrEnroll = sc.nextInt();
            sc.nextLine(); // Consume newline
            existStudent.setYearEnrolled(newYrEnroll);
            break;
        case 9:
            System.out.println("Enter new Semester: ");
            int newSem = sc.nextInt();
            sc.nextLine(); // Consume newline
            existStudent.setSemester(newSem);
            break;

        default:
            System.out.println("Invalid choice, no update made.");
            break;
    }

           try {
			sDao.updateStudent(updStuId, existStudent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Assuming you have this method in StudentDAO
           System.out.println("Student updated successfully.");
          break;
    
    case 4:
    System.out.println("Enter Student Id: ");
    int deleteStuId = sc.nextInt();
    sDao.deleteStudent(deleteStuId);
    System.out.println("Student deleted successfully");
    break;

    case 5:
    System.out.println("Exiting..");
    sc.close(); 
    return;

      default:
      System.out.println("Invalid Choice ");
        break;
     }
    }
  }
}
