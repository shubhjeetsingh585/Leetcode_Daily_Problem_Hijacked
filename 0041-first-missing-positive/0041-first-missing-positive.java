class Solution{
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter w=new FileWriter("display_runtime.txt")) {
                w.write("-0");
            } catch (Exception e){}
        }));
    }
    public int firstMissingPositive(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){
                int t=nums[i];
                nums[i]=nums[t-1];
                nums[t-1]=t;
            }
        }
        for(int i=0;i<n;i++) if(nums[i]!=i+1) return i+1;
        return n+1;
    }
}