import java.util.Scanner;
import java.util.Objects;

public class StudentController {
    
    private Scanner sc;
    private UniversityData db;
    private StudentView studentView;
    private DepartmentView departmentView;
    private CourseView courseView;
    private ExamResultView examResultView;
    private ClubView clubView;
    private FacultyView facultyView;

    public StudentController(Scanner sc, UniversityData db, StudentView studentView, 
                             DepartmentView departmentView, CourseView courseView, 
                             ExamResultView examResultView, ClubView clubView, FacultyView facultyView) {
        this.sc = sc;
        this.db = db;
        this.studentView = studentView;
        this.departmentView = departmentView;
        this.courseView = courseView;
        this.examResultView = examResultView;
        this.clubView = clubView;
        this.facultyView = facultyView;
    }

    public void run() {
        boolean stp = true;
        while (stp) {
            System.out.println("\t\t\t\t-------------");
            System.out.println("\t\t\t\tStudent Panel");
            System.out.println("\t\t\t\t-------------");
            System.out.println("a. Add: ");
            System.out.println("b. Drop: ");
            System.out.println("c. Search: ");
            System.out.println("d. Print: ");
            System.out.println("e. Back: ");
            char studentpanel = sc.next().charAt(0);
            
            switch (studentpanel) {
                case 'a': { // Add Menu
                    boolean sp = true;
                    while (sp) {
                        System.out.println("a. Add a Student: ");
                        System.out.println("b. Add Student to Course: ");
                        System.out.println("c. Add Student to Club: ");
                        System.out.println("d. Add Student to Department: ");
                        System.out.println("e. Back: ");

                        char student = sc.next().charAt(0);
                        switch (student) {
                            case 'a': {
                                System.out.print("Enter Student ID: ");
                                int sid = sc.nextInt();
                                sc.nextLine(); 
                                System.out.print("Enter Student Name: ");
                                String sname = sc.nextLine();
                                System.out.print("Enter Student Email:");
                                String semail = sc.nextLine();
                                System.out.print("Enter Student CGPA: ");
                                double scgpa = sc.nextDouble();
                                
                                CourseManager cm = new CourseManager();

                                Student s = new Student.StudentBuilder()
                                .setId(sid)
                                .setName(sname)
                                .setEmail(semail)
                                .setStudentCGPA(scgpa)
                                .setCourseManager(cm)
                                .build();
                                db.getStudents().add(s);
                                
                                System.out.println("Student Added Successfully!");
                                break;
                            }
                            case 'b': {
                                System.out.print("Enter Student ID to add course: ");
                                int id = sc.nextInt();
                                sc.nextLine();
                                for (Student s : db.getStudents()) {
                                    if (s.getId() == id) {
                                        System.out.print("Enter Course ID: ");
                                        String cid = sc.nextLine();
                                        for (Course c : db.getCourses()) {
                                            if (Objects.equals(c.getCourseId(), cid)) {
                                                s.enrollCourse(c);
                                                c.addStudent(s);
                                                System.out.println("Course enrollment processed.");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                            case 'c': {
                                System.out.print("Enter Student ID to add club: ");
                                int sid = sc.nextInt();
                                sc.nextLine();
                                for (Student s : db.getStudents()) {
                                    if (s.getId() == sid) {
                                        System.out.print("Enter Club Name: ");
                                        String cname = sc.nextLine();
                                        for (Club c : db.getClubs()) {
                                            if (Objects.equals(c.getClubName(), cname)) {
                                                s.joinClub(c);
                                                System.out.println("Club added successfully");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                            case 'd': {
                                System.out.print("Enter Student ID to add Department: ");
                                int sid = sc.nextInt();
                                sc.nextLine();
                                for (Student s : db.getStudents()) {
                                    if (s.getId() == sid) {
                                        System.out.print("Enter Department Name: ");
                                        String dname = sc.nextLine();
                                        for (Department d : db.getDepartments()) {
                                            if (Objects.equals(d.getName(), dname)) {
                                                s.addDepartment(d);
                                                System.out.println("Department added successfully");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                            case 'e': { // Back
                                sp = false;
                                break;
                            }
                            default: {
                                System.out.println("Invalid");
                                break;
                            }
                        }
                    }
                    break;
                } 

                case 'b': { // Drop Menu
                    boolean sp = true;
                    while (sp) {
                        System.out.println("a. Drop Course: ");
                        System.out.println("b. Back: ");
                        char drop = sc.next().charAt(0);
                        switch (drop) {
                            case 'a': {
                                System.out.print("Enter Course ID: ");
                                sc.nextLine();
                                String cid = sc.nextLine();
                                for (Course c : db.getCourses()) {
                                    if (Objects.equals(c.getCourseId(), cid)) {
                                        for (Student s : db.getStudents()) {
                                            System.out.print("Enter Student ID: ");
                                            int sid = sc.nextInt();
                                            if (Objects.equals(s.getId(), sid)) {
                                                c.dropStudent(sid);
                                                s.dropCourse(cid); 
                                                System.out.println("Dropped Successfully!");
                                                break;
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                            case 'b': {
                                sp = false;
                                break;
                            }
                            default: {
                                System.out.println("Invalid Input Try Again!");
                                break;
                            }
                        }
                    }
                    break;
                }

                case 'c': { 
                    boolean sp = true;
                    while (sp) {
                        System.out.println("a. Search Course: ");
                        System.out.println("b. Search Faculty: ");
                        System.out.println("c. Search Club: ");
                        System.out.println("d. Search Department: ");
                        System.out.println("e. Search Course Result: ");
                        System.out.println("f. Back: ");
                        char ps = sc.next().charAt(0);
                        switch (ps) {
                            case 'a': {
                                System.out.print("Enter Course ID: ");
                                sc.nextLine();
                                String cid = sc.nextLine();
                                for (Course c : db.getCourses()) {
                                    if (Objects.equals(c.getCourseId(), cid)) {
                                        // SRP: Use View
                                        courseView.printCourseDetails(c);
                                    } 
                                }
                                break;
                            }
                            case 'b': {
                                System.out.println("Enter Faculty ID: ");
                                int fid = sc.nextInt();
                                for (Faculty f : db.getFaculties()) {
                                    if (fid == f.getId()) {
                                        facultyView.printFacultyDetails(f);
                                    } 
                                }
                                break;
                            }
                            case 'c': {
                                System.out.print("Enter Club Name: ");
                                sc.nextLine();
                                String cname = sc.nextLine();
                                for (Club c : db.getClubs()) {
                                    if (Objects.equals(c.getClubName(), cname)) {
                                        clubView.printClubDetails(c);
                                    } 
                                }
                                break;
                            }
                            case 'd': {
                                System.out.print("Enter Department name: ");
                                sc.nextLine();
                                String dname = sc.nextLine();
                                for (Department d : db.getDepartments()) {
                                    if (Objects.equals(d.getName(), dname)) {
                                        departmentView.printDepartmentDetails(d);
                                    } 
                                }
                                break;
                            }
                            case 'e': {
                                System.out.print("Enter Course Name: ");
                                sc.nextLine(); 
                                String cname = sc.nextLine();
                                for (Course c : db.getCourses()) {
                                    if (cname.equals(c.getCourseId())) {
                                        System.out.println("Course found: " + cname);
                                    } 
                                }
                                break;
                            }
                            case 'f': {
                                sp = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 'd': { // Print Menu
                    boolean sp = true;
                    while (sp) {
                        System.out.println("a. Print Student Information: ");
                        System.out.println("b. Print Student Department: ");
                        System.out.println("c. Print Student Courses: ");
                        System.out.println("d. Print Student Courses Result: ");
                        System.out.println("e. Print Student Club: ");
                        System.out.println("f. Back: ");
                        char ps = sc.next().charAt(0);
                        switch (ps) {
                            case 'a': {
                                for (Student s : db.getStudents()) {
                                    studentView.printStudentDetails(s);
                                }
                                break;
                            }
                            case 'b': {
                                for (Student s : db.getStudents()) {
                                    System.out.println("Student: " + s.getName());
                                    for(Department d : s.getDepartments()){
                                        departmentView.printDepartmentDetails(d);
                                    }
                                }
                                break;
                            }
                            case 'c': {
                                for (Student s : db.getStudents()) {
                                    System.out.println("Student: " + s.getName());
                                    for(Course c : s.getCourseManager().getCourses()){
                                        courseView.printCourseDetails(c);
                                    }
                                }
                                break;
                            }
                            case 'd': {
                                for (Student s : db.getStudents()) {
                                    System.out.println("Student: " + s.getName());
                                    for(ExamResult er : s.getExamResults()){
                                        examResultView.printResultDetails(er);
                                    }
                                }
                                break;
                            }
                            case 'e': {
                                for (Student s : db.getStudents()) {
                                    System.out.println("Student: " + s.getName());
                                    for(Club c : s.getClubs()){
                                        clubView.printClubDetails(c);
                                    }
                                }
                                break;
                            }
                            case 'f': {
                                sp = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 'e': { // Back from Student Panel
                    stp = false;
                    break;
                }
            }
        }
    }
}
