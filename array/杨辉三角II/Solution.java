    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * @param rowIndex
     * @return
     */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre;
        List<Integer> ans = new ArrayList<>();
        if(rowIndex < 0)
        	return ans;
        ans.add(1);
        for(int i = 1; i <= rowIndex; i++) {
        	pre = new ArrayList<>(ans);
        	ans.clear();
        	ans.add(1);
        	for(int j = 0; j < pre.size()-1; j++)
        		ans.add(pre.get(j)+pre.get(j+1));
        	ans.add(1);
        }
        return ans;
    }
}
