class Solution{
    public int maxDepth(String s){
        int d=0,res=0;
        for(char c:s.toCharArray()) {
            if(c=='(') res = Math.max(res, ++d);
            else if(c==')') d--;
        }
        return res;
    }
}