public class Department {

    private String name;
    private double totalCredit;

    public Department() {
    }

    public Department(String name, double totalCredit) {
        this.name = name;
        this.totalCredit = totalCredit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(double totalCredit) {
        this.totalCredit = totalCredit;
    }
}
