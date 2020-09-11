class Solution1300 {
    public int findBestValue(int[] arr, int target) {
        // we can sort the array O(nlogn)
        // then binary search the value target/number of element in array
        Arrays.sort(arr);
        int n = arr.length, i = 0;
        while (i < n && target > arr[i] * (n - i)) {
            target -= arr[i++];
        }
        if (i == n) return arr[n - 1];
        int res = target / (n - i);
        if (target - res * (n - i) > (res + 1) * (n - i) - target)
            res++;
        return res;
    }
}