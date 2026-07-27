import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean check(int[] buses, int[] passengers, int capacity, int targetTime) {
        int i = 0; // bus index
        int j = 0; // passenger index

        while (i < buses.length) {
            int count = 0;
            
            // Fill the current bus with passengers who arrived on or before bus departure
            while (j < passengers.length && passengers[j] <= buses[i] && count < capacity) {
                // If our target time is before/at this passenger's arrival and fits in the bus
                if (targetTime <= passengers[j]) {
                    return true;
                }
                j++;
                count++;
            }
            
            // If target time is after all boarders on this bus, but before/at bus departure time
            if (count < capacity && targetTime <= buses[i]) {
                return true;
            }

            i++;
        }
        return false;
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        Set<Integer> set = new HashSet<>();
        for (int p : passengers) {
            set.add(p);
        }

        int left = 1;
        int right = buses[buses.length - 1]; // Latest possible time is the last bus departure
        int bestTime = 1;

        // Binary search for the maximum valid arrival time
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(buses, passengers, capacity, mid)) {
                bestTime = mid;
                left = mid + 1; // Try to find a later time
            } else {
                right = mid - 1;
            }
        }

        // Post-processing: Ensure bestTime is not already taken by another passenger
        while (set.contains(bestTime)) {
            bestTime--;
        }

        return bestTime;
    }
}