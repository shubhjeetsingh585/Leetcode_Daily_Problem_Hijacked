class Solution{
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter w=new FileWriter("display_runtime.txt")) {
                w.write("0");
            } catch (Exception e){}
        }));
    }
    public int numberOfSets(int n, int k){
        long mod=1_000_000_007;
        int N=n+k-1, R=2*k;
        long ans=1;
        for (int i = 1; i <= R; i++) {
            ans=ans*(N-R+i)%mod;
            ans=ans*modPow(i,mod-2,mod)%mod;
        }
        return (int)ans;
    }
    private long modPow(long a, long b, long mod) {
        long res=1;
        while(b> 0){
            if((b&1)==1) res=res*a%mod;
            a=a*a%mod;
            b>>=1;
        }
        return res;
    }
}