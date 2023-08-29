import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Lesson4 {
    /**
     * Задание 4
     * На рисунке показан пример треугольника из чисел.
     * Написать метод:
     * ■ выводящий значения треугольника на консоль в таком
     * виде как на рисунке;
     * ■ вычисляющий наибольшую сумму чисел, через
     * которые проходит путь, начинающийся на вершине и
     * заканчивающийся где-то на основании.
     * 1. Каждый шаг может идти диагонально вниз-направо
     * или диагонально вниз-налево.
     * 2. Количество строк в треугольнике >1, но <100.
     * 3. Числа в треугольнике все целые от 0 до 99 включительно (генерируются случайным образом).
     * В примере, описанном выше, это путь 7, 3, 8, 7, 5, дающий
     * максимальную сумму 30.
     * Программа должна выводить на экран треугольник и
     * путь, который даст максимальный результат. Для текущего
     * примера он будет такой – влево, влево, вправо, влево.
     */

    public static void main(String[] args) {
        generateTriangle(triangleArray);
        printTriangle(triangleArray);
        generateTriangleMatrix(triangleMatrix);
        fieldTriangleMatrix(triangleMatrix);
//        go();
//        printTriangle(triangleMatrix);
        generateTriangleMatrix(triangleSupportMatrix);
        printTriangle(triangleArrayHelp);
        compression(triangleArrayHelp);
        printTriangle(triangleArrayHelp);

    }

    public static final int[] row = new int[]{0, 1};
    public static final int[] cel = new int[]{1, 1};
    public static int x = 0;
    public static int y = 0;
    public static int minLengthTriangle = 2;
    public static int maxLengthTriangle = 10;
    public static int minNumberInTriangle = 0;
    public static int maxNumberInTriangle = 100;

    public static int lengthArray = 5;

    public static int[][] triangleArray = new int[lengthArray][];
    public static int[][] triangleArrayHelp = new int[][]{{60},{80, 28},{16, 94, 42},{15, 45, 2, 33},{98, 7, 93, 3, 79}};
    public static int[][] triangleMatrix = new int[lengthArray][];
    public static int[][] triangleSupportMatrix = new int[lengthArray][];
    public static int[] wayArray = new int[lengthArray];
    public static int[] holdWayArray = new int[lengthArray];

    public static boolean isValid(int x, int y, int[] array) {
        return x > 0 && y > 0 && x < lengthArray && y < array.length;
    }

    public static void generateTriangle(int[][] triangleArray) {
        for (int i = 0; i < triangleArray.length; i++) {
            triangleArray[i] = generateArray(i + 1);
        }
    }

    public static int[] generateArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random(minNumberInTriangle, maxNumberInTriangle);
        }
        return array;
    }

    public static int[] generateMatrixArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = 0;
        }
        return array;
    }

    public static void generateTriangleMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = generateMatrixArray(i + 1);
        }
    }

    public static void printTriangle(int[][] array) {
        for (int[] a : array) {
            System.out.print(Arrays.toString(a) + "\n");
        }
        System.out.println();
    }

    public static int random(int minValue, int maxValue) {
        return ThreadLocalRandom.current().nextInt(minValue, maxValue);
    }

    public static void go() {
        int holdCounter = 0;
        int counter = 0;
        for (int i = 0; i < triangleMatrix.length; i++) {
            for (int j = 0; j < triangleMatrix[i].length; j++) {
                if (triangleMatrix[i][j] == minValueInArray(triangleMatrix[i]) && triangleMatrix[i][j] != 0) {
                    counter += triangleArray[i][j];
                    holdWayArray[i] = triangleArray[i][j];

                }
            }
        }

        if (counter > holdCounter) {
            holdCounter = counter;
            wayArray = holdWayArray;
        }
        System.out.println(holdCounter);
        System.out.println(Arrays.toString(wayArray));
        counter = 0;
        minusArray(triangleMatrix);
        if (triangleMatrix[0][0] == 0) {
            return;
        }

        go();
    }

    public static int minValueInArray(int[] array) {
        int minValue = Integer.MAX_VALUE;
        for (int j : array) {
            if (j < minValue && j != 0) {
                minValue = j;
            }
        }
        return minValue;
    }

//    public static void counterMaxNumber(int[][] array) {
//        int counter = 0;
//        int finalSum = 0;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < i + 1; j++) {
//
//            }
//        }
//    }

//    public static void stepDefinition(int[][] triangleMatrix) {
//
//        int holdX = 0;
//        int holdY = 0;
//
//        for (int i = 0; i < 2; i++) {
//            int newX = x++;
//            int newY = y + row[i];
//            if (isValid(x, y)) {
//                if (triangleMatrix[newX][newY] < triangleMatrix[holdX][holdY] && triangleMatrix[newX][newY] != 0) {
//                    holdY = newY;
//                    holdX = newX;
//                }
//            }
//        }
//        x = holdX;
//        y = holdY;
//        triangleMatrix[x][y] = triangleMatrix[x][y] - 1;
//        if (triangleMatrix[0][0] == 0) {
//            return;
//        }
//        stepDefinition(triangleMatrix);
//    }


    public static int pow(int value, int powValue) {
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }

    public static void fieldTriangleMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = pow(2, array.length - (i + 1));
                if (j != 0) {
                    array[i][j] = array[i][j - 1] * 2;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j != 0 && j != array[i].length - 1) {
                    array[i][j]++;
                }
            }
        }
    }

    public static void fieldTriangleSupportMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]++;
                if (i < array.length - 1) {
                    array[i + 1][j]++;
                    array[i + 1][j + 1]++;
                }
            }
        }
    }

    public static void minusArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    array[i][j]--;
                }
            }
        }
    }


    public static ArrayList<Integer> array1 = new ArrayList<>();

    public static void compression(int[][] array) {
        int hold = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == 0) {
                    a += array[i][j];
                    array[i][j] = a;
                }
                if (j == array[i].length - 1) {
                    b += array[i][j];
                    array[i][j] = b;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j > 0 && j < array[i].length - 1) {
                    hold = Math.max(array[i - 1][j], array[i - 1][j - 1]);
                    array[i][j] = hold + array[i][j];

                }

            }
        }
    }
//    public static void x(int[][] array) {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                array[i][j] = pow(2, array.length - (i + 1));
//                if (j != 0 && j != array[i].length - 1) {
//                    array[i][j]++;
//                }
//            }
//        }
//    }
}
