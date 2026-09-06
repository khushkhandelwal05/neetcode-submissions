class Solution {

    class Pair {
        int val;
        int ind;
        public Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }

    public int[] dailyTemperatures(int[] temp) {
        Stack<Pair> st = new Stack<>();
        int[] res = new int[temp.length];
        for(int i = 0 ; i < temp.length ; i++) {
            if(st.isEmpty()){
                 st.push(new Pair(temp[i], i));
                 continue;
            }
            while(!st.isEmpty() && st.peek().val < temp[i]) {
                Pair ro = st.pop();
                res[ro.ind] = i - ro.ind;
            }
            st.push(new Pair(temp[i], i));
        } 
        return res;
    }
}
