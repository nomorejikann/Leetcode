/**
给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
*/
class Solution {
    public int subarraysDivByK(int[] A, int K) {
       int[] map=new int[K];
        map[0]=1;
        int sum=0;
        int r=0;
        for(int i:A){
            sum=(sum+i)%K;
            if(sum<0)
                sum+=K;
            r+=map[sum];
            map[sum]++;
        }
        return r;
    }
}
