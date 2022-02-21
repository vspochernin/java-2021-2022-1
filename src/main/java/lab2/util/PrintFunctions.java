package lab2.util;

import lab2.exceptions.FileNotExistException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class PrintFunctions {
    // Напечатать в консоль матрицу с максимальной длиной числа (включая возможный минус) maxNumLength.
    public static void printMatrix(int[][] matrix, int maxNumLength) {
        System.out.println("-".repeat(maxNumLength + 1).repeat(matrix[0].length));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(String.format("%" +
                        maxNumLength + "d ", matrix[i][j]));
            }
            System.out.println();
        }
        System.out.println("-".repeat(maxNumLength + 1).repeat(matrix[0].length));
    }

    // Напечатать в файл матрицу с максимальной длиной числа (включая возможный минус) maxNumLength.
    public static void printMatrixToFile(File file, int[][] matrix, int maxNumLength) throws IOException {
        // Try здесь ради автоматического закрытия ресурса.
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("-".repeat(maxNumLength + 1).repeat(matrix[0].length) + "\n");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    writer.write(String.format("%" +
                            maxNumLength + "d ", matrix[i][j]));
                }
                writer.write('\n');
            }
            writer.write("-".repeat(maxNumLength + 1).repeat(matrix[0].length) + '\n');
        } catch (NoSuchFileException | FileNotFoundException e) {
            throw new FileNotExistException("Записываемый файл не существует или недоступен");
        }
    }
}
