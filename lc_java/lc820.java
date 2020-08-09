class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        int res = 0;
        TrieNode root = new TrieNode();
        for(String s : words){
            if(tryInsert(s, root)){
               res += s.length() + 1; 
            }
        }
        return res;
    }
    
    private boolean tryInsert(String s, TrieNode root){
        boolean res = false;
        char[] arr = s.toCharArray();
        TrieNode curr = root;
        for(int i = arr.length - 1; i >= 0; i--){
            if(!curr.containsKey(arr[i])){
                res = true;
                curr.put(arr[i], new TrieNode());
            }
            curr = curr.get(arr[i]);
        }
        return res;
    }
}

class TrieNode{
    
    private final int R = 26;
    
    private TrieNode[] links;
    
    private boolean isEnd;
    
    public TrieNode(){
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char key){
        return links[key - 'a'] != null;
    }
    
    public TrieNode get(char key){
        return links[key - 'a'];
    }
    
    public void put(char key, TrieNode node){
        links[key - 'a'] = node;
    }
}

class Demo820
{
	public static void main(String[] args)
	{	
		String[] str = {"time", "me", "bell"};
		Solutionlc820 s = new Solutionlc820();
		int result = s.minimumLengthEncoding(str);
		System.out.println(result);
		}
}