package studentinformationsystem;

import java.util.ArrayList;

class Student extends Person {

    private double studentCGPA;
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private int numberOfCourses = 0;
    private ArrayList<ExamResult> resultList = new ArrayList<ExamResult>();
    private ArrayList<Club> clubList = new ArrayList<Club>();
    private int numberOfClubs = 0;
    private ArrayList<Department> departmentList = new ArrayList<Department>();

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public Student() {
    }

    public Student(int id, String name, String email, double studentCGPA) {
        super(id, name, email);
        this.studentCGPA = studentCGPA;
    }

    public double getStudentCGPA() {
        return studentCGPA;
    }

    public void setStudentCGPA(double studentCGPA) {
        this.studentCGPA = studentCGPA;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourse(int numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    public ArrayList<ExamResult> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<ExamResult> resultList) {
        this.resultList = resultList;
    }

    public ArrayList<Club> getClubList() {
        return clubList;
    }

    public void setClubList(ArrayList<Club> clubList) {
        this.clubList = clubList;
    }

    public int getNumberOfClubs() {
        return numberOfClubs;
    }

    public void setNumberOfClubs(int numberOfClubs) {
        this.numberOfClubs = numberOfClubs;
    }

    @Override
    public void display() {
        System.out.println("Student Id: " + getId());
        System.out.println("Student Name: " + getName());
        System.out.println("Student Email: " + getEmail());
        System.out.println("Student CGPA: " + getStudentCGPA());
              
    }
    
    public void displayAssignCourse(){
        for(Course c: courseList){
            c.display();
        }
    }

    public void addCourse(Course course) {
        courseList.add(course);
        numberOfCourses++;
    }

    public void dropCourse(String coursedrop) {
        int i;
        for (i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseId().equals(coursedrop)) {
                courseList.remove(i);
                numberOfCourses--;
                break;
            }
        }
    }
    
    public void addExamMarks(ExamResult er){
        resultList.add(er);
    }
    
    public void displayAssignExamResult(){
        for(ExamResult er: resultList){
            er.display();
        }
    }
    
    public void addClub(Club c) {
        clubList.add(c);
        numberOfClubs++;

    }
    
    public void displayAssignClub() {
        for (Club c : clubList) {
            c.display();
        }
    }
    
    public void addDepartment(Department d ){
        departmentList.add(d);
    }
    
    public void displayAssignDepartment() {
        for (Department d : departmentList) {
            d.display();
        }
    }
    
    

}
