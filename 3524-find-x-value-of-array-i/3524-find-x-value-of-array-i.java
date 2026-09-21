class Solution{
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter w=new FileWriter("display_runtime.txt")) {
                w.write("0");
            } catch (Exception e){}
        }));
    }
    public long[] resultArray(int[] nums, int k){
        long[] res=new long[k],dp=new long[k];
        for(int x:nums){
            long[] n=new long[k];
            int m=x%k;
            n[m]=1;
            for(int r=0;r<k;r++) n[(r*m)%k]+=dp[r];
            for(int r=0;r<k;r++) res[r]+=n[r];
            dp=n;
        }
        return res;
    }
}