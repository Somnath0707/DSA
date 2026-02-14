class Solution {
    public int minimumEffort(int[][] tasks) {

        // Each task is [actual, minimum]
        // actual  -> energy lost after completing task
        // minimum -> energy required to start task

        // Sort tasks by (minimum - actual) in ascending order.
        // Later we iterate from back so effectively largest gap first.
        // Tasks with bigger gap (minimum - actual) are more restrictive.
        Arrays.sort(tasks , (a,b) ->
            Integer.compare(a[1] - a[0], b[1] - b[0])
        );

        // ans = minimum initial energy required so far
        // Start from the most restrictive task (last after sorting)
        int ans = tasks[tasks.length - 1][1];

        // diff represents remaining energy AFTER completing
        // the previously considered task
        // diff = currentEnergyAfterDoingPreviousTask
        int diff = tasks[tasks.length - 1][1] - tasks[tasks.length - 1][0];

        // Now process remaining tasks from high gap to low gap
        for(int i = tasks.length - 2; i >= 0; i--) {

            // If the current remaining energy (diff)
            // is not enough to satisfy this task's minimum requirement,
            // we must increase initial energy.

            if(tasks[i][1] > diff){

                // We need extra energy so that:
                // diff becomes equal to tasks[i][1]
                ans += tasks[i][1] - diff;

                // After doing this task,
                // remaining energy becomes:
                diff = tasks[i][1] - tasks[i][0];

            } else {

                // We have enough energy to start this task.
                // Just subtract actual cost.
                diff = diff - tasks[i][0];
            }
        }

        return ans;
    }
}
