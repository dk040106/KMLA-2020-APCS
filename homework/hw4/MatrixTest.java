public class MatrixTest {
    public static void additionTest() {
        double[][] arr1 = { 
            { 1, 2, 3 }, 
            { 7, 8, 9 }, 
            { 4, 5, 6 } 
        };
        
        Matrix mat1 = new Matrix(arr1);

        if(!mat1.add(Matrix.Zero(3)).equals(mat1))
        {
            throw new Error();
        }
    }

    public static void determinantTest() {
        Matrix I = Matrix.Identity(5);
        if(I.determinant() != 1)
        {
            throw new Error();
        }
    }

    public static void multiplyTest() {
        double[][] arr1 = { 
            { 1, 2, 3 }, 
            { 7, 8, 9 }, 
            { 4, 5, 6 } 
        };

        Matrix mat1 = new Matrix(arr1);

        if(!mat1.multiply(Matrix.Identity(3)).equals(mat1))
        {
            throw new Error();
        }
    }

    public static void gaussEliminationTest() {
        Matrix A = Matrix.Random(3, 3, 100);
        Matrix B = Matrix.Random(3, 1, 100);

        if(!A.multiply(A.gaussEliminationBackSubstitution(B)).equals(B)) {
            throw new Error();
        }
    }
}
