/**
给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
*/
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
          map.put(i, map.getOrDefault(i, 0)+1);
        List<Integer> ans = new ArrayList<>();
        for(Integer i : map.keySet()){
            int v = map.get(i);
            if(ans.contains(v))
              return false;
            ans.add(v);
        }
        return true;
    }
}
