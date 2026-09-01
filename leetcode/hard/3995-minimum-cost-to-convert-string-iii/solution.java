class Solution {
    public int check(String match , int ind , String source , String replace , String target ){
        int cost = 0 ; 
        int n = source.length(); 
        if(n-ind < match.length()) return -1; 
        for(int i = 0 ; i < match.length() ; i++){
            if(match.charAt(i) == source.charAt(ind) || match.charAt(i) == '*'){
                if(replace.charAt(i) != target.charAt(ind)) return -1; 
                else if(match.charAt(i) == '*') cost++; 
                ind++; 
                continue; 
            }
            else if(match.charAt(i)  != source.charAt(ind++)){
                return -1; 
            }
        }
        return cost; 
    }

    Integer dp[] ; 
    public int f(int i , String source , String target , List<List<String>> rules , int[] costs){
        if(i >= target.length()){
            return 0 ; 
        }
        if(dp[i] != null) return dp[i]; 
        int take = 10000000 ; 
        int tryMatch = 10000000 ; 

        if(source.charAt(i) == target.charAt(i)){
            take = f(i+1, source , target , rules , costs );// take or try rule cuase we never know ahed or in just next index there might be an mismatch 
        }

        for(int ind = 0 ; ind < rules.size() ; ind++){
            String currMatch = rules.get(ind).get(0); 
            String currReplace = rules.get(ind).get(1); 
            int cost = check(currMatch , i , source , currReplace , target);
            if(cost != -1){
                cost += costs[ind]; 
                int nextInd = i + currMatch.length(); 
                tryMatch = Math.min(tryMatch , cost + f(nextInd , source , target , rules , costs));
            }
        }   

        return dp[i] =  Math.min(take , tryMatch); 
    }
    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {
        // we need to make source -> target 

        // for each j the character pattern must either be equal to the current char at l+j or be * ; 
        // 5000 * 200 * 20 = 10 ^ 6 iguess
        // 10000000

        // well brute force just works fine i guess

        // we try matching hello with world at each point we can try see if there is any mathcin in the rules 

        // and can try like take or skip cuase there could be a better solution to it afterwards 

        // instead of traveseing the 
        if(source.equals(target)) return 0 ; 
        dp = new Integer[source.length()]; 
        int ans =  f(0, source , target, rules , costs);
        if(ans >= 10000000) return -1; 
        return ans; 

    }
}