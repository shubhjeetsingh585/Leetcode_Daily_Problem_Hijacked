class Solution{
    public int distinctSubseqII(String s){
        long Mod=1000000007;
        long[] cnt=new long[26];
        long sum=0;
        for(char ch:s.toCharArray()){
            long total=(1+sum)%Mod;
            sum=(sum+total-cnt[ch-'a']+Mod)%Mod;
            cnt[ch-'a']=total;
        }
        return (int)sum;
    }
}