/**

字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
*/
class Solution {
    public String compressString(String S) {
        if(S.length() < 2)
        return S;
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        char pre = arr[0];
        int count = 0;
        for(char c : arr){
            if(pre == c){
                count++;
            }else{    
                sb.append(pre).append(count);
                count = 1;
                pre = c;
            }
        }
        sb.append(S.charAt(S.length()-1)).append(count);
        if(sb.length() >= S.length())
        return S;
        return sb.toString();
    }
}
