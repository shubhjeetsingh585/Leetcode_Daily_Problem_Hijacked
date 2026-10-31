class Solution{
    public int uniquePaths(int[][] grid){
        int m=grid.length,n=grid[0].length;
        int mod=1_000_000_007;
        int[][][] dp=new int[m+1][n+1][2];
        dp[0][0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int r=dp[i][j][0],d=dp[i][j][1];
                if(grid[i][j]==0){
                    int sum=(r+d)%mod;
                    dp[i][j+1][0]=(dp[i][j+1][0]+sum)%mod;
                    dp[i+1][j][1]=(dp[i+1][j][1]+sum)%mod;
                }
                else{
                    dp[i+1][j][1]=(dp[i+1][j][1]+r)%mod;
                    dp[i][j+1][0]=(dp[i][j+1][0]+d)%mod;
                }
            }
        }
        return (dp[m-1][n-1][0]+dp[m-1][n-1][1])%mod;
    }
}