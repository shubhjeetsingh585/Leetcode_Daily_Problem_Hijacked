class Solution{
    public List<String> letterCombinations(String digits){
        List<String>res=new ArrayList<>();
        if(digits.length()==0) return res;
        StringBuilder chstr=new StringBuilder();
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        getAll(res,digits,0,map,chstr);
        return res;

    }
    void getAll(List<String>res,String digits,int i,HashMap<Character,String>map,StringBuilder chstr){
        if(i==digits.length()){
            res.add(chstr.toString());
            return ;
        }
        char ch=digits.charAt(i);
        String str=map.get(ch);
        for(int j=0;j<str.length();j++){
            chstr.append(str.charAt(j));
            getAll(res,digits,i+1,map,chstr);
            chstr.deleteCharAt(chstr.length()-1);
        }
    }
}