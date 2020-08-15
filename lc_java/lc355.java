import java.util.*;

class Person
{	
	public Queue<Integer> tweets = new PriorityQueue<>(10);
	public int personid;
	public Set<Integer> followed = new HashSet<Integer>();
	public Set<Integer> beFollowed = new HashSet<Integer>();

	public Person(int personid)
	{
		this.personid = personid;
	}
	public void follow(int followedID)
	{
		followed.add(followedID);
		
	}
	public void beFollowed(int followerID)
	{
		beFollowed.add(followerID);
	}
	public void addtweet(int tweetid)
	{
		if(tweets.size() == 10)
		{
			tweets.remove();
			tweets.add(tweetid);
		}
		else
		{
			tweets.add(tweetid);
		}
	}
}
class Tweet
{
	
}
class Twitter {

    /** Initialize your data structure here. */
	private Map<Integer, Person> users= new HashMap<>();
	private Map<Integer, Queue<Integer>> tweet_map= new HashMap<>();

	private int user_number = 0;
	
    public Twitter() {
        // have a hashmap which store list of follower for each followee. we can use set here since following same follower is not allowed
    	for (int i=0; i<100; i++)
    	{
    		users.put(i, new Person(i));
    	}
    	
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	
    	users.get(userId).addtweet(tweetId);

    	for(Integer follower: users.get(userId).beFollowed)
    	{
        	users.get(follower).addtweet(tweetId);
    	}
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        return new ArrayList<Integer>(users.get(userId).tweets);
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

        	users.get(followeeId).beFollowed(followerId);
        	users.get(followerId).follow(followeeId);


    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	users.get(followerId).followed.remove(followeeId);
    	users.get(followeeId).beFollowed.remove(followerId);

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

class Demolc355
{
	public static void main(String[] args)
	{
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		
		twitter.follow(1, 2);
		twitter.postTweet(2, 6);
		System.out.println(twitter.getNewsFeed(1));
		twitter.unfollow(1, 2);
		System.out.println(twitter.getNewsFeed(1));
	}
}