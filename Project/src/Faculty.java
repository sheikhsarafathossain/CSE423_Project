import java.util.ArrayList;
import java.util.List;

public class Faculty extends Person {

    private String position;
    private int maxCourseLoad;
    private CourseManager courseManager;

    private final List<Club> clubs = new ArrayList<>();
    private final List<Department> departments = new ArrayList<>();

    public Faculty() {
    }

    public Faculty(int id, String name, String email, String position, int maxCourseLoad, CourseManager courseManager) {
        super(id, name, email);
        this.position = position;
        this.maxCourseLoad = maxCourseLoad;
        this.courseManager = courseManager;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public int getNumberOfClubs() {
        return clubs.size();
    }

    public void addCourse(Course course) {
        courseManager.assignCourse(course);
    }

    public void dropCourse(String courseId) {
        courseManager.withdrawCourse(courseId);
    }

    public void addClub(Club club) {
        clubs.add(club);
    }

    public void dropClub(String clubName) {
        clubs.removeIf(c -> c.getClubName().equals(clubName));
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }
}
