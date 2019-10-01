class Solution {
    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     * 例如，A -> 1,B -> 2,C -> 3,AA -> 27
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int ret = 0;
        for(char c : s.toCharArray())
        	ret = ret * 26 + (c - 'A') +1;
        return ret;
    }
}
