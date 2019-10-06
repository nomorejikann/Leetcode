    /**
     * 编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
     * @param n
     * @return
     */
class Solution {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<Integer>();
        //4必定不是快乐数
        while(n!=4) {
        	//按照位数添加
        	while(n!=0) {
        		list.add(n%10);
        		n/=10;
        	}
        	int temp = 0;
        	for(int i:list) {
        		temp+=i*i;
        	}
        	if(temp==1) {
        		return true;
            //下一轮
        	}else {
        		list.clear();
        		n = temp;
        	}
        }
		return false;
    }
}
