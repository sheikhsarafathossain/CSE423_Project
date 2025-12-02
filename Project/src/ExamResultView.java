public class ExamResultView {

    public void printResultDetails(ExamResult result) {
        System.out.println("--- Exam Result ---");
        System.out.println("Course Name: " + result.getCourseName());
        System.out.println("Mid-Term 1: " + result.getMid1());
        System.out.println("Mid-Term 2: " + result.getMid2());
        System.out.println("Final Exam: " + result.getFinalExam());
        System.out.println("Average: " + result.averageMarks());
    }
}
