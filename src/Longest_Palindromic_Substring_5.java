public class Longest_Palindromic_Substring_5 {

    public static void main(String[] args) {
        System.out.println("babad       → реальность: " + longestPalindrome("babad"));
        System.out.println("cbbd       → реальность: " + longestPalindrome("cbbd"));
        System.out.println("abcba       → реальность: " + longestPalindrome("abcba"));
        System.out.println("aacabdkacaa       → реальность: " + longestPalindrome("aacabdkacaa"));
        System.out.println("abcda       → реальность: " + longestPalindrome("abcda"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (isPalindromic(s)) {
                return s;
            } else return s.substring(0, 1);
        }

        StringBuilder longestPalindromic = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            for (int y = s.length() - 1; y > i; y--) {
                if (s.charAt(i) == s.charAt(y)) {
                    String sub = s.substring(i, y + 1);
                    if (sub.length() == 2) {
                        if (sub.length() > longestPalindromic.length()) {
                            longestPalindromic.delete(0, longestPalindromic.length());
                            longestPalindromic.append(sub);
                        }
                    }
                    if (isPalindromic(s.substring(i, y + 1))) {
                        if (sub.length() > longestPalindromic.length()) {
                            longestPalindromic.delete(0, longestPalindromic.length());
                            longestPalindromic.append(sub);
                        }
                    }
                }
            }
        }
        if (longestPalindromic.isEmpty()) {
            return s.substring(0, 1);
        }
        return longestPalindromic.toString();
    }

    private static boolean isPalindromic(String s) {
        int lastLetterIndex = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(lastLetterIndex)) {
                return false;
            }
            --lastLetterIndex;
        }
        return true;
    }
}
