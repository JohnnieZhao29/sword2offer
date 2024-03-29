package D22;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zjy
 * @version 1.0
 */

public class I1 {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String>  set = new HashSet<>(Arrays.asList(words));
        for(String word : words){
            for(int i = 1; i < word.length(); i++){
                set.remove(word.substring(i));
            }
        }
        int res = 0;
        for(String word : set){
            res += word.length() + 1;
        }
        return res;
    }
}
