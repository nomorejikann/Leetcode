    /**
     * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
     * @param list1
     * @param list2
     * @return
     */
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if(list1.length < 1 || list2.length < 1)
        	return  new String[0];
        //保存位置
    	Map<String, Integer> m = new HashMap<>();
    	//计算共同
    	Map<Integer, List<String>> m2 = new HashMap<>();
    	int min = 0x7fffffff;
    	for(int i = 0; i < list1.length; i++) 
    		m.put(list1[i], i);
    	for(int i = 0; i < list2.length; i++) {
    		if(m.get(list2[i])!=null) {
    			min = Math.min(min, m.get(list2[i])+i);
    			List<String> l = m2.getOrDefault(i+m.get(list2[i]), new ArrayList<>());
        		l.add(list2[i]);
        		m2.put(m.get(list2[i])+i, l);
    		}
    	}
    	return  m2.get(min).toArray(new String[m2.get(min).size()]);
    }
}
