class Solution {
    public boolean checkString(String s) {
        int n=s.length(), lA=-1,fB=n;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a') lA=i;
            else if(s.charAt(i)=='b' && fB==n) fB=i;
        }
        return lA<fB;
    }
}