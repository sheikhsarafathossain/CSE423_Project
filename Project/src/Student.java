import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private double studentCGPA;
    private CourseManager courseManager; 
    
    private List<ExamResult> examResults = new  
    ArrayList<>();
    private List<Club> clubs = new ArrayList<>();
    private List<Department> departments = new 
    ArrayList<>();

    public Student() {
    }

    public Student(int id, String name, String email, double studentCGPA) {
        super(id, name, email);
        this.studentCGPA = studentCGPA;
    }

    public Student(int id, String name, String email, double studentCGPA, CourseManager cm) {
        super(id, name, email);
        this.studentCGPA = studentCGPA;
        this.courseManager = cm; 
    }


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

    public List<ExamResult> getExamResults() {
        return examResults;
    }

    public void setExamResults(List<ExamResult> examResults) {
        this.examResults = examResults;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    public int getNumberOfClubs() {
        return clubs.size();
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void enrollCourse(Course courseId) {
        this.courseManager.enrollCourse(courseId);
    }

    public void dropCourse(String courseId) {
        this.courseManager.dropCourse(courseId);
    }
    
    public void addExamResult(ExamResult result){
        examResults.add(result);
    }
    
    public void joinClub(Club club) {
        clubs.add(club);
    }
    
    public void addDepartment(Department department) {
        departments.add(department);
    }
}
