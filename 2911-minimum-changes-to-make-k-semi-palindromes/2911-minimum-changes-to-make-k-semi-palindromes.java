class Solution{
    
    public int minimumChanges(String s,int k){
        int n=s.length(),inf=1000000000;
        int[][] cost=new int[n][n];
        for(int l=0;l<n;l++){
            for(int r=l+1;r<n;r++){
                int len=r-l+1;
                cost[l][r]=inf;
                for(int d=1;d<len;d++){
                    if(len%d!=0) continue;
                    int groups=len/d,cur=0;
                    for(int i=0;i<groups/2;i++){
                        for(int j=0;j<d;j++){
                            if(s.charAt(l+i*d+j)!=s.charAt(l+(groups-1-i)*d+j)) cur++;
                        }
                    }
                    cost[l][r]=Math.min(cost[l][r],cur);
                }
            }
        }
        int[][] dp=new int[k+1][n+1];
        for(int[] a:dp) Arrays.fill(a,inf);
        dp[0][0]=0;
        for(int p=1;p<=k;p++){
            for(int i=2*p;i<=n;i++){
                for(int j=2*(p-1);j<=i-2;j++){
                    dp[p][i]=Math.min(dp[p][i],dp[p-1][j]+cost[j][i-1]);
                }
            }
        }
        return dp[k][n];
    }
}