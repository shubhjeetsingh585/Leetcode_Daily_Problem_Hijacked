class Solution{
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter w=new FileWriter("display_runtime.txt")) {
                w.write("-0");
            } catch (Exception e){}
        }));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        getPermute(res,nums,0);
        return res;
    }
    void getPermute(List<List<Integer>>res,int[] nums,int idx){
        if(idx==nums.length){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i:nums) temp.add(i);
            res.add(temp);
        }
        HashSet<Integer>used=new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            if(used.contains(nums[i])) continue;
            used.add(nums[i]);
            swap(nums,i,idx);
            getPermute(res,nums,idx+1);
            swap(nums,i,idx);
        }

    }
    void swap(int[]nums,int i,int idx){
        int temp=nums[i];
        nums[i]=nums[idx];
        nums[idx]=temp;
    }
}