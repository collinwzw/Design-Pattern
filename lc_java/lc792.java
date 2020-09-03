class Solution792 {
	public int numMatchingSubseq(String s, String[] words) {
        int res = 0, cur, i;
        List<Integer>[] pos = positions(s);
        for (String w : words) {
            for (i = 0, cur = 0; i < w.length(); i++, cur++) {
                char c = w.charAt(i);
                cur = search(pos[c-'a'], cur);
                if (cur == -1) break;
            }
            if (cur != -1) res++;
        }
        return res;
    }
	
    private List<Integer>[] positions(String s) {
        List<Integer>[] pos = new List['z'-'a'+1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pos[c-'a'] == null) pos[c-'a'] = new ArrayList<>();
            pos[c-'a'].add(i);
        }
        return pos;
    }
	
	private int search(List<Integer> ns, int n) {
        if (ns == null) return -1;
        int lo = 0, hi = ns.size()-1;
        if (ns.get(lo) >= n) return ns.get(lo);
        if (ns.get(hi) < n) return -1;
        while (lo < hi) {
            int mi = (lo + hi)/2;
            if (ns.get(mi) == n) return ns.get(mi);
            if (ns.get(mi) < n) lo = mi+1;
            else hi = mi;
        }
        return ns.get(hi);
    }
}

class Demo792
{
	public static void main(String[] args)
	{
		
	}
}