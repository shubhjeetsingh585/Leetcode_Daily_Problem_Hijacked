class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num) return "";
        StringBuilder res=new StringBuilder();
        res.append("9".repeat(sum/9));
        if(sum%9>0) res.append(sum%9);
        return res.append("0".repeat(num-res.length())).toString();
    }
}