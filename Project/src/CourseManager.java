import java.util.ArrayList;

// Now implements both interfaces to satisfy ISP
public class CourseManager implements StudentActions, FacultyActions { 

    private ArrayList<Course> courseList = new ArrayList<Course>();
    private int numberOfCourses = 0;

    public CourseManager() {
    }

    // --- Standard Getters (Used by Views/MainClass) ---
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

    // =========================================================
    // STUDENT ACTIONS IMPLEMENTATION
    // =========================================================
    
    @Override
    public void enrollCourse(Course c) {
        // Reuse the logic for adding a course
        addCourseInternal(c);
    }

    @Override
    public void dropCourse(String courseId) {
        // Reuse the logic for dropping a course
        dropCourseInternal(courseId);
    }

    // =========================================================
    // FACULTY ACTIONS IMPLEMENTATION
    // =========================================================

    @Override
    public void assignCourse(Course c) {
        // Faculty "assigning" a course is the same logic as adding one to their list
        addCourseInternal(c);
    }

    @Override
    public void withdrawCourse(String courseId) {
        // Faculty "withdrawing" is the same logic as dropping
        dropCourseInternal(courseId);
    }

    // =========================================================
    // INTERNAL LOGIC (Helper Methods)
    // =========================================================
    // We keep the actual logic private or protected so it isn't called directly.
    // The world must use the Interface methods above.

    private void addCourseInternal(Course course) {
        courseList.add(course);
        numberOfCourses++;
    }

    private void dropCourseInternal(String courseId) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseId().equals(courseId)) {
                courseList.remove(i);
                numberOfCourses--;
                break; 
            }
        }
    }
}