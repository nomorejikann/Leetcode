给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。

注意:

给定的整数保证在32位带符号整数的范围内。
你可以假定二进制数不包含前导零位。
*/
class Solution {
    public int findComplement(int num) {
        int tmp = num;
        int num2 = 1;
        while(tmp>0){
            num2<<=1;
            tmp>>=1;
        }
        num2-=1;
        return num^num2;
    }
}
