class Solution {
    List<List<Integer>> list;
    int longestPathAll; 

    public int dfs(int node , String s){
        // System.out.println(list.get(node) + "is the curr Node ");
        if(list.get(node) == null) return 1; 

        int max = 0 , secMax = 0 ; 

        for(int n : list.get(node)){
            int currLong = dfs(n , s); 

            if(s.charAt(node) == s.charAt(n)) continue; 

            if(currLong > max){
                 secMax = max; 
                max = currLong; 
               
            }
            else if(currLong > secMax){
                secMax = currLong ; 
            }
        }

        longestPathAll = Math.max(longestPathAll , max + secMax + 1);

        return max+1; 
    }
    public int longestPath(int[] parent, String s) {
        // return 4; 
        // dfs on every node is not feasible to the constraint
        // a-> c, b , d

        // c -> a , b -> a , a-> 0 nothing 

        // a->

        list = new ArrayList<>(); 
        int n = parent.length; 
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>()); 
        }
        for(int i = 1 ; i < n ; i++){
            list.get(parent[i]).add(i); 
        }

        dfs(0,s);
        return longestPathAll;
    }
}