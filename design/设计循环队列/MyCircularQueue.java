class MyCircularQueue {
    int size;
	int head = -1;
	int tail = -1;
	int[] data;
	
	 /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {

        data = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        //已满
    	if(size == data.length)
        	return false;
    	//tail+1
    	tail = (tail+1) % data.length;
    	data[tail] = value;
    	//初次
    	if(size == 0) 
    		head = tail;
    	size++;
    	return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size == 0)
        	return false;
        //head+1
        head = (head + 1) % data.length;
        size--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(size == 0)
        	return -1;
        return data[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if(size == 0)
        	return -1;
        return data[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return data.length == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
