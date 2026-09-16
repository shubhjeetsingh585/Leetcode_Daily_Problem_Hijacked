class Solution{
    public int[][] generateMatrix(int n){
        int[][] res=new int[n][n];
        int t=0,b=n-1,l=0,r=n-1,val=1;
        while(t<=b && l<=r){
            for(int j=l;j<=r;j++) res[t][j]=val++;
            t++;
            for(int i=t;i<=b;i++) res[i][r]=val++;
            r--;
            for(int j=r;t<=b && j>=l;j--) res[b][j]=val++;
            b--;
            for(int i=b;l<=r && i>=t;i--) res[i][l]=val++;
            l++;
        }
        return res;
    }
}