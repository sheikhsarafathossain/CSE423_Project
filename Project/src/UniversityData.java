import java.util.ArrayList;
import java.util.List;

public class UniversityData {

    private static UniversityData instance = null;

    private UniversityData() { 
        
    }

    public static UniversityData getInstance() {
        if (instance == null) {
            instance = new UniversityData();
        }
        return instance;
    }

    private List<Student> students = new ArrayList<>();

    private List<Faculty> faculties = new ArrayList<>();

    private List<Course> courses = new ArrayList<>();

    private List<Department> departments = new ArrayList<>();

    private List<Club> clubs = new ArrayList<>();

    private List<ExamResult> examResults = new ArrayList<>();


    public List<Student> getStudents() { 
        return students; 
    }

    public List<Faculty> getFaculties() { 
        return faculties; 
    }

    public List<Course> getCourses() {
        return courses;     
    }

    public List<Department> getDepartments() { 
        return departments; 
    }

    public List<Club> getClubs() { 
        return clubs; 
    }

    public List<ExamResult> getExamResults() { 
        return examResults;
    }

    public void addStudent(Student s) { 
        students.add(s); 
    }

    public void addFaculty(Faculty f) { 
        faculties.add(f); 
    }

    public void addCourse(Course c) { 
        courses.add(c); 
    }

    public void addDepartment(Department d) { 
        departments.add(d); 
    }

    public void addClub(Club c) { 
        clubs.add(c); 
    }

    public void addExamResult(ExamResult r) { 
        examResults.add(r); 
    }
}
