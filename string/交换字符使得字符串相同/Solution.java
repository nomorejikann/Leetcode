/**
有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
*/
class Solution {
    public int minimumSwap(String s1, String s2) {
        int c1 = 0;
        int c2 = 0;
        int df1 = 0;
        int df2 = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == 'x'){
                c1++;
                if(s2.charAt(i) == 'y')
                  df1++;
            }else{
                c2++;
                if(s2.charAt(i) == 'x')
                  df2++;
            }
            if(s2.charAt(i) == 'x')
              c1++;
            else
              c2++;
        }

        if(c1 % 2 != 0 || c2 % 2 != 0)
          return -1;
        return df1/2+df1%2+df2/2+df2%2;
    }
}
