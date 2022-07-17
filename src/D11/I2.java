package D11;

import java.util.HashMap;

/**
 * @author zjy
 * @version 1.0
 */

public class I2 {
    /**
     *
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int length = Math.max(w1.length(), w2.length());
            for (int j = 0; j < length; j++) {
                int index1 = j >= w1.length() ? -1 : map.get(w1.charAt(j));
                int index2 = j >= w2.length() ? -1 : map.get(w2.charAt(j));
                if(index1 < index2){
                    break;
                }
                if(index1 > index2){
                    return false;
                }
            }
        }
        return true;
    }
}
