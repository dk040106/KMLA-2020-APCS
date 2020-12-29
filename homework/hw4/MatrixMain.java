public class MatrixMain {
    public static void main(String[] args) {
        int testNum = 100;
        double[][] totalError = new double[3][testNum];

        for (int i = 0; i < testNum; i++) {
            int testSize = 1000;

            Matrix A = Matrix.Random(testSize, testSize, 100);
            Matrix B = Matrix.Random(testSize, 1, 100);

            Matrix X1 = A.LUDecomposition(B);
            Matrix X2 = A.gaussJordanElimination(B);
            Matrix X3 = A.gaussEliminationBackSubstitution(B);

            double diff1 = A.multiply(X1).diff(B);
            double diff2 = A.multiply(X2).diff(B);
            double diff3 = A.multiply(X3).diff(B);

            totalError[0][i] = diff1 / (testSize * 1);
            totalError[1][i] = diff2 / (testSize * 1);
            totalError[2][i] = diff3 / (testSize * 1);
        }
        System.out.println("LUDecomposition");
        summary(totalError[0]);
        System.out.println("gaussJordanElimination");
        summary(totalError[1]);
        System.out.println("gaussEliminationBackSubstitution");
        summary(totalError[2]);
    }

    public static void summary(double[] arr) {
        final int LENGTH = arr.length;
        double sum = 0;
        for (double el : arr) {
            sum += el;
        }

        double mean = sum / LENGTH;
        System.out.println(mean);

        double ssum = 0;
        for (double el : arr) {
            ssum += (el - mean) * (el - mean);
        }
        double std = Math.sqrt(ssum / (LENGTH - 1));

        System.out.println(std);
        System.out.println(std / mean);
    }

    public static void GEBSTest() {
        for (int i = 1; i <= 2; i++) {
            int temp = (int) Math.pow(10.0, i);

            for (int j = 1; j <= 9; j++) {
                int testSize = temp * j;

                Matrix A = Matrix.Random(testSize, testSize, 100);
                Matrix B = Matrix.Random(testSize, 1, 100);

                long startTime = System.currentTimeMillis();
                Matrix X = A.gaussEliminationBackSubstitution(B);
                long endTime = System.currentTimeMillis();

                double diff = A.multiply(X).diff(B);

                System.out.printf("Test Matrix size: %d x %d\n", testSize, testSize);
                System.out.println("걸린 시간: " + (endTime - startTime) / 1000.0 + "초");
                System.out.println("== 오차 ==");
                System.out.println("전체 오차: " + diff);
                System.out.println("평균 오차: " + diff / (testSize * testSize)); // (전체 오차 / 행렬의 크기)
                System.out.println();
            }
        }
    }

    public static void GJETest() {
        for (int i = 1; i <= 2; i++) {
            int temp = (int) Math.pow(10.0, i);

            for (int j = 1; j <= 9; j++) {
                int testSize = temp * j;

                Matrix A = Matrix.Random(testSize, testSize, 100);
                Matrix B = Matrix.Random(testSize, 1, 100);

                long startTime = System.currentTimeMillis();
                Matrix X = A.gaussJordanElimination(B);
                long endTime = System.currentTimeMillis();

                double diff = A.multiply(X).diff(B);

                System.out.printf("Test Matrix size: %d x %d\n", testSize, testSize);
                System.out.println("걸린 시간: " + (endTime - startTime) / 1000.0 + "초");
                System.out.println("== 오차 ==");
                System.out.println("전체 오차: " + diff);
                System.out.println("평균 오차: " + diff / (testSize * testSize)); // (전체 오차 / 행렬의 크기)
                System.out.println();
            }
        }
    }

    public static void LUTest() {
        for (int i = 1; i <= 2; i++) {
            int temp = (int) Math.pow(10.0, i);

            for (int j = 1; j <= 9; j++) {
                int testSize = temp * j;

                Matrix A = Matrix.Random(testSize, testSize, 100);
                Matrix B = Matrix.Random(testSize, 1, 100);

                long startTime = System.currentTimeMillis();
                Matrix X = A.LUDecomposition(B);
                long endTime = System.currentTimeMillis();

                double diff = A.multiply(X).diff(B);

                System.out.printf("Test Matrix size: %d x %d\n", testSize, testSize);
                System.out.println("걸린 시간: " + (endTime - startTime) / 1000.0 + "초");
                System.out.println("== 오차 ==");
                System.out.println("전체 오차: " + diff);
                System.out.println("평균 오차: " + diff / (testSize * testSize)); // (전체 오차 / 행렬의 크기)
                System.out.println();
            }
        }
    }
}