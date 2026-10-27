class Solution{
    public String[] createGrid(int m,int n){
        char[][] g=new char[m][n];
        for(char[] row:g) Arrays.fill(row,'#');
        Arrays.fill(g[0],'.');
        for(int i=0;i<m;i++) g[i][n-1]='.';
        String[] res=new String[m];
        for(int i=0;i<m;i++) res[i]=new String(g[i]);
        return res;
    }
}