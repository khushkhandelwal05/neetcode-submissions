class TimeMap {

    // [1,3,4,6,7]

    HashMap<String, HashMap<Integer, String>> hm;
    HashMap<String,ArrayList<Integer>> har;

    public TimeMap() {
        hm = new HashMap<>();
        har = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.putIfAbsent(key,new HashMap<>());
        hm.get(key).put(timestamp,value);
        har.putIfAbsent(key,new ArrayList<>());
        har.get(key).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)){
            return "";
        }
        if(hm.get(key).containsKey(timestamp)){
            return hm.get(key).get(timestamp);
        }
        ArrayList<Integer> ar = har.get(key);
        int s = 0;
        int e = ar.size() - 1;
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (ar.get(mid) >= timestamp) {
                e = mid - 1;
            } else {
                ans = ar.get(mid);
                s = mid + 1;
            }
        }
        if(ans == -1) {
            return "";
        }
        return hm.get(key).get(ans);
    }
}
