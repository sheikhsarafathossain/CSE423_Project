import java.util.ArrayList;

public class Student extends Person {

    private double studentCGPA;
    private CourseManager courseManager; 
    
    private ArrayList<ExamResult> resultList = new ArrayList<ExamResult>();
    private ArrayList<Club> clubList = new ArrayList<Club>();
    // REMOVED: private int numberOfClubs = 0; (Redundant)
    private ArrayList<Department> departmentList = new ArrayList<Department>();

    public Student() {
    }

    public Student(int id, String name, String email, double studentCGPA, CourseManager cm) {
        super(id, name, email);
        this.studentCGPA = studentCGPA;
        this.courseManager = cm; 
    }

    // --- Getters and Setters ---

    public double getStudentCGPA() {
        return studentCGPA;
    }

    public void setStudentCGPA(double studentCGPA) {
        this.studentCGPA = studentCGPA;
    }

    public CourseManager getCourseManager() {
        return courseManager;
    }

    public void setCourseManager(CourseManager courseManager) {
        this.courseManager = courseManager;
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

    // Fix: Dynamic calculation ensures data integrity
    public int getNumberOfClubs() {
        return clubList.size();
    }
    
    // Setter for number is removed as it's calculated automatically

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departmentList = departmentList;
    }

    // --- Data Logic Methods ---

    public void addCourse(Course course) {
        this.courseManager.enrollCourse(course);
    }

    public void dropCourse(String coursedrop) {
        this.courseManager.dropCourse(coursedrop);
    }
    
    public void addExamMarks(ExamResult er){
        resultList.add(er);
    }
    
    public void addClub(Club c) {
        clubList.add(c);
        // Removed numberOfClubs++
    }
    
    public void addDepartment(Department d ){
        departmentList.add(d);
    }
}