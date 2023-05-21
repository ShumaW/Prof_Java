import java.util.Arrays;

public class Little_Harder {

    public static void main(String[] args) {
        System.out.println("-".repeat(25) + " Task 1 " + "-".repeat(25));
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int maxZeroSubmatrixSize = findMaxZeroSubmatrix(matrix);
        System.out.println("Max Zero Submatrix Size: " + maxZeroSubmatrixSize + "x" + maxZeroSubmatrixSize);

        System.out.println("-".repeat(25) + " Task 2 " + "-".repeat(25));
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(findTheWay(grid));

        System.out.println("-".repeat(25) + " Task 3 " + "-".repeat(25));
        int[][] array = {
                {1, 2, 3},
                {2, 4, 5},
                {3, 5, 6}
        };
        System.out.println(symmetricArray(array));
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

    public static int findMaxZeroSubmatrix(int[][] matrix) {  // принял, что по умолчанию ищём квадратную подматрицу
        int rows = matrix.length;                             // состоящую из нулей
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j];
        }

        int maxSubmatrixSize = 1;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxSubmatrixSize = Math.max(maxSubmatrixSize, dp[i][j]);
                }
            }
        }

        return maxSubmatrixSize;
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
     */

    public static int findTheWay(int[][] arr) {
        int[] res = new int[arr.length + arr[0].length - 1];
        int indexRes = 0;
        int sum = 0;
        int minWay = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[0][i];
            res[indexRes] = arr[0][i];
            indexRes++;
        }
        for (int i = 1; i < arr.length && indexRes < res.length; i++) {
            sum += arr[i][arr.length - 1];
            res[indexRes] = arr[i][arr.length - 1];
            indexRes++;
        }
//        System.out.println(Arrays.toString(res));
        minWay = sum;
        sum = 0;
        int j = 0;
        for (int i = 0; i < arr.length && j < arr[0].length; i++) {
            sum += arr[i][j];
            j++;
        }
        j = 0;
        if (minWay > sum) {
            for (int i = 0; i < res.length; i++) {
                res[i] = 0;
            }
            for (int i = 0; i < arr.length && j < arr[0].length; i++) {
                res[i] = arr[i][j];
                j++;
            }
        }
//        System.out.println(Arrays.toString(res));
        minWay = Math.min(minWay, sum);
        sum = 0;
        for (int i = 0; i < arr[0].length; i++) {
            sum += arr[i][0];
        }
        for (int i = 1; i < arr.length; i++) {
            sum += arr[arr[0].length - 1][i];
        }
        j = 0;
        if (minWay > sum) {
            for (int i = 0; i < res.length; i++) {
                res[i] = 0;
            }
            for (int i = 0; i < arr.length && j < arr[0].length; i++) {
                res[j] = arr[i][0];
                j++;
            }
            for (int i = 1; i < arr.length; i++) {
                res[j] = arr[arr[0].length - 1][i];
                j++;

            }
        }
        System.out.println(Arrays.toString(res));
        minWay = Math.min(minWay, sum);
        return minWay;
    }

    /**
     * Напишите программу, которая проверяет, является ли двумерный массив симметричным
     * (относительно главной диагонали).
     * 19:51
     * int[][] array = {
     * {1, 2, 3},
     * {2, 4, 5},
     * {3, 5, 6}
     * };
     */
    public static boolean symmetricArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

