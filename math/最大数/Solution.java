class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) 
        	 arr[i] =  String.valueOf(nums[i]);
        //比较器
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        if (arr[0].equals("0")) 
            return "0";
        
        for (String temp : arr) 
            sb.append(temp);
        return sb.toString();
    }
}
