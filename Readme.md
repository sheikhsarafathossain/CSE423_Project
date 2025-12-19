## Architectural Pattern: Model-View-Controller (MVC)

The project is implemented using the **Model-View-Controller (MVC)** architectural pattern.  
This pattern separates the application into three main logical components, ensuring a clear separation between **data management**, **user interface**, and **application control flow**. As a result, internal representations of information are kept independent from how information is presented to or accepted from the user.

---

## 1. MVC Components

### Model (Data & Business Logic)

**What it is:**  
Represents the data and core rules of the application. The Model is completely independent of the user interface.

**Classes:**
- `UniversityData` (central data store)
- `Student`
- `Faculty`
- `Course`
- `Club`
- `Department`
- `ExamResult`

**Responsibilities:**
- Store the state of the university (students, courses, faculties, etc.)
- Handle core business logic (e.g., CGPA calculation)

---

### View (User Interface)

**What it is:**  
Responsible for presenting data to the user in a readable format.

**Classes:**
- `StudentView`
- `CourseView`
- `FacultyView`
- `ClubView`
- `DepartmentView`
- `ExamResultView`

**Responsibilities:**
- Format output for display (e.g., `System.out.println("Student Name: " + name)`)
- Display data received from controllers
- Do **not** process user input or make decisions

---

### Controller (Application Coordinator)

**What it is:**  
Acts as the intermediary between the Model and the View. Controllers receive user input and translate it into actions on the Model and View.

**Classes:**
- `AppController`
- `StudentController`
- `AdminController`

**Responsibilities:**
- Read user input using `Scanner`
- Decide which menu or panel to display
- Call Model methods to update data (e.g., adding a student)
- Call View methods to display results (e.g., printing student details)

---

## Detailed Implementation Breakdown

---

## 1. Front Controller (Entry Point)

**Classes:** `MainClass`, `AppController`

### How It Works

- `MainClass` acts only as a **launcher**
- Control is immediately transferred to `AppController`
- `AppController` functions as the **Root Controller**
- Initializes shared resources:
  - `UniversityData` (singleton data store)
  - `Scanner`
  - View classes
- Manages high-level navigation between:
  - Student Panel
  - Admin Panel

---

## 2. Dependency Injection

`AppController` creates shared dependencies once and passes them to child controllers.  
This approach follows the **Dependency Injection** principle.

### Example

```java
// Inside AppController
new StudentController(sc, db, studentView, ...).run();
```
## Benefits

- Controllers do not create their own dependencies
- Improves testability and flexibility
- Reduces coupling between components

---

## 3. Specialized Controllers

The large logic previously inside `MainClass` was split into smaller, focused controllers.

### StudentController

- **Pattern:** Page Controller / Feature Controller
- **Role:** Manages all student-related operations
- **Logic:** Handles the student menu loop until the user chooses to go back

---

### AdminController

- **Pattern:** Page Controller / Feature Controller
- **Role:** Manages admin and faculty operations
- **Logic:** Handles the admin menu functionality

---

## Why This Design Is Better

### 1. Single Responsibility Principle (SRP)

- `MainClass` no longer handles application logic
- `StudentController` focuses only on student-related features
- `AdminController` focuses only on administrative tasks

---

### 2. Maintainability

- Feature-specific logic is easy to locate
- Modifying features like **Add Course** only requires changes in `AdminController`
- No need to search through large, mixed code files

---

### 3. Scalability

- New panels (e.g., Guest Panel) can be added by creating a new controller
- Only a single routing change is needed in `AppController`
- Existing functionality remains unaffected

---

## Diagram (Structure & Flow)

Below is a textual representation of the class relationships and control flow:

### MainClass (`main()`)

- Starts → `AppController`

### AppController

- Holds → `UniversityData`, `Scanner`
- Routes to → `StudentController`
- Routes to → `AdminController`

### StudentController

- Modifies Data → `UniversityData`
- Updates UI → `StudentView`

### AdminController

- Modifies Data → `UniversityData`
- Updates UI → `CourseView`
