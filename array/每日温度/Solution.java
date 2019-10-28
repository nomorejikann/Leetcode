    /**
     * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     * @param T
     * @return
     */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        for(int i = T.length-2; i >=0; i--) {
        	//加上之前升高天数
        	for(int j = i+1; j < T.length; j+=ans[j]) {
        		if(T[i] < T[j]) {
        			ans[i] = j - i;
        			break;
        		//之后没有升高
        		}else if(ans[j] == 0) {
        			break;
        		}
        	}
        }
        return ans;
    }
}
