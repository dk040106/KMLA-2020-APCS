package ch3;

public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student("Daniel Kim", new int[] { 100, 100, 100 }, "none");
        Student g = new GraduateStudent("Daniel Kim", new int[] { 100, 100, 100 }, "none", 191037);
        Student u = new UnderGraduateStudent("Daniel Kim", new int[] { 100, 100, 100 }, "none");

        System.out.println(((GraduateStudent) s).getGradID());
        System.out.println(((GraduateStudent) g).getGradID());
    }
}
