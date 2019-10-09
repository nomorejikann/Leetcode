    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * @param numRows
     * @return
     */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows == 0)
        	return ans;
        ans.add(Arrays.asList(1));
        for(int i = 1; i < numRows; i++) {
        	List<Integer> l = new ArrayList<>();
        	List<Integer> pre = ans.get(i-1);
        	//开头的1
        	l.add(1);
        	for(int j = 0; j < pre.size()-1; j++) 
        		l.add(pre.get(j)+pre.get(j+1));
        	//结尾的1
        	l.add(1);
        	ans.add(l);
        }
        return ans;
    }
}
