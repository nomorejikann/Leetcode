	    /**
	     * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
你需要输出替换之后的句子。
输入只包含小写字母
	     * @param dict
	     * @param sentence
	     * @return
	     */
class Solution {
    Tire root = new Tire();
	    public String replaceWords(List<String> dict, String sentence) {
	        for(String s : dict)
	        	insert(s);
	        StringBuilder sb = new StringBuilder();
	        for(String s : sentence.split(" "))
	        	sb.append(search(s)).append(" ");
	        return sb.deleteCharAt(sb.length()-1).toString();
	    }
	    class Tire{
        	Tire[] next;
        	String word;
        	Tire(){
        		next = new Tire[26];
        		word = null;
        	}
        	
        }
	    public void insert(String word) {
    		Tire t = root;
    		for(char c : word.toCharArray()) {
    		    if(t.next[c-'a'] == null)
    		    	t.next[c-'a'] = new Tire();
    		    t = t.next[c-'a'];
    		}
    		t.word = word;
    	}
    	
    	public String search(String word) {
    		Tire t = root;
    		for(char c : word.toCharArray()) {
    			if(t.next[c-'a'] != null)
    				t = t.next[c-'a'];
    			//起始就没有找到
    			else
    				return word;
    			//是否找到
    			if(t.word != null)
        			return t.word;
    		}
    		return word;
    	}
}
