class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        private Stack<Character> ss = new Stack<>();
        private Stack<Character> st = new Stack<>();
        
        for (char ch: S.toCharArray()) {
            if (ch == '#')
            {
                if (ss.size()>0)
                {
                    ss.pop();
                }
            }
            else
            {
                ss.push(ch);
            }
        }
        
        for (char ch: T.toCharArray()) {
            if (ch == '#')
            {
                if (st.size()>0)
                {
                    st.pop();
                }
            }
            else
            {
                st.push(ch);
            }
        }
        
        if (ss.size()!= st.size()){
            return false;
        } 
        while(ss.size()>0)
        {
            if (ss.pop() != st.pop())
            {
                return false;
            }
        }
        return true;
    }
}