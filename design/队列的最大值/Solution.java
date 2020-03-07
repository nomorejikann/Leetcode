/**
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1
*/
class MaxQueue {
    int max = -1;
    LinkedList<Integer> list;
    Queue<Integer> deQue;
    public MaxQueue() {
        list = new LinkedList<>();
        deQue = new LinkedList<>();
    }
    
    public int max_value() {
        if(list.isEmpty())
        return -1;
        return list.getFirst();
    }
    
    public void push_back(int value) {
        deQue.offer(value);
        while(!list.isEmpty() && list.getLast() < value)
            list.removeLast();
        list.addLast(value);
    }
    
    public int pop_front() {
        if(deQue.isEmpty())
          return -1;
        int d = deQue.poll();
        if(d == list.getFirst())
           return list.removeFirst();
        return d;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
