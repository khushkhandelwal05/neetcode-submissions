class Solution {
    public int carFleet(int target, int[] pos, int[] sp) {
        ArrayList<Pair> cs = new ArrayList<>();
        double tar = target;
        for (int i = 0 ; i < pos.length ; i++) {
            cs.add(new Pair(pos[i], sp[i]));
        }
        cs.sort(Comparator.comparingInt(a -> a.key));
        double[] time = new double[pos.length];
        for(int i = 0 ; i < cs.size() ; i++) {
            time[i] = (tar - cs.get(i).key) / cs.get(i).val;
        }
        Stack<Double> st = new Stack<>();
        for (int i = 0 ; i < time.length ; i++) {
            while(!st.isEmpty() && time[i] >= st.peek()){
                st.pop();
            }
            st.push(time[i]);
        }
        return st.size();
    }

     // Helper class
    static class Pair {
        int key;
        int val;

        Pair(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
}
