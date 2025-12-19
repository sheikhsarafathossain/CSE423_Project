Architectural Pattern: Model-View-Controller (MVC)
The project is implemented using the Model-View-Controller (MVC) architectural pattern. This pattern separates the application into three main logical components to separate internal representations of information from the ways information is presented to and accepted from the user.
1. The Components
Model (The Data & Logic)
•	What it is: Represents the data and the rules of the application. It is independent of the user interface.
•	Classes: UniversityData (The data store), Student, Faculty, Course, Club, Department, ExamResult.
•	Responsibility: Storing the state of the university (lists of students, courses, etc.) and handling core logic (like calculating a CGPA).
View (The User Interface)
•	What it is: Responsible for displaying data to the user.
•	Classes: StudentView, CourseView, FacultyView, ClubView, DepartmentView, ExamResultView.
•	Responsibility: Formatting the output strings (e.g., System.out.println("Student Name: " + name)). The Views do not handle user input or make decisions.
Controller (The Coordinator)
•	What it is: The "brain" that accepts user input, converts it into commands for the Model or View.
•	Classes: AppController, StudentController, AdminController.
•	Responsibility:
o	Reading input from Scanner.
o	Deciding which menu to show.
o	Calling the Model to update data (e.g., adding a student).
o	Calling the View to display data (e.g., printing student details).

Detailed Implementation Breakdown
1. The "Front Controller" Entry Point
Class: AppController (and MainClass)
•	How it works:
o	MainClass is now just a launcher. It instantly hands control to AppController.
o	AppController acts as the Root Controller. It initializes the shared resources (the UniversityData singleton, the Scanner, and the Views).
o	It manages the High-Level Navigation (switching between Student Panel and Admin Panel).
2. Dependency Injection
Notice that AppController creates the dependencies once and passes them down. This is Dependency Injection.
Java
// Inside AppController
new StudentController(sc, db, studentView, ...).run();
•	Benefit: StudentController doesn't need to know how to create a database connection or a view; it just receives them. This makes the code testable and flexible.
3. Specialized Controllers
We split the massive MainClass logic into two focused controllers:
StudentController
•	Pattern: Page Controller / Feature Controller.
•	Role: Handles everything related to the 'Student Panel'.
•	Logic: Contains the case 'a' switch block from the original code. It loops until the user presses 'back'.
AdminController
•	Pattern: Page Controller / Feature Controller.
•	Role: Handles everything related to the 'Admin & Faculty Panel'.
•	Logic: Contains the case 'b' switch block from the original code.
•	
Why this is better?
1. Single Responsibility Principle (SRP):
•	MainClass is no longer responsible for everything.
•	StudentController only cares about students.
•	AdminController only cares about admin tasks.
2. Maintainability:
If you want to change how the "Add Course" feature works, you know exactly where to go: AdminController. You don't have to scroll through 600 lines of mixed code.
3. Scalability:
If you want to add a "Guest Panel" later, you just create a GuestController and add one line to AppController. You don't risk breaking the existing Student/Admin logic.

Diagram (Structure & Flow)
Below is a textual representation of the class relationships and flow:
1.	MainClass (+main())
o	Starts → AppController
2.	AppController (-UniversityData db, -Scanner sc, +run())
o	Routes to → StudentController
o	Routes to → AdminController
3.	StudentController (+run(), -addStudent(), -dropCourse())
o	Modifies Data → UniversityData
o	Updates UI → StudentView
4.	AdminController (+run(), -addFaculty(), -addCourse())
o	Modifies Data → UniversityData
o	Updates UI → CourseView