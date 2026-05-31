class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length; 
        long newMass = mass;
        for(int i = 0 ; i < n ; i++){
            if(newMass >= asteroids[i]){
                newMass += asteroids[i];
            }
            else {
                return false; 
            }
        }
        return true; 
    }
}