    /**
     * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
     * @param N
     * @param K
     * @return
     */
class Solution {
    public int kthGrammar(int N, int K) {
        //basic
    	if(N == 0)
        	return 0;
        //recursion (k+1)/2求出展开的节点位置
    	int ans = kthGrammar(N-1, (K+1)/2);
        //0->01
    	if(ans % 2 == 0)
        	return 1-(K%2);
    	//1->10
    	return (K%2);
    }
}
