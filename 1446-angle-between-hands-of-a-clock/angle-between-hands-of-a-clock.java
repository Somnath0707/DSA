class Solution {
    public double angleClock(int hour, int minute) {
         double minuteHandAngle = minute * 6.0;
        
        // Calculate hour hand angle: 30 degrees per hour + 0.5 degrees per minute
        // Use hour % 12 to handle 24-hour format (e.g., 13:00 -> 1:00)
        double hourHandAngle = ((hour % 12) * 30.0) + (minute * 0.5);
        
        // Find the absolute difference
        double angle = Math.abs(hourHandAngle - minuteHandAngle);
        
        // Return the smaller angle (interior vs exterior)
        return Math.min(angle, 360.0 - angle);
    }
}