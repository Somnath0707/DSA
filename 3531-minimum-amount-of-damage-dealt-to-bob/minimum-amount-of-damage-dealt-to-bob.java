class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        // we have power and two inte arr damge and health boht having length n 

        // bob ah n enemy where enemy i will deal bob damge[i] points per sec while they are alive helath[i] > 0 

        // every sec after the emenis deal damge to bob he chooses one of the enemies that is still alive and deals power points of damge to them 

        // deteremine the minimum toatl amount of damge point that wil be dealt to bob before all n enemies are dead 
        int n = damage.length;
        int temp[][] = new int[n][3];
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

            int ratio = damage[i] / totalTime; 
            
            if(damage[i] < totalTime  ) ratio = 0 ;
            else if(damage[i] % totalTime != 0){
                ratio += 1 ; 
            }
            System.out.println( damage[i] + " " + totalTime + " " +  ratio);



            
            
            temp[i][2] = ratio; 
            System.out.println(temp[i][0] + " " + temp[i][1] + " " + temp[i][2]);
            System.out.println(" temp ");
        }

        

        Arrays.sort(temp, (a, b) -> {
            // Cross-multiply to compare (Damage_B / Time_B) vs (Damage_A / Time_A)
            // Value B = Damage_B * Time_A
            // Value A = Damage_A * Time_B
            long valueB = (long) b[0] * a[1]; 
            long valueA = (long) a[0] * b[1]; 
            
            return Long.compare(valueB, valueA);
        });

        for(int i =0 ; i < n ; i++){
            int currDamage = temp[i][0]; 
            int totalTime = temp[i][1]; 
            int ratio = temp[i][2]; 

            System.out.println(currDamage + " " + totalTime + " " + ratio );
        }

        long taken = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int curr[] = temp[i]; 
            int currDamage = curr[0]; 
            int time = curr[1]; 

            taken += 1L *  totalDamage * time; 
            totalDamage -= currDamage;
            
        }

        return taken ; 

    }
}