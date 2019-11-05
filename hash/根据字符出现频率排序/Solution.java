    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     * @param s
     * @return
     */
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for(char c : s.toCharArray())
        	m.put(c, m.getOrDefault(c, 0)+1);
        
        StringBuilder sb = new StringBuilder();
        while(m.size() > 0) {
        	int count = 0;
        	char ch = ' ';
        	//找出最大的一个
            for(Character c : m.keySet()) { 
            	if(count < m.get(c)) {
            		count = m.get(c);
            		//最大的字母
            		ch = c;
            	}
            }
            for(int i = 0; i < count; i++)
            	sb.append(ch);
            //移除掉最大的
            m.remove(ch);
        }
        
        return sb.toString();
    }
}
