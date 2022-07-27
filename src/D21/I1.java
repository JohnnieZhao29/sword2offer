package D21;

/**
 * @author zjy
 * @version 1.0
 * 实现一个前缀树
 */

public class I1 {
}
class Trie {
    private Trie[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = searchPre(word);
        if(trie == null){
            return false;
        }
        return trie.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPre(prefix) != null;
    }

    private Trie searchPre(String prefix){
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i)-'a';
            if(node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

