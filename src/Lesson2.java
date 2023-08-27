import java.util.Arrays;

public class Lesson2 {
    /**
     * Задание 2
     * Написать и протестировать перегруженный метод, выводящий на экран:
     * ■ одномерный массив типа int;
     * ■ одномерный массив типа String;
     * ■ двухмерный массив типа int;
     * ■ двухмерный массив типа float.
     */

    public static void main(String[] args) {

    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printArray(String[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printArray(int[][] array) {
        for (int[] a : array) {
            System.out.print(Arrays.toString(a) + "\n");
        }
        System.out.println();
    }

    public static void printArray(float[][] array) {
        for (float[] a : array) {
            System.out.print(Arrays.toString(a) + "\n");
        }
        System.out.println();
    }
}
