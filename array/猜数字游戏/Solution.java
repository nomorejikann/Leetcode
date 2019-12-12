/**你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，
告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。
你的朋友将会根据提示继续猜，直到猜出秘密数字。
请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
请注意秘密数字和朋友的猜测数都可能含有重复数字。
*/
class Solution {
    public String getHint(String secret, String guess) {
        char[] serChars = secret.toCharArray();
        char[] guesChars = guess.toCharArray();
        //bullket
        int[] secNums = new int[10];
        int[] guesNums = new int[10];
        int bulls = 0;
        for (int i = 0; i < serChars.length; i++) {
            if (serChars[i] == guesChars[i]) {
                bulls++;
            }
            secNums[serChars[i] -'0']++;
            guesNums[guesChars[i] - '0']++;
        }
        int cow = 0;
        for (int i = 0; i <= 9; i++) {
            //两个桶是否有相同的数字，即最小交集
            int min = secNums[i] < guesNums[i] ? secNums[i] :guesNums[i];
            cow += min;
        }
        cow -= bulls;
        return bulls+"A"+cow+"B";
    }
}
