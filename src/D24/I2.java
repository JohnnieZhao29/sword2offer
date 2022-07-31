package D24;

/**
 * @author zjy
 * @version 1.0
 */

public class I2 {
    public int mySqrt(int x) {
        int lo = 0, hi = x;
        int res = -1;
        while( lo <= hi){
            int mid = lo + ((hi - lo) >> 1);
            if( (long) mid * mid <= x){
                res = mid;
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return res;

    }
}
