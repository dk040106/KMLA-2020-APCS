public class ColorGrid {
    private String[][] pixels;
    private int rows;
    private int cols;
    private int historyIndex;
    private int[][] history;
    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, -1, 1, 0};
    
    public ColorGrid(String s, int numRows, int numCols) {
        if(numRows * numCols != s.length()) {
            throw new IllegalArgumentException();
        }
        rows = numRows;
        cols = numCols;

        pixels = new String[rows][cols];

        int index = 0;
        for(int i=0; i<numRows; i++) {
            for(int j=0; j<numCols; j++) {
                pixels[i][j] = s.substring(index, index+1);
                index++;
            }
        }
    }

    public void paintRegion(int row, int col, String newColor, String oldColor) {
        if(row >= 0 && row < rows && col >= 0 && col < cols) {
            if(pixels[row][col].equals(oldColor)) {
                pixels[row][col] = newColor;
                if(history != null)
                {
                    historyIndex++;
                    history[row][col] = historyIndex;
                }
                for(int i=0; i<4; i++)
                {
                    paintRegion(row + dx[i], col + dy[i], newColor, oldColor);
                }
            }
        }
    }

    public int[][] paintRegionWithHistory(int row, int col, String newColor, String oldColor) {
        historyIndex = 0;
        history = new int[rows][cols];
        paintRegion(row, col, newColor, oldColor);    
        return history;
    }

    public void display() {
        for(String[] row: pixels) {
            for(String el: row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
