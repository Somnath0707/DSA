class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        // we have power and two inte arr damge and health boht having length n 

        // bob ah n enemy where enemy i will deal bob damge[i] points per sec while they are alive helath[i] > 0 

        // every sec after the emenis deal damge to bob he chooses one of the enemies that is still alive and deals power points of damge to them 

        // deteremine the minimum toatl amount of damge point that wil be dealt to bob before all n enemies are dead 
        int n = damage.length;
        double temp[][] = new double[n][3];
        long totalDamage = 0 ; 
        for(int i = 0 ; i < n ; i++){
            temp[i][0] = damage[i]; 
            int currHealth = health[i]; 
            totalDamage += damage[i]; 
            int totalTime = currHealth / power ; 

            if(currHealth % power != 0 ) {
                totalTime = currHealth / power + 1; 
            }
            temp[i][1] = totalTime;

            double ratio = (double)damage[i] / totalTime; 
            
            // System.out.println( damage[i] + " " + totalTime + " " +  ratio);



            
            
            temp[i][2] = ratio; 
            // System.out.println(temp[i][0] + " " + temp[i][1] + " " + temp[i][2]);
            // System.out.println(" temp ");
        }

        

        Arrays.sort(temp , (a,b)-> {
            if(b[2] != a[2]) return Double.compare(b[2] , a[2]);
            if(b[0] != a[0]) return Double.compare(b[0] , a[0]);
            return Double.compare(a[1] , b[1]);
        });

        // for(int i =0 ; i < n ; i++){
        //     int currDamage = temp[i][0]; 
        //     int totalTime = temp[i][1]; 
        //     Doulbe ratio = temp[i][2]; 

        //     System.out.println(currDamage + " " + totalTime + " " + ratio );
        // }

        long taken = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int currDamage = (int)temp[i][0]; 
            int time = (int)temp[i][1]; 

            taken += 1L *  totalDamage * time; 
            totalDamage -= currDamage;
            
        }

        return taken ; 

    }
}