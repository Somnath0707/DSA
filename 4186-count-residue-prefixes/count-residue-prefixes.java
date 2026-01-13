class Solution {
    public int residuePrefixes(String s) {
        // Create a HashSet to store all the unique elements 

        Set<Character> set = new HashSet<>();
        // A counter to keep the count of residue 
        int count  = 0 ; 

        // Iterate through the string 
        for(int i = 0 ; i < s.length() ; i++){
            // Add the element at i th index to the set 
            set.add(s.charAt(i));

            // We know that set store the only unqiue elemnts 
            // dd here first set<'d'> will be stored
            // the again the d will try to enter the set but but but
            // d already exist in set so it wont add 
            // So it keeps the track of the distinct elements 
            int distinctElemets = set.size();

            // As the index start from 0 we have to +1 to make it right 
            int prefixLen = i + 1; 
            // EX: "abc" here for 'a' the i is 0 but we know
            // the length is 1 so we need to do i + 1; 


            // Condtion as given in the question 
            if(prefixLen%3 == distinctElemets){
                // If condition is meet increment the counter 
                count ++;
            }
        }
        return count ; 
    }
}