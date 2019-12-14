/**
给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
任何左括号 ( 必须有相应的右括号 )。
任何右括号 ) 必须有相应的左括号 ( 。
左括号 ( 必须在对应的右括号之前 )。
* 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
一个空字符串也被视为有效字符串。
*/
class Solution {
    public boolean checkValidString(String s) {
        int r=0;
        int t=0;
        if(s.length()<1)
            return true;
        if(s.length()<2&&s.charAt(0)!='*')
            return false;
        for(char c:s.toCharArray())
            if(c=='*')
                t++;
        //从左至右
        for(char c:s.toCharArray()){
            if(r<0)
              return false;
          switch(c){
              case ')':r--;break;
              case '(':r++;break;
              case '*':r++;break;
              default: return false;
            }
        }
        //*的数量
        if(r<=t)
            return true;
        r=0;
       //从右至左
       for(int i=s.length()-1;i>=0;i--){
           char c=s.charAt(i);
           if(r<0)
            return false;
           switch(c){
              case ')':r++;break;
              case '(':r--;break;
              case '*':r++;break;
              default: return false;
            }
        }
        if(r<=t)
            return true;
        return false;
    }
}
