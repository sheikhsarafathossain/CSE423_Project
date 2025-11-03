package studentinformationsystem;

public class Department {

    private String departmentName;
    private double departmentTotalCredit;

    public Department() {
    }

    public Department(String departmentName, double departmentTotalCredit) {
        this.departmentName = departmentName;
        this.departmentTotalCredit = departmentTotalCredit;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getDepartmentTotalCredit() {
        return departmentTotalCredit;
    }

    public void setDepartmentTotalCredit(double departmentTotalCredit) {
        this.departmentTotalCredit = departmentTotalCredit;
    }

    public void display() {
        System.out.println("Department Name: " + departmentName);
        System.out.println("Department Total Credit: " + departmentTotalCredit);
        

    }

}