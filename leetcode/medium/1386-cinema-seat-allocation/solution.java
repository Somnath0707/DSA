class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        Map<Integer,Set<Integer>> map = new HashMap<>(); 

        for(int[] num : reservedSeats){
            int row = num[0]; 
            int col = num[1]; 
            map.putIfAbsent(row , new HashSet<>());
            map.get(row).add(col); 
        }
        int ans = 2 * n ; 
        Set<Integer> taken = new HashSet<>(); 
        for(int num[] : reservedSeats){
            int row = num[0]; 
            if(taken.contains(row)) continue; 
            taken.add(row); 
            boolean firstTaken = false; 
            int count = 0 ; 
            int temp = 0 ; 
            for(int j = 1 ; j < 11 ; j++){
                if( (j == 2 || j  == 4 || j == 6) && firstTaken == false && !map.get(row).contains(j)){
                    count++; 
                    firstTaken = true; 
                }
                else if(firstTaken == true && !map.get(row).contains(j)){
                    count++; 
                    if(count == 4){
                        temp++; 
                        firstTaken = false; 
                        count = 0 ; 
                    }
                }
                else{
                    count = 0 ; 
                    firstTaken = false; 
                }
            }
            if(temp == 0) ans-=2; 
            else if(temp == 1) ans -= 1 ; 
        }
        return ans; 
    }
}