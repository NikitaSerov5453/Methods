import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Lesson6 {
    /**
     * Задание 6
     * Напишите метод, проверяющую правильность расстановки скобок в строке, введенной с клавиатуры. При правильной расстановке выполняются условия:
     * ■ количество открывающих и закрывающих скобок равно;
     * ■ внутри любой пары открывающая–соответствующая
     * закрывающая скобка, скобки расставлены правильно.
     * В строке могут присутствовать как круглые, так и квадратные скобки (и др. символы). Каждой открывающей
     * скобке соответствует закрывающая того же типа (круглой –
     * круглая, квадратной – квадратная).
     * Пример неправильной расстановки: ( [ a) b]
     * Пример правильных входных данных: (a[b](f[(g)(g)]))
     * Программа должна вывести результат в виде сообщения,
     * примеры:
     * ■ Правильная строка
     * ■ Ошибка отсутствие (
     * ■ Ошибка отсутствие (
     * ■ Ошибка отсутствие [
     * ■ Ошибка отсутствие ]
     */

    public static void main(String[] args) {
        countingBrackets(string);
    }

    public static String string = "(a[b](f[(g)(g)]))";
    public static void countingBrackets(String s) {
        char b = '(';
        char b1 = ')';
        char c = '[';
        char c1 = ']';
        int counterB = 0;
        int counterC = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == b) {
                counterB++;
            } else if (s.charAt(i) == b1) {
                counterB--;
            } else if (s.charAt(i) == c) {
                counterC++;
            } else if (s.charAt(i) == c1) {
                counterC--;
            }
        }
        if (counterC == 0 && counterB == 0) {
            if (checkingMatchingBrackets(s)) {
                System.out.println("Все хорошо");
            } else {
                System.out.println("Ошибка");
            }
        } else if (counterB > 0) {
            System.out.println("Ошибка отсутствие )");
        } else if (counterB < 0) {
            System.out.println("Ошибка отсутствие (");
        }
        if (counterC > 0) {
            System.out.println("Ошибка отсутствие ]");
        } else if (counterC < 0) {
            System.out.println("Ошибка отсутствие [");
        }
    }

    public static boolean checkingMatchingBrackets(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (brackets.containsValue(c)) {
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {

                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
