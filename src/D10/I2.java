package D10;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author zjy
 * @version 1.0
 * 运用所掌握的数据结构，设计和实现一个LRU
 * (Least Recently Used，最近最少使用) 缓存机制 。
 *
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/OrIXps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class I2 {
}

/**
 * 使用队列，队头存放最近使用的缓存，使用缓存的时候，首先把他拿出来，然后放到队头
 * 需要支持在任意位置插入删除元素
 */
class LRUCache {
    int max;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.max = capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        int res = cache.get(key);
        update(key);
        return res;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            update(key);
            return;
        }
        if(cache.size() >= max){
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key,value);

    }

    public void update(int key){
        // 更新key
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }
}
