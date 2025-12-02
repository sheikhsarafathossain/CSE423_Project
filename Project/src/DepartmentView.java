public class DepartmentView {

    public void printDepartmentDetails(Department department) {
        System.out.println("--- Department Details ---");
        System.out.println("Department Name: " + department.getName());
        System.out.println("Total Credit: " + department.getTotalCredit());
    }
}
