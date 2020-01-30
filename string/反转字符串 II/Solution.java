/**
给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。=
示例:
输入: s = "abcdefg", k = 2
输出: "bacdfeg"
*/
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i += 2 * k) {
            int j = Math.min(i + k - 1, len - 1);
            swapChar(chars, i, j);
        }
        return String.valueOf(chars);
    }

    public void swapChar(char[] cs, int l, int r) {
        int times = (r - l + 1) / 2;
        if (r - l == 1) times = 1;
        for (int i = 0; i < times; i++) {
            char tmp = cs[l + i];
            cs[l + i] = cs[r - i];
            cs[r - i] = tmp;
        }
    }
}
