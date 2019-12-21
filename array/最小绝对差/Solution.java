/**
给你个整数数组 arr，其中每个元素都 不相同。
请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
*/
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = 0x7fffffff;
        for(int i = 1; i < arr.length; i++)
          min = Math.min(min, arr[i]-arr[i-1]);
        List<List<Integer>> ans = new ArrayList<>();
         for(int i = 1; i < arr.length; i++){
             if(arr[i]-arr[i-1] == min){
                 List<Integer> l  = new ArrayList<>();
                 l.add(arr[i-1]);
                 l.add(arr[i]);
                 ans.add(l);
             }
         }
         return ans;
    }
}
