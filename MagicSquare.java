
public class MagicSquare {
    public static void main(String[] args) {
        int[][] MagicSquare = new int[5][5];
        int rows, column;
        rows = 0;
        column = 2;

        MagicSquare[rows][column] = 1; 

        for (int fill = 2; fill <= 25; fill++)
        {
            // up and right
            rows--;
            column++;

            // rows se bahar
            if (rows < 0)
                rows = 4;

            // if column se bahar
            if (column > 4)
                column = 0;

            // already filled
            if (MagicSquare[rows][column] != 0) {
                rows += 2;
                column--;

                // nichae se bahr ajae
                if (rows > 4)
                    rows = rows - 5;
                if (column < 0)
                    column = 4;
            }

            MagicSquare[rows][column] = fill;
        }

        // print in matrix form
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(MagicSquare[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
