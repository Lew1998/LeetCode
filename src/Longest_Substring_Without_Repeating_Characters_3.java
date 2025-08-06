import java.util.HashMap;
import java.util.Map;

/**
 * Класс {@code Longest_Substring_Without_Repeating_Characters_3} реализует решение задачи №3 на LeetCode —
 * поиск длины самой длинной подстроки без повторяющихся символов.
 * <p>
 * Примеры тестов выводятся в консоль в формате:
 * <pre>
 *     вход → ожидание: {ожидаемое значение}, реальность: {полученное значение}
 * </pre>
 */
public class Longest_Substring_Without_Repeating_Characters_3 {
    public static void main(String[] args) {
        System.out.println("au       → ожидание: 2, реальность: " + lengthOfLongestSubstring("au"));
        System.out.println("aab      → ожидание: 2, реальность: " + lengthOfLongestSubstring("aab"));
        System.out.println("pwwkew   → ожидание: 3, реальность: " + lengthOfLongestSubstring("pwwkew"));
        System.out.println("dvdf     → ожидание: 3, реальность: " + lengthOfLongestSubstring("dvdf"));
    }

    /**
     * Возвращает длину самой длинной подстроки без повторяющихся символов.
     * <p>
     * Алгоритм использует скользящее окно и хеш-таблицу, чтобы отслеживать последние
     * позиции каждого символа. При повторении символа окно сдвигается вперёд.
     *
     * @param s входная строка
     * @return длина самой длинной подстроки без повторяющихся символов
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int maxSizeSubString = 0;
        Map<Character, Integer> tempSubStringChars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (tempSubStringChars.containsKey(s.charAt(i))) {
                i = tempSubStringChars.get(s.charAt(i));
                tempSubStringChars.clear();
            } else {
                tempSubStringChars.put(s.charAt(i), i);
            }
            if (tempSubStringChars.size() > maxSizeSubString) {
                maxSizeSubString = tempSubStringChars.size();
            }
        }

        return maxSizeSubString;
    }
}
// TODO переписать, сейчас отработал за 78ms