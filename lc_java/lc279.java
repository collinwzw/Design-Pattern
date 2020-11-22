class Solution279 {
    public int numSquares(int n) {
       //we have to use dp here
        // for each possible number from 1 tp n, we compute the least number of 
        //perfect square numbers
        // but we need to generate list of all possible perfect square number dynamically
        //
        //Time Complexity O()

    int[] dp = new int[n + 1];
        
    for (int i = 1; i <= n; i++) {
        dp[i] = Integer.MAX_VALUE;
    }
    
    for (int i = 1; i <= n; i++) {
        int sqrt = (int)Math.sqrt(i);
        
        if (sqrt * sqrt == i) {
            dp[i] = 1;
            continue;                
        }
        
        for (int j = 1; j <= sqrt; j++) {
            int dif = i - j * j;
            dp[i] = Math.min(dp[i], (dp[dif] + 1));
        }
    }
    
    return dp[n];
}