import java.util.Scanner;

public class AppController {

    private UniversityData db;
    private UniversityUIFactory uiFactory;
    private Scanner sc;
    private StudentView studentView;
    private FacultyView facultyView;
    private CourseView courseView;
    private ClubView clubView;
    private DepartmentView departmentView;
    private ExamResultView examResultView;

    public AppController() {
        this.sc = new Scanner(System.in);
        this.db = UniversityData.getInstance();
        this.uiFactory = new ConsoleUIFactory();
        this.studentView = uiFactory.createStudentView();
        this.facultyView = uiFactory.createFacultyView();
        this.courseView = uiFactory.createCourseView();
        this.clubView = uiFactory.createClubView();
        this.departmentView = uiFactory.createDepartmentView();
        this.examResultView = uiFactory.createExamResultView();
    }

    public void run() {
        try {
            boolean res = true;
            while (res) {
                System.out.println("a. Student Panel: ");
                System.out.println("b. Admin & Faculty Panel: ");
                System.out.println("0. Exit: ");
                char mainfunction = sc.next().charAt(0);

                switch (mainfunction) {
                    // ======================================================
                    // STUDENT PANEL
                    // ======================================================
                    case 'a': {
                        new StudentController(sc, db, studentView, departmentView, courseView, examResultView, clubView, facultyView).run();
                        break;
                    }
                    
                    // ======================================================
                    // ADMIN & FACULTY PANEL
                    // ======================================================
                    case 'b': { 
                        new AdminController(sc, db, studentView, facultyView, courseView, examResultView).run();
                        break;
                    }
                    case '0': {
                        res = false;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        sc.close();
    }
}
