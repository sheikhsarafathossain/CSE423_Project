public class CourseView {

    public void printCourseDetails(Course course) {
        System.out.println("--- Course Details ---");
        System.out.println("Course ID: " + course.getCourseId());
        System.out.println("Course Title: " +  
                         course.getCourseTitle());
        System.out.println("Credit: " + course.getCredit());
    }
}
