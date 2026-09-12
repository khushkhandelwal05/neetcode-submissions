class TimeMap {

    HashMap<String, ArrayList<Pair>> map;

    class Pair {
        int time;
        String val;

        public Pair(int time, String val) {
            this.time = time;
            this.val = val;
        }
    }

    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Pair> pa = map.getOrDefault(key, new ArrayList<>());
        pa.add(new Pair(timestamp, value));
        Collections.sort(pa, (a, b) -> a.time - b.time);
        map.put(key, pa);
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Pair> pa = map.getOrDefault(key, new ArrayList<>());
        if (pa.size() == 0) return "";
        int s = 0;
        int e = pa.size() - 1;
        int ans = -1;
        while(s <= e) {
            int mid = s + ((e - s) / 2);
            if(pa.get(mid).time == timestamp) return pa.get(mid).val;
            if(pa.get(mid).time > timestamp) {
                e = mid - 1;
            } else {
                s = mid + 1;
                ans = mid;
            }
        }
        return ans == -1 ? "" : pa.get(ans).val;
    }
}
