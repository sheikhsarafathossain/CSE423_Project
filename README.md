Implementation of SOLID Principles

S - Single Responsibility Principle (SRP)

The Problem:

My entity classes were violating SRP by handling multiple distinct tasks. For example, ExamResult.java was not only storing grades but also managing a list of courses. Similarly, Student.java contained System.out.println statements, meaning a change in UI requirements would force me to open and modify a backend data class.

The Solution:

I decoupled the codebase by assigning single responsibilities:

UI Separation: I removed all display() methods from the entities. I created dedicated "View" classes (e.g., StudentView, ClubView) solely responsible for formatting and printing data.

Logic Isolation: I moved the data storage lists out of MainClass and into a dedicated UniversityData class, which now acts as the single source of truth for the system's state.

Data Purity: I stripped ExamResult of unrelated logic, ensuring it serves only as a data packet for exam scores.

O - Open/Closed Principle (OCP)

The Problem:

The system was not "Closed for Modification." If the university decided to change the maximum capacity of a course from 40 to 60, I would have to modify the source code of the Course class and recompile the application.

The Solution:

I made the system "Open for Extension" by introducing dynamic configuration:

Dynamic Capacity: I modified the Course constructor to accept a capacity integer. This allows me to create different course instances with different limits (e.g., a Lab with 20 seats vs. a Theory class with 100) without ever touching the Course class code again.

Configurable Faculty Load: Similarly, I added a maxCourseLoad attribute to the Faculty class, allowing dynamic assignment limits per professor.

L - Liskov Substitution Principle (LSP)

The Problem:

I needed to ensure that Student and Faculty entities could be treated interchangeably where appropriate (e.g., in a general "Person" search), without causing runtime errors or requiring complex if-else checks.

The Solution:

I introduced an abstract base class, Person, containing shared attributes like id, name, and email. Both Student and Faculty extend this class. This ensures that any component designed to handle a Person can seamlessly process both students and faculty members, adhering to strict polymorphism.

I - Interface Segregation Principle (ISP)

The Problem:

A generic "UserActions" interface would have forced users to implement methods irrelevant to their role. For instance, a Student does not need an assignCourse() method (which is a Faculty task), and a Faculty member does not need an enrollCourse() method.

The Solution:

I split the behaviors into role-specific interfaces:

StudentActions Interface: Defines enrollCourse() and dropCourse().

FacultyActions Interface: Defines assignCourse() and withdrawCourse().

CourseManager Implementation: The manager implements both interfaces, but the Student class only interacts with the StudentActions methods, ensuring they are never exposed to irrelevant functionality.

D - Dependency Inversion Principle (DIP)

The Problem:

My high-level modules (like Student) were dependent on low-level modules (like CourseManager) by directly instantiating them (new CourseManager()). This created a rigid dependency chain.

The Solution:

I implemented Dependency Injection:

Instead of the Student creating the CourseManager, the manager is created in the MainClass (the entry point) and passed into the Student constructor.

This "inverts" the control. The Student class now relies on an abstraction (the injected object) rather than a concrete implementation it creates itself. This makes the codebase significantly easier to test and maintain.
