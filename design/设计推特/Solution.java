/**
设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：

postTweet(userId, tweetId): 创建一条新的推文
getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
follow(followerId, followeeId): 关注一个用户
unfollow(followerId, followeeId): 取消关注一个用户

*/
import java.util.*;
class Twitter {
    //全局时间戳
    private  int timeStamp=0;
    //Tweet是有序链表,按照时间戳来排序
    private  Map<Integer,Tweet> userTweetMap=new HashMap<>();
    //followMap
    private  Map<Integer,Set<Integer>> userFollowMap=new HashMap<>();;

    public Twitter() {}
    
    public void postTweet(int userId, int tweetId) {
        Tweet oldHead=userTweetMap.get(userId);
        userTweetMap.compute(userId,(k,v)->new Tweet(tweetId,++timeStamp)).next=oldHead;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq=new PriorityQueue<>((t1,t2)->t2.time-t1.time);
        List<Integer> feed=new ArrayList<>();
        follow(userId,userId);
        userFollowMap.get(userId).forEach(followerId->Optional.ofNullable(userTweetMap.get(followerId)).ifPresent(tw->pq.offer(tw)));
        int count=0;
        while(!pq.isEmpty() && count<10){
            Tweet tw=pq.poll();
            feed.add(tw.twId);
            if(tw.next!=null){
                pq.offer(tw.next);
            }
            count++;
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowMap.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Optional.ofNullable(userFollowMap.get(followerId)).ifPresent(set->set.remove(followeeId));
    }
}

class Tweet{
    int twId;
    int time;
    Tweet next;
    public Tweet(int twId,int time){
        this.twId=twId;
        this.time=time;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
