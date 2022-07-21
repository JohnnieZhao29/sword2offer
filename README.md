# sword2offer
剑指offer（专项突击版）刷题

命名方式，D3.I1表示第三天第一题。

其余命名的表示某一类型题的额外训练，huisu.I46表示回溯算法的练习，题目是leetcode题库第46题。

代码的注释中部分含有题目、题解、分析。

每天刷完后会更新到Github仓库中。

欢迎参加23届应届毕业生一起交流刷题、面试经验。


---
## 算法的学习
### 回溯算法
需要在函数里面传递两个参数，一个是路径（已经选择的），另一个是选择（未选择的）。

当路径已经满足需求的时候（通常是长度达到了限制），需要判定当前路径是否符合题目，符合则留下，不符合则
直接返回。_**注意**_：这里千万不要对路径进行任何处理，比如删除路径中的选择等，删除选择
的操作是在返回以后，由上一层函数进行的，最后一层只对路径进行判断，除此之外不做任何其他操作。
---
拿一道字节的面试题举例，使用[2,1,9,3]数组组合成一个数，找到最大的小于21563的那个数。

很明显这道题需要用回溯算法进行暴力求解。

但是这道题每次从数组中选择一个数后，还可以重复选择，因此每一次的选择，可选的都是一样的。
最后的判断条件，是目前已经选择的数是否是一个五位数即可，然后判断是否小于21563，并且更新最大值。

代码如下：
```java
public static Integer res = new Integer(Integer.MIN_VALUE);
public static void main(String[] args) {
    int[] nums = new int[]{2,5,6,9,3};
    int target = 73211563;
    // 找到使用nums组合的最大的小于target的数
    int len = String.valueOf(target).length();
    StringBuilder buffer = new StringBuilder();
    backtrack(nums, target, len, buffer);
    System.out.println(res);
}

public static void backtrack(int[] nums, int target,
                             int len, StringBuilder buffer){
    if(buffer.length() == len){
        int i = Integer.parseInt(buffer.toString());
        if(i < target){
            res = Math.max(res, i);
        }
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        buffer.append(nums[i]);
        backtrack(nums, target, len, buffer);
        buffer.deleteCharAt(buffer.length()-1);
    }
}
```
---
刚开始接触回溯算法，难免会疑惑，回溯算法会不会对同一个路径进行多次计算？
或者说会不会无限递归呢？其实不会，for循环的起始位置，以及循环体内对每一次选择的判断
会确保回溯算法刚刚好遍历完全部的选择，然后返回。

DFS算法和回溯算法在大体上是一样的，但是我们可以发现回溯算法是需要记录轨迹，到达底部就需要撤销选择，
但是DFS算法有时候不需要撤销，这是因为回溯算法需要传入轨迹，但是DFS算法有时候只需要传入当前结点的状态，可以说
在传入状态的时候，这个结点进行了分身，同时往下运行多个可能的选择，因此每达到一个底部，只需要记录最终状态即可，其他的选择
早就在传入先前状态的时候就选择了。

形象点说明，DFS是多元平行宇宙，到达一个选择点后，每一个选择都会自行开辟一个多元宇宙，最终可以在一个时间切面上同时看到所有的结果。
但是回溯算法是单一宇宙，想要知道所有选择最终的结果，需要不断的时间穿越，回到现在的结点进行选择。

当然这并不是说DFS的时间复杂度低于回溯算法，只是一个形象的比喻。

