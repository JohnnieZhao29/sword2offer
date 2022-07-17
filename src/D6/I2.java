package D6;

import java.util.Locale;

/**
 * @author zjy
 * @version 1.0
 */

public class I2 {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if(Character.isLetterOrDigit(s1.charAt(i))){
                sb.append(s1.charAt(i));
            }else{
            }
        }
        int n = sb.length();
        String sub = sb.toString();
        int lo = 0, hi = n - 1;
        boolean res = true;
        while(lo < hi){
           if(sub.charAt(lo) == sub.charAt(hi)){
               lo++;
               hi--;
           }else{
               res = false;
               break;
           }
        }
        return res;
    }
}
