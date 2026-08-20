class Solution{
    public int maxNumberOfFamilies(int n, int[][] reservedSeats){
        HashMap<Integer,Integer>m=new HashMap<>();
        for(int[] x:reservedSeats) if(x[1]>1 && x[1]<10) m.put(x[0], m.getOrDefault(x[0],0) | (1<<x[1]));
        int ans=(n-m.size())*2;
        for(int v:m.values()){
            boolean a=(v & 60) ==0;
            boolean b=(v & 240) ==0;
            boolean c=(v & 960) ==0;
            if(a && c) ans+=2;
            else if(a || b || c) ans++;
        }
        return ans;
    }
}