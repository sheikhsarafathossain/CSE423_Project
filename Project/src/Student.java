import java.util.ArrayList;

class Student extends Person {

    private double studentCGPA;
    
    private CourseManager courseManager;
    private ArrayList<ExamResult> resultList = new ArrayList<ExamResult>();
    private ArrayList<Club> clubList = new ArrayList<Club>();
    private int numberOfClubs = 0;
    private ArrayList<Department> departmentList = new ArrayList<Department>();

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public Student() {
    }

    public Student(int id, String name, String email, double studentCGPA) {
        super(id, name, email);
        this.studentCGPA = studentCGPA;
        this.courseManager = new CourseManager();
    }

    public double getStudentCGPA() {
        return studentCGPA;
    }

    public void setStudentCGPA(double studentCGPA) {
        this.studentCGPA = studentCGPA;
    }

    public CourseManager getCourseManager() {
        return courseManager;
    }

    public void setCourseManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }


    public ArrayList<ExamResult> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<ExamResult> resultList) {
        this.resultList = resultList;
    }

    public ArrayList<Club> getClubList() {
        return clubList;
    }

    public void setClubList(ArrayList<Club> clubList) {
        this.clubList = clubList;
    }

    public int getNumberOfClubs() {
        return numberOfClubs;
    }

    public void setNumberOfClubs(int numberOfClubs) {
        this.numberOfClubs = numberOfClubs;
    }

    @Override
    public void display() {
        System.out.println("Student Id: " + getId());
        System.out.println("Student Name: " + getName());
        System.out.println("Student Email: " + getEmail());
        System.out.println("Student CGPA: " + getStudentCGPA());  //Dependency Inversion Principles
    }
    

    public void displayAssignCourse(){
        this.courseManager.displayAssignCourse();
    }

    public void addCourse(Course course) {
        this.courseManager.addCourse(course);
    }

    public void dropCourse(String coursedrop) {
        this.courseManager.dropCourse(coursedrop);
    }
    
    
    public void addExamMarks(ExamResult er){
        resultList.add(er);
    }
    
    public void displayAssignExamResult(){
        for(ExamResult er: resultList){
            er.display();
        }
    }
    
    public void addClub(Club c) {
        clubList.add(c);
        numberOfClubs++;

    }
    
    public void displayAssignClub() {
        for (Club c : clubList) {
            c.display();
        }
    }
    
    public void addDepartment(Department d ){
        departmentList.add(d);
    }
    
    public void displayAssignDepartment() {
        for (Department d : departmentList) {
            d.display();
        }
    }
    
    

}
