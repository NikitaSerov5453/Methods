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
        printTriangle(triangleMatrix);
        stepDefinition();

    }
    public static final int[] row = new int[]{0,1};
    public static int x = 0;
    public static int y = 0;
    public static int minLengthTriangle = 2;
    public static int maxLengthTriangle = 10;
    public static int minNumberInTriangle = 0;
    public static int maxNumberInTriangle = 100;

    public static int lengthArray = random(minLengthTriangle, maxLengthTriangle);

    public static int[][] triangleArray = new int[lengthArray][];
    public static int[][] triangleMatrix = new int[lengthArray][];
    public static int[] wayArray = new int[lengthArray];

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < lengthArray && y < lengthArray;
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

    public static void generateTriangleMatrix(int[][] triangleArray) {
        for (int i = 0; i < triangleArray.length; i++) {
            triangleArray[i] = generateMatrixArray(i + 1);
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

    public static void counterMaxNumber(int[][] array) {
        int counter = 0;
        int finalSum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                counter = counter + array[i][j];
                if (finalSum < counter) {
                    finalSum = counter;
                }
            }
        }
    }

    public static void stepDefinition() {
        int holdX = 0;
        int holdY = 0;
        for (int i = 0; i < 2; i++) {
            int newX = x + row[i];
            int newY = y++;
            if (isValid(x, y)) {
                holdY = newY;
                holdX = newX;
            }
        }
        System.out.println(x);
        System.out.println(y);
        x = holdX;
        y = holdY;
        System.out.println(x);
        System.out.println(y);
    }

}
