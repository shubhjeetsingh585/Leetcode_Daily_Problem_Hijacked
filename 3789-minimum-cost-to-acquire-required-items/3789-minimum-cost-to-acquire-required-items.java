class Solution{
    public long minimumCost(int cost1,int cost2,int costBoth,int need1,int need2){
        long t=0;
        if(cost1+cost2<=costBoth) t=1L*cost1*need1+1L*cost2*need2;
        else{
            int cnt=Math.min(need1,need2);
            t=1L*cnt*costBoth;
            need1-=cnt;
            need2-=cnt;
            if(need1>0) t+=1L*need1*Math.min(cost1,costBoth);
            else if(need2>0) t+=1L*need2*Math.min(cost2,costBoth);
        }
        return t;
    }
}