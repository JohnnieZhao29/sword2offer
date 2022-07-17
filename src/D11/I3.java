package D11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zjy
 * @version 1.0
 */

public class I3 {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 1440){
            return 0;
        }
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < timePoints.size() - 1; i++){
            int times1 = getTime(timePoints.get(i));
            int times2 = getTime(timePoints.get(i+1));
            res = Math.min(res, times2-times1);
        }
        res = Math.min(res, getTime(timePoints.get(0)) -
                getTime(timePoints.get(timePoints.size()-1)) +1440);
        return res;
    }
    public int getTime(String s){
        return ((s.charAt(0) - '0') * 10 +
                (s.charAt(1) - '0')) * 60 +
                (s.charAt(3) - '0') * 10 +
                (s.charAt(4) - '0');
    }
}
