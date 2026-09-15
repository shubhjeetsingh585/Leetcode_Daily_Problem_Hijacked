class Solution{
    public int maxPalindromes(String s, int k){
        int n=s.length();
        int[] dp=new int[n+1];
        for(int i=n-1;i>=0;--i){
            dp[i]=dp[i+1];
            if(i+k-1<n && isPal(s,i,i+k-1)) dp[i]=Math.max(dp[i],1+dp[i+k]);
            if(i+k<n && isPal(s,i,i+k)) dp[i]=Math.max(dp[i],1+dp[i+k+1]);
        }
        return dp[0];
    }
    boolean isPal(String s, int l, int r){
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--)) return false;
        }
        return true;
    }
}