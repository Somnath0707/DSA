class Solution {

    public boolean palindrom(String str){
        int i = 0 ; 
        int j = str.length()-1; 

        while(i <= j){
            if(str.charAt(i) == str.charAt(j)){
                i++; 
                j--; 
            }
            else
            return false; 
        }
        return true; 
    }
    public int f(int i , StringBuilder str1 , StringBuilder str2  , String s){
        if(i == s.length()){
            if(palindrom(str1.toString()) && palindrom(str2.toString())){
                return str1.length() * str2.length(); 
            }
            return 0 ; 
        } 

        int ans = 0 ; 
        

        str1.append(s.charAt(i)); 
        int take1 = f(i+1 , str1 , str2 , s); 
        str1.deleteCharAt(str1.length()-1);

        str2.append(s.charAt(i)); 
        int take2 = f(i+1 , str1 , str2 , s); 
        str2.deleteCharAt(str2.length()-1); 


        int skip = f(i+1 , str1 , str2 , s); 

        return Math.max(take1 , Math.max(take2 , skip));
    }
    public int maxProduct(String s) {
        // we t

        // we can do is f(0 , str , mask); 

        // if(we get a palindorme one we do ) ans = Math max(ans , len * f(0 , newStr , mask , count )) if( count == 2 ) 

        // we can do is taken Math.max(take  , take and compare and skip )
        StringBuilder str1 = new StringBuilder(); 
        StringBuilder str2 = new StringBuilder(); 
        return f(0 , str1 , str2 , s); 
    }
}