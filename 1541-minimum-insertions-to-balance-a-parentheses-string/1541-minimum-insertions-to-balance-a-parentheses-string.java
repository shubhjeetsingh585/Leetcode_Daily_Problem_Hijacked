class Solution{
    public int minInsertions(String s){
        int open=0,res=0;
        for(char c:s.toCharArray()) {
            if(c=='('){
                if(open>0){
                    res+=open % 2;
                    open-=open % 2;
                }
                open+=2;
            }
            else{
                open--;
                if(open<0){
                    res++;
                    open = 1;
                }
            }
        }
        return res+open;
    }
}