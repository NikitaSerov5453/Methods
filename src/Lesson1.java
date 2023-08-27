import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Lesson1 {
    /**
     * Задание 1
     * Написать и протестировать методы работы с квадратными матрицами (матрицы представить в виде двухмерных
     * массивов).
     * Должны присутствовать методы:
     * ■ создания единичной (диагональной) матрицы;
     * ■ создания нулевой матрицы;
     * ■ сложение матриц;
     * ■ умножения матриц;
     * ■ умножение матрицы на скаляр;
     * ■ определение детерминанта матрицы;
     * ■ вывод матрицы на консоль.
     */

    public static void main(String[] args) {

    }

    public static int random(int minValue, int maxValue) {
        return ThreadLocalRandom.current().nextInt(minValue, maxValue);
    }

    public static int[][] unitDiagonalMatrix(int matrixSize) {
        int[][] diagonalMatrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < diagonalMatrix.length; i++) {
            for (int j = 0; j < diagonalMatrix.length; j++) {
                if (i == j) {
                    diagonalMatrix[i][j] = random(-10, 11);
                }
            }
        }
        return diagonalMatrix;
    }

    public static int[][] zeroMatrix(int matrixSize) {
        return new int[matrixSize][matrixSize];
    }

    public static int[][] sumMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] sumMatrix = new int[2][2];
        for (int i = 0; i < sumMatrix.length; i++) {
            for (int j = 0; j < sumMatrix.length; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return sumMatrix;
    }

    public static int[][] powMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] multiplicationMatrix = new int[2][2];
        multiplicationMatrix[0][0] = matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0];
        multiplicationMatrix[0][1] = matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1];
        multiplicationMatrix[1][0] = matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[1][0];
        multiplicationMatrix[1][1] = matrix1[1][0] * matrix2[0][1] + matrix1[1][1] * matrix2[1][1];
        return multiplicationMatrix;
    }

    public static int[][] powMatrixScalar(int[][] matrix, int scalar) {
        int[][] scalarMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < scalarMatrix.length; i++) {
            for (int j = 0; j < scalarMatrix.length; j++) {
                scalarMatrix[i][j] = matrix[i][j] * scalar;
            }
        }
        return scalarMatrix;
    }

    public static int determinantMatrix(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] a : matrix) {
            System.out.print(Arrays.toString(a) + "\n");
        }
        System.out.println();
    }
}
