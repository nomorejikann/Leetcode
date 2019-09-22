package design;

import java.util.Hashtable;
/**
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，
它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {
	class DLinkedNode {
		  int key;
		  int value;
		  DLinkedNode pre;
		  DLinkedNode next;
		}
	//数据结构
	private Hashtable<Integer, DLinkedNode> cache = 
			new Hashtable<Integer, DLinkedNode>();
	//使用量
	private int count;
	//容量
	private int capacity;
	//头，尾//作为起始点
	private DLinkedNode head, tail;

		/**
		 * 添加到头的下一个
		 */
		private void addNode(DLinkedNode node) {
		    
		  node.pre = head;
		  node.next = head.next;

		  head.next.pre = node;
		  head.next = node;
		}

		/**
		 * 删除已存在的
		 */
		private void removeNode(DLinkedNode node){
		  DLinkedNode pre = node.pre;
		  DLinkedNode next = node.next;

		  pre.next = next;
		  next.pre = pre;
		}

		/**
		 * 移动到头的下一个(删除并新增一个)
		 */
		private void moveToHead(DLinkedNode node){
		  this.removeNode(node);
		  this.addNode(node);
		}

		//删除最后一个(过期的)尾的前一个
		private DLinkedNode popTail(){
		  DLinkedNode res = tail.pre;
		  this.removeNode(res);
		  return res;
		}



		public LRUCache(int capacity) {
		  this.count = 0;
		  this.capacity = capacity;

		  head = new DLinkedNode();
		  head.pre = null;

		  tail = new DLinkedNode();
		  tail.next = null;

		  head.next = tail;
		  tail.pre = head;
		}

		public int get(int key) {

		  DLinkedNode node = cache.get(key);
		  if(node == null){
		    return -1; 
		  }

		  this.moveToHead(node);

		  return node.value;
		}


		public void put(int key, int value) {
		  DLinkedNode node = cache.get(key);
		  //新增
		  if(node == null){

		    DLinkedNode newNode = new DLinkedNode();
		    newNode.key = key;
		    newNode.value = value;

		    this.cache.put(key, newNode);
		    this.addNode(newNode);

		    ++count;

		    //更新最旧值
		    if(count > capacity){
		      // pop the tail
		      DLinkedNode tail = this.popTail();
		      this.cache.remove(tail.key);
		      --count;
		    }
		  //已存在，更新值到头部
		  }else{
		    // update the value.
		    node.value = value;
		    this.moveToHead(node);
		  }
		}
}

