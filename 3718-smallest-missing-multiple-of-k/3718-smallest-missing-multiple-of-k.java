class Solution{
    public int missingMultiple(int[] nums,int k){
        HashSet<Integer>s=new HashSet<>();
        for(int x:nums) s.add(x);
        for(int i=k;;i+=k) if(!s.contains(i)) return i;
    }
}