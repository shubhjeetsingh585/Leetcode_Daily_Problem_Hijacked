class Solution{
    public boolean canAliceWin(int n){
        int m=10,cnt=0;
        while(n>=m){
            n-=m;
            m--;
            cnt++;
        }
        return cnt%2==1;
    }
}