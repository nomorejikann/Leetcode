/**
设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
*/
class KthLargest {
    int size;
    PriorityQueue<Integer> p ;
    public KthLargest(int k, int[] nums) {
        p = new PriorityQueue<>(k);
        size = k;
        for(int i : nums)
           add(i);
    }
    
    public int add(int val) {
        if(p.size()<size){
            p.offer(val);
        } else if(p.peek() < val){
            p.poll();
            p.offer(val);
        }
        return p.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
