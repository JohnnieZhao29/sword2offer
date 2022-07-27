package D21;

import java.util.List;

/**
 * @author zjy
 * @version 1.0
 *
 * 在英语中，有一个叫做词根(root) 的概念，
 * 它可以跟着其他一些词组成另一个较长的单词——我们称这个词为继承词(successor)。
 * 例如，词根an，跟随着单词other(其他)，可以形成新的单词another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 需要输出替换之后的句子。
 *
 */

public class I2 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        String[] strings = sentence.split(" ");
        for (int k = 0; k < strings.length; k++){
            String word = strings[k];
            StringBuilder buffer = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                buffer.append(word.charAt(i));
                boolean search = trie.search(buffer.toString());
                if(search){
                    strings[k] = buffer.toString();
                    break;
                }
            }
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            buffer.append(strings[i]);
            buffer.append(" ");
        }
        buffer.deleteCharAt(buffer.length()-1);
        return buffer.toString();
    }
}
