/**
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
*/
class Solution {
    public int rob(int[] nums) {
       int money = 0, tmp = 0, num = 0;
        if (nums == null || nums.length == 0) return money;

        for (int i = 0; i < nums.length; i ++) {
            num = money;
            money = Math.max(tmp + nums[i], money);
            tmp = num;
        }

        return money;
    }
}
