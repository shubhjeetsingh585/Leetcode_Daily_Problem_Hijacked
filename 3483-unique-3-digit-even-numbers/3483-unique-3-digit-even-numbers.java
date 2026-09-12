class Solution{
    public int totalNumbers(int[] digits){
        int[] freq=new int[10];
        for(int d:digits) freq[d]++;
        int cnt=0;
        for(int i=100;i<=998;i+=2){
            int n=i;
            int[] vis=new int[10];
            while(n>0){
                vis[n%10]++;
                n/=10;
            }
            boolean bol=true;
            for(int d=0;d<=9;d++){
                if(vis[d]>freq[d]){
                    bol=false;
                    break;
                }
            }
            if(bol) cnt++;
        }
        return cnt;
    }
}