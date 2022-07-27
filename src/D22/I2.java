package D22;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjy
 * @version 1.0
 */

public class I2 {
}
class MapSum {

    Map<String, Integer> map;

    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int res = 0;
        for (String s : map.keySet()) {
            if (s.startsWith(prefix)) {
                res += map.get(s);
            }
        }
        return res;
    }
}

/**
 *  0 3: mid--> 0+3/2 = 1
 *  2 3: mid--> 2+1/2 = 2
 *  2 1
 */

