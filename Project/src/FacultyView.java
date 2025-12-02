public class FacultyView {

    public void printFacultyDetails(Faculty faculty) {
        System.out.println("--- Faculty Details ---");
        System.out.println("Faculty Id: " + faculty.getId());
        System.out.println("Faculty Name: " + faculty.getName());
        System.out.println("Faculty Email: " + faculty.getEmail());
        System.out.println("Faculty Position: " + 
            faculty.getPosition());
    }
}
