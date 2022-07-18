package D12;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author zjy
 * @version 1.0
 */

public class I1 {
    public static void main(String[] args) {
        String[] s = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(s));
    }
    /**
     * 逆波兰表达式
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int n = tokens.length;
        int res = 0;
        while(i < n){
            String token = tokens[i];
            i++;
            if("+-*/".contains(token)){
                int n1 = stack.pop();
                int n2 = stack.pop();
                switch (token){
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n2 - n1;
                        break;
                    case "*":
                        res = n1 * n2;
                        break;
                    case "/":
                        res = n2 / n1;
                        break;
                }
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
