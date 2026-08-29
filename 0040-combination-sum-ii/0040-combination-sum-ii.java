class Solution{
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>>combinationSum2(int[] candidates,int target){
        Arrays.sort(candidates);
        dfs(candidates,target,0,new ArrayList<>());
        return ans;
    }
    void dfs(int[] a,int target,int idx,List<Integer> cur){
        if(target==0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=idx;i<a.length && a[i]<=target;i++){
            if(i>idx && a[i]==a[i-1]) continue;
            cur.add(a[i]);
            dfs(a,target-a[i],i+1,cur);
            cur.remove(cur.size()-1);
        }   
    }
}