class Solution {

    class Pair {
        int val;
        int ind;
        public Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Pair> st = new Stack<>();
        int max = 0;
        for (int i = 0 ; i < heights.length ; i++) {
            while(!st.isEmpty() && st.peek().val >= heights[i]) {
                Pair top = st.pop();
                int start = st.isEmpty() ? 0 : st.peek().ind + 1;
                max = Math.max(max, (i - start) * top.val);
            }
            st.push(new Pair(heights[i], i));
        }
        int last = heights.length;
        while(!st.isEmpty()) {
            Pair num = st.pop();
            int start = 0;
            if(!st.isEmpty()) {
                start = st.peek().ind + 1;
            }
            int area = (last - start) * num.val;
            max = Math.max(max, area);
        }
        return max;
    }
}
