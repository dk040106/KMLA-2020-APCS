package ch3;

public class Student {
    public final static int NUM_TESTS = 3;
    private String name;
    private int[] tests;
    private String grade;

    public Student() {
        this("", new int[NUM_TESTS], "");
    }

    public Student(String name, int[] tests, String grade) {
        if (tests.length != NUM_TESTS) {
            throw new IllegalArgumentException("length of tests array has to be " + NUM_TESTS);
        }
        this.name = name;
        this.tests = tests;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void computeGrade() {
        if (name.isBlank() || name.isBlank()) {
            setGrade("No Grade");
        } else if (getTestAverage() >= 65) {
            setGrade("Pass");

        } else {
            setGrade("Fail");
        }
    }

    public double getTestAverage() {
        double total = 0;
        for (int score : tests) {
            total += score;
        }
        return total / NUM_TESTS;
    }
}
