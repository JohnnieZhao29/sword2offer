package D11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zjy
 * @version 1.0
 */

public class I1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // 将s--> s_key
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        ArrayList<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
    public String getKey(String s){
        int[] ch = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i)-'a']++;
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            buffer.append(ch[i]);
            buffer.append((char) (i+'a'));
        }
        return buffer.toString();
    }
}
