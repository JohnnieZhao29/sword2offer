package D10;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zjy
 * @version 1.0
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同且字符顺序不完全相同
 * 则称s 和 t互为变位词（字母异位词）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/dKk3P7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class I3 {
    public boolean isAnagram(String s, String t) {
        int[] tchs = new int[26];
        int[] schs = new int[26];
        if(s.length() != t.length() ||  s.equals(t)){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            schs[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tchs[t.charAt(i)-'a']++;
        }
//        boolean res = Arrays.equals(tchs, schs);
        return Arrays.equals(tchs, schs);
    }
}
