# Design Pattern Implementation Branch – README

## Overview

This branch demonstrates the **application of multiple design patterns** to improve the overall architecture of the University Management System.  
Each pattern was introduced to solve **specific structural and design limitations** found in the earlier version of the project.

The focus of this branch is not just to use design patterns, but to use them **correctly, meaningfully, and where they actually improve the code**—in terms of readability, extensibility, and maintainability.

All explanations below are strictly based on the provided implementation.

---

## Objectives of This Refactor

- Reduce tight coupling between classes  
- Simplify object creation and system workflows  
- Centralize shared responsibilities  
- Improve extensibility without modifying existing code  
- Make the codebase easier to understand, modify, and scale  

---

## Design Patterns Implemented

---

## 1. Singleton Pattern  
**Class:** `UniversityData`

### Why It Was Implemented

Previously, `UniversityData` could be instantiated multiple times. This could lead to:
- Multiple copies of students, courses, faculties, etc.  
- Inconsistent system state  
- No single source of truth for application data  

In a university management system, **there must be exactly one shared data store**.

### How It Was Implemented

- A private static instance variable  
- A private constructor to prevent external instantiation  
- A public `getInstance()` method for controlled access  

### How It Improves the Previous Code

- Ensures **only one instance** of `UniversityData` exists  
- Prevents accidental duplication of system data  
- Guarantees data consistency across the entire application  

### Key Benefits of Singleton Here

- Centralized data management  
- Controlled global access  
- Improved data integrity  
- Safer architecture for shared resources  

---


## 2. Builder Pattern  
**Classes:**  
- `Student.StudentBuilder`  
- `Faculty.FacultyBuilder`  
- `Course.Builder`  

### Why It Was Implemented

Previously, object creation relied on:
- Long constructors  
- Many parameters  
- Strict parameter ordering
- Adding new feature is difficult because have to modify constructor

This caused:
- Poor readability  
- High risk of mistakes  
- Difficulty adding new fields later  

### How It Was Implemented

Each major entity provides a **Builder class** that constructs objects **step by step** using meaningful method calls.


Student student = new Student.StudentBuilder()
    .setId(id)
    .setName(name)
    .setEmail(email)
    .setStudentCGPA(cgpa)
    .setCourseManager(mediator)
    .build();

### How It Improves the Previous Code

- Adding new feature is easier with builder
- Object creation becomes clear and self-explanatory
- No confusion about constructor parameter order  
- Mandatory and optional fields are handled safely  
- Objects are always created in a valid state  

---

### Why Builder Is Especially Important Here

- The system contains complex domain objects such as `Student`, `Faculty`, and `Course`  
- These objects may gain additional attributes in the future  
- Builder allows adding new features without modifying existing constructors  
- Step-by-step construction makes object creation easier to understand and maintain  

---

### Key Benefits of Builder Pattern Here

- Step-by-step object construction  
- Greatly improved readability  
- Safer object initialization  
- Easy to extend without breaking existing code  
- Eliminates constructor overloading problems  

---

## 3. Mediator Pattern  
**Class:** `CourseMediator`

### Why It Was Implemented

Before introducing the Mediator:
- Students, faculty, and courses interacted directly  
- Enrollment, dropping, and assignment logic was scattered  
- Changes in one class affected many others  

This resulted in:
- Tight coupling  
- Difficult maintenance  
- Poor separation of responsibilities  

---

### How It Was Implemented

`CourseMediator`:
- Acts as a central communication hub  
- Manages course creation  
- Handles student enrollment and removal  
- Assigns and removes faculty  
- Manages exam result handling  
- Publishes system events using an `EventBus`  

---

### How It Improves the Previous Code

- Entities no longer communicate directly  
- All coordination logic exists in one place  
- Business rules become easier to manage and modify  

---

### Key Benefits of Mediator Here

- Reduced inter-class dependencies  
- Centralized control of complex workflows  
- Easier debugging and extension  
- Cleaner and more modular architecture  

---

## 4. Abstract Factory Pattern  

**Classes:**  
- `UniversityUIFactory`  
- `ConsoleUIFactory`  

### Why It Was Implemented

Previously:
- UI components were created directly using `new`  
- Switching to a different UI required code changes everywhere  

This violated the **Open–Closed Principle**.

---

### How It Was Implemented

- Defined a factory interface for UI components  
- Implemented `ConsoleUIFactory` to produce all required views  


UniversityUIFactory factory = new ConsoleUIFactory();
StudentView studentView = factory.createStudentView();

### How It Improves the Previous Code

- UI creation logic is centralized  
- New UI types (GUI, Web) can be added without modifying existing code  
- Client code depends on abstraction, not concrete implementations  

---

### Key Benefits of Abstract Factory Here

- Loose coupling between UI and business logic  
- Easy UI replacement or extension  
- Cleaner and more scalable design  
- Strong adherence to the Open–Closed Principle  

---

## Overall Improvements Achieved

- Clear separation of concerns  
- Reduced coupling across the system  
- Safer and clearer object creation  
- Centralized coordination logic  
- Highly extensible architecture  
- Strong alignment with SOLID and GoF principles  

---

## Branch Purpose

This branch exists to demonstrate **correct, necessary, and justified use of design patterns** within a real project.  
Each pattern was chosen to solve a **real design problem**, not for theoretical demonstration.

This branch represents a shift from:

**“Working code” → “Well-structured, maintainable architecture”**
