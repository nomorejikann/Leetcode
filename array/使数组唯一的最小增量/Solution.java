/**

给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。

返回使 A 中的每个值都是唯一的最少操作次数。
*/
class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int c = 0;
 
        for(int i = 0; i < A.length-1; i++){
            if(A[i+1] <= A[i]){
              int t = A[i+1];
              A[i+1] = A[i]+1;
              c+= A[i+1] - t;
            }
        }

        return c;
    }
}
