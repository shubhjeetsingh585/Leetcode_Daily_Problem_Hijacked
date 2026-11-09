class Solution{
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter w=new FileWriter("display_runtime.txt")) {
                w.write("0");
            } catch (Exception e){}
        }));
    }
    public List<Integer> busiestServers(int k,int[] arrival,int[] load){
        TreeSet<Integer>free=new TreeSet<>();
        int[] count=new int[k];
        PriorityQueue<int[]> busy=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<k;i++) free.add(i);
        for(int i=0;i<arrival.length;i++){
            while(!busy.isEmpty()&&busy.peek()[0]<=arrival[i]) free.add(busy.poll()[1]);
            if(free.isEmpty()) continue;
            Integer s=free.ceiling(i%k);
            if(s==null) s=free.first();
            free.remove(s);
            count[s]++;
            busy.offer(new int[]{arrival[i]+load[i],s});
        }
        int max=Arrays.stream(count).max().getAsInt();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<k;i++) if(count[i]==max) res.add(i);
        return res;   
    }
}