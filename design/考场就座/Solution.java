/**
在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。

当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)

返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
*/
class ExamRoom {
    
    //用list来记录有哪些座位已经有考生在坐
    List<Integer> list;
    int N;
    
    public ExamRoom(int N) {
        list = new ArrayList<Integer>();
        this.N = N;
    }
    
    public int seat() {
        //考场无人，考生做"0"号座位
        if(list.size() == 0){
            list.add(0);
            return 0;
        }  
        //result用来记录考场要坐的座位号，maxLen记录最大距离
        int result = 0, maxLen = list.get(0);
        //计算相邻两位考生之间的距离，且若距离大于当前的maxLen，应该更新maxLen
        for(int i = 0; i < list.size() - 1; i++){
            int a = list.get(i), b = list.get(i + 1);
            if((b - a) / 2 > maxLen){
                result = (a + b) / 2;
                maxLen = (b - a) / 2;
            }
        }
        if(N - 1 - list.get(list.size() - 1) > maxLen){
            result = N - 1;
        }
        
        //寻找第一个大于result的数,为了保证list是有序的(非递减的)。
        int index = lowerBound(list, result);
        list.add(index, result);
        return result;
    }
    
    //lowerBound方法(list是非递减的):
    //在list中找到第一个 大于等于 result 的那个数的索引。
    //基本思想是：二分查找
    //例如 list : {1,2,3,4,6,7,8} ; result : 5;  返回值是4.
    //因为lsit中第一的大于等于5的数是6,其索引为4.
    private int lowerBound(List<Integer> list, int result){
        int min = 0, max = list.size();
        while(min < max) {
            int mid = (max + min) / 2;
            if(result <= list.get(mid)) {
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }
    
    //直接将p从list中移除就好了
    public void leave(int p) {
        list.remove(new Integer(p));
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
