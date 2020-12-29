import chn.util.*;

public class ColorGridMain {
    public static void main(String[] args) {
        FileInput fi = new FileInput("data/colorGridInput.txt");
        int rows = Integer.parseInt(fi.readToken());
        int cols = Integer.parseInt(fi.readToken());
        String s = fi.readToken();

        ColorGrid c = new ColorGrid(s, rows, cols);
        c.display();

        int row = Integer.parseInt(fi.readToken());
        int col = Integer.parseInt(fi.readToken());
        String newColor = fi.readToken();
        String oldColor = fi.readToken();

        int[][] history = c.paintRegionWithHistory(row, col, newColor, oldColor);
        c.display();

        for(int[] r: history) {
            for(int el: r) {
                System.out.printf("%3d", el);
            }
            System.out.println();
        }

    }
}
