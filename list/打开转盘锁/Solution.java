/*
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
*/
class Solution {
     public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        String start="0000";
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue1.offer(start);
        int step=0;
        if(dead.contains(target)||dead.contains("0000")) return -1;
        while(!queue1.isEmpty()){
            String cur=queue1.poll();
            if(target.equals(cur)){
                return step;
            }
            List<String> nexts= getNexts(cur);
            for(String s:nexts){
                if(!dead.contains(s)&&!visited.contains(s)){
                    visited.add(s);
                    queue2.offer(s);
                }
            }
            if(queue1.isEmpty()){
                queue1=queue2;
                queue2=new LinkedList<String>();
                step++;
            }
            
        }
        return -1;
    }
/**
*获取邻接的所有节点
*/
    public List<String> getNexts(String cur){
        List<String> list = new ArrayList<>();
        
        for(int i=0;i<4;i++){
            StringBuilder curSb= new StringBuilder(cur);
            curSb.setCharAt(i,cur.charAt(i)=='0'?'9':(char)(cur.charAt(i)-1));
            list.add(curSb.toString());
            curSb.setCharAt(i,(char)cur.charAt(i)=='9'?'0':(char)(cur.charAt(i)+1));
            list.add(curSb.toString());
               
        }
        return list;
        
    }
}
