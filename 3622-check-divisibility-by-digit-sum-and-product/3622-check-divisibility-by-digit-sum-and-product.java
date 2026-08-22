class Solution{
    public boolean checkDivisibility(int n){
        int sum=0,pro=1,x=n;
        while(x>0){
            int d=x%10;
            sum+=d;
            pro*=d;
            x/=10;
        }
        return n%(sum+pro)==0;
    }
}