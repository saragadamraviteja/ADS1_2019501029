import java.util.*;
final class Solution {
    private Solution() {
        // for check style
    }
    /**.
     * checks for input char and push into stack
     * or pop accordingly
     * @param str  input string 
     * @return  balanced or not
     */
    public static String isMatching(final String str) {
        Stack2 x = new Stack2(str.length());
        // Stack<Character> x = new Stack<Character>();
    if(str.charAt(0) == '{' || str.charAt(0) == '['
        || str.charAt(0) == '(') {
            x.push(str.charAt(0));
    } else return "NO";
    for (int i = 1; i < str.length(); i++) {
        Character ch = str.charAt(i);
        if (str.charAt(i) == '{' || str.charAt(i) == '['
                || str.charAt(i) == '(') {
            x.push(str.charAt(i));
        } else if(ch == '}' && (x.pop() == '{')) {
                continue;
        } else if(ch == ']' && (x.pop() == '[')) {
                continue;
        } else if(ch == ')' && (x.pop() == '(')) {
                continue;
        } else return "NO";
    }
    if (x.isEmpty()) {
        return "YES";
    }
    return "NO";
}
}

