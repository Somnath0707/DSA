class Solution {
    public boolean check(String str){
        String temp = str.substring(11 , 13);
        System.out.println(temp);
        int age = Integer.parseInt(temp);
        if(age > 60 ){
            return true; 
        }
        return false;
        
    }
    public int countSeniors(String[] details) {
        int ans = 0 ; 
        for(String s : details){
            String str = s;
            if(check(str)){
                ans++;
            }
        }
        return ans; 
    }
}