package D5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zjy
 * @version 1.0
 */

public class I2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int ns = s.length();
        int ps = p.length();
        int[] cs = new int[26];
        int[] cp = new int[26];
        if(ns < ps){
            return res;
        }
        for (int i = 0; i < ps; i++) {
            cs[s.charAt(i)-'a']++;
            cp[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(cs,cp)){
            res.add(0);
        }
        for(int i = ps; i < ns; i++){
            cs[s.charAt(i-ps)-'a']--;
            cs[s.charAt(i)-'a']++;
            if(Arrays.equals(cp,cs)){
                res.add(i-ps+1);
            }
        }
        return res;

    }
}
