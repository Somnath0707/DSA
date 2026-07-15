class Solution {
    public int gcd(int a , int b){
        while(b != 0){
            int temp = b; 
            b = a % b; 
            a = temp; 
        }
        return a; 
    }
    public int gcdOfOddEvenSums(int n) {
        int oddGcd = 0; 
        int evenGcd = 0 ; 
        for(int i = 1 ; i < n*2+1 ; i = i+2){
            oddGcd += i; 
        }

        for(int i = 2 ; i < n*2+1 ; i = i + 2){
            evenGcd += i; 
        }

        return gcd(evenGcd , oddGcd);
    }
}