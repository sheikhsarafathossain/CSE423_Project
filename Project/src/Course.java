import java.util.ArrayList;

public class Course {

    private String courseId, courseTitle;
    private double credit;
    private int capacity; // OCP FIX: Capacity is now variable, not hardcoded
    
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<ExamResult> resultList = new ArrayList<ExamResult>();
    
    // Redundant counter 'numberOfStudent' removed. We will use studentList.size()
    
    private Faculty faculty;

    public Course() {
    }

    // Updated Constructor to accept capacity
    public Course(String courseId, String courseTitle, double credit, int capacity) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.credit = credit;
        this.capacity = capacity;
    }

    // --- Getters and Setters ---
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public String getCourseTitle() { return courseTitle; }
    public void setCourseTitle(String courseTitle) { this.courseTitle = courseTitle; }

    public double getCredit() { return credit; }
    public void setCredit(double credit) { this.credit = credit; }
    
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public ArrayList<Student> getStudentList() { return studentList; }
    public void setStudentList(ArrayList<Student> studentList) { this.studentList = studentList; }

    // Dynamic getter instead of manual counter
    public int getNumberOfStudent() { return studentList.size(); }

    public Faculty getFaculty() { return faculty; }
    public void setFaculty(Faculty faculty) { this.faculty = faculty; }

    // --- Data Logic ---

    public void addStudent(Student s) {
        // OCP FIX: Checks against the specific capacity of this course instance
        if (studentList.size() < capacity) {
            studentList.add(s);
        } else {
             System.out.println("Course Capacity Full (" + capacity + ")");
        }
    }

    public void dropStudent(int studentId) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == studentId){
                studentList.remove(i);
                break;
            }
        }
    }
    
    public void addMarks(ExamResult e){
        resultList.add(e);
    }
    
    public void addFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void dropFaculty() {
        this.faculty = null;
    }
}