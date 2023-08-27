import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Lesson3 {
    /**
     * Задание 3
     * В массиве хранится n явно заданных текстовых строк. Создать метод:
     * ■ выводящий содержимое массива в строку через пробел;
     * ■ сортирующий массив в обратном порядке (без учета
     * регистра) от z до a;
     * ■ сортирующий массив по количеству слов в строке (слова
     * разделены пробелами).
     * Программа должна вывести строки в начальном и отсортированном порядке.
     * Дополнительно: 1 балл за генерацию случайных уникальных строк реализованных в виде метода.
     */

    public static void main(String[] args) {
        strings();
        printArray(strings);
        reversSortArray(strings);
        printArray(strings);
        lengthStringSortArray(strings);
        printArray(strings);

    }

    public static int arrayLength = 10;
    public static String[] strings = new String[arrayLength];

    public static void strings() {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = randomStringGenerator();
        }
    }

    public static void printArray(String[] strings) {
        for (String string : strings) {
            System.out.print(string + " ");
        }
        System.out.println();
    }

    public static void reversSortArray(String[] strings) {
        Arrays.sort(strings,Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
    }

    public static void lengthStringSortArray(String[] strings) {
        Arrays.sort(strings, Comparator.comparingInt(String::length));
    }

    public static String randomStringGenerator() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = random(1, 11);
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public static int random(int minValue, int maxValue) {
        return ThreadLocalRandom.current().nextInt(minValue, maxValue);
    }
}
