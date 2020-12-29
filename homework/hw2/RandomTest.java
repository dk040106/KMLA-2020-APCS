import java.util.Arrays;
import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        probabilityTest();
    }

    public static void seedTest() {
        System.out.println("Seed Test...\n");

        long seed = 100L;
        int bound = 100;
        byte[] bytes = new byte[100];

        Random rand1 = new Random(seed);
        System.out.println(rand1.nextBoolean());
        rand1.nextBytes(bytes);
        System.out.println(bytes);
        System.out.println(rand1.nextDouble());
        System.out.println(rand1.nextFloat());
        System.out.println(rand1.nextGaussian());
        System.out.println(rand1.nextInt());
        System.out.println(rand1.nextInt(bound));
        System.out.println(rand1.nextLong());

        System.out.println();

        Random rand2 = new Random(seed);
        System.out.println(rand2.nextBoolean());
        rand2.nextBytes(bytes);
        System.out.println(bytes);
        System.out.println(rand2.nextDouble());
        System.out.println(rand2.nextFloat());
        System.out.println(rand2.nextGaussian());
        System.out.println(rand2.nextInt());
        System.out.println(rand2.nextInt(bound));
        System.out.println(rand2.nextLong());
    }

    public static void probabilityTest() {
        for(int i=0; i<10; i++)
        {
            probabilityTest2((long) Math.pow(10, i), 10);
        }
    }

    public static void probabilityTest2(long num_trial, int bound) {
        Random rand = new Random();

        // print out information
        System.out.println("\n=========================");
        System.out.println("총 테스트 횟수: " + num_trial);
        System.out.println("테스트 범위: 0 ~ " + bound);
        System.out.println("-------------------------");

        // initialize test array
        long[] arr = new long[bound];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        // execute test
        for (int i = 0; i < num_trial; i++) {
            arr[rand.nextInt(arr.length)]++;
        }

        // print out information
        System.out.println("숫자별 출현 횟수:");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i]);
        }

        System.out.printf("평균: %.5f\n", mean(num_trial, arr));
        System.out.printf("Coefficient of variation (CV): %.5f\n", CV(arr));
        System.out.println("=========================");
    }

    // mean of 각 숫자들의 등장
    public static double mean(long num_trial, long[] arr) {
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * i;
        }

        double mean = sum / num_trial;

        return mean;
    }

    // coefficient of deviation of 각 숫자의 등장 횟수
    public static double CV(long[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        double mean = sum / arr.length;

        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.pow(arr[i] - mean, 2);
        }

        double variance = sum / arr.length;
        double std = Math.sqrt(variance);

        return std / mean;
    }
}