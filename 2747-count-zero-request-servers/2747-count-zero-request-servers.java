class Solution{
    public int[] countServers(int n,int[][] logs,int x,int[] queries){
        Arrays.sort(logs,(a,b)->a[1]-b[1]);
        int m=queries.length;
        int[][] q=new int[m][2];
        for (int i=0;i<m;i++) q[i]=new int[]{queries[i],i};
        Arrays.sort(q,(a,b)->a[0]-b[0]);
        int[] res=new int[m];
        int[] freq=new int[n+1];
        int left=0,right=0,active=0;
        for(int[] query:q){
            int t=query[0];
            while(right<logs.length && logs[right][1]<=t){
                if(freq[logs[right][0]]++==0) active++;
                right++;
            }
            while(left<right && logs[left][1]<t-x){
                if(--freq[logs[left][0]]==0) active--;
                left++;
            }
            res[query[1]]=n-active;
        }
        return res;
    }
}