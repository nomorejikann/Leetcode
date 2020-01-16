/**
给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。

通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
*/
class Solution {
    public int dayOfYear(String date) {
         String year = date.substring(0,4);
        String month = date.substring(5,7);
        String day = date.substring(8);
        
        String[] bigMonth = {"1","3","5","7","8","10","12"};
        //默认二月28天
        int two = 28;
        int total = 0;
        //累加月
        for(int i=1;i<Integer.valueOf(month);i++){
            if(i ==2){
                if(Integer.valueOf(year) % 100 == 0){
                    if(Integer.valueOf(year) % 400 == 0){
                        two = 29;
                    }
                }else if(Integer.valueOf(year) % 4 == 0){
                    two = 29;
                }
                total += two;
            }else if(Arrays.asList(bigMonth).contains(String.valueOf(i))){
                total += 31;
            }else {
                total += 30;
            }
        }
        //天
        total += Integer.valueOf(day);
        return total;

    }
}
