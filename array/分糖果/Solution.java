/**
给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。
回妹妹可以获得的最大糖果的种类数。
*/
class Solution {
	//寻找最大最小值区间,然后创建数组进行记录
	public int distributeCandies(int[] candies) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int candy : candies) {
			if (candy > max) {
				max = candy;
			}
			if (candy < min) {
				min = candy;
			}
		}

		boolean[] arrs = new boolean[max - min + 1];//默认false
		int kind = 0;
		for (int candy : candies) {
			if (!arrs[candy - min]) {//没有遇到过
				kind++;
				arrs[candy - min] = true;//改为已经遇到过
			}
		}

		return kind >= candies.length / 2 ? candies.length / 2 : kind;
	}
}
