public class Image {
    private final int BLACK = 0;
    private final int WHITE = 1;
    private final int[] dx = { -1, 0, 0, 1 };
    private final int[] dy = { 0, -1, 1, 0 };
    private int[][] image;
    public final int ROWS;
    public final int COLS;

    private int[][] history;
    private int orderCount;

    public Image(int rows, int cols) {
        ROWS = rows;
        COLS = cols;

        image = new int[ROWS][COLS];
    }

    public Image(int[][] _image) {
        checkImage(_image);
        ROWS = _image.length;
        COLS = _image[0].length;

        image = new int[ROWS][COLS];
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                image[i][j] = _image[i][j];
            }
        }
    }

    private boolean checkImage(int[][] _image) {
        return true;
    }

    public void display() {
        for(int[] row: image) {
            for(int el: row) {
                System.out.printf("%2d", el);
            }
            System.out.println();
        }
    }

    public void eraseBlob(int row, int col) {
        if(row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            if(image[row][col] == BLACK)
            {
                image[row][col] = WHITE;

                history[row][col] = orderCount;
                orderCount++;
                
                for(int i=0; i<4; i++) {
                    eraseBlob(row + dx[i], col + dy[i]);
                }
            }
        }
    }

    public int[][] eraseBlobWithHistory(int row, int col) {
        orderCount = 1;
        history = new int[ROWS][COLS];
        eraseBlob(row, col);
        return history;
    }
}
