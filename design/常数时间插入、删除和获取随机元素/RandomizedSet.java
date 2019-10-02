/**
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
insert(val)：当元素 val 不存在时，向集合中插入该项。
remove(val)：元素 val 存在时，从集合中移除该项。
getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。

 *
 */
public class RandomizedSet {
	private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rd;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rd = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        map.put(val, list.size());
        list.add(val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int idxRemove = map.remove(val);
        //总是移除list最后一位
        if(idxRemove != list.size() - 1) {
            int valLast = list.get(list.size() - 1);
            //更新索引,将移除的位置更新为最后一位
            map.put(valLast, idxRemove);
            //最后一位覆盖要移除的idx
            list.set(idxRemove, valLast);
        }
        //移除最后一位
        list.remove(list.size() - 1);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rd.nextInt(list.size()));
    }
}
