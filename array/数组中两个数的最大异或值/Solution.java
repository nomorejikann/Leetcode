/**
给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
返回仅包含 1 的最长（连续）子数组的长度。
*/
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            // 从最高位试着找nums的前缀
            mask = mask | (1 << i);
            HashSet<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(mask & num);
            }
            //判断最大异或结果的当前位是否为1
            int temp=max|(1<<i);
            for (int prefix: set){
                if (set.contains(prefix^temp)) {
                    max=temp;
                }
            }
        }
        return max;

    }
}
