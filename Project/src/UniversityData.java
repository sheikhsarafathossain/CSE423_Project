import java.util.ArrayList;

public class UniversityData {
    
    // These lists used to be inside your Main method
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Faculty> facultyList = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();
    private ArrayList<Club> clubList = new ArrayList<>();
    private ArrayList<Department> departmentList = new ArrayList<>();
    
    // We provide getters so MainClass can access them
    public ArrayList<Student> getStudents() { return studentList; }
    public ArrayList<Faculty> getFaculties() { return facultyList; }
    public ArrayList<Course> getCourses() { return courseList; }
    public ArrayList<Club> getClubs() { return clubList; }
    public ArrayList<Department> getDepartments() { return departmentList; }
}