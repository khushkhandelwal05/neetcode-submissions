class Solution {
    class Pair {
        int pos;
        int speed;
        public Pair(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<Pair> pod = new ArrayList<>();
        for(int i = 0 ; i < speed.length ; i++) {
            pod.add(new Pair(position[i], speed[i]));
        }
        Collections.sort(pod, (a,b) -> a.pos - b.pos);
        Stack<Double> st = new Stack<>();
        for(int i = 0 ; i < pod.size() ; i++) {
            Double time = ((double)target - pod.get(i).pos) / pod.get(i).speed;
            if(st.isEmpty()) {
                st.push(time);
            }
            while(!st.isEmpty() && st.peek() <= time) {
                st.pop();
            }
            st.push(time);
        }
        return st.size();
    }
}
