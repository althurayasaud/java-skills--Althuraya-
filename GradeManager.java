public class GradeManager {

    // Method to reverse each student name
    public static String[] reverseStudentNames(String[] names) {
        String[] reversed = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            reversed[i] = new StringBuilder(names[i]).reverse().toString();
        }
        return reversed;
    }

    // Method to calculate
    public static char getLetterGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else if (score >= 60) return 'D';
        else return 'F';
    }

    //  find failing students (score < 60)
    public static String[] findFailingStudents(String[] names, int[] scores) {
        int count = 0;
        for (int score : scores) {
            if (score < 60) count++;
        }

        String[] failing = new String[count];
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failing[index] = names[i];
                index++;
            }
        }
        return failing;
    }

    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        // Test reverseStudentNames
        System.out.println(" The Rever Student Names:");
        String[] reversedNames = reverseStudentNames(students);
        for (String name : reversedNames) {
            System.out.println(name);
        }

        // Test getLetterGrade
        System.out.println("The Letter Grades:");
        for (int i = 0; i < students.length; i++) {
            char grade = getLetterGrade(scores[i]);
            System.out.println(students[i] + ": " + grade);
        }

        // Test findFailingStudents
        System.out.println("The  Failing Students (score < 60):");
        String[] failingStudents = findFailingStudents(students, scores);
        if (failingStudents.length == 0) {
            System.out.println("None");
        } else {
            for (String name : failingStudents) {
                System.out.println(name);
            }
        }
    }
}
