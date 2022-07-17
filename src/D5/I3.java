package D5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjy
 * @version 1.0
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 */

public class I3 {
    public int lengthOfLongestSubstring(String s) {
        // 不含重复字符的最长连续子字符串的长度
        Map<Character, Integer> map = new HashMap<>();
        if(s.length()==0) return 0;
        int n = s.length();
        // 记录对应下标
        map.put(s.charAt(0),0);
        int lo = 0;
//        int hi = 0;
        int maxlength = 1;
        for(int i = 1; i < n; i++){
            if(map.containsKey(s.charAt(i))){
                int lastIndex = map.get(s.charAt(i));
                int newIndex = i;
                // map.clear();
                lo = Math.max((lastIndex + 1), lo);
                map.put(s.charAt(i),newIndex);
            }else{

                map.put(s.charAt(i),i);
            }
            maxlength = Math.max(maxlength, i - lo + 1);
        }
        return maxlength;
    }
}
