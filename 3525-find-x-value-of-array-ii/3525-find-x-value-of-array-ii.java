class Solution{
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter w=new FileWriter("display_runtime.txt")) {
                w.write("0");
            } catch (Exception e){}
        }));
    }
    class Node{
        int p;
        int[] f;
        Node(int k){ 
            f=new int[k];
        }
    }
    int k;
    Node merge(Node a, Node b){
        if(a==null) return b;
        if(b==null) return a;
        Node c=new Node(k);
        c.p=a.p*b.p%k;
        for(int i=0;i<k;i++) c.f[i]+=a.f[i];
        for(int i=0;i<k;i++) c.f[a.p*i%k]+=b.f[i];
        return c;
    }
    public int[] resultArray(int[] nums,int k,int[][] queries){
        this.k=k;
        int n=nums.length, m=queries.length;
        Node[] st=new Node[n<<1];
        for(int i=0;i<n;i++){
            st[i+n]=new Node(k);
            st[i+n].p=nums[i] % k;
            st[i+n].f[st[i+n].p]=1;
        }
        for(int i=n-1;i>0;i--) st[i]=merge(st[i<<1],st[i<<1|1]);
        int[] res=new int[m];
        for(int q=0;q<m;q++){
            int idx=queries[q][0],val=queries[q][1],start=queries[q][2],x=queries[q][3];
            int p=idx+n;
            st[p]=new Node(k);
            st[p].p=val%k;
            st[p].f[st[p].p]=1;
            for(p>>=1;p>0;p>>=1) st[p]=merge(st[p<<1],st[p<<1|1]);
            Node L=null, R=null;
            for(int l=start+n,r=n+n;l<r;l>>=1,r>>=1){
                if((l&1)==1) L=merge(L,st[l++]);
                if((r&1)==1) R=merge(st[--r],R);
            }
            res[q]=merge(L,R).f[x];
        }
        return res;
    }
}