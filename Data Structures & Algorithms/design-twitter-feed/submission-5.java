class Twitter {

    class Pair {
        int time;
        int tweetId;

        public Pair(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }
    
    int time;
    // Maps a user to the set of people THEY are following
    HashMap<Integer, Set<Integer>> following;
    // Maps a user to their list/queue of tweets
    HashMap<Integer, List<Pair>> tweets;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        // Using a List makes it simpler to retrieve than a Queue
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Pair(time++, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Min-heap to keep track of the top 10 most recent tweets
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        // 1. Get tweets from the user themselves
        if (tweets.containsKey(userId)) {
            for (Pair p : tweets.get(userId)) {
                pq.add(p);
                if (pq.size() > 10) pq.poll(); // Evict the oldest if size > 10
            }
        }

        // 2. Get tweets from everyone the user follows
        if (following.containsKey(userId)) {
            for (Integer followeeId : following.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    for (Pair p : tweets.get(followeeId)) {
                        pq.add(p);
                        if (pq.size() > 10) pq.poll();
                    }
                }
            }
        }

        // 3. Extract elements from heap (goes from oldest to newest)
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().tweetId);
        }

        // 4. Reverse to get newest first
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        // A user shouldn't follow themselves in the map logic
        if (followerId == followeeId) return;
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
