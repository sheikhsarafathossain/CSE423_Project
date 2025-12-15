import java.util.Scanner;
import java.util.Objects;

public class AdminController {

    private Scanner sc;
    private UniversityData db;
    private StudentView studentView;
    private FacultyView facultyView;
    private CourseView courseView;
    private ExamResultView examResultView;

    public AdminController(Scanner sc, UniversityData db, StudentView studentView, 
                           FacultyView facultyView, CourseView courseView, ExamResultView examResultView) {
        this.sc = sc;
        this.db = db;
        this.studentView = studentView;
        this.facultyView = facultyView;
        this.courseView = courseView;
        this.examResultView = examResultView;
    }

    public void run() {
        boolean stp = true;
        while (stp) {
            System.out.println("\t\t\t\t---------------------");
            System.out.println("\t\t\t\tAdmin & Faculty Panel");
            System.out.println("\t\t\t\t---------------------");
            System.out.println("a. Add: ");
            System.out.println("b. Drop: ");
            System.out.println("c. Update: ");
            System.out.println("d. Search: ");
            System.out.println("e. Print: ");
            System.out.println("f. Back: ");
            char studentpanel = sc.next().charAt(0);
            
            switch (studentpanel) {
                case 'a': { // Admin Add
                    boolean sp = true;
                    while (sp) {
                        System.out.println("a. Add Faculty: ");
                        System.out.println("b. Add Course: ");
                        System.out.println("c. Add Club: ");
                        System.out.println("d. Add Department: ");
                        System.out.println("e. Add Faculty to Course: ");
                        System.out.println("f. Add Faculty to Club: ");
                        System.out.println("g. Add Faculty to Department: ");
                        System.out.println("h. Add Result to Course: ");
                        System.out.println("i. Back: ");
                        char admin = sc.next().charAt(0);
                        switch (admin) {
                            case 'a': { // Add Faculty
                                System.out.print("Enter Faculty ID: ");
                                int fid = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter Faculty Name: ");
                                String fname = sc.nextLine();
                                System.out.print("Enter Faculty Email: ");
                                String femail = sc.nextLine();
                                System.out.print("Enter Faculty Position: ");
                                String fpos = sc.nextLine();
                                
                                System.out.print("Enter Max Course Load (e.g. 3): ");
                                int fload = sc.nextInt();
                                sc.nextLine();

                                CourseManager cm = new CourseManager();
                                
                                Faculty f = new Faculty.FacultyBuilder()
                                .setId(fid)
                                .setName(fname)
                                .setEmail(femail)
                                .setPosition(fpos)
                                .setMaxCourseLoad(fload)
                                .setCourseManager(cm)
                                .build();
                                db.getFaculties().add(f);
                                System.out.println("Faculty Added Successfully!");
                                break;
                            }
                            case 'b': { // Add Course
                                sc.nextLine();
                                System.out.print("Enter Course ID: ");
                                String cid = sc.nextLine();
                                System.out.print("Enter Course Title: ");
                                String ct = sc.nextLine();
                                System.out.print("Enter Course Credit: ");
                                double cc = sc.nextDouble();
                                
                                System.out.print("Enter Student Capacity: ");
                                int ccap = sc.nextInt();
                                sc.nextLine();

                                db.getCourses().add(new Course(cid, ct, cc, ccap));
                                System.out.println("Course Added Successfully!");
                                break;
                            }
                            case 'c': {
                                System.out.print("Enter Club Name: ");
                                sc.nextLine();
                                String cname = sc.nextLine();
                                System.out.print("Enter Club Position: ");
                                String cp = sc.nextLine();
                                db.getClubs().add(new Club(cname, cp));
                                System.out.println("Club Added Successfully!");
                                break;
                            }
                            case 'd': {
                                System.out.print("Enter Department Name: ");
                                sc.nextLine();
                                String dname = sc.nextLine();
                                System.out.print("Enter total Departmental Credit: ");
                                Double dc = sc.nextDouble();
                                db.getDepartments().add(new Department(dname, dc));
                                System.out.println("Department Added Successfully!");
                                break;
                            }
                            case 'e': {
                                System.out.print("Enter Faculty ID to add Course:");
                                int fid = sc.nextInt();
                                sc.nextLine();
                                for (Faculty f : db.getFaculties()) {
                                    if (f.getId() == fid) {
                                        System.out.print("Enter Course ID: ");
                                        String cid = sc.nextLine();
                                        for (Course c : db.getCourses()) {
                                            if (Objects.equals(c.getCourseId(), cid)) {
                                                f.addCourse(c);
                                                c.setFaculty(f);;
                                                System.out.println("Course added to Faculty.");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                            case 'f': { // Faculty to Club
                                System.out.print("Enter Faculty ID to add club: ");
                                int fid = sc.nextInt();
                                sc.nextLine();
                                for(Faculty f: db.getFaculties()){
                                    if(f.getId() == fid){
                                        System.out.print("Enter Club Name: ");
                                        String cname = sc.nextLine();
                                        for(Club c : db.getClubs()){
                                            if(Objects.equals(c.getClubName(), cname)){
                                                f.addClub(c);
                                                System.out.println("Club added to Faculty");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                            case 'g': { // Faculty to Department
                                System.out.print("Enter Faculty ID to add Department: ");
                                int fid = sc.nextInt();
                                sc.nextLine();
                                for(Faculty f : db.getFaculties()){
                                    if(f.getId() == fid){
                                        System.out.print("Enter Department Name: ");
                                        String dname = sc.nextLine();
                                        for(Department d : db.getDepartments()){
                                            if(Objects.equals(d.getName(), dname)){
                                                f.addDepartment(d);
                                                System.out.println("Department added to Faculty");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                            case 'h': { // Add Results
                                System.out.print("Enter Student ID: ");
                                int sid = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter Course ID to add Exam Results:");
                                String cid = sc.nextLine();

                                System.out.println("Enter Mid 1 Result: ");
                                double mid1 = sc.nextDouble();
                                System.out.println("Enter Mid 2 Result: ");
                                double mid2 = sc.nextDouble();
                                System.out.println("Enter Final Result: ");
                                double finall = sc.nextDouble();
                                
                                ExamResult newResult = new ExamResult(cid, mid1, mid2, finall);
                                examResultView.printResultDetails(newResult);

                                for (Course c : db.getCourses()) {
                                    if (Objects.equals(c.getCourseId(), cid)) {
                                        c.addExamResult(newResult);
                                        for(Student s : db.getStudents()) {
                                            if(s.getId() == sid) {
                                                s.addExamResult(newResult);
                                                System.out.println("Marks added.");
                                                break;
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                            case 'i': {
                                sp = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                
                // UPDATE MENU (Case c)
                case 'c': {
                    boolean sp = true;
                    while (sp) {
                        System.out.println("\nUpdate Menu");
                        System.out.println("a. Update Student Info");
                        System.out.println("b. Back");
                        char ucc = sc.next().charAt(0);
                        switch (ucc) {
                            case 'a': {
                                System.out.print("Enter Student ID to update: ");
                                int studentId = sc.nextInt();
                                sc.nextLine();
                                for (Student s : db.getStudents()) {
                                    if (s.getId() == studentId) {
                                        System.out.print("Enter Student's new Name: ");
                                        String sname = sc.nextLine();
                                        s.setName(sname);
                                        System.out.println("Updated!");
                                    }
                                }
                                break;
                            }
                            case 'b': sp = false; break;
                        }
                    }
                    break;
                }
                
                case 'e': { // Admin Print
                    boolean sp = true;
                    while (sp) {
                        System.out.println("a. Print Student Details: ");
                        System.out.println("b. Print Faculty Details: ");
                        System.out.println("c. Print Course Details: ");
                        System.out.println("d. Back: ");
                        char ps = sc.next().charAt(0);
                        switch (ps) {
                            case 'a': {
                                System.out.println("All Students: ");
                                for (Student s : db.getStudents()) {
                                    studentView.printStudentDetails(s);
                                }
                                break;
                            }
                            case 'b': {
                                System.out.println("All Faculty Members: ");
                                for (Faculty f : db.getFaculties()) {
                                    facultyView.printFacultyDetails(f);
                                }
                                break;
                            }
                            case 'c': {
                                System.out.println("All Courses :");
                                for (Course c : db.getCourses()) {
                                    courseView.printCourseDetails(c);
                                }
                                break;
                            }
                            case 'd': {
                                sp = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 'f': {
                    stp = false;
                    break;
                }
            }
        }
    }
}
