package lab2.util;

import lab2.exceptions.DivNullException;

public class MatrixFunctions {
    // Проверка, является ли двумерный массив матрицей.
    static boolean isMatrix(int[][] matrix) {
        if (matrix.length < 1) {
            return false;
        }
        // Матрица должна иметь прямоугольный вид.
        int size = matrix[0].length;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != size) {
                return false;
            }
        }
        return true;
    }

    // Повернуть матрицу на 90 градусов против часовой стрелки.
    public static int[][] getRotatedLeftMatrix(int[][] matrix) {
        if (!isMatrix(matrix)) {
            throw (new IllegalArgumentException("Передана не матрица"));
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] resultMatrix = new int[m][n];
        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                resultMatrix[n - j - 1][i] = matrix[i][j];
            }
        }
        return resultMatrix;
    }

    // Получить матрицу, в которой каждый элемент разделен на сумму соседних.
    public static void multiplyMatrix(int[][] matrix) {
        if (!isMatrix(matrix)) {
            throw (new IllegalArgumentException("Передана не матрица"));
        }
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int leftIndex = (j == 0) ? (m - 1) : (j - 1);
                int rightIndex = (j == m - 1) ? (0) : (j + 1);
                int divider = matrix[i][leftIndex] + matrix[i][rightIndex];
                if (divider == 0) {
                    throw new DivNullException("Деление на ноль невозможно");
                }
                matrix[i][j] /= divider;
            }
        }
    }
}
