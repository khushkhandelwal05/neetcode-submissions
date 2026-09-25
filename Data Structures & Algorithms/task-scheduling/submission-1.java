class Solution {
    class Pair {
        int count;
        int time;

        public Pair(int count, int time) {
            this.time = time;
            this.count = count;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int curT = 0;
        Queue<Pair> qu = new LinkedList<>();

        int[] count = new int[26];
        for(char task : tasks) {
            count[task - 'A']++;
        }

        for(int i : count) {
            if(i > 0) {
                pq.add(i);
            }
            
        }

        while(!pq.isEmpty() || !qu.isEmpty()) {

            if(!qu.isEmpty() && qu.peek().time == curT) {
                pq.add(qu.poll().count);
            }

            if(!pq.isEmpty()) {
                int val = pq.poll();
                val--;
                if(val != 0){
                    qu.add(new Pair(val, curT + n + 1));
                }
            }

            curT++;
        }

        return curT;
    }
}
