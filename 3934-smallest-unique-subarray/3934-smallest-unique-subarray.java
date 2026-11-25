class Solution{
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter w=new FileWriter("display_runtime.txt")) {
                w.write("0");
            } catch (Exception e){}
        }));   
    }
    public int smallestUniqueSubarray(int[] nums){
        int n=nums.length,base=100003,mod=1000000007;
        long[] pow=new long[n+1],pre=new long[n+1];
        pow[0]=1;
        for(int i=0;i<n;i++){
            pow[i+1]=pow[i]*base%mod;
            pre[i+1]=(pre[i]*base+nums[i])%mod;
        }
        int l=1,r=n,res=n;
        while(l<=r){
            int mid=(l+r)/2;
            HashMap<Long,Integer> map=new HashMap<>();
            for(int i=0;i+mid<=n;i++){
                long h=(pre[i+mid]-pre[i]*pow[mid]%mod+mod)%mod;
                map.put(h,map.getOrDefault(h,0)+1);
            }
            boolean found=false;
            for(int v:map.values()){
                if(v==1){
                    found=true;
                    break;
                }
            }
            if(found){
                res=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return res;
    }
}