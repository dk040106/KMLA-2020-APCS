package ch3;

public class GraduateStudent extends Student {
    private int gradID;

    public GraduateStudent() {
        super();
        gradID = 0;
    }

    public GraduateStudent(String name, int[] tests, String grade, int gradID) {
        super(name, tests, grade);
        this.gradID = gradID;
    }

    public int getGradID() {
        return gradID;
    }

    public void computeGrade() {
        super.computeGrade();
        if (getTestAverage() >= 90) {
            setGrade("Pass with distiction");
        }
    }
}
