class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        
        // FIX 1: Change to double[][] so we can store exact decimal ratios
        double temp[][] = new double[n][3];
        long totalDamage = 0 ; 
        
        for(int i = 0 ; i < n ; i++){
            temp[i][0] = damage[i]; 
            int currHealth = health[i]; 
            totalDamage += damage[i]; 
            
            // Your exact time logic (perfect)
            int totalTime = currHealth / power ; 
            if(currHealth % power != 0 ) {
                totalTime = currHealth / power + 1; 
            }
            temp[i][1] = totalTime;

            // FIX 2: Just use a standard double division! No manual ceiling needed.
            // 6 / 5 becomes 1.2 instead of getting crushed to 1 or 2.
            double ratio = (double) damage[i] / totalTime; 
            
            temp[i][2] = ratio; 
        }

        // Your exact sorting logic, just using Double.compare since the array is double[][]
        Arrays.sort(temp , (a,b)-> {
            if(b[2] != a[2]) return Double.compare(b[2] , a[2]);
            if(b[0] != a[0]) return Double.compare(b[0] , a[0]);
            return Double.compare(a[1] , b[1]);
        });

        long taken = 0 ; 
        for(int i = 0 ; i < n ; i++){
            // Cast back to int for your math
            int currDamage = (int) temp[i][0]; 
            int time = (int) temp[i][1]; 

            // Your exact tracking logic (perfect)
            taken += 1L * totalDamage * time; 
            totalDamage -= currDamage;
        }

        return taken ; 
    }
}