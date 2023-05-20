import java.util.Arrays;

public class Little_Harder {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0}
        };

        System.out.println(Arrays.toString(findMatrixZero(matrix)));

        int largestSubMatrix = findLargestSubMatrix(matrix);
        System.out.println(largestSubMatrix + "x" + largestSubMatrix);

    }

    /**
     * Напишите программу, которая находит наибольшую общую подматрицу,
     * состоящую только из нулей, в двумерном массиве.
     * <p>
     * int[][] matrix = {
     * {1, 0, 0, 1, 0},
     * {0, 0, 1, 1, 0},
     * {0, 0, 0, 0, 1},
     * {1, 0, 1, 1, 0},
     * {0, 0, 0, 0, 0}
     * };
     */
    public static int[] findMatrixZero(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[2];

        int[][] dp = new int[rows][cols];
        int maxSubMatrixSizeRow = 0;
        int maxSubMatrixSizeCol = 0;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (matrix[i][j] == 0) {
                    maxSubMatrixSizeCol++;
                    if (matrix[i][j +1] == 0 && matrix[i + 1][j] == 0 && matrix[i +1][j +1] == 0){
                        maxSubMatrixSizeCol++;
                        maxSubMatrixSizeRow++;
                    }
                }
            }
        }
        res[0] = maxSubMatrixSizeRow;
        res[1] = maxSubMatrixSizeCol;
        return res;
    }

//    public static int findMaxZeroSubmatrix(int[][] matrix) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        int[][] dp = new int[rows][cols];
//        int maxZeroSubmatrixSize = 0;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (i == 0 || j == 0) {
//                    dp[i][j] = matrix[i][j];
//                } else if (matrix[i][j] == 0) {
//                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
//                }
//
//                if (dp[i][j] >= maxZeroSubmatrixSize) {
//                    maxZeroSubmatrixSize += dp[i][j];
//                }
//            }
//        }
//
//        return maxZeroSubmatrixSize;
//    }


    public static int findLargestSubMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int maxSubMatrixSize = 0;

        // Заполняем первую строку dp согласно исходной матрице
        for (int i = 0; i < cols; i++) {
            dp[0][i] = matrix[0][i];
            maxSubMatrixSize = Math.max(maxSubMatrixSize, dp[0][i] );
        }

        // Заполняем первый столбец dp согласно исходной матрице
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0];
            maxSubMatrixSize = Math.max(maxSubMatrixSize, dp[i][0]);
        }

        // Заполняем остальные элементы dp и обновляем размер наибольшей подматрицы
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));

                    maxSubMatrixSize = Math.max(maxSubMatrixSize, dp[i][j]);

                } else {
                    dp[i][j] = 0;
                }

            }
        }

        return maxSubMatrixSize;
    }

/**
 * Напишите программу, которая находит наименьший путь от
 * верхнего левого угла до нижнего правого угла в двумерном массиве.
 * Каждая ячейка содержит стоимость прохода.
 * <p>
 * int[][] grid = {
 * {1, 3, 1},
 * {1, 5, 1},
 * {4, 2, 1}
 * };
 * 19:51
 * Напишите программу, которая проверяет, является ли двумерный массив симметричным
 * (относительно главной диагонали).
 * 19:51
 * int[][] array = {
 * {1, 2, 3},
 * {2, 4, 5},
 * {3, 5, 6}
 * };
 */
}

