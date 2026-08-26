class Solution{
    public String shortestBeautifulSubstring(String s,int k){
        String res="";
        for(int i=0;i<s.length();i++){
            int o=0;
            for(int j=i;j<s.length();j++){
                if(s.charAt(j)=='1') o++;
                if(o==k){
                    String cur=s.substring(i,j+1);
                    if(res.isEmpty() || cur.length()<res.length() || (cur.length()==res.length() && cur.compareTo(res)<0)) res=cur;
                }
                if(o>k) break;
            }
        }
        return res;
    }
}