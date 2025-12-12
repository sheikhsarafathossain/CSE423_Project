public class ConsoleUIFactory implements UniversityUIFactory {
    @Override
    public StudentView createStudentView() { 
        return new StudentView(); 
    }
    
    @Override
    public FacultyView createFacultyView() { 
        return new FacultyView(); 
    }
    
    @Override
    public CourseView createCourseView() { 
        return new CourseView(); 
    }
    
    @Override
    public ClubView createClubView() { 
        return new ClubView(); 
    }
    
    @Override
    public DepartmentView createDepartmentView() { 
        return new DepartmentView(); 
    }

    @Override
    public ExamResultView createExamResultView() { 
        return new ExamResultView(); 
    }
    
}