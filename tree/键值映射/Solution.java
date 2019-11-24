    /**
    实现一个 MapSum 类里的两个方法，insert 和 sum。
对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
    */
    class MapSum {

        WordTree root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new WordTree(' ');
        }

        public void insert(String key, int val) {

            WordTree head = root;
            for (char ch : key.toCharArray()) {
                if (head.children[ch - 'a'] == null) {
                    head.children[ch - 'a'] = new WordTree(ch);
                }
                head = head.children[ch - 'a'];
            }
            head.v = val;

        }

        public int sum(String prefix) {
            WordTree head = root;
            for (char ch : prefix.toCharArray()) {
                head = head.children[ch - 'a'];
                if (head == null) {
                    return 0;
                }
            }

            return sum(head) + head.v;
        }

        public int sum(WordTree head) {
            int t = 0;
            if (head == null) {
                return t;
            }
            for (WordTree wordTree : head.children) {
                if (wordTree != null) {
                    t += wordTree.v + sum(wordTree);
                }
            }
            return t;
        }
    }

    class WordTree {

        char ch;
        WordTree[] children;
        int v;

        public WordTree(char ch) {
            this.ch = ch;
            this.children = new WordTree[26];
            this.v = 0;
        }

    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
