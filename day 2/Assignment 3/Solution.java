import java.util.*;
class Solution{
	public static String isMatching(String str){
Stack<Character> x = new Stack<Character>();

    for (int i = 0; i < str.length(); i++) {
        Character ch = str.charAt(i);
        if (str.charAt(i) == '{' || str.charAt(i) == '['
                || str.charAt(i) == '(') {
            x.push(str.charAt(i));
        } else {
            if (x.isEmpty() 
                    || (x.peek() == '[' && ch == '[')
                    || (x.peek() == '{' && ch == '{')
                    || (x.peek() == '(' && ch == '(')) {
                return "NO";
            } else {
                x.pop();
            }
        }
    }
    if (x.empty())
        return "YES";
    return "NO";
}
}
