public class ExamResultView {
    public void printResultDetails(ExamResult result) {
        System.out.println("--- Exam Result ---");
        System.out.println("Course Name: " + result.getCourseName());
        System.out.println("Mid-Term-1: " + result.getMid1Marks());
        System.out.println("Mid-Term-2: " + result.getMid2Marks());
        System.out.println("Final-Term: " + result.getFinalMarks());
        System.out.println("Average: " + result.averageMarks());
    }
}