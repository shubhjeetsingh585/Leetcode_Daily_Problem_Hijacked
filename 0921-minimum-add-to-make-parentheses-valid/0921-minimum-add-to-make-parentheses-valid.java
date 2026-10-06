class Solution{
    public int minAddToMakeValid(String s){
        int cnt=0, sum=0;
        for(char c:s.toCharArray()){
            if(c=='(') cnt++;
            else if(cnt>0) cnt--;
            else sum++;
        }
        return cnt+sum;
    }
}