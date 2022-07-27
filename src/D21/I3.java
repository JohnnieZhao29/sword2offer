package D21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zjy
 * @version 1.0
 *
 * 设计一个使用单词列表进行初始化的数据结构，单
 * 词列表中的单词 互不相同 。
 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，
 * 使得所形成的新单词存在于已构建的神奇字典中。
 *
 */

public class I3 {

}
class MagicDictionary {
    // 存放字典单词
    Set<String> words;
    // 记录字典中所有广义邻居对应的个数
    Map<String, Integer> neighbors;
    public MagicDictionary() {
        words = new HashSet<>();
        neighbors = new HashMap<>();
    }
    // 生成一个单词所有的广义邻居
    public String[] getNeighbors(String word){
        // 广义邻居的个数=字符串的长度
        String[] res = new String[word.length()];
        StringBuilder buffer = new StringBuilder(word);
        // 修改字符串中的各位上的字符来生成广义邻居
        for(int i = 0; i < buffer.length(); i++){
            char c = buffer.charAt(i);
            // 只需要替换为一个统一的"*"即可
            buffer.setCharAt(i, '*');
            res[i] = buffer.toString();
            buffer.setCharAt(i,c);
        }
        return res;
    }

    // 构建字典
    public void buildDict(String[] dictionary) {
        // 统计字典中所有单词的广义邻居数
        for(String word : dictionary){
            words.add(word);// 将字典单词加入哈希表中，方便后面 查验插入的字符是否已经在单词表中。
            for(String neighbor : getNeighbors(word)){
                neighbors.put(neighbor, neighbors.getOrDefault(neighbor, 0) + 1);
            }
        }
    }

    // 在字典中查找是否存在广义邻居
    public boolean search(String searchWord) {
        // 查找所有广义邻居数。
        for(String neighbor : getNeighbors(searchWord)){
            int neighborNum  = neighbors.getOrDefault(neighbor, 0);
            if(neighborNum > 1 || neighborNum == 1 && !words.contains(searchWord)) return true;
        }
        return false;
    }
}

