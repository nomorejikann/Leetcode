/**
 * 使用栈实现队列的下列操作：

push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。
 * @author Nomorejikann
 *
 */
class MyQueue {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    int size = 0;
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	//input
        stack.push(x);
        size++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int i  = 0;
        while(i++ < size) {
            stack2.push(stack.pop());
        }
        //移除最先的
        int result = stack2.pop();
        size--;
        i = 0;
        //还原
        while(i++ < size) {
            stack.push(stack2.pop());
        }
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
        int i  = 0;
        //peek最先的
        while(i++ < size) {
            stack2.push(stack.pop());
        }
        int result = stack2.peek();
        i = 0;
        //还原
        while(i++ < size) {
            stack.push(stack2.pop());
        }
        return result;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
