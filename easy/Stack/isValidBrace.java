package Stack;

import java.util.Stack;

/**
 * @program: 20. 有效的括号
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * @author: poooooi
 * @create: 2021-03-03 22:10
 **/

public class isValidBrace {
    private static boolean isValid(String s) {
        //若字符串长度为奇数，则不符合规则，直接返回false
        if (s.length() % 2 != 0) return false;

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stk.push(c);
            } else {
                if (stk.empty()) {
                    return false;
                }
                if ((c == ')' && stk.peek() == '(') || (c == ']' && stk.peek() == '[') || (c == '}' && stk.peek() == '{')) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }
        return stk.empty();
    }

    public static void main(String[] args) {
        String testString = "({[]})";
        String testString1 = "()(){}{}[][]";
        String testString2 = "([[]]{})";
        String testString3 = "{}[()]";

        System.out.println(testString + ":" + isValid(testString));
        System.out.println(testString + ":" + isValid(testString1));
        System.out.println(testString + ":" + isValid(testString2));
        System.out.println(testString + ":" + isValid(testString3));
    }
}