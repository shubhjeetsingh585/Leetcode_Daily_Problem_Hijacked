class Solution{
    public int numDistinct(String s,String t){
        long[] dp=new long[t.length()+1];
        dp[0]=1;
        for(char ch:s.toCharArray()){
            for(int i=t.length();i>0;i--){
                if(ch==t.charAt(i-1)) dp[i]+=dp[i-1];
            }
        }
        return (int)dp[t.length()];
    }
}