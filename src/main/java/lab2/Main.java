package lab2;

import lab2.exceptions.BigArgumentException;
import lab2.exceptions.DivNullException;
import lab2.util.Functions;
import lab2.util.MatrixFunctions;
import lab2.util.PrintFunctions;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        File inputFile = new File("./src/main/resources/lab2-input.txt");
        File outputFile = new File("./src/main/resources/lab2-output.txt");
        boolean check = true; // Продолжить ли генерировать подходящую матрицу?

        int N = 0;
        try {
            N = Functions.readInt(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
            check = false;
        } catch (BigArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Будет установлено максимально возможное N = 1 000 000");
            N = 1_000_000;
        }

        // Максимально возможная длина числа (включая возможный минус).
        int maxNumLength = Integer.valueOf(N).toString().length() + 1;

        while (check) {
            try {
                Functions.cleanFile(outputFile);
                int[][] matrix = Functions.getMatrix(N, N, -N, N);
                PrintFunctions.printMatrix(matrix, maxNumLength);
                for (int i = 0; i < 3; i++) {
                    // Перевернули матрицу.
                    matrix = MatrixFunctions.getRotatedLeftMatrix(matrix);
                    PrintFunctions.printMatrix(matrix, maxNumLength);
                    // Перемножили матрицу.
                    MatrixFunctions.multiplyMatrix(matrix);
                    PrintFunctions.printMatrix(matrix, maxNumLength);
                    PrintFunctions.printMatrixToFile(outputFile, matrix, maxNumLength);
                }
                check = false;
            } catch (DivNullException e) {
                System.out.println(e.getMessage());
                System.out.println("Будет подобрана другая матрица");
            } catch (IOException e) {
                e.printStackTrace();
                check = false;
            }
        }
    }
}
