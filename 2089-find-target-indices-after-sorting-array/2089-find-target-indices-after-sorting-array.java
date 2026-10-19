class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int cnt=0,st=0;
        for(int x:nums){
            if(x==target) cnt++;
            if(x<target) st++;
        }
        List<Integer>res=new ArrayList<>();
        while(cnt-->0) res.add(st++);
        return res;
    }
}