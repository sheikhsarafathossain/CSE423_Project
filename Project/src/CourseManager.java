import java.util.ArrayList;

public class CourseManager{ // Single Responsibility Principles

    private ArrayList<Course> courseList = new ArrayList<Course>();
    private int numberOfCourses = 0;

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
}
