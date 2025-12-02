import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseId;
    private String courseTitle;
    private double credit;
    private int capacity;

    private final List<Student> students = new ArrayList<>();
    private final List<ExamResult> examResults = new ArrayList<>();

    private Faculty faculty;

    public Course() {
    }

    public Course(String courseId, String courseTitle, double credit, int capacity) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.credit = credit;
        this.capacity = capacity;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<ExamResult> getExamResults() {
        return examResults;
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void addStudent(Student student) {
        if (students.size() < capacity) {
            students.add(student);
        } else {
            System.out.println("Course capacity reached (" + capacity + ")");
        }
    }

    public void dropStudent(int studentId) {
        students.removeIf(s -> s.getId() == studentId);
    }

    public void addExamResult(ExamResult result) {
        examResults.add(result);
    }

    public void removeFaculty() {
        this.faculty = null;
    }
}



