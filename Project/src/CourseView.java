public class CourseView {
    
    public void printCourseDetails(Course course) {
        System.out.println("--- Course Details ---");
        System.out.println("Course Id: " + course.getCourseId());
        System.out.println("Course Title : " + course.getCourseTitle());
        System.out.println("Course Credit : " + course.getCredit());
    }
}