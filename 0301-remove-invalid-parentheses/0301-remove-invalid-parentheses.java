class Solution{
    List<String>res=new ArrayList<>();
    public List<String> removeInvalidParentheses(String s){
        int l=0,r=0;
        for(char c:s.toCharArray()){
            if(c=='(') l++;
            else if(c==')'){
                if(l>0) l--;
                else r++;
            }
        }
        dfs(s,0,l,r);
        return res;
    }
    private void dfs(String s,int start,int l,int r){
        if(l==0 && r==0){
            if(isValid(s)) res.add(s);
            return;
        }
        for(int i=start;i<s.length();i++){
            if(i>start && s.charAt(i)==s.charAt(i-1)) continue;
            if(l>0 && s.charAt(i)=='(') dfs(s.substring(0,i)+s.substring(i+1),i,l-1,r);
            if(r>0 && s.charAt(i)==')') dfs(s.substring(0,i)+s.substring(i+1),i,l,r-1);
        }
    }
    private boolean isValid(String s){
        int bal=0;
        for(char c:s.toCharArray()) {
            if(c=='(') bal++;
            else if(c==')'){
                if(--bal<0) return false;
            }
        }
        return bal==0;   
    }
}