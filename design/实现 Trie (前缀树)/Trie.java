package design;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class Trie {
	class Node {
		//记录单词，不需要删除操作
	    public Node[] child = new Node[26];
	    public boolean isEnd = false;
	}

    public Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {\
        	//没有则插入新的字符
            if(temp.child[c - 'a'] == null)                 
                temp.child[c - 'a'] = new Node();
            temp = temp.child[c-'a'];
        }
        //结尾为true
        temp.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            //如果
        	if (temp.child[c-'a'] == null)
                return false;
            else
                temp = temp.child[c-'a'];
        }
        //防止出现apple:true app:false
        return temp.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char c : prefix.toCharArray()) {
            if (temp.child[c-'a'] == null)
                return false;
            else
                temp = temp.child[c-'a'];
        }
        return true;
    }
}


