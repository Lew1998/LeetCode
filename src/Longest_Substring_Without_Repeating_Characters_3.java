import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au")); //2
        System.out.println(lengthOfLongestSubstring("aab"));//2
        System.out.println(lengthOfLongestSubstring("pwwkew")); //3
        System.out.println(lengthOfLongestSubstring("dvdf"));//3
    }

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