package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/*
"pwwkew"
 122344
 122233
"abcabcbb"
 12333333
 */
public class LongestSubstringWithoutRepetions {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> currentCharPosition = new HashMap<>();
        int windowStart = 0;
        int maxLength = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            int pos = currentCharPosition.getOrDefault(s.charAt(windowEnd),0);
            if (pos>windowStart) {
                windowStart =  pos;
            }
            if (windowEnd-windowStart+1>maxLength) {
                maxLength = windowEnd-windowStart+1;
            }
            currentCharPosition.put(s.charAt(windowEnd),windowEnd+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abccdef"));
    }
}
