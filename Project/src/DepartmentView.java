public class DepartmentView {
    public void printDepartmentDetails(Department dept) {
        System.out.println("--- Department Details ---");
        System.out.println("Department Name: " + dept.getDepartmentName());
        System.out.println("Total Credit: " + dept.getDepartmentTotalCredit());
    }
}