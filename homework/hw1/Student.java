public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private double height;
    private Gender gender;

    private double average;
    private String name;
    private double[] scores;

    public Student() {
        this("John", "Doe", 10, 100f, Gender.O, new double[] { 0.0, 0.0, 0.0 });
    }

    public Student(String firstName, String lastName, int age, double height, Gender gender, double[] scores) {
        setName(firstName, lastName);
        setAge(age);
        setHeight(height);
        setGender(gender);
        setScores(scores);
    }

    // Modifier
    public void setName(String firstName, String lastName) {
        if (firstName.isBlank() || firstName.isEmpty()) {
            System.out.println("Name cannot be blank or empty.");
            firstName = "John";
        }
        if (lastName.isBlank() || lastName.isEmpty()) {
            System.out.println("Name cannot be blank or empty.");
            lastName = "Doe";
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.name = firstName + " " + lastName;
    }

    public void setAge(int age) {
        if (age < 0 || age > 200) {
            System.out.println("Are you human?");
            age = 10;
        }
        this.age = age;
    }

    public void setHeight(double height) {
        if (height < 0 || height > 300) {
            System.out.println("Are you human?");
            height = 170.0f;
        }
        this.height = height;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setScores(double[] scores) {
        if (scores.length != 3) {
            System.out.println("Scores has to be array of length 3. (Current: " + scores.length + ")");
        }

        for (int i = 0; i < 3; i++) {
            scores[i] = validateScore(scores[i]);
        }

        this.scores = scores;
        setAverage();
    }

    private double validateScore(double score) {
        if (score < 0.0 || score > 100.0) {
            System.out.println("Score cannot be below 0 or above 100");
            System.out.println("Setting to defalut value (" + score + " => " + "0)");
            score = 0.0;
        }
        return score;
    }

    private void setAverage() {
        double sum = 0;
        // 성적은 중간, 기말, 수행이기 때문에 길이를 3이라고 생각한다.
        for (int i = 0; i < 3; i++) {
            sum += scores[i];
        }
        average = sum / 3;
    }

    // Accessor
    public String toString() {
        return "Student(" + name + " : " + gender.getLabel() + ")";
    }

    public double getAverage() {
        return average;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getHeight() {
        return height;
    }

    public Gender getGender() {
        return gender;
    }
}