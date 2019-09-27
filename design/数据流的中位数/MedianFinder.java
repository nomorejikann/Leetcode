class MedianFinder {

    //最大堆
	PriorityQueue<Integer> maxQueue;
    //最小堆
	PriorityQueue<Integer> minQueue;
    /** initialize your data structure here. */
    public MedianFinder() {
        
    	maxQueue = new PriorityQueue<>((a,b)->b-a);
       
    	minQueue = new PriorityQueue<>();
    }
    public void addNum(int num) {
    	
    	//堆新增
        if(maxQueue.isEmpty() || num<=maxQueue.peek()){
               maxQueue.add(num);
               
        }else{
            minQueue.add(num);
            
        }
        //调整堆的大小
        if(maxQueue.size()==minQueue.size()+2){
            minQueue.add(maxQueue.poll());
        }
       //调整堆的大小
        if(minQueue.size()==maxQueue.size()+2){
            maxQueue.add(minQueue.poll());
        }

    }

    public double findMedian() {
        if(maxQueue.size()==minQueue.size())
            return (double)(maxQueue.peek()+minQueue.peek())/2;
        if(maxQueue.size()>minQueue.size())
                return maxQueue.peek();
        return minQueue.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
