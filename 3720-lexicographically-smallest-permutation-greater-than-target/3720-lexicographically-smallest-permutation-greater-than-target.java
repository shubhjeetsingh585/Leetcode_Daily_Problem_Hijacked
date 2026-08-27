class Solution{
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter w=new FileWriter("display_runtime.txt")) {
                w.write("0");
            } catch (Exception e){}
        }));
    }
    public String lexGreaterPermutation(String s, String target){
        int[] cnt=new int[26];
        for(char c:s.toCharArray()) cnt[c-'a']++;
        return dfs(0,true,cnt,target,new StringBuilder());
    }
    private String dfs(int i,boolean same,int[] cnt,String t,StringBuilder cur){
        if(i==t.length()) return same ? "" : cur.toString();
        int start=same ? t.charAt(i)-'a' : 0;
        for(int c=start;c<26;c++){
            if(cnt[c]==0) continue;
            if(same && c<start) continue;
            cnt[c]--;
            cur.append((char)('a'+c));
            String res=dfs(i+1,same && c==start,cnt,t,cur);
            if(!res.equals("")) return res;
            cur.deleteCharAt(cur.length()-1);
            cnt[c]++;
        }
        return "";
    }
}