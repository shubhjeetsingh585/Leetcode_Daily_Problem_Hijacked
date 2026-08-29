class Solution{
    public String countAndSay(int n){
        String s="1";
        while(--n>0){
            StringBuilder t=new StringBuilder();
            for(int i=0,j;i<s.length();i=j){
                j=i;
                while(j<s.length()&&s.charAt(i)==s.charAt(j)) j++;
                t.append(j-i).append(s.charAt(i));
            }
            s=t.toString();
        }
        return s;
    }
}