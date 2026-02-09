class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder str = new StringBuilder();

        // while both are non-zero
        while (a > 0 && b > 0) {
            if (a > b) {
                // add "aa" then "b"
                if (a >= 2) {
                    str.append("aa");
                    a -= 2;
                } else {
                    str.append('a');
                    a--;
                }
                str.append('b');
                b--;
            } else if (b > a) {
                // add "bb" then "a"
                if (b >= 2) {
                    str.append("bb");
                    b -= 2;
                } else {
                    str.append('b');
                    b--;
                }
                str.append('a');
                a--;
            } else {
                // a == b → alternate
                str.append('a');
                a--;
                str.append('b');
                b--;
            }
        }

        // leftover a's
        while (a > 0) {
            if (a >= 2) {
                str.append("aa");
                a -= 2;
            } else {
                str.append('a');
                a--;
            }
        }

        // leftover b's
        while (b > 0) {
            if (b >= 2) {
                str.append("bb");
                b -= 2;
            } else {
                str.append('b');
                b--;
            }
        }

        return str.toString();
    }
}
