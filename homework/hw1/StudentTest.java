import chn.util.*;

public class StudentTest {
    static Student[] students;
    static SchoolClass APCS2020_2;

    public static void main(String[] args) {
        getStudentList();
        APCS2020_2 = new SchoolClass(students);
        outputInfo();
    }

    public static void getStudentList() {
        FileInput fi = new FileInput("data/input.txt");
        int studentNum = Integer.parseInt(fi.readLine());

        students = new Student[studentNum];
        for (int i = 0; i < studentNum; i++) {
            String firstName = fi.readToken();
            String lastName = fi.readToken();
            Gender gender;
            switch (fi.readToken()) {
                case "M":
                    gender = Gender.M;
                    break;
                case "F":
                    gender = Gender.F;
                    break;
                default:
                case "O":
                    gender = Gender.O;
                    break;
            }
            int age = Integer.parseInt(fi.readToken());
            double height = Double.parseDouble(fi.readToken());
            double[] scores = { Double.parseDouble(fi.readToken()), Double.parseDouble(fi.readToken()),
                    Double.parseDouble(fi.readToken()) };
            students[i] = new Student(firstName, lastName, age, height, gender, scores);
        }
        fi.close();
    }

    public static void outputInfo() {
        FileOutput fo = new FileOutput("data/output.txt");
        fo.println("개인별 성적 평균");
        for (Student student : students) {
            fo.println(student.getName() + ": " + String.format("%.2f", student.getAverage()) + "점");
        }
        fo.println();
        fo.println("반 평균: " + String.format("%.2f", APCS2020_2.getAverage()) + "점");
        fo.println("반 표준편차: " + String.format("%.2f", APCS2020_2.getStd()) + "점");
        fo.close();
    }
}