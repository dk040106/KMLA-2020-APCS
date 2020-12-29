public class Matrix {
    private double[][] elements;
    final int rows;
    final int cols;

    /**
     * Default constructor Creates a Matrix 4 x 5 with all elements initialized with
     * 0
     */
    public Matrix() {
        this(4, 5);
    }

    public Matrix(int length) {
        this(length, length, 0.0);
    }

    public Matrix(int _rowNum, int _colNum) {
        this(_rowNum, _colNum, 0.0);
    }

    public Matrix(int _rowNum, int _colNum, double _value) {
        rows = _rowNum;
        cols = _colNum;
        elements = new double[_rowNum][_colNum];
        for (int i = 0; i < _rowNum; i++) {
            for (int j = 0; j < _colNum; j++) {
                elements[i][j] = _value;
            }
        }
    }

    public Matrix(double[][] _elements) {
        if (!matrixTest(_elements)) {
            throw new IllegalArgumentException("The length of every rows has to be same.");
        }
        rows = _elements.length;
        cols = _elements[0].length;

        elements = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] = _elements[i][j];
            }
        }
    }

    public static Matrix Identity(int length) {
        Matrix result = new Matrix(length);

        for (int i = 0; i < length; i++) {
            result.set(i, i, 1.0);
        }

        return result;
    }

    public static Matrix Zero(int length) {
        Matrix result = new Matrix(length);
        return result;
    }

    public static Matrix Random(int _rowNum, int _colNum, double range) {
        Matrix result = new Matrix(_rowNum, _colNum);

        for (int i = 0; i < _rowNum; i++) {
            for (int j = 0; j < _colNum; j++) {
                result.set(i, j, Math.random() * range);
            }
        }

        return result;
    }

    private boolean matrixTest(double[][] elements) {
        for (int i = 1; i < elements.length; i++) {
            if (elements[i].length != elements[0].length) {
                return false;
            }
        }

        return true;
    }

    public Matrix add(Matrix other) {
        if (other.rows != this.rows || other.cols != this.cols) {
            throw new IllegalArgumentException("Can't add matrices that have diffeerent sizes.");
        }

        Matrix result = new Matrix(this.rows, this.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.set(i, j, this.get(i, j) + other.get(i, j));
            }
        }

        return result;
    }

    public Matrix substract(Matrix other) {
        if (other.rows != this.rows || other.cols != this.cols) {
            throw new IllegalArgumentException("Can't substract matrices that have diffeerent sizes.");
        }

        Matrix result = new Matrix(this.rows, this.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.set(i, j, this.get(i, j) - other.get(i, j));
            }
        }

        return result;
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            String errorMessage = String.format("Can't multiply matrices with size (%d x %d) and (%d x %d)", this.rows,
                    this.cols, other.rows, other.cols);
            throw new IllegalArgumentException(errorMessage);
        }

        Matrix result = new Matrix(this.rows, other.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                result.set(i, j, dot(this.getElements()[i], other.T().getElements()[j]));
            }
        }

        return result;
    }

    public Matrix multiply(double num) {
        Matrix result = new Matrix(this.rows, this.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.set(i, j, this.get(i, j) * num);
            }
        }

        return result;
    }

    public Matrix T() {
        Matrix result = new Matrix(this.cols, this.rows);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.set(j, i, this.get(i, j));
            }
        }

        return result;
    }

    public double dot(double[] arr1, double[] arr2) {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Can't calculate dot product with different length");
        }

        double sum = 0.0;

        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i] * arr2[i];
        }

        return sum;
    }

    public double determinant() {
        if (this.rows != this.cols) {
            throw new Error("Determinant is ony defined on square matrix");
        }

        if (this.rows == 0) {
            return 0;
        }

        if (this.rows == 1) {
            return this.get(0, 0);
        }

        if (this.rows == 2) {
            return this.get(0, 0) * this.get(1, 1) - this.get(0, 1) * this.get(1, 0);
        }

        double sum = 0.0;

        for (int i = 0; i < this.rows; i++) {
            sum += this.get(0, i) * this.cofactor(0, i);
        }

        return sum;
    }

    public double minor(int row, int col) {
        if (this.rows != this.cols) {
            throw new ArithmeticException("Determinant is ony defined on square matrix");
        }

        Matrix result = new Matrix(this.rows - 1, this.cols - 1);

        for (int i = 0; i < this.rows; i++) {
            if (i == row) {
                continue;
            }

            int resultRow = i;
            if (i > row) {
                resultRow--;
            }

            for (int j = 0; j < this.rows; j++) {
                if (j == col) {
                    continue;
                }

                int resultCol = j;
                if (j > col) {
                    resultCol--;
                }

                result.set(resultRow, resultCol, this.get(i, j));
            }
        }

        return result.determinant();
    }

    public double cofactor(int row, int col) {
        // row + col의 값이 짝수면 양수, 홀수면 음수이다.
        int sign = ((row + col) % 2 == 0) ? 1 : -1;
        return this.minor(row, col) * sign;
    }

    public boolean equals(Matrix other) {
        if (other.rows != this.rows || other.cols != this.cols) {
            return false;
        }

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                // double 비교하기
                if (!equals(this.get(i, j), other.get(i, j))) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean equals(double a, double b) {
        final double Epsilon = 10e-16;
        return Math.abs(a - b) <= Epsilon * Math.max(a, b);
    }

    public double diff(Matrix other) {
        if (other.rows != this.rows || other.cols != this.cols) {
            throw new Error("1");
        }

        double sum = 0.0;

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                sum += Math.abs(this.get(i, j) - other.get(i, j));
            }
        }
        return sum;
    }

    public Matrix gaussEliminationBackSubstitution(Matrix b) {
        if (this.rows != this.cols) {
            throw new Error("this is not a square Matrix");
        }

        final int ROW_LENGTH = this.rows;

        if (ROW_LENGTH != b.rows) {
            throw new Error("B has to have same number of rows with A");
        }

        final int COL_LENGTH = b.cols;

        Matrix A = this.clone();
        Matrix B = b.clone();
        Matrix X = new Matrix(ROW_LENGTH, COL_LENGTH);

        // Gauss Elimination
        for (int i = 0; i < ROW_LENGTH; i++) {
            // i번째 행을 diagonal의 값으로 나눈다. (2)
            double temp1 = A.get(i, i);

            for (int j = 0; j < ROW_LENGTH; j++) {
                A.set(i, j, A.get(i, j) / temp1);
            }
            for (int l = 0; l < COL_LENGTH; l++) {
                B.set(i, l, B.get(i, l) / temp1);
            }

            // i번째 행 밑에 있는 모든 열의 값을
            // i, i 밑에 있는 값이 0이 되도록 한다. (3)
            for (int j = i + 1; j < ROW_LENGTH; j++) {
                double temp2 = A.get(j, i);
                for (int k = 0; k < ROW_LENGTH; k++) {
                    A.set(j, k, A.get(j, k) - A.get(i, k) * temp2);
                }
                for (int l = 0; l < COL_LENGTH; l++) {
                    B.set(j, l, B.get(j, l) - B.get(i, l) * temp2);
                }
            }
        }

        // Backward Substitution
        for (int i = ROW_LENGTH - 1; i >= 0; i--) {
            for (int j = 0; j < COL_LENGTH; j++) {
                double sum = 0;
                for (int k = i; k < ROW_LENGTH; k++) {
                    sum += A.get(i, k) * X.get(k, j);
                }
                X.set(i, j, B.get(i, j) - sum);
            }
        }
        return X;
    }

    public Matrix gaussJordanElimination(Matrix b) {
        if (this.rows != this.cols) {
            throw new Error("this is not a square Matrix");
        }

        final int ROW_LENGTH = this.rows;

        if (ROW_LENGTH != b.rows) {
            throw new Error("B has to have same number of rows with A");
        }

        final int COL_LENGTH = b.cols;

        Matrix A = this.clone();
        Matrix B = b.clone();

        // forward phase
        for (int i = 0; i < ROW_LENGTH; i++) {
            // i번째 행을 diagonal의 값으로 나눈다. (2)
            double temp1 = A.get(i, i);

            for (int j = 0; j < ROW_LENGTH; j++) {
                A.set(i, j, A.get(i, j) / temp1);
            }
            for (int j = 0; j < COL_LENGTH; j++) {
                B.set(i, j, B.get(i, j) / temp1);
            }

            // i번째 행 밑에 있는 모든 열의 값을
            // i, i 밑에 있는 값이 0이 되도록 한다. (3)
            for (int j = i + 1; j < ROW_LENGTH; j++) {
                double temp2 = A.get(j, i);
                for (int k = 0; k < ROW_LENGTH; k++) {
                    A.set(j, k, A.get(j, k) - A.get(i, k) * temp2);
                }
                for (int k = 0; k < COL_LENGTH; k++) {
                    B.set(j, k, B.get(j, k) - B.get(i, k) * temp2);
                }
            }
        }

        // backward phase
        for (int i = ROW_LENGTH - 1; i >= 0; i--) {
            // i번째 행 위에 있는 모든 열의 값을
            // i, i 위에 있는 값이 0이 되도록 하게 행연산을 수행한다. (3)
            for (int j = i - 1; j >= 0; j--) {
                double temp2 = A.get(j, i);
                for (int k = 0; k < ROW_LENGTH; k++) {
                    A.set(j, k, A.get(j, k) - A.get(i, k) * temp2);
                }
                for (int k = 0; k < COL_LENGTH; k++) {
                    B.set(j, k, B.get(j, k) - B.get(i, k) * temp2);
                }
            }
        }

        return B;
    }

    public Matrix LUDecomposition(Matrix b) {
        if (this.rows != this.cols) {
            throw new Error("this is not a square Matrix");
        }

        final int ROW_LENGTH = this.rows;

        if (ROW_LENGTH != b.rows) {
            throw new Error("B has to have same number of rows with A");
        }

        final int COL_LENGTH = b.cols;

        Matrix U = this.clone();
        Matrix L = new Matrix(ROW_LENGTH, ROW_LENGTH);
        Matrix X = new Matrix(ROW_LENGTH, COL_LENGTH);
        Matrix Y = new Matrix(ROW_LENGTH, COL_LENGTH);

        // Gauss Elimination
        for (int i = 0; i < ROW_LENGTH; i++) {
            // i번째 행을 diagonal의 값으로 나눈다. (2)
            double temp1 = U.get(i, i);
            L.set(i, i, temp1);
            for (int j = 0; j < ROW_LENGTH; j++) {
                U.set(i, j, U.get(i, j) / temp1);
            }

            // i번째 행 밑에 있는 모든 열의 값을
            // i, i 밑에 있는 값이 0이 되도록 한다. (3)
            for (int j = i + 1; j < ROW_LENGTH; j++) {
                double temp2 = U.get(j, i);
                L.set(j, i, temp2);
                for (int k = 0; k < ROW_LENGTH; k++) {
                    U.set(j, k, U.get(j, k) - U.get(i, k) * temp2);
                }
            }
        }
        // Forward Substitution to solve Y
        for (int i = 0; i < ROW_LENGTH; i++) {
            for (int j = 0; j < COL_LENGTH; j++) {
                double sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += L.get(i, k) * Y.get(k, j);
                }
                Y.set(i, j, (b.get(i, j) - sum) / L.get(i, i));
            }
        }

        // Backward Substitution to solve X
        for (int i = ROW_LENGTH - 1; i >= 0; i--) {
            for (int j = 0; j < COL_LENGTH; j++) {
                double sum = 0;
                for (int k = i + 1; k < ROW_LENGTH; k++) {
                    sum += U.get(i, k) * X.get(k, j);
                }
                X.set(i, j, Y.get(i, j) - sum);
            }
        }

        return X;
    }

    public Matrix cramersRule(Matrix b) {
        if (this.rows != this.cols) {
            throw new Error("Not a square Matrix");
        }

        final int LENGTH = this.rows;

        if (LENGTH != b.rows || b.cols != 1) {
            throw new Error("B has to be a vector and has same rows with A");
        }

        Matrix A = this.clone();
        Matrix B = b.clone();
        Matrix X = new Matrix(LENGTH, 1);

        double determinant = A.determinant();

        // Gauss Elimination
        for (int i = 0; i < LENGTH; i++) {
            X.set(i, 0, Matrix.setCol(A, i, B.getElements()[0]).determinant() / determinant);
        }

        return X;
    }

    public Matrix adjoint() {
        Matrix result = new Matrix(this.rows, this.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.set(i, j, this.cofactor(i, j));
            }
        }

        return result.T();
    }

    public Matrix inverse() {
        return this.adjoint().multiply(1 / this.determinant());
    }

    public double get(int row, int col) {
        return elements[row][col];
    }

    public void set(int row, int col, double value) {
        elements[row][col] = value;
    }

    public static Matrix setCol(Matrix matrix, int col, double[] value) {
        Matrix result = matrix.clone();

        if (value.length != result.rows) {
            throw new Error("Length of column is not same as the Matrix");
        }

        for (int i = 0; i < result.rows; i++) {
            result.elements[i][col] = value[i];
        }

        return result;
    }

    public double[][] getElements() {
        return elements;
    }

    public String toString() {
        String result = "";
        result += String.format("Size: %d x %d\n", rows, cols);

        for (double[] row : elements) {
            for (double el : row) {
                result += String.format("%,.2f\t", el);
            }
            result += "\n";
        }
        return result;
    }

    public Matrix clone() {
        Matrix result = new Matrix(this.elements);
        return result;
    }
}