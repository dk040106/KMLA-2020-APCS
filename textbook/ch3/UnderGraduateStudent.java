public class UnderGraduateStudent extends Student {
    public UnderGraduateStudent() {
        super();
    }

    public UnderGraduateStudent(String name, int[] tests, String grade) {
        super(name, tests, grade);
    }

    public void computeGrade() {
        super.computeGrade();
        if (getTestAverage() >= 70) {
            setGrade("Pass");
        } else {
            setGrade("Fail");
        }
    }
}
