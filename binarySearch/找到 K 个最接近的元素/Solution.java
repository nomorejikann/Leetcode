	/**
	 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
	 * @param arr
	 * @param k
	 * @param x
	 * @return
	 */
class Solution{
public List<Integer> findClosestElements(int[] arr, int k, int x) {
    	//移动次数
        int removeNums = arr.length-k;
        int left = 0;
        int right = arr.length-1;
        //向中心点缩进
        while(removeNums-- > 0){
        	//左边距离比右边小
        	if(x-arr[left] <= arr[right]-x){
                //小于等于 都移动右指针
                right--;
            //右边距离比左边小
        	}else{
                left++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = left; i <= right; i++){
            list.add(arr[i]);
        }
        return list;
    }
}
