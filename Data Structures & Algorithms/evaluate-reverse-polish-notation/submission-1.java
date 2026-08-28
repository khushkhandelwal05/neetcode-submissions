class Solution {
    public int evalRPN(String[] to) {
        Stack<Integer> st = new Stack<>();
        for(int k = 0 ; k < to.length ; k++) {
            String op = to[k];
            if (op.equals("+")) {
                int i = st.pop();
                int j = st.pop();
                st.push(i + j);
            } else if (op.equals("-")) {
                int i = st.pop();
                int j = st.pop();
                st.push(j - i);
            } else if (op.equals("*")) {
                int i = st.pop();
                int j = st.pop();
                st.push(i * j);
            } else if (op.equals("/")) {
                int i = st.pop();
                int j = st.pop();
                st.push(j / i);
            } else {
                st.push(Integer.parseInt(op));
            }
        }
        return st.peek();
    }
}
