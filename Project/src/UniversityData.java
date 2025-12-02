import java.util.List;
import java.util.ArrayList;

public class UniversityData {
    
    private List<Student> studentList = new ArrayList<>();
    private List<Faculty> facultyList = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();
    private List<Club> clubList = new ArrayList<>();
    private List<Department> departmentList = new ArrayList<>();
    
    public List<Student> getStudents() { 
        return studentList; 
    }

    public List<Faculty> getFaculties() { 
        return facultyList; 
    }

    public List<Course> getCourses() { 
        return courseList; 
    }

    public List<Club> getClubs() { 
        return clubList; 
    }

    public List<Department> getDepartments() { 
        return departmentList; 
    }
}
