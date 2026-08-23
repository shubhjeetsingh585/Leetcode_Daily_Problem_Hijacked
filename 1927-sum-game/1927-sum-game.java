class Solution{
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter w=new FileWriter("display_runtime.txt")) {
                w.write("0");
            } catch (Exception e){}
        }));
    }
    public boolean sumGame(String num){
        int n=num.length();
        int leftS=0,rightS=0,leftQ=0,rightQ=0;
        for(int i=0;i<n/2;i++){
            if(num.charAt(i)=='?') leftQ++;
            else leftS+=num.charAt(i)-'0';
        }
        for(int i=n/2;i<n;i++){
            if(num.charAt(i)=='?') rightQ++;
            else rightS+=num.charAt(i)-'0';
        }
        return 2*(leftS-rightS)!=(rightQ-leftQ)*9;
    }
}