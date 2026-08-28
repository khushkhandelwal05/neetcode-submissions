class Solution {

    class Point {
        int[] pos;
        double dist;

        Point(int[] pos, double dist) {
            this.pos = pos;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> Double.compare(a.dist, b.dist));
        for(int[] pos : points) {
            double dist = Math.sqrt((pos[0] * pos[0]) + (pos[1] * pos[1]));
            System.out.println(dist);
            Point po = new Point(pos, dist);
            pq.add(po);
        }

        int[][] ans = new int[k][2];

        for(int i = 0 ; i < k ; i++){
            ans[i] = pq.poll().pos;
        }

        return ans;
    }
}
