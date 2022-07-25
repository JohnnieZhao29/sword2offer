package D19;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author zjy
 * @version 1.0
 */

public class I3 {
}
class MyCalendar {

    TreeSet<int[]> booked;

    /**
     * 有序set，重写TreeSet中的比较器，对于区间来说，只有完全不重合才有大小之分，
     * 否则就是相等，无法添加
     */
    public MyCalendar() {
        booked = new TreeSet<>((a, b) -> {
            if(a[1] <= b[0])
                return -1;
            else if(a[0] >= b[1])
                return 1;
            else
                return 0;
        });
    }

    public boolean book(int start, int end) {
        int[] e = new int[]{start, end};
        return booked.add(e);
    }
}

