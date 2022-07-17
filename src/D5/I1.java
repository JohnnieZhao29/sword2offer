package D5;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zjy
 * @version 1.0
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 */

public class I1 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            nums1[s1.charAt(i)-'a']++;
            nums2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(nums1,nums2)){
            return true;
        }
//        int left = 0;
//        int right = s1.length()-1;
        for(int i = s1.length(); i < s2.length(); i++){
            nums2[s2.charAt(i-s1.length())-'a']--;
            nums2[s2.charAt(i)-'a']++;
            if(Arrays.equals(nums1,nums2)){
                return true;
            }
        }
        return false;
    }
}
