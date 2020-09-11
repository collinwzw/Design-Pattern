class Solution1551 {
    public int minOperations(int n) {
        // we need to know what value are we going to change to, it seems the median value in the array is the best. (2 * n/2) + 1 for odd n and (2*(n/2)) for even
        
        //eg:
        // n = 6 => [1,3,5,7,9,11],  we want value 6
        // n = 4 => [1,3,5,7], we want value 4
        
        // the absolute value of difference in each side of the array respect to the median value is the same. so actually we just need to count the how many element there
        // [1,3,5....i-2, i, i + 2 .... 2*n-1 ,2*n+1]
        // so the operation we need for n=odd is [i-1,... ,6,4,2,0,  ]
        // so all we need to do is sum from 0 to i-1 where i increment 2 each time
        
        // for n = even  [i-1, .... 5,3,1,1,3....]
        // sum from 1 to i - 1 where i increment 2 each time
        
        
        int result = 0;
        
        int start;
        
        if (n%2 == 0)
        {
            start = 1;
        }
        else
        {
            start = 0;
        }
        result += start ;
        
        while (start < (n-1))
        {
            start += 2;
            result += start ;
        }
        
        return result;
    }
}