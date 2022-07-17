package D6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zjy
 * @version 1.0
 * 给定两个字符串 s 和t 。返回 s 中包含t的所有字符的最短子字符串。
 * 如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 *
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 *
 */

public class I1 {
    public static void main(String[] args) {
        System.out.println(minWindow("aab", "aab"));
    }
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;
        int end = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            // 如果t中含有这个字母
            if(tMap.containsKey(c)){
                // 放入s的map中
                sMap.put(c,sMap.getOrDefault(c,0)+1);
                if(sMap.get(c).equals(tMap.get(c))){
                    valid++;
                    // 这一字母的数量满足(>=)，那么这一字母种类通过
                }
            }
            while(valid == tMap.size()){
                if((right - left) < length){
                    start = left;
                    end = right;
                    length = right - left;
                }
                char d = s.charAt(left);
                left++;
                if(tMap.containsKey(d)){
                    if(sMap.get(d).equals(tMap.get(d))){
                        valid--;
                    }
                    sMap.put(d,sMap.get(d)-1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}
