/**
根据逆波兰表示法，求表达式的值。
有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
*/
class Solution {
    public int evalRPN(String[] tokens) {
        int[] STACK = new int[tokens.length];
        //前一个
        int top = -1;
        //当前的
        int cur;
        for ( String token : tokens ) {
            switch ( token ) {
                case "*":
                    cur = top;
                    //出栈两次
                    STACK[--top] = STACK[top] * STACK[cur];
                    break;
                case "+":
                    cur = top;
                    STACK[--top] = STACK[top] + STACK[cur];
                    break;
                case "-":
                    cur = top;
                    STACK[--top] = STACK[top] - STACK[cur];
                    break;
                case "/":
                    cur = top;
                    STACK[--top] = STACK[top] / STACK[cur];
                    break;
                    //数字入栈
                default:
                    STACK[++top] = Integer.valueOf( token );
                    break;
            }
        }
        return STACK[top];

    }
}
