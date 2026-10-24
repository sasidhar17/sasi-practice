package slidingwidow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//"abcabcbb"

class LongestSubstringWithoutRepeatingChar {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 1;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > 1) {
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("eghghhgg"));
    }
}
