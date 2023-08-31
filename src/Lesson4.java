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
        generateTriangle(triangleArrayCopy);
        copyArray(triangleArray, triangleArrayCopy);
        printTriangle(triangleArray);
        compression(triangleArray);
        System.out.println(maxValueInArray(triangleArray[lengthArray - 1]));
        getWay(triangleArray, triangleArrayCopy);
        System.out.println(Arrays.toString(wayArray));
    }

    public static int minNumberInTriangle = 0;
    public static int maxNumberInTriangle = 100;
    public static int lengthArray = random(2, 100);
    public static int[][] triangleArray = new int[lengthArray][];
    public static int[][] triangleArrayCopy = new int[lengthArray][];
    public static int[] wayArray = new int[lengthArray];


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

    public static void printTriangle(int[][] array) {
        for (int[] ints : array) {
            for (int k = array.length; k > ints.length; k--) {
                System.out.print(" ");
            }
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int random(int minValue, int maxValue) {
        return ThreadLocalRandom.current().nextInt(minValue, maxValue);
    }

    public static int maxValueInArray(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int j : array) {
            if (j > maxValue && j != 0) {
                maxValue = j;
            }
        }
        return maxValue;
    }

    public static void compression(int[][] array) {
        int hold;
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

    public static void getWay(int[][] array, int[][] arrayCopy) {
        int maxValue = maxValueInArray(array[lengthArray - 1]);
        int i = array.length - 1;
        int j = findIndex(array[i], maxValue);
        wayArray[i] = arrayCopy[i][j];
        for (; ; ) {
            boolean b = isValid(i, j, array[i - 1]);
            if (b) {
                j = findIndex(array[i - 1], Math.max(array[i - 1][j - 1], array[i - 1][j]));
                i--;
                wayArray[i] = arrayCopy[i][j];
            } else if (j == 0) {
                if (i - 1 == 0) {
                    i--;
                    wayArray[i] = arrayCopy[i][j];
                    return;
                }
                i--;
                wayArray[i] = arrayCopy[i][j];
            } else if (j == array[i].length - 1) {
                if (i - 1 == 0 && j - 1 == 0) {
                    i--;
                    j--;
                    wayArray[i] = arrayCopy[i][j];
                    return;
                }
                i--;
                j--;
                wayArray[i] = arrayCopy[i][j];
            } else {
                return;
            }
        }
    }

    public static boolean isValid(int i, int j, int[] array) {
        return i > 0 && j > 0 && i < lengthArray && j < array.length;
    }

    public static int findIndex(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void copyArray(int[][] array, int[][] arrayCopy) {
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, arrayCopy[i], 0, array[i].length);
        }
    }

}
