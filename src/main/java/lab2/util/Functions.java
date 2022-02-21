package lab2.util;

import lab2.exceptions.BigArgumentException;
import lab2.exceptions.FileNotExistException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardOpenOption;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Functions {
    // Получение случайного числа из отрезка [min; max].
    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    // Получение матрицы N * M, заполненной случайными числами на отрезке [min; max].
    public static int[][] getMatrix(int N, int M, int min, int max) {
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = getRandomNumber(min, max);
            }
        }
        return matrix;
    }

    // Очистить файл.
    public static void cleanFile(File file) throws IOException {
        try (BufferedWriter br = Files.newBufferedWriter(file.toPath(),
                StandardOpenOption.TRUNCATE_EXISTING)) {
        } catch (NoSuchFileException | FileNotFoundException e) {
            throw new FileNotExistException("Очищаемый файл не существует или недоступен");
        }
    }

    // Считать из файла число.
    public static int readInt(File file) throws FileNotExistException {
        try (Scanner input = new Scanner(file)) {
            if (input.hasNextInt()) {
                int result = input.nextInt();
                if (result <= 1_000_000) {
                    return result;
                } else {
                    throw new BigArgumentException("Слишком большое число N");
                }
            } else {
                throw new NoSuchElementException("Входной файл не содержит число");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotExistException("Не найден входной файл");
        }
    }
}
