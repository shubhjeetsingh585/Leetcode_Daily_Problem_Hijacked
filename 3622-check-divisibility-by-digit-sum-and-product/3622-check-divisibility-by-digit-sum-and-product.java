class Solution{
    public boolean checkDivisibility(int n){
        int sum=0,pro=1,x=n;
        while(n!=0){
            int d=n%10;
            sum+=d;
            pro*=d;
            n/=10;
        }
        int res=sum+pro;
        if(x%res==0) return true;
        return false;
    }
}