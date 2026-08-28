class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == ')') {
                if(!st.isEmpty() && st.pop() == '(') {
                    continue;
                } else {
                    return false;
                }
            }
            if(c == ']') {
                if(!st.isEmpty() && st.pop() == '[') {
                    continue;
                } else {
                    return false;
                }
            }
            if(c == '}') {
                if(!st.isEmpty() && st.pop() == '{') {
                    continue;
                } else {
                    return false;
                }
            }
            st.push(c);
        }
        return st.isEmpty();
    }
}
