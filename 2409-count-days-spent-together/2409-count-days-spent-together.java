class Solution{
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String st=arriveAlice.compareTo(arriveBob)>0 ? arriveAlice : arriveBob;
        String end=leaveAlice.compareTo(leaveBob)<0 ? leaveAlice : leaveBob;
        int[] days={0,31,59,90,120,151,181,212,243,273,304,334};
        int a=days[Integer.parseInt(st.substring(0,2))-1]+Integer.parseInt(st.substring(3));
        int b=days[Integer.parseInt(end.substring(0,2))-1]+Integer.parseInt(end.substring(3));
        return Math.max(0,b-a+1);
    }
}