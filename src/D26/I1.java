package D26;

/**
 * @author zjy
 * @version 1.0
 */


import java.util.Random;

/**
 * 快排过程中，如果基准正好是k，那么就直接返回这个位置，
 */
public class I1 {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int index = quickSort(nums, 0, nums.length - 1, nums.length - k);
        return nums[index];
    }

    public int quickSort(int[] nums, int l, int r, int k){
        int key = partition(nums, l, r);
        if(key == k){
            return key;
        }else if(key > k){
            return quickSort(nums, l, key - 1, k);
        }else{
            return quickSort(nums, key + 1, r, k);
        }
    }
    public int partition(int[] nums, int l, int r){
        int keyIndex = random.nextInt(r - l + 1) + l;
        int flag = nums[keyIndex];
        // 将keyIndex拿出
        swap(nums, l, keyIndex);
        int i = l + 1;
        int j = r;
        while(i <= j){
            while(i < r && nums[i] <= flag){
                i++;
            }
            while(j > l && nums[j] > flag){
                j--;
            }
            if(i >= j){
                break;
            }
            swap(nums, i , j);
        }
        // 此时l+1到r是排完的
        // l+1到i是小于等于flag的，j到r是大于flag的
        swap(nums, l, j);
        return j;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
