package D6;

/**
 * @author zjy
 * @version 1.0
 */

public class I4 {
    public boolean validPalindrome(String s) {
// 删除一个字符是否可以回文，那就是当遇到不相同的时候，跳过任意一个，只要满足一个，就是回文。
        int lo = 0, hi = s.length()-1;
        boolean ans = true;
        while(lo < hi){
            if(s.charAt(lo) == s.charAt(hi)){
                lo++;
                hi--;
            }else{
                ans = isPalindrome(s,lo+1, hi) || isPalindrome(s, lo, hi - 1);
                break;
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s, int left, int right){
        boolean res = true;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                res = false;
                break;
            }
        }
        return res;
    }
}
