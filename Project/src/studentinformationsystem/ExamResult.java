package studentinformationsystem;

import java.util.ArrayList;

public class ExamResult {

    private String courseName;
    private double mid1Marks, mid2Marks, finalMarks;
    private ArrayList<Course> CourseList = new ArrayList<Course>();
    public ExamResult() {
    }

    public ExamResult(String courseName, double mid1Marks, double mid2Marks, double finalMarks) {
        this.courseName = courseName;
        this.mid1Marks = mid1Marks;
        this.mid2Marks = mid2Marks;
        this.finalMarks = finalMarks;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getMid1Marks() {
        return mid1Marks;
    }

    public void setMid1Marks(double mid1Marks) {
        this.mid1Marks = mid1Marks;
    }

    public double getMid2Marks() {
        return mid2Marks;
    }

    public void setMid2Marks(double mid2Marks) {
        this.mid2Marks = mid2Marks;
    }

    public double getFinalMarks() {
        return finalMarks;
    }

    public void setFinalMarks(double finalMarks) {
        this.finalMarks = finalMarks;
    }
    
    public double averageMarks(){
        return (mid1Marks+mid2Marks+finalMarks) / 3;
    }
    public void addCourse(Course e){
        CourseList.add(e);
    }
    
    public void courseDisplay(){
        for(Course i: CourseList){
            i.display();
        }
    }

    public void display() {
        System.out.println("Mid-Term-1 marks: " + mid1Marks);
        System.out.println("Mid-Term-2 marks: " + mid2Marks);
        System.out.println("Final-Term marks: " + finalMarks);
      
    }

}