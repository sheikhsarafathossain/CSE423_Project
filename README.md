# Code Smell Removal Branch – README

## Overview

This branch focuses on **systematic code smell identification and refactoring** of the University Management System.  
The goal of this refactor was to improve **readability, maintainability, extensibility, and design quality** without changing the system’s external behavior.

All changes follow **clean code practices** and **SOLID principles**, ensuring the codebase is easier to understand, test, and extend.

---

## Refactoring Objectives

- Remove redundant fields and logic  
- Improve naming clarity and domain meaning  
- Enforce proper separation of concerns  
- Replace rigid implementations with flexible abstractions  
- Simplify collection handling and logic  
- Align model–view responsibilities  

---

## Key Design Improvements Applied

- **SRP (Single Responsibility Principle)**  
- **OCP (Open–Closed Principle)**  
- **ISP (Interface Segregation Principle)**  
- **Encapsulation & Information Hiding**  
- **Use of Interfaces over Concrete Implementations**  
- **Removal of Redundant State & Primitive Obsession**

---

## File-Wise Refactoring Summary

### 1. `Club.java` & `ClubView.java`

**Problems Identified**
- Ambiguous attribute naming (`clubPosition`)
- Domain meaning unclear

**Refactoring Applied**
- Renamed `clubPosition` → `memberRole`
- Improved semantic clarity
- View updated to reflect correct domain terminology

**Benefit**
- Improved readability and domain expressiveness

---

### 2. `Course.java`

**Problems Identified**
- Redundant student counter
- Hardcoded logic
- Tight coupling to `ArrayList`
- Manual iteration for removal

**Refactoring Applied**
- Removed redundant `numberOfStudent`
- Used `List` interface instead of `ArrayList`
- Dynamic capacity checking
- Replaced loops with `removeIf()`
- Separated data and logic cleanly

**Principles Applied**
- SRP, OCP, Encapsulation

---

### 3. `CourseManager.java`

**Problems Identified**
- Code duplication across student and faculty actions
- Violated ISP
- Manual counters and loops

**Refactoring Applied**
- Implemented `StudentActions` and `FacultyActions`
- Centralized logic using private helper methods
- Removed redundant course counters
- Used `removeIf()` for cleaner logic

**Benefit**
- Cleaner API  
- No duplicated logic  
- Better role separation  

---

### 4. `Department.java` & `DepartmentView.java`

**Problems Identified**
- Display logic inside model
- Poor naming consistency

**Refactoring Applied**
- Removed display logic from model
- Renamed fields for clarity (`departmentName` → `name`)
- Moved presentation responsibility to View

**Principle Applied**
- SRP

---

### 5. `ExamResult.java` & `ExamResultView.java`

**Problems Identified**
- ExamResult managing course collections
- Mixed responsibilities
- Inconsistent naming

**Refactoring Applied**
- Removed course list from ExamResult
- Renamed fields (`mid1Marks` → `mid1`)
- Retained only result-related logic
- View updated accordingly

**Principle Applied**
- SRP

---

### 6. `Faculty.java`

**Problems Identified**
- Redundant counters
- Concrete collection types
- Manual removal loops

**Refactoring Applied**
- Replaced `ArrayList` with `List`
- Removed redundant `numberOfClubs`
- Used `removeIf()` for club removal
- Cleaner interaction with `CourseManager`

**Benefits**
- Improved maintainability  
- Reduced state inconsistency  

---

### 7. `Student.java`

**Problems Identified**
- Duplicate counters
- Typo in variable names
- Inconsistent data handling

**Refactoring Applied**
- Removed redundant counters
- Unified naming conventions
- Delegated enrollment logic to `CourseManager`
- Used `List` abstraction consistently

**Principles Applied**
- SRP, Encapsulation

---

### 8. `UniversityData.java`

**Problems Identified**
- Tight coupling to `ArrayList`
- Limited flexibility

**Refactoring Applied**
- Replaced `ArrayList` with `List` interface
- Improved abstraction and future extensibility

---

## Interfaces (`StudentActions`, `FacultyActions`)

**Purpose**
- Separate responsibilities for different user roles
- Enforce ISP

**Outcome**
- Cleaner contracts  
- No unnecessary method exposure  

---

## Overall Benefits of Refactoring

- Cleaner architecture  
- Reduced code duplication  
- Improved scalability  
- Better adherence to OOP principles  
- Easier debugging and future enhancement  
- Instructor-grade clean code structure  

---

## Branch Purpose

This branch **only contains refactored files** where all identified code smells have been removed.  
It serves as a **clear comparison point** against the original implementation and demonstrates applied software engineering best practices.
