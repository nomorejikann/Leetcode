/*
*实现一个数据结构支持以下操作：
Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
*/
class AllOne {
	Map<String, Integer> data = new HashMap<>();
	TreeMap<Integer, Set<String>> weight = new TreeMap<>();

	/** Initialize your data structure here. */
	public AllOne() {

	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		int c = data.getOrDefault(key, 0);
		data.put(key, c + 1);
		// 移除之前的
		Set<String> set = weight.get(c);
		if (set != null) {
			if (set.size() == 1)
				weight.remove(c);
			else
				set.remove(key);
		}

		// 加入当前的
		set = weight.get(c + 1);
		if (set == null) {
			set = new HashSet<>();
			set.add(key);
			weight.put(c + 1, set);
		} else {
			set.add(key);
		}

	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the data
	 * structure.
	 */
	public void dec(String key) {
		if (data.get(key) == null)
			return;
		int c = data.get(key);

		Set<String> set = weight.get(c);
		// 1则移除
		if (c == 1)
			data.remove(key);
		else
			data.put(key, c - 1);

		// 改变权重
		if (set.size() == 1) {
			weight.remove(c);
		} else {
			set.remove(key);
		}
		// 减一
	
		if(c-1 > 0) {
			set = weight.get(c-1);
			if (set == null) {
				set = new HashSet<>();
				set.add(key);
				weight.put(c - 1, set);
			} else {
				set.add(key);
			}
		}
		
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		// 不存在最大
		if (weight.size() < 1)
			return "";
		for (String s : weight.lastEntry().getValue())
			return s;
		return "";
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		// 不存在最小
		if (weight.size() < 1)
			return "";
		for (String s : weight.firstEntry().getValue())
			return s;
		return "";
	}
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
