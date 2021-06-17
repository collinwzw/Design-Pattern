import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;



class Solution275 {
    public int hIndex(int[] citations) {
        int result = 0;
        for (int i = citations.length; i> 0; i--){
            if (citations[i - 1] > citations.length - i) result++;
        }
        return result;
    }
}


