/**

给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。

请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。

如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
如果 searchWord 不是任何单词的前缀，则返回 -1 。
字符串 S 的 「前缀」是 S 的任何前导连续子字符串。
*/
public int isPrefixOfWord(String sentence, String searchWord) {
    String[] senArr = sentence.split(" ");
    for (int i = 0 ; i < senArr.length; i++) {
        if (senArr[i].indexOf(searchWord) == 0) return i + 1;
    }
    return -1;
}

