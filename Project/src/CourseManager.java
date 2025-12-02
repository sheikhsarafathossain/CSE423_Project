import java.util.ArrayList;
import java.util.List;

public class CourseManager implements StudentActions, FacultyActions {

    private final List<Course> courses = new ArrayList<>();

    public CourseManager() {
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public void enrollCourse(Course course) {
        addCourseInternal(course);
    }

    @Override
    public void dropCourse(String courseId) {
        dropCourseInternal(courseId);
    }

    @Override
    public void assignCourse(Course course) {
        addCourseInternal(course);
    }

    @Override
    public void withdrawCourse(String courseId) {
        dropCourseInternal(courseId);
    }

    private void addCourseInternal(Course course) {
        courses.add(course);
    }

    private void dropCourseInternal(String courseId) {
        courses.removeIf(c -> c.getCourseId().equals(courseId));
    }
}
