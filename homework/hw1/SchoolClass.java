public class SchoolClass {
    private Student[] students;

    public SchoolClass(Student[] students) {
        this.students = students;
    }

    public double getAverage() {
        if (students.length == 0 || students == null) {
            return 0.0;
        }
        double sum = 0;
        for (Student student : students) {
            sum += student.getAverage();
        }
        return sum / students.length;
    }

    public double getStd() {
        if (students.length == 0 || students == null) {
            return 0.0;
        }
        double squareSum = 0;
        for (Student student : students) {
            squareSum += Math.pow(student.getAverage() - getAverage(), 2);
        }
        double variance = squareSum / students.length;
        return Math.sqrt(variance);
    }
}
