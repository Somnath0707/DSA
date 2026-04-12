class Solution {

    public double calcAngle(int side1 , int side2 , int opp){
        // cos theta = side1 * side 2 + s1 * s2 + opp * opp ) / 2 * side1 * side2;
        double cos = (side1 * side1 + side2 * side2 - opp * opp ) /( 2.0 * side1 * side2);

        return Math.toDegrees(Math.acos(cos));
    }
    public double[] internalAngles(int[] sides) {

        int a = sides[0];
        int b = sides[1];
        int c = sides[2] ;


        // check if the triangle exist 
        if(a + b <= c || b + c <= a || a + c <= b){
            return new double[0];
        }

        // check each angel for all the side 
        double angleOfA = calcAngle(b , c , a);
        double angleOfB = calcAngle(a , c , b);
        double angleOfC = calcAngle(a , b , c);


        double angles[] = {angleOfA , angleOfB , angleOfC};

        Arrays.sort(angles);

        return angles;
        
    }
}
