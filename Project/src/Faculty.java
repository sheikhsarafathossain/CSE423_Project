import java.util.ArrayList;

public class Faculty extends Person {

    private String facultyPosition;
    private int maxCourseLoad; 
    private CourseManager courseManager;

    private ArrayList<Club> clubList = new ArrayList<Club>();
    private ArrayList<Department> departmentList = new ArrayList<Department>();
    // REMOVED: private int numberOfClubs = 0; (Redundant)

    public Faculty() {
    }

    public Faculty(int id, String name, String email, String facultyPosition, int maxCourseLoad, CourseManager cm) {
        super(id, name, email);
        this.facultyPosition = facultyPosition;
        this.maxCourseLoad = maxCourseLoad;
        this.courseManager = cm; 
    }

    // --- Getters and Setters ---

    public String getFacultyPosition() {
        return facultyPosition;
    }

    public void setFacultyPosition(String facultyPosition) {
        this.facultyPosition = facultyPosition;
    }

    public int getMaxCourseLoad() {
        return maxCourseLoad;
    }

    public void setMaxCourseLoad(int maxCourseLoad) {
        this.maxCourseLoad = maxCourseLoad;
    }

    public CourseManager getCourseManager() {
        return courseManager;
    }

    public void setCourseManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public ArrayList<Club> getClubList() {
        return clubList;
    }

    public void setClubList(ArrayList<Club> clubList) {
        this.clubList = clubList;
    }

    // Fix: Dynamic calculation
    public int getNumberOfClubs() {
        return clubList.size();
    }
    
    // Setter removed

    // --- Data Logic Methods ---

    public void addCourse(Course c) {
        if (this.courseManager.getNumberOfCourses() < maxCourseLoad) {
            this.courseManager.assignCourse(c);
        } else {
            System.out.println("Course capacity reached maximum number.");
        }
    }

    public void dropCourse(String courseId) {
        this.courseManager.withdrawCourse(courseId);
    }

    public void addClub(Club c) {
        clubList.add(c);
    }

    public void dropClub(String clubName) {
        for (int i = 0; i < clubList.size(); i++) {
             if (clubList.get(i).getClubName().equals(clubName)) {
                clubList.remove(i);
                break;
            }
        }
    }
    
    public void addDepartment(Department d ){
        departmentList.add(d);
    }
}