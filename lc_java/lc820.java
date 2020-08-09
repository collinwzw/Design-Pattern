class Solutionlc820 {
    public int minimumLengthEncoding(String[] words) {
        
    	//put the Strings into a result string
    	//check the last char of result string matches the last character of incoming words
    	// if reach the first char of incoming word, then we know it's part of it.
    	 StringBuilder str = new StringBuilder("");
    	 str.append(words[0]);
    	for(int i = 1; i<words.length;i++)
    	{
    		//System.out.println(str);
    		//str.append("#");
    		//System.out.println(str.substring(str.length()-words[i].length()));
    		//System.out.println(str.substring(str.length()-words[i].length()) == words[i]);
    		if (str.length() > words[i].length() &&str.substring(str.length()-words[i].length()).equals( words[i])){
    			str.append("#");
    		}
    		else
    		{
    			str.append("#" + words[i]);
    		}
    		
    	}
    	
    	return str.length();
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