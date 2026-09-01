class Solution {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>>res=new ArrayList<>();
        getPermute(nums,0,res);
        return res;
    }
    void getPermute(int[] nums, int idx,List<List<Integer>>res){
        if(idx==nums.length){
            List<Integer>curr=new ArrayList<>();
            for(int i:nums)curr.add(i);
            res.add(curr);
            return;
        }
        for(int i= idx;i<nums.length;i++){
            swap(nums,i,idx);
            getPermute(nums,idx+1,res);
            swap(nums,i,idx);
        }
    }
    void swap(int[] nums,int i,int idx){
        int temp=nums[i];
        nums[i]=nums[idx];
        nums[idx]=temp;
    }
}