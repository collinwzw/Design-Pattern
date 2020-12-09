class Solution56 {
    public int[][] merge(int[][] intervals) {
    int[] startingTime = new int[intervals.length];
    int[] endingTime = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++){
      startingTime[i] = intervals[i][0];
      endingTime[i] = intervals[i][1];
    }
    
    Arrays.sort(startingTime);
    Arrays.sort(endingTime);
    
    List<int[]> result = new ArrayList<>();
    for (int i = 0; i < intervals.length; i ++){
      int currentIndex = i;
      while(currentIndex < intervals.length - 1 &&startingTime[currentIndex+1] <= endingTime[currentIndex]){
        currentIndex++;
      }
      //non-overlap
      result.add( new int[] {startingTime[i], endingTime[currentIndex]});
      i = currentIndex ;
    }
    
    int[][] r = new int[result.size()][2];
    result.toArray(r);
    return r;
  }
}