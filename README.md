# SOLID Principles Refactoring – SOLID Branch

## Overview

This branch contains the **SOLID-principle–compliant refactoring** of the original project.  
The goal of this refactor was to improve **code quality, maintainability, extensibility, and testability** by strictly applying all five **SOLID principles**.

All business logic, domain models, persistence, presentation, and application bootstrapping responsibilities have been **clearly separated**, while preserving the core functionality of the original system.

---

## Purpose of This Branch

- Apply **all five SOLID principles** correctly  
- Remove tight coupling and large responsibility-heavy classes  
- Improve readability and future extensibility  
- Demonstrate proper **object-oriented design** practices  
- Meet the instructor’s refactoring and documentation requirements  

> **Note:**  
> This branch only contains the **SOLID-applied implementation**.  
> The original implementation remains unchanged in the main / previous branch.

---

## Project Structure (After Refactoring)

```text
solid_refactor/
│
├── app/
│   └── MainApp.java
│
├── model/
│   ├── Person.java
│   ├── Student.java
│   ├── Faculty.java
│   ├── Course.java
│   ├── Department.java
│   ├── Club.java
│   └── ExamResult.java
│
├── repo/
│   ├── CourseRepository.java
│   └── InMemoryCourseRepository.java
│
├── service/
│   ├── CourseService.java
│   ├── GradeStrategy.java
│   └── StandardGradeStrategy.java
│
├── ui/
│   └── CoursePrinter.java
│
└── originals/
    └── (Original files preserved for comparison)
```
## SOLID Principles Application

---

## 1. Single Responsibility Principle (SRP)

**Definition:**  
A class should have **only one reason to change**.

### What Was Done

- Domain classes (`Student`, `Course`, `Faculty`, etc.) now **only store data**
- Business logic moved into **service classes**
- Printing and output logic moved into **UI classes**
- Persistence logic separated into **repository classes**

### Example

- `CourseService` → handles course-related business logic  
- `CoursePrinter` → handles displaying courses  
- `CourseRepository` → handles data storage  

This ensures that changes in UI, persistence, or business rules do not affect each other.

---

## 2. Open/Closed Principle (OCP)

**Definition:**  
Classes should be **open for extension** but **closed for modification**.

### What Was Done

- Introduced the `GradeStrategy` interface
- Implemented `StandardGradeStrategy` as one grading rule
- New grading rules can be added **without modifying existing code**

### Example

```java
public interface GradeStrategy {
    String grade(ExamResult r);
}
```
To add a new grading system, only a new class implementing GradeStrategy is needed.

## 3. Liskov Substitution Principle (LSP)

**Definition:**  
Objects of a superclass should be replaceable with objects of its subclasses **without breaking the system**.

### What Was Done

- `Student` and `Faculty` correctly extend `Person`
- No overridden methods violate expected behavior
- Subclasses do not weaken or change base class contracts

### Result

Any method that works with `Person` can safely work with `Student` or `Faculty`.

---

## 4. Interface Segregation Principle (ISP)

**Definition:**  
Clients should not be forced to depend on methods they do not use.

### What Was Done

- Large “manager” responsibilities were broken into **small, focused interfaces**
- `CourseRepository` only contains persistence-related methods
- Services depend only on the interfaces they actually require

### Benefit

Classes remain lightweight and easy to understand, implement, and test.

---

## 5. Dependency Inversion Principle (DIP)

**Definition:**  
High-level modules should depend on **abstractions**, not concrete implementations.

### What Was Done

- `CourseService` depends on `CourseRepository` interface
- Concrete implementation (`InMemoryCourseRepository`) is injected
- `MainApp` handles object creation and dependency wiring

### Example

```java
public CourseService(CourseRepository repository) {
    this.repository = repository;
}
```
This allows switching storage mechanisms (file, database, API) without modifying business logic

## Overall Improvements Achieved

- Clear separation of concerns across domain models, services, repositories, and UI components  
- Reduced tight coupling between classes through interface-based design  
- Improved code readability and maintainability  
- Easier extensibility for future features (new grading strategies, repositories, reports)  
- Better testability due to dependency injection and modular components  
- Elimination of large, responsibility-heavy classes  
- Proper adherence to all five SOLID principles  

---

## Branch Purpose – With_SOLID

The **With_SOLID** branch contains the fully refactored version of the project where **all SOLID principles have been correctly applied**.

This branch was created to:

- Demonstrate the practical application of SOLID principles in a real Java project  
- Improve overall software design quality and architecture  
- Serve as a clean, maintainable, and extensible version of the system  
- Provide a clear comparison against the original implementation  
- Fulfill academic requirements for code refactoring and documentation  

The original, non-refactored implementation is preserved in the without_solid branch for reference and comparison.
