package studentinformationsystem;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        try {
            ArrayList<Student> studentList = new ArrayList<Student>();
            ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
            ArrayList<Course> CourseList = new ArrayList<Course>();
            ArrayList<Club> clubList = new ArrayList<Club>();
            ArrayList<ExamResult> resultList = new ArrayList<ExamResult>();
            ArrayList<Department> departmentList = new ArrayList<Department>();

            boolean res = true;
            while (res) {
                System.out.println("a. Student Panel: ");
                System.out.println("b. Admin & Faculty Panel: ");
                System.out.println("0. Exit: ");
                char mainfunction = sc.next().charAt(0);
                switch (mainfunction) {
                    //case a started
                    case 'a': {
                        boolean stp = true;
                        while (stp) {
                            System.out.println("\t\t\t\t-------------");
                            System.out.println("\t\t\t\tStudent Panel");
                            System.out.println("\t\t\t\t-------------");
                            System.out.println("a. Add: "); //done
                            System.out.println("b. Drop: "); //done
                            System.out.println("c. Search: "); //done
                            System.out.println("d. Print: ");//done
                            System.out.println("e. Back: ");//done
                            char studentpanel = sc.next().charAt(0);
                            switch (studentpanel) {
                                case 'a': { //add 
                                    boolean sp = true;
                                    while (sp) {
                                        System.out.println("a. Add a Student: "); //done
                                        System.out.println("b. Add Student to Course: "); //done
                                        System.out.println("c. Add Student to Club: "); //done
                                        System.out.println("d. Add Student to Department: "); //done
                                        System.out.println("e. Back: "); //done

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
                                                studentList.add(new Student(sid, sname, semail, scgpa));
                                                System.out.println("Student Added Successfully!");
                                                break;
                                            }
                                            case 'b': {
                                                System.out.print("Enter Student ID to add course: ");
                                                int id = sc.nextInt();
                                                sc.nextLine();
                                                for (int ii = 0; ii < studentList.size(); ii++) {
                                                    if (studentList.get(ii).getId() == id) {
                                                        System.out.print("Enter Course ID: ");
                                                        String cid = sc.nextLine();
                                                        for (int jj = 0; jj < CourseList.size(); jj++) {
                                                            if (Objects.equals(CourseList.get(jj).getCourseId(), cid)) {
                                                                studentList.get(ii).addCourse(CourseList.get(jj));
                                                                CourseList.get(jj).addStudent(studentList.get(ii));
                                                                System.out.println("Course added successfully");
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
                                                for (int ii = 0; ii < studentList.size(); ii++) {
                                                    if (studentList.get(ii).getId() == sid) {
                                                        System.out.print("Enter Club Name: ");
                                                        String cname = sc.nextLine();
                                                        for (int jj = 0; jj < clubList.size(); jj++) {
                                                            if (Objects.equals(clubList.get(jj).getClubName(), cname)) {
                                                                studentList.get(ii).addClub(clubList.get(jj));
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
                                                for (int ii = 0; ii < studentList.size(); ii++) {
                                                    if (studentList.get(ii).getId() == sid) {
                                                        System.out.print("Enter Department Name: ");
                                                        String dname = sc.nextLine();
                                                        for (int jj = 0; jj < departmentList.size(); jj++) {
                                                            if (Objects.equals(departmentList.get(jj).getDepartmentName(), dname)) {
                                                                studentList.get(ii).addDepartment(departmentList.get(jj));
                                                                System.out.println("Department added successfully");
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                }
                                                break;
                                            }

                                            case 'e': { //back
                                                sp = false;
                                                break;
                                            }

                                            default: {
                                                System.out.println("Invalid");
                                                sp = true;
                                                stp = true;
                                                break;
                                            }
                                        }

                                    } //add while end
                                    break;
                                } // a case end

                                case 'b': { //drop b case started
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
                                                for (int i = 0; i < CourseList.size(); i++) {
                                                    if (Objects.equals(CourseList.get(i).getCourseId(), cid)) {
                                                        for (int j = 0; j < studentList.size(); j++) {
                                                            System.out.print("Enter Student ID: ");
                                                            int sid = sc.nextInt();
                                                            if (Objects.equals(studentList.get(j).getId(), sid)) {
                                                                CourseList.get(i).dropStudent(sid);
                                                                studentList.get(j).dropCourse(cid);
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
                                                sp = true;
                                                break;
                                            }
                                        }

                                    }
                                    break;
                                }

                                case 'c': { //search

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

                                                for (Course i : CourseList) {
                                                    if (Objects.equals(i.getCourseId(), cid)) {
                                                        i.display();
                                                        // i.getFaculty().display();
                                                    } else {
                                                        System.out.println("Not Found!");
                                                    }
                                                }

                                                break;
                                            }

                                            case 'b': {
                                                System.out.println("Enter Faculty ID: ");
                                                int fid = sc.nextInt();
                                                for (Faculty i : facultyList) {
                                                    if (fid == i.getId()) {
                                                        i.display();
                                                    } else {
                                                        System.out.println("Not Found!");
                                                    }
                                                }

                                                break;
                                            }
                                            case 'c': {
                                                System.out.print("Enter Club Name: ");
                                                sc.nextLine();
                                                String cname = sc.nextLine();

                                                for (Club i : clubList) {
                                                    if (Objects.equals(i.getClubName(), cname)) {
                                                        i.display();
                                                        // i.getFaculty().display();
                                                    } else {
                                                        System.out.println("Not Found!");
                                                    }
                                                }

                                                break;
                                            }
                                            case 'd': {
                                                System.out.print("Enter Department name: ");
                                                sc.nextLine();
                                                String dname = sc.nextLine();

                                                for (Department i : departmentList) {
                                                    if (Objects.equals(i.getDepartmentName(), dname)) {
                                                        i.display();
                                                        // i.getFaculty().display();
                                                    } else {
                                                        System.out.println("Not Found!");
                                                    }
                                                }

                                                break;
                                            }
                                            case 'e': {
                                                System.out.print("Enter Course Name: ");
                                                String cname = sc.nextLine();

                                                for (Course i : CourseList) {
                                                    if (cname.equals(i.getCourseId())) {
                                                        i.printMarks();
                                                    } else {
                                                        System.out.println("Not Found!");
                                                    }
                                                }
                                                break;
                                            }
                                            case 'f': {
                                                sp = false;
                                                break;
                                            }
                                            default: {
                                                System.out.println("Invalid Input Please Try Again!");
                                                break;
                                            }
                                        }

                                    }

                                    break;
                                }
                                case 'd': { //print
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
                                                for (Student i : studentList) {
                                                    i.display();
                                                }
                                                break;
                                            }
                                            case 'b': {
                                                for (Student i : studentList) {
                                                    i.displayAssignDepartment();

                                                }
                                                break;
                                            }
                                            case 'c': {
                                                for (Student i : studentList) {

                                                    i.displayAssignCourse();

                                                }
                                                break;
                                            }

                                            case 'd': {
                                                for (Student i : studentList) {
                                                    i.displayAssignExamResult();
                                                }
                                                break;
                                            }
                                            case 'e': {
                                                for (Student i : studentList) {

                                                    i.displayAssignClub();
                                                }
                                                break;
                                            }

                                            case 'f': {
                                                sp = false;
                                                break;
                                            }

                                            default: {
                                                System.out.println("Invalid Input Please Try Again!");
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }

                                case 'e': { //back
                                    stp = false;
                                    break;
                                }

                                default: {
                                    System.out.println("Invalid Input Please Try Again!");
                                    stp = true;
                                    break;
                                }
                            }
                        } //student panel while loop ends
                        break;
                    }
                    //case a ended

                    //case b started (Admin & Faculty Panel)
                    case 'b': {
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
                                case 'a': { //add 
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
                                            case 'a': { //add faculty
                                                System.out.print("Enter Faculty ID: ");
                                                int fid = sc.nextInt();
                                                sc.nextLine();
                                                System.out.print("Enter Faculty Name: ");
                                                String fname = sc.nextLine();
                                                System.out.print("Enter Faculty Email: ");
                                                String femail = sc.nextLine();
                                                System.out.print("Enter Faculty Position: ");
                                                String fpos = sc.nextLine();
                                                facultyList.add(new Faculty(fid, fname, femail, fpos));
                                                System.out.println("Faculty Added Successfully!");
                                                break;

                                            }
                                            case 'b': { //add course

                                                sc.nextLine();
                                                System.out.print("Enter Course ID: ");
                                                String cid = sc.nextLine();
                                                System.out.print("Enter Course Title: ");
                                                String ct = sc.nextLine();
                                                System.out.print("Enter Course Credit: ");
                                                double cc = sc.nextDouble();
                                                sc.nextLine();
                                                CourseList.add(new Course(cid, ct, cc));
                                                System.out.println("Course Added Successfully!");
                                                break;
                                            }

                                            case 'c': { //add club
                                                System.out.print("Enter Club Name: ");
                                                sc.nextLine();
                                                String cname = sc.nextLine();
                                                System.out.print("Enter Club Position: ");
                                                String cp = sc.nextLine();
                                                clubList.add(new Club(cname, cp));
                                                System.out.println("Club Added Successfully!");
                                                break;

                                            }

                                            case 'd': {
                                                System.out.print("Enter Department Name: ");
                                                sc.nextLine();
                                                String dname = sc.nextLine();
                                                System.out.print("Enter total Departmental Credit: ");
                                                Double dc = sc.nextDouble();
                                                departmentList.add(new Department(dname, dc));
                                                System.out.println("Department Added Successfully!");
                                                break;
                                            }

                                            case 'e': {
                                                System.out.print("Enter Faculty ID to add Course:");
                                                int fid = sc.nextInt();
                                                sc.nextLine();

                                                for (int ii = 0; ii < facultyList.size(); ii++) {
                                                    if (facultyList.get(ii).getId() == fid) {
                                                        System.out.print("Enter Course ID: ");
                                                        String cid = sc.nextLine();
                                                        for (int jj = 0; jj < CourseList.size(); jj++) {
                                                            if (Objects.equals(CourseList.get(jj).getCourseId(), cid)) {
                                                                facultyList.get(ii).addCourse(CourseList.get(jj));
                                                                CourseList.get(jj).addFaculty(facultyList.get(ii));
                                                                System.out.println("Course added successfully");
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                }
                                                break;
                                                // facultyList.
                                            }

                                            case 'f': {
                                                System.out.print("Enter Faculty ID to add Club:");
                                                int fid = sc.nextInt();
                                                sc.nextLine();

                                                for (int ii = 0; ii < facultyList.size(); ii++) {
                                                    if (facultyList.get(ii).getId() == fid) {
                                                        System.out.print("Enter Club Name: ");
                                                        String cname = sc.nextLine();
                                                        for (int jj = 0; jj < clubList.size(); jj++) {
                                                            if (Objects.equals(clubList.get(jj).getClubName(), cname)) {
                                                                facultyList.get(ii).addClub(clubList.get(jj));
                                                                System.out.println("Club added successfully");
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                }
                                                break;

                                            }

                                            case 'g': {
                                                System.out.print("Enter Faculty ID to add Department:");
                                                int fid = sc.nextInt();
                                                sc.nextLine();

                                                for (int ii = 0; ii < facultyList.size(); ii++) {
                                                    if (facultyList.get(ii).getId() == fid) {
                                                        System.out.print("Enter Department Name: ");
                                                        String dname = sc.nextLine();
                                                        for (int jj = 0; jj < departmentList.size(); jj++) {
                                                            if (Objects.equals(departmentList.get(jj).getDepartmentName(), dname)) {
                                                                facultyList.get(ii).addDepartment(departmentList.get(jj));
                                                                System.out.println("Department added successfully");
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                }
                                                break;
                                            }

                                            case 'h': {//result 
                                                System.out.print("Enter Student ID: ");
                                                int sid = sc.nextInt();
                                                sc.nextLine();
                                                System.out.print("Enter Course ID to add Exam Results:");
                                                String cid = sc.nextLine();

                                                System.out.println("Enter Mid 1 Result: ");
                                                double mid1 = sc.nextInt();
                                                System.out.println("Enter Mid 2 Result: ");
                                                double mid2 = sc.nextInt();
                                                System.out.println("Enter Final Result: ");
                                                double finall = sc.nextInt();
                                                resultList.add(new ExamResult(cid, mid1, mid2, finall));

                                                for (int j = 0; j < resultList.size(); j++) {
                                                    if (Objects.equals(resultList.get(j).getCourseName(), cid)) {
                                                        for (int i = 0; i < CourseList.size(); i++) {
                                                            if (Objects.equals(CourseList.get(i), cid)) {
                                                                for (int k = 0; k < studentList.size(); k++) {
                                                                    CourseList.get(i).addMarks(resultList.get(j));
                                                                    studentList.get(k).addExamMarks(resultList.get(j));
                                                                    break;
                                                                }

                                                            }
                                                        }
                                                    }
                                                }

                                                break;
                                            }

                                            case 'i': { //back
                                                sp = false;
                                                break;
                                            }

                                            default: {
                                                System.out.println("Invalid Input");
                                                sp = true;
                                                stp = true;
                                                break;
                                            }
                                        }

                                    } //add while end
                                    break;
                                } // a case end
                                case 'b': { //drop b case started
                                    boolean sp = true;
                                    while (sp) {
                                        System.out.println("a. Drop Student From Course: ");
                                        System.out.println("b. Drop Faculty From Course: ");
                                        System.out.println("c. Back: ");
                                        char drop = sc.next().charAt(0);
                                        switch (drop) {
                                            case 'a': {
                                                System.out.print("Enter Course ID: ");
                                                sc.nextLine();
                                                String cid = sc.nextLine();
                                                for (int i = 0; i < CourseList.size(); i++) {
                                                    if (Objects.equals(CourseList.get(i).getCourseId(), cid)) {
                                                        for (int j = 0; j < studentList.size(); j++) {
                                                            System.out.print("Enter Student ID: ");
                                                            int sid = sc.nextInt();
                                                            if (Objects.equals(studentList.get(j).getId(), sid)) {
                                                                CourseList.get(i).dropStudent(sid);
                                                                studentList.get(j).dropCourse(cid);
                                                                System.out.println("Dropped Successfully!");
                                                                break;
                                                            }
                                                        }

                                                    }
                                                }
                                                break;
                                            }

                                            case 'b': {
                                                System.out.print("Enter Faculty ID: ");
                                                int fid = sc.nextInt();
                                                sc.nextLine();

                                                for (int i = 0; i < facultyList.size(); i++) {
                                                    if (Objects.equals(facultyList.get(i).getId(), fid)) {
                                                        System.out.print("Enter Course ID: ");
                                                        String cid = sc.nextLine();
                                                        for (int j = 0; j < CourseList.size(); j++) {
                                                            if (Objects.equals(CourseList.get(i).getCourseId(), cid)) {
                                                                CourseList.get(j).dropFaculty();
                                                                facultyList.get(i).dropCourse(cid);
                                                                System.out.println("Dropped Successfully!");
                                                                break;
                                                            } else {
                                                                System.out.println("Failed to Drop!");
                                                            }
                                                        }

                                                    }
                                                }
                                                break;

                                            }

                                            case 'c': {
                                                sp = false;
                                                break;
                                            }

                                            default: {
                                                System.out.println("Invalid Input Try Again!");
                                                sp = true;
                                                break;
                                            }
                                        }

                                    }
                                    break;
                                }

                                case 'c': {

                                    boolean sp = true;
                                    while (sp) {

                                        System.out.println("\nUpdate Menu");
                                        System.out.println("a. Update Student Info: ");
                                        System.out.println("b. Update Course Info: ");
                                        System.out.println("c. Update Faculty Info: ");
                                        System.out.println("d. Update Club Info: ");
                                        System.out.println("e. Update Department Info: ");
                                        System.out.println("f. Back: ");

                                        System.out.print("Enter your choice: ");
                                        char ucc = sc.next().charAt(0);

                                        switch (ucc) {

                                            case 'a': {

                                                System.out.print("Enter Student ID to update: ");
                                                int studentId = sc.nextInt();
                                                sc.nextLine();

                                                for (int i = 0; i < studentList.size(); i++) {
                                                    if (studentList.get(i).getId() == studentId) {
                                                        System.out.print("Enter Student's new ID: ");
                                                        int sid = sc.nextInt();
                                                        sc.nextLine();
                                                        studentList.get(i).setId(sid);
                                                        System.out.print("Enter Student's new Name: ");
                                                        String sname = sc.nextLine();
                                                        studentList.get(i).setName(sname);
                                                        System.out.print("Enter Student's new Email: ");
                                                        String smail = sc.nextLine();
                                                        studentList.get(i).setEmail(smail);
                                                        System.out.print("Enter Student's new CGPA: ");
                                                        Double sCGPA = sc.nextDouble();
                                                        studentList.get(i).setStudentCGPA(sCGPA);
                                                        System.out.println("ID successfully updated for: " + sid);
                                                        break;
                                                    } else {
                                                        System.out.println("Not found");
                                                    }
                                                }
                                                break;
                                            }

                                            case 'b': {

                                                System.out.print("Enter Course ID to update: ");
                                                String courseId = sc.nextLine();

                                                for (int i = 0; i < CourseList.size(); i++) {
                                                    if (CourseList.get(i).getCourseId().equals(courseId)) {
                                                        System.out.print("Enter Course's new ID:");
                                                        String cid = sc.nextLine();
                                                        CourseList.get(i).setCourseId(cid);
                                                        System.out.println("Enter Course's new Title: ");
                                                        String ct = sc.nextLine();
                                                        CourseList.get(i).setCourseTitle(ct);
                                                        System.out.println("Enter Course's new Credit: ");
                                                        double cc = sc.nextDouble();
                                                        CourseList.get(i).setCredit(cc);
                                                        System.out.println("ID successfully updated for: " + cid);
                                                        break;
                                                    } else {
                                                        System.out.println("Not found");
                                                    }
                                                }
                                                break;
                                            }

                                            case 'c': {

                                                System.out.print("Enter Faculty ID to update: ");
                                                int facultyId = sc.nextInt();
                                                sc.nextLine();

                                                for (int i = 0; i < facultyList.size(); i++) {
                                                    if (facultyList.get(i).getId() == facultyId) {
                                                        System.out.print("Enter Faculty's new ID: ");
                                                        int fid = sc.nextInt();
                                                        sc.nextLine();
                                                        facultyList.get(i).setId(fid);

                                                        System.out.print("Enter Faculty's new Name: ");
                                                        String fname = sc.nextLine();
                                                        facultyList.get(i).setName(fname);
                                                        System.out.print("Enter Faculty's new Email: ");
                                                        String fmail = sc.nextLine();
                                                        facultyList.get(i).setEmail(fmail);
                                                        System.out.print("Enter Faculty's new Position: ");
                                                        String fpos = sc.nextLine();
                                                        facultyList.get(i).setFacultyPosition(fpos);
                                                        System.out.println("ID successfully updated for: " + fid);
                                                        break;
                                                    } else {
                                                        System.out.println("Not found");
                                                    }
                                                }
                                                break;
                                            }
                                            case 'd': {
                                                System.out.print("Enter Club Name to update: ");
                                                String cn = sc.nextLine();

                                                for (int i = 0; i < clubList.size(); i++) {
                                                    if (clubList.get(i).getClubName().equals(cn)) {
                                                        System.out.print("Enter Club's new Name:");
                                                        String cname = sc.nextLine();
                                                        clubList.get(i).setClubName(cname);
                                                        System.out.println("Club name successfully updated for: " + cname);
                                                        break;
                                                    } else {
                                                        System.out.println("Not found");
                                                    }
                                                }
                                                break;
                                            }
                                            case 'e': {
                                                System.out.print("Enter Department Name to update: ");
                                                String dn = sc.nextLine();

                                                for (int i = 0; i < departmentList.size(); i++) {
                                                    if (departmentList.get(i).getDepartmentName().equals(dn)) {
                                                        System.out.print("Enter Department's new Name:");
                                                        String dname = sc.nextLine();
                                                        departmentList.get(i).setDepartmentName(dname);
                                                        System.out.println("Department name successfully updated for: " + dname);
                                                        break;
                                                    } else {
                                                        System.out.println("Not found");
                                                    }
                                                }
                                                break;
                                            }
                                            case 'f': {
                                                sp = false;
                                                break;
                                            }

                                            default: {
                                                sp = true;
                                                break;
                                            }

                                        }
                                    }

                                    break;
                                }
                                //case c end update end
                                case 'd': { //search
                                    boolean sp = true;
                                    while (sp) {
                                        System.out.println("a. Search Course: ");
                                        System.out.println("b. Search Faculties: ");
                                        System.out.println("c. Search Club: ");
                                        System.out.println("d. Search Department: ");
                                        System.out.println("e. Search Course Result: ");
                                        System.out.println("f. Search Whether a faculty teaches a Course: ");
                                        System.out.println("h. Search Courses taken by student: ");
                                        System.out.println("i. Back: ");
                                        char ps = sc.next().charAt(0);
                                        switch (ps) {
                                            case 'a': {
                                                System.out.print("Enter Course ID: ");
                                                sc.nextLine();
                                                String cid = sc.nextLine();

                                                for (Course i : CourseList) {
                                                    if (Objects.equals(i.getCourseId(), cid)) {
                                                        i.display();
                                                    } else {
                                                        System.out.println("Not Found!");
                                                    }
                                                }

                                                break;
                                            }

                                            case 'b': {
                                                System.out.println("Enter Faculty ID: ");
                                                int fid = sc.nextInt();
                                                for (Faculty i : facultyList) {
                                                    if (fid == i.getId()) {
                                                        i.display();
                                                    } else {
                                                        System.out.println("Not Found!");
                                                    }
                                                }

                                                break;
                                            }
                                            case 'c': {
                                                System.out.print("Enter Club Name: ");
                                                sc.nextLine();
                                                String cname = sc.nextLine();

                                                for (Club i : clubList) {
                                                    if (Objects.equals(i.getClubName(), cname)) {
                                                        i.display();
                                                    } else {
                                                        System.out.println("Not Found!");
                                                    }
                                                }

                                                break;
                                            }
                                            case 'd': {
                                                System.out.print("Enter Department Name: ");
                                                sc.nextLine();
                                                String dname = sc.nextLine();

                                                for (Department i : departmentList) {
                                                    if (Objects.equals(i.getDepartmentName(), dname)) {
                                                        i.display();
                                                    } else {
                                                        System.out.println("Not Found!");
                                                    }
                                                }

                                                break;
                                            }
                                            case 'e': { //exam result search
                                                System.out.println("Enter Student ID: ");
                                                
                                                int sid = sc.nextInt();

                                                for(Student i: studentList){
                                                    if(Objects.equals(i.getId(), sid)){
                                                        System.out.print("Enter Course ID: ");
                                                        String cid = sc.nextLine();
                                                        for(Course j: CourseList){
                                                            if(Objects.equals(j.getCourseId(), cid)){
                                                                j.printMarks();
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }

                                                break;
                                            }

                                            case 'f': {
                                                System.out.print("Enter Faculty ID: ");
                                                int fid = sc.nextInt();
                                                sc.nextLine();
                                                for (Faculty i : facultyList) {
                                                    if (fid == i.getId()) {
                                                        System.out.print("Enter Course ID: ");
                                                        String cid = sc.nextLine();
                                                        for (Course c : CourseList) {
                                                            if (Objects.equals(c.getCourseId(), cid)) {
                                                                i.display();
                                                            }
                                                        }

                                                    } else {
                                                        System.out.println("Not Found!");
                                                    }
                                                }
                                                break;
                                            }
                                            case 'h': {
                                                System.out.print("Enter Course ID: ");
                                                sc.nextLine();
                                                String cid = sc.nextLine();
                                                for (Course c : CourseList) {
                                                    if (Objects.equals(c.getCourseId(), cid)) {
                                                        System.out.println("Enter Student ID: ");
                                                        int sid = sc.nextInt();
                                                        for (Student s : studentList) {
                                                            if (sid == s.getId()) {
                                                                s.display();
                                                                s.displayAssignCourse();

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
                                            default: {
                                                System.out.println("Invalid Input Please Try Again!");
                                                break;
                                            }
                                        }

                                    }

                                    break;
                                }
                                case 'e': {
                                    //print

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
                                                for (int bb = 0; bb < studentList.size(); bb++) {
                                                    System.out.println("(" + bb + ")");
                                                    studentList.get(bb).display();
                                                    studentList.get(bb).displayAssignClub();
                                                    studentList.get(bb).displayAssignDepartment();
                                                    studentList.get(bb).displayAssignCourse();
                                                }
                                                break;
                                            }
                                            case 'b': {
                                                System.out.println("All Faculty Members: ");
                                                for (int bb = 0; bb < facultyList.size(); bb++) {
                                                    System.out.println("(" + bb + ")");
                                                    facultyList.get(bb).display();
                                                    facultyList.get(bb).displayAssignCourse();
                                                    facultyList.get(bb).displayAssignClub();
                                                    facultyList.get(bb).displayAssignDepartment();

                                                }
                                                break;
                                            }
                                            case 'c': {
                                                System.out.println("All Courses :");
                                                for (int bb = 0; bb < CourseList.size(); bb++) {
                                                    System.out.println("(" + bb + ")");
                                                    CourseList.get(bb).display();
                                                    CourseList.get(bb).getFaculty();
                                                    System.out.println(CourseList.get(bb).getNumberOfStudent());
                                                    CourseList.get(bb).getStudentList();
                                                }
                                                break;
                                            }

                                            case 'd': {
                                                sp = false;
                                                break;
                                            }

                                            default: {
                                                System.out.println("Invalid Input Please Try Again!");
                                                break;
                                            }
                                        }
                                    }
                                    break;

                                }
                                case 'f': { //back
                                    stp = false;
                                    break;
                                }

                                default: {
                                    System.out.println("Invalid Input Please Try Again!");
                                    stp = true;
                                    break;
                                }
                            }
                        } //admin panel while loop ends
                        break;
                    }
                    //case b ended

                    //Case 0 started (Exit)
                    case '0': {
                        res = false;
                        break;
                    }
                    //Case 0 Ended

                    default: {
                        System.out.println("Invalid Input Try Again!");
                        res = true;
                        break;
                    }

                } // main switch ended

                //main switch started
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
