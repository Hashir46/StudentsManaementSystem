package StudentManagementSystem;

public class Student {

	  private int stuId;
	  private String firstName;
	  private String lastName;
	  private String dob;
	  private String email;
	  private String phnNo;
	  private String address;
	  private String course;
	  private int yearEnrolled;
	  private int semester;


	  public Student(String firstName, String lastName, String dob, String email, String phnNo, String address, String course, int yearEnrolled, int semester) {

		 
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.dob = dob;
	    this.email = email;
	    this.phnNo = phnNo;
	    this.address = address;
	    this.course = course;
	    this.yearEnrolled = yearEnrolled;
	    this.semester = semester;
	    
	  }


	  public int getStuId() {
	    return stuId;
	  }


	  public void setStuId(int stuId) {
	    this.stuId = stuId;
	  }


	  public String getFirstName() {
	    return firstName;
	  }


	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }


	  public String getLastName() {
	    return lastName;
	  }


	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }


	  public String getDob() {
	    return dob;
	  }


	  public void setDob(String dob) {
	    this.dob = dob;
	  }


	  public String getEmail() {
	    return email;
	  }


	  public void setEmail(String email) {
	    this.email = email;
	  }


	  public String getPhnNo() {
	    return phnNo;
	  }


	  public void setPhnNo(String phnNo) {
	    this.phnNo = phnNo;
	  }


	  public String getAddress() {
	    return address;
	  }


	  public void setAddress(String address) {
	    this.address = address;
	  }


	  public String getCourse() {
	    return course;
	  }


	  public void setCourse(String course) {
	    this.course = course;
	  }


	  public int getYearEnrolled() {
	    return yearEnrolled;
	  }


	  public void setYearEnrolled(int yearEnrolled) {
	    this.yearEnrolled = yearEnrolled;
	  }


	  public int getSemester() {
	    return semester;
	  }


	  public void setSemester(int semester) {
	    this.semester = semester;
	  }




	}

	 

