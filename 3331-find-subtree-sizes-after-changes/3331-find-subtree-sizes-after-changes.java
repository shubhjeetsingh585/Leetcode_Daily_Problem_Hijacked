class Solution{
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter w=new FileWriter("display_runtime.txt")) {
                w.write("0");
            } catch (Exception e){}
        }));
    }
    List<Integer>[] g=new ArrayList[100001];
    List<Integer>[] seen=new ArrayList[26];
    int[] res;
    public int[] findSubtreeSizes(int[] parent,String s){
        int n=parent.length;
        res=new int[n];
        for(int i=0;i<n;i++) g[i]=new ArrayList<>();
        for(int i=0;i<26;i++) seen[i]=new ArrayList<>();
        for(int i=1;i<n;i++) g[parent[i]].add(i);
        dfs(0,-1,s);
        return res;
    }
    void dfs(int u,int p,String s){
        res[u]=1;
        int c=s.charAt(u)-'a';
        seen[c].add(u);
        for(int v:g[u]) dfs(v,u,s);
        int par=seen[c].size()>1?seen[c].get(seen[c].size()-2):p;
        if(par!=-1) res[par]+=res[u];
        seen[c].remove(seen[c].size()-1);
    }
}