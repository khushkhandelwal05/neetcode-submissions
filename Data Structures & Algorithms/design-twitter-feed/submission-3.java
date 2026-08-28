class Twitter {

    class Tweet {
        Integer id;
        Integer cnt;
        Tweet(int id, int cnt) {
            this.id = id;
            this.cnt = cnt;
        }
    }

    HashMap<Integer, Set<Integer>> users;
    HashMap<Integer, ArrayList<Tweet>> tweets;
    int count = 0;

    public Twitter() {
        users = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)) users.put(userId, new HashSet<>());
        if(!tweets.containsKey(userId)) tweets.put(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, count++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> a.cnt - b.cnt);
        if(tweets.containsKey(userId)) {
            for(Tweet tw : tweets.get(userId)) {
                pq.add(tw);
                if(pq.size() > 10) pq.poll();
            }
        }
        if(users.containsKey(userId)) {
            for(Integer i : users.get(userId)) {
                if (i == userId) continue;
                for(Tweet tw : tweets.get(i)) {
                    pq.add(tw);
                    if(pq.size() > 10) pq.poll();
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while(!pq.isEmpty()) {
            arr.add(pq.poll().id);
        }
        Collections.reverse(arr);
        return arr;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
             users.put(followerId, new HashSet<>());
        }
        users.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) return;
        users.get(followerId).remove(followeeId);
    }
}
