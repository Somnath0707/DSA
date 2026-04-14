class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        solve("" , 0 , 0 , n , list);
        return list;
    }

    public void solve (String str , int open , int closed , int total , List<String> list){
        if(str.length() == 2 * total ){
            list.add(str);
            return ; 
        }

        if(open < total ){
            solve(str + "(" , open + 1 , closed , total , list);
        }

        if(closed < open){
            solve(str + ")" , open , closed+1 , total , list);
        }
    }
}