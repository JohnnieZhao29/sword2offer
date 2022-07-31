package D25;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author zjy
 * @version 1.0
 */

public class I1 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        res.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] curArray = intervals[i];
            int[] lastArray = res.getLast();
            if(curArray[0] <= lastArray[1]){
                lastArray[1] = Math.max(curArray[1], lastArray[1]);
            }else{
                res.add(curArray);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
