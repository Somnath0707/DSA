class Solution {
    public int check(String str){
        int total =1 ; 
        for(char ch : str.toCharArray()){
            int val = ch -'0';
            total *= val; 
        }
        System.out.println(total);
        return total ; 
    }
    public int smallestNumber(int n, int t) {
        int ans = 0 ; 
        for(int i = n ; i <=100 ; i++){

            String str = String.valueOf(i); 
            System.out.println(str);
            int val = check(str);
            if(val % t ==0) {
                ans = i ; 
                break;
            }
        }
        return ans; 
    }
}