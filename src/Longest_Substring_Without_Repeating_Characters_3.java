import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters_3 {
    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters_3 longestSubstringWithoutRepeatingCharacters3 = new Longest_Substring_Without_Repeating_Characters_3();
        System.out.println(longestSubstringWithoutRepeatingCharacters3.lengthOfLongestSubstring("au"));
    }

//    Input: s = "abcabcbb"
//    Output: 3


    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int counter;
        int result = 0;
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (res.get(c) == null) {

                if ((i + 1 < s.length()) && s.charAt(i + 1) != 0 && s.charAt(i + 1) == c) {
                    counter = 1;
                    if (result < counter) {
                        result = counter;
                    }
                    res.clear();
                }

                if ((i + 1 < s.length()) && s.charAt(i + 1) != 0 && s.charAt(i + 1) != c) {
                    res.put(c, i);
                    counter = res.size();
                    if (result < counter) {
                        result = counter;
                    }
                } else {
                    counter = res.size();
                    if (result < counter) {
                        result = counter;
                    }
                    res.clear();
                }
            }
        }


        return result;
    }
}
