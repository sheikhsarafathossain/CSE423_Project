package studentinformationsystem;

import java.util.ArrayList;

class Faculty extends Person {

    private String facultyPosition;
    private ArrayList<Course> CourseList = new ArrayList<Course>();
    private int numberOfCourses = 0;
    private ArrayList<Club> clubList = new ArrayList<Club>();
    private ArrayList<Department> departmentList = new ArrayList<Department>();
    private int numberOfClubs = 0;

    public Faculty() {
    }

    public Faculty(int id, String name, String email, String facultyPosition) {
        super(id, name, email);
        this.facultyPosition = facultyPosition;
    }

    public String getFacultyPosition() {
        return facultyPosition;
    }

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public void setFacultyPosition(String facultyPosition) {
        this.facultyPosition = facultyPosition;
    }

    public ArrayList<Course> getCourseList() {
        return CourseList;
    }

    public void setCourseList(ArrayList<Course> CourseList) {
        this.CourseList = CourseList;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourse(int numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
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
        System.out.println("Faculty Id: " + getId()); 
        System.out.println("Faculty Name: " + getName());
        System.out.println("Faculty Email: " + getEmail());
        System.out.println("Faculty Position: " + facultyPosition);
               

    }

    public void addCourse(Course c) {
        if (numberOfCourses <= 3) {
            CourseList.add(c);
            numberOfCourses++;
        } else {
            System.out.println("Course capacity reached maximum number.\n"
                    + "Cant add more");
        }
    }

    public void dropCourse(String courseId) {
        for (Course c : CourseList) {
            if (c.getCourseId() == courseId) {
                CourseList.remove(c);
                numberOfCourses--;
            }
        }
    }

    public void displayAssignCourse() {
        for (Course c : CourseList) {
            c.display();
        }
    }

    public void addClub(Club c) {

        clubList.add(c);
        numberOfClubs++;

    }

    public void dropClub(String clubName) {
        for (Club c : clubList) {
            if (c.getClubName() == clubName) {
                clubList.remove(c);
                numberOfClubs++;
            }
        }
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
