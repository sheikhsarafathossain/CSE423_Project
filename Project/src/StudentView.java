public class StudentView {
    
    public void printStudentDetails(Student student) {
        System.out.println("--- Student Details ---");
        System.out.println("Student Id: " + student.getId());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Email: " +   student.getEmail());
        System.out.println("Student CGPA: " +   student.getStudentCGPA());
    }
}
