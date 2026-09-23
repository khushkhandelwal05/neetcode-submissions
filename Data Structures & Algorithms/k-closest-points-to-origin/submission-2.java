class Solution {

    class Pair {
        double x;
        double y;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(Math.sqrt((a.x * a.x) + (a.y * a.y)),                                                              Math.sqrt((b.x * b.x) + (b.y * b.y))));

        for(int[] point : points) {
            pq.add(new Pair(point[0], point[1]));
        }

        int[][] res = new int[k][2];


        for(int i = 0 ; i < k ; i++) {
            Pair val = pq.poll();
            res[i][0] = (int)val.x;
            res[i][1] = (int)val.y;
        }


        return res;

    }
}
