import java.util.*;
class Solution{
    public int[] maximumWeight(List<List<Integer>> intervals){
        int n=intervals.size();
        Integer[] p=new Integer[n];
        for(int i=0;i<n;i++) p[i]=i;
        Arrays.sort(p,(i,j)->intervals.get(i).get(1).equals(intervals.get(j).get(1))
            ? intervals.get(i).get(0)-intervals.get(j).get(0)
            : intervals.get(i).get(1)-intervals.get(j).get(1));
        long[][] dp=new long[5][n+1];
        List<Integer>[][] take=(List<Integer>[][]) new ArrayList[5][n+1];
        for(int k=0;k<5;k++){
            for(int i=0;i<=n;i++){
                take[k][i]=new ArrayList<>();
            }
        }
        for(int i=1;i<=n;i++){
            int id=p[i-1];
            int l=intervals.get(id).get(0);
            int lo=0,hi=i-2,pos=-1;
            while(lo<=hi){
                int mid=(lo+hi)>>>1;
                if(intervals.get(p[mid]).get(1)<l){
                    pos=mid;
                    lo=mid+1;
                }
                else hi=mid-1;
            }
            int j=pos+1;
            for(int k=1;k<=4;k++){
                dp[k][i]=dp[k][i-1];
                take[k][i]=take[k][i-1];
                long vis=dp[k-1][j]+intervals.get(id).get(2);
                if(vis>dp[k][i]){
                    dp[k][i]=vis;
                    take[k][i]=new ArrayList<>(take[k-1][j]);
                    take[k][i].add(id);
                    Collections.sort(take[k][i]);
                }
                else if(vis==dp[k][i]){
                    List<Integer>t=new ArrayList<>(take[k-1][j]);
                    t.add(id);
                    Collections.sort(t);
                    if(take[k][i].isEmpty() || lex(t,take[k][i])<0) take[k][i]=t;
                }
            }
        }
        long best=0;
        List<Integer>res=new ArrayList<>();
        for(int k=0;k<=4;k++){
            if(dp[k][n]>best){
                best=dp[k][n];
                res=take[k][n];
            }
            else if(dp[k][n]==best && lex(take[k][n],res)<0) res=take[k][n];            
        }
        return res.stream().mapToInt(x->x).toArray();
    }
    int lex(List<Integer> a,List<Integer> b){
        for(int i=0;i<Math.min(a.size(),b.size());i++){
            if(!a.get(i).equals(b.get(i))) return Integer.compare(a.get(i),b.get(i));
        }
        return Integer.compare(a.size(),b.size());
    }
}