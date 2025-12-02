public class ExamResult {

    private String courseName;
    private double mid1, mid2, finalExam;

    public ExamResult() {
    }

    public ExamResult(String courseName, double mid1, double mid2, double finalExam) {
        this.courseName = courseName;
        this.mid1 = mid1;
        this.mid2 = mid2;
        this.finalExam = finalExam;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName)  
   {
        this.courseName = courseName;
    }

    public double getMid1() {
        return mid1;
    }

    public void setMid1(double mid1) {
        this.mid1 = mid1;
    }

    public double getMid2() {
        return mid2;
    }

    public void setMid2(double mid2) {
        this.mid2 = mid2;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    public double averageMarks() {
        return (mid1 + mid2 + finalExam) / 3;
    }
}
