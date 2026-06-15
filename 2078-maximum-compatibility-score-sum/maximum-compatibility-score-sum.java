class Solution {

    public int f(int i, Set<Integer> taken, int[][] students, int[][] mentors) {
        if (i == students.length) return 0;
        int take = 0;
        int skip = 0;

        int n = mentors.length;

        for (int ind = 0; ind < n; ind++) {

            if (!taken.contains(ind)) {

                int score = 0;

                for (int j = 0; j < students[0].length; j++) {
                    if (students[i][j] == mentors[ind][j]) {
                        score++;
                    }
                }

                taken.add(ind);

                take = Math.max(take ,score + f(i + 1, taken, students, mentors ));
                taken.remove(ind);
            }
        }


        return Math.max(take, skip);
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {

        Set<Integer> set = new HashSet<>();

        return f(0, set, students, mentors);
    }
}