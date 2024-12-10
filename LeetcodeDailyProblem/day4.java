class Solution {
    public int maximumLength(String s) {
   int maxLen = -1;
        for (int length = 1; length <= s.length(); length++) {
            for (int i = 0; i <= s.length() - length; i++) {
                String substring = s.substring(i, i + length);
                if (isSpecial(substring) && countOccurrences(s, substring) >= 3) {
                    maxLen = Math.max(maxLen, length);
                }
            }
        }
        return maxLen;
    }

    private boolean isSpecial(String s) {
        char firstChar = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c != firstChar) {
                return false;
            }
        }
        return true;
    }

    private int countOccurrences(String s, String substring) {
        int count = 0;
        for (int i = 0; i <= s.length() - substring.length(); i++) {
            if (s.substring(i, i + substring.length()).equals(substring)) {
                count++;
            }
        }
        return count;
    }
}
