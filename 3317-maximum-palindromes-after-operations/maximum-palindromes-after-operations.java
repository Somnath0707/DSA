class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        // first sort the words based on the len of the string so we fill the smallest one first 
        // we count each character and count 
        // try making the smallest lenght first 
        // for odd we take all even one odd for even we take all even 
        // for count 1 we can take odd if no odd then we can take from even 
        // 4 4-> 2 and then 2 and then 4 
        // 2 , 2 , 1 -> 2 , 1 yep we can 
        // 1 1 1 1 1 -> 

        // make even and odd from odd -= odd number from even -= even number but i dont know  like what should we do like remove the suppose 7 len is thnere we can remove 5 from odd and 2 from even or 3 from odd and 4 from even or 1 from odd and 6 from even ? 
        // or do i have to do in the form of the indiviudal no i dont think so 

        // ["rqfsx","kja","mx","r"]
        //  2 1 1 1 2 1 1 1 1
        // even = 4 and odd = 7 
        // 1 even 4 odd 6
        // 2 even 2 odd 6
        // 3 even 2 odd 3 
        // 4 even 0 odd 0 
        // whichever one is more take that and try 
        // aagha , bc 
        // 3 1 1 1 1 
        // odd = 7 even = 0 
        // odd-= 2 

        // so we have to make a freq array with each and there frequency and for each we have to check 
        // return 1; 
        int n = words.length; 
        int freq[] = new int[26]; 
        int len[] = new int[n]; 

        for(int i = 0 ; i < n ; i++){
            len[i] = words[i].length(); 
            for(char ch : words[i].toCharArray()){
                freq[ch-'a']++; 
            }
        }

        int evenPair = 0 ; 
        int oddPair =0;

        for(int i = 0 ; i < 26 ; i++){
            evenPair += freq[i] /2 ; 
            oddPair += freq[i] % 2 ; 
        }

        Arrays.sort(len);
        int ans = 0 ; 
        
        for(int i =0 ; i < n ; i++){
            int curr = len[i] ; 
            if(curr % 2 == 0){
                int pairNeed = curr / 2; 
                if(evenPair >= pairNeed){
                    ans++; 
                    evenPair -= pairNeed; 
                }
                else
                break; 
            }
            else{
                int evenPairNeed = curr / 2; 
                if(evenPair >= evenPairNeed){
                    evenPair -= evenPairNeed; 
                    if(oddPair >=1 ){
                        oddPair--; 
                        ans++; 
                    }else{
                        if(evenPair > 0){
                            evenPair--; 
                            oddPair++; 
                            ans++; 
                        }
                        else{
                            break; 
                        }
                    }
                }
                else break ;

            }
        }
        return ans; 
    }
}

// ["abbb","ba","aa"] -> 4 4 
// ["aab","bca"] -> 3 2 1 