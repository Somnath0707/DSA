class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String str = String.valueOf(high);
        String lowStr = String.valueOf(low);
        StringBuilder temp = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        int prev = 1;

        while (prev <= 9) {

            temp.setLength(0);

            temp.append(prev);
            int taken = prev;

            for (int j = 1; j < str.length() && taken < 9; j++) {

                taken++;
                temp.append(taken);

                int num = Integer.parseInt(temp.toString());

                if (num > high)
                    break;

                if (temp.length() >= lowStr.length() && num >= low) {
                    list.add(num);
                }
            }

            prev++;
        }
        Collections.sort(list);
        return list;
    }
}