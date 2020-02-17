/**
如果一个字符在字符串 S 中有且仅有出现一次，那么我们称其为独特字符。

例如，在字符串 S = "LETTER" 中，"L" 和 "R" 可以被称为独特字符。

我们再定义 UNIQ(S) 作为字符串 S 中独特字符的个数。

那么，在 S = "LETTER" 中， UNIQ("LETTER") =  2。

对于给定字符串 S，计算其所有非空子串的独特字符的个数（即 UNIQ(substring)）之和。

如果在 S 的不同位置上出现两个甚至多个相同的子串，那么我们认为这些子串是不同的。

考虑到答案可能会非常大，规定返回格式为：结果 mod 10 ^ 9 + 7。
*/
class Solution {
    public int uniqueLetterString(String S) {
        Map<Character, List<Integer>> index = new HashMap();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            index.computeIfAbsent(c, x-> new ArrayList<Integer>()).add(i);
        }

        long ans = 0;
        for (List<Integer> A: index.values()) {
            for (int i = 0; i < A.size(); ++i) {
                long prev = i > 0 ? A.get(i-1) : -1;
                long next = i < A.size() - 1 ? A.get(i+1) : S.length();
                ans += (A.get(i) - prev) * (next - A.get(i));
            }
        }

        return (int) ans % 1_000_000_007;
    }
}
