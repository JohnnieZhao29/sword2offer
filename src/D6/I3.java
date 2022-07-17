package D6;

/**
 * @author zjy
 * @version 1.0
 */

public class I3 {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += countPalindrome(s, i, i);
            res += countPalindrome(s, i, i+1);
        }
        return res;
    }
    // 中心扩散寻找所有回文子串
    public int countPalindrome(String s, int lo, int hi){
        int ans = 0;
        while(lo >= 0 && hi < s.length()){
            if(s.charAt(lo) == s.charAt(hi)){
                lo--;
                hi++;
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
}
