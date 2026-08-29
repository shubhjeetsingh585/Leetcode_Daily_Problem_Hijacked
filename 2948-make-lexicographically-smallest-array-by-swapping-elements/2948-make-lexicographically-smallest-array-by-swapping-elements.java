class Solution{
    public int[] lexicographicallySmallestArray(int[] nums,int limit){
        int n=nums.length;
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=nums[i];
            a[i][1]=i;
        }
        Arrays.sort(a,(x,y)->x[0]-y[0]);
        int[] ans=new int[n];
        int i=0;
        while(i<n){
            int j=i+1;
            while(j<n && a[j][0]-a[j-1][0]<=limit) j++;
            List<Integer>idx=new ArrayList<>();
            for(int k=i;k<j;k++) idx.add(a[k][1]);
            Collections.sort(idx);
            for(int k=0;k<idx.size();k++) ans[idx.get(k)]=a[i+k][0];
            i=j;
        }
        return ans;
    }
}