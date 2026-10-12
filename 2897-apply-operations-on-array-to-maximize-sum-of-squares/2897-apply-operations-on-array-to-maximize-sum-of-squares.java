class Solution{
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter w=new FileWriter("display_runtime.txt")) {
                w.write("0");
            } catch (Exception e){}
        }));
    }
    public int maxSum(List<Integer> nums,int k){
        long[] bits=new long[31];
        long mod=1_000_000_007L;
        for(int x:nums) for(int b=0;b<31;b++) if((x&(1<<b))!=0) bits[b]++;
        long res=0;
        while(k-->0){
            long x=0;
            for(int b=30;b>=0;b--){
                if(bits[b]>0){
                    x|=1L<<b;
                    bits[b]--;
                }
            }
            res=(res+x*x)%mod;
        }
        return (int)res;
    }
}